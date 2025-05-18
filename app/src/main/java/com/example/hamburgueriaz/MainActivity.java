package com.example.hamburgueriaz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.net.Uri;
import android.content.ActivityNotFoundException;

import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mQuantidade, mValorTotal, mInputNome;
    CheckBox checkBoxBacon, checkBoxQueijo, checkBoxOnionRings;
    TextView mResumoPedido;
    final int VALOR_HAMBURGUER = 20;
    final int VALOR_BACON = 2;
    final int VALOR_QUEIJO = 2;
    final int VALOR_ONION = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button mButtonSubtrair = findViewById(R.id.IdButtonSubtrair);
        Button mButtonAdicionar = findViewById(R.id.IdButtonAdicionar);
        Button mButtonEnviarPedido = findViewById(R.id.IdButtonEnviarPedido);
;       mQuantidade = findViewById(R.id.IdQuantidadeNumero);
        mValorTotal = findViewById(R.id.IdValorTotal);
        mInputNome = findViewById(R.id.IdInputNome);
        mResumoPedido = findViewById(R.id.IdResumoPedido);
        checkBoxBacon = findViewById(R.id.checkBoxBacon);
        checkBoxQueijo = findViewById(R.id.checkBoxQueijo);
        checkBoxOnionRings = findViewById(R.id.checkBoxOnionRings);

        mButtonAdicionar.setOnClickListener(v -> {
            alterarQuantidade(1);
        });

        mButtonSubtrair.setOnClickListener(v -> {
            alterarQuantidade(-1);
        });

        mButtonEnviarPedido.setOnClickListener(v -> {
            String nome = mInputNome.getText().toString().trim();
            if (nome.isEmpty()) {
                Toast.makeText(this, "Informe seu nome", Toast.LENGTH_SHORT).show();
                return; // Impede que continue se o nome estiver vazio
            }
            enviarPedido();
        });

        checkBoxBacon.setOnCheckedChangeListener((buttonView, isChecked) -> calcularValorTotal());
        checkBoxQueijo.setOnCheckedChangeListener((buttonView, isChecked) -> calcularValorTotal());
        checkBoxOnionRings.setOnCheckedChangeListener((buttonView, isChecked) -> calcularValorTotal());
    }
    private void alterarQuantidade(int valor) {
        int quantidade = getQuantidadeAtual();
        quantidade += valor;
        if (quantidade < 0) quantidade = 0;
        mQuantidade.setText(String.valueOf(quantidade));
        calcularValorTotal();
    }
    private int getQuantidadeAtual() {
        String texto = mQuantidade.getText().toString();
        return texto.isEmpty() ? 0 : Integer.parseInt(texto);
    }
    private void calcularValorTotal() {
        int quantidade = getQuantidadeAtual();
        int valorBase = quantidade * VALOR_HAMBURGUER;
        int adicionais = 0;
        if (checkBoxBacon.isChecked()){
            adicionais += VALOR_BACON;
        }
        if (checkBoxQueijo.isChecked()){
            adicionais += VALOR_QUEIJO;
        }
        if (checkBoxOnionRings.isChecked()){
            adicionais += VALOR_ONION;
        }
        int valorFinal = valorBase + adicionais;
        mValorTotal.setText("R$ " + valorFinal);
    }
    private void enviarPedido() {
        calcularValorTotal();

        String nome = mInputNome.getText().toString();
        int quantidade = getQuantidadeAtual();
        String bacon = checkBoxBacon.isChecked() ? "Sim" : "Não";
        String queijo = checkBoxQueijo.isChecked() ? "Sim" : "Não";
        String onion = checkBoxOnionRings.isChecked() ? "Sim" : "Não";
        String precoFinal = mValorTotal.getText().toString();

        String resumo = "Nome do cliente: " + nome + "\n" +
                "Tem Bacon? " + bacon + "\n" +
                "Tem Queijo? " + queijo + "\n" +
                "Tem Onion Rings? " + onion + "\n" +
                "Quantidade: " + quantidade + "\n" +
                "Preço final: " + precoFinal;

        mResumoPedido.setText("RESUMO DO PEDIDO:\n" + resumo);
        Uri uri = Uri.parse("mailto:")
                .buildUpon()
                .appendQueryParameter("subject", "Pedido de " + nome)
                .appendQueryParameter("body", resumo)
                .build();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(uri);
        try {
            startActivity(Intent.createChooser(intent, "Enviar pedido via e-mail"));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Nenhum aplicativo de e-mail encontrado", Toast.LENGTH_LONG).show();
        }
    }
}
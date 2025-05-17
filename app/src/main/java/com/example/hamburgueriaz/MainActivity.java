package com.example.hamburgueriaz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button mButtonSubtrair;
        Button mButtonAdicionar;
        EditText mQuantidade;

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mButtonSubtrair = findViewById(R.id.IdButtonSubtrair);
        mButtonAdicionar = findViewById(R.id.IdButtonAdicionar);
        mQuantidade = findViewById(R.id.IdQuantidadeNumero);

        mButtonAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantidadeTexto = mQuantidade.getText().toString();
                int quantidade = quantidadeTexto.isEmpty() ? 0 : Integer.parseInt(quantidadeTexto);
                quantidade++;
                mQuantidade.setText(String.valueOf(quantidade));
            }
        });

        mButtonSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantidadeTexto = mQuantidade.getText().toString();
                int quantidade = quantidadeTexto.isEmpty() ? 0 : Integer.parseInt(quantidadeTexto);
                if (quantidade > 0) {
                    quantidade--;
                    mQuantidade.setText(String.valueOf(quantidade));
                }
            }
        });






    }
}
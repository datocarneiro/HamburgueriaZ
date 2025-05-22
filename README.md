# Aplicativo HamburgueriaZ
---

# 📄 Documentação do Projeto — Aplicativo **HamburgueriaZ**

## 📚 Tecnologias Utilizadas

* **Java**
* **Android Studio**
* **XML para Layouts**
* **API Android Intents (para e-mail)**

## 🎯 Objetivo

Desenvolver um aplicativo Android com fins acadêmicos que permita ao usuário realizar pedidos de hambúrgueres personalizados, incluindo opcionais como bacon, queijo e onion rings. O pedido pode ser visualizado em um resumo e enviado via e-mail.

---

## 📱 Funcionalidades

| Funcionalidade             | Descrição                                                                 |
| -------------------------- | ------------------------------------------------------------------------- |
| Seleção de Quantidade      | Permite ao usuário aumentar ou diminuir a quantidade de hambúrgueres.     |
| Escolha de Adicionais      | O usuário pode marcar adicionais como bacon, queijo e onion rings.        |
| Cálculo do Valor Total     | O valor total do pedido é calculado automaticamente com base nas opções.  |
| Resumo do Pedido           | Exibe os detalhes do pedido de forma clara ao usuário.                    |
| Envio do Pedido via E-mail | Permite enviar o pedido para um e-mail (cliente ou restaurante fictício). |

---

## 🧮 Regras de Negócio

* Valor base do hambúrguer: `R$ 20,00`
* Adicionais:

  * Bacon: `R$ 2,00`
  * Queijo: `R$ 2,00`
  * Onion Rings: `R$ 3,00`
* O valor total é recalculado automaticamente ao modificar a quantidade ou os adicionais.

---

## 🖥️ Componentes da Interface

| Componente           | ID XML                 | Tipo       |
| -------------------- | ---------------------- | ---------- |
| Quantidade           | `IdQuantidadeNumero`   | `EditText` |
| Valor Total          | `IdValorTotal`         | `EditText` |
| Nome do Cliente      | `IdInputNome`          | `EditText` |
| Resumo do Pedido     | `IdResumoPedido`       | `TextView` |
| Checkbox Bacon       | `checkBoxBacon`        | `CheckBox` |
| Checkbox Queijo      | `checkBoxQueijo`       | `CheckBox` |
| Checkbox Onion Rings | `checkBoxOnionRings`   | `CheckBox` |
| Botão Adicionar      | `IdButtonAdicionar`    | `Button`   |
| Botão Subtrair       | `IdButtonSubtrair`     | `Button`   |
| Botão Enviar Pedido  | `IdButtonEnviarPedido` | `Button`   |

---

## 🔁 Fluxo de Execução

1. Usuário informa seu nome e define a quantidade de hambúrgueres.
2. Seleciona adicionais conforme desejar.
3. O valor total é calculado automaticamente.
4. Ao clicar em “Enviar Pedido”, o sistema valida o nome, gera o resumo e abre um app de e-mail para envio do pedido.

---

## 📝 Conclusão

Este aplicativo demonstra conceitos básicos de desenvolvimento Android, como manipulação de componentes da interface, validações, interações com o sistema (e-mail) e cálculos dinâmicos. É um projeto ideal para fins acadêmicos, facilitando a compreensão de eventos, manipulação de estados e integração de funcionalidades em um ambiente Android.

---





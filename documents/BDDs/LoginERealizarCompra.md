## Login e Finalizar a compra.

---
CT-001

**Funcionalidade:** Processo completo de login, compra e finalização do pedido

Como um usuário.
Quero realizar login, selecionar produtos, finalizar a compra e deslogar.
Para garantir de compra bem-sucedida.

**Cenário:** Realizar uma compra completa e sair do sistema

**Dado** que eu estou na tela de login

**E** eu preencho o campo "Username" com "standard_user"

**E** eu preencho o campo "Password" com "secret_sauce"

**E** eu clico no botão "Login"

**Então** eu sou redirecionado para a página "Product"

**Quando** eu identifico 2 produtos desejados

**E** eu clico no botão "ADD TO CART" para ambos os produtos

**Então** o número de itens no ícone do carrinho deve ser atualizado para "2"

**Quando** eu clico no ícone do carrinho

**Então** eu sou redirecionado para a tela "Your Cart"

**E** as quantidades, nomes e descrições dos produtos no carrinho devem ser exibidos corretamente

**Quando** eu clico no botão "CHECKOUT"

**Então** eu sou redirecionado para a tela "Checkout: Your Information"

**Quando** eu preencho o campo "FirstName" com "Ricardo"

**E** eu preencho o campo "LastName" com "Costa"

**E** eu preencho o campo "Postal Code" com "90619-900"

**E** eu clico no botão "CONTINUE"

**Então** eu sou redirecionado para a tela "Checkout: Overview"

**Então** eu devo ver as quantidades, nomes e descrições corretas dos produtos no checkout

**Quando** eu clico no botão "FINISH"

**Então** eu sou redirecionado para a tela "FINISH"

**E** eu devo ver a mensagem "THANK YOU FOR YOUR ORDER"

**Quando** eu clico no botão "Logout"

**E** eu sou redirecionado para a tela de login

**Então** Encerro a sessão.
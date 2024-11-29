## Products - BDD

---
CT-001

**Funcionalidade:** Gerenciamento de carrinho de compras

Como um usuário. 
Quero adicionar produtos ao carrinho, verificar e ajustar quantidades.
Para concluir minha compra com os itens desejados.

**Cenário:** Adicionar produto ao carrinho e proceder ao checkout

**Dado** que eu estou na página de listagem de produtos

**Quando** eu identifico o produto desejado

**E** eu clico no botão "ADD TO CART" do produto selecionado

**Então** o número de itens no ícone do carrinho deve ser atualizado para "1"

**Quando** eu clico no ícone do carrinho

**Então** eu devo ser redirecionado para a tela "Your Cart"

**Quando** eu preencho o campo de quantidade do item com "2"

**Então** as quantidades, nomes e descrições dos produtos no carrinho devem ser exibidos corretamente

**Quando** eu clico no botão "CHECKOUT"

**Então** eu devo ser redirecionado para a tela "Checkout: Your Information"

---
CT-002

**Funcionalidade:** Persistência do carrinho de compras
Como um usuário
Quero adicionar produtos ao carrinho e garantir que os itens sejam mantidos após atualizar a página
Para continuar minha compra sem perder informações.

**Cenário:** Adicionar produto ao carrinho e verificar persistência após recarregar a página

**Dado** que eu estou na página de listagem de produtos

**Quando** eu identifico o produto desejado

**E** eu clico no botão "ADD TO CART" do produto selecionado

**E** eu atualizo a página

**Quando** eu clico no ícone do carrinho

**Então** eu devo ser redirecionado para a tela "Your Cart"

**E** as quantidades, nomes e descrições dos produtos no carrinho devem ser exibidas corretamente

**Quando** eu atualizo a página novamente

**Então** as quantidades, nomes e descrições dos produtos no carrinho devem continuar corretas

---
CT-003

**Funcionalidade:** Remoção de itens do carrinho de compras

Como um usuário.
Quero remover todos os produtos do carrinho.
Para esvaziar o carrinho caso não deseje mais os itens.

**Cenário:** Adicionar produto ao carrinho e remover todos os itens

**Dado** que eu estou na página de listagem de produtos

**Quando** eu identifico o produto desejado

**E** eu clico no botão "ADD TO CART" do produto selecionado

**E** eu clico no ícone do carrinho

**Então** eu devo ser redirecionado para a tela "Your Cart"

**Quando** eu clico no botão "REMOVE" para cada item no carrinho

**Então** o carrinho deve estar vazio

**E** devo ver a mensagem "Your cart is empty"

---
CT-004

**Funcionalidade:** Adicionar e remover produtos do carrinho

Como um usuário.
Quero adicionar produtos ao carrinho, removê-los e finalizar uma comprar.
Garantir que o sistema não permita que finalizar uma compra quando o carrinho de compras está vazio.

**Cenário:** Adicionar produto ao carrinho e removê-lo

**Dado** que eu estou na tela "Product"

**Quando** eu identifico o produto desejado

**E** eu clico no botão "ADD TO CART" do produto selecionado

**Então** o produto é adicionado ao carrinho

**Quando** eu clico no ícone do carrinho

**Então** eu sou redirecionado para a tela "Your Cart"

**Quando** eu clico no botão "REMOVE" para todos os itens no carrinho

**Então** o carrinho deve ficar vazio

**E** o sistema exibe a mensagem "Your cart is empty"

**Quando** eu clico no botão "CHECKOUT"

**Então** o sistema impede a continuidade para a próxima etapa

**E** o sistema exibe a mensagem "The cart cannot be empty"
## Checkout to Finish - BDD

---
CT-001

**Funcionalidade:** Finalização de pedido no checkout

Como um usuário.
Quero preencher minhas informações, revisar o pedido e concluir a compra.
Para finalizar minha compra com sucesso.

**Cenário:** Preencher informações de checkout e finalizar pedido

**Dado** que eu estou na tela "Checkout: Your Information"

**Quando** eu preencho o campo "FirstName" com "Ricardo"

**E** eu preencho o campo "LastName" com "Costa"

**E** eu preencho o campo "Postal Code" com "90619-900"

**E** eu clico no botão "CONTINUE"

**Então** eu devo ser redirecionado para a tela "Checkout: Overview"

**E** eu devo ver as quantidades, nomes e descrições corretas dos produtos no checkout

**E** eu devo verificar:

**_| Forma de pagamento | Informação de envio | Valor total dos itens | Valor da taxa | Valor total geral |_**

**Quando** eu clico no botão "FINISH"

**Então** eu devo ser redirecionado para a tela "FINISH"

**E** eu devo ver a mensagem "THANK YOU FOR YOUR ORDER"

**Quando** eu clico no botão "Logout"

**Então** eu devo ser redirecionado para a tela de login

---
CT-002

**Funcionalidade:** Validação de campos obrigatórios no checkout

Como um usuário.
Quero ser avisado quando deixar de preencher campos obrigatórios no checkout.

**Cenário:** Tentar continuar sem preencher os campos obrigatórios

**Dado** que eu estou na tela "Checkout: Your Information"

**Quando** eu não preencho o campo "FirstName"

**E** eu não preencho o campo "LastName"

**E** eu não preencho o campo "Postal Code"

**E** eu clico no botão "CONTINUE"

**Então** eu devo ver uma mensagem de erro "First Name is required"

**E** devo permanecer na tela "Checkout: Your Information"

---
CT-003

**Funcionalidade:** Validação de campos obrigatórios no checkout

Como um usuário.
Quero ser avisado ao tentar continuar sem preencher todos os campos obrigatórios.

**Cenário:** Tentar continuar preenchendo apenas o campo "FirstName"

**Dado** que eu estou na tela "Checkout: Your Information"

**Quando** eu preencho o campo "FirstName" com "Ricardo"

**E** eu não preencho o campo "LastName"

**E** eu não preencho o campo "Postal Code"

**E** eu clico no botão "CONTINUE"

**Então** eu devo ver uma mensagem de erro "Last Name is required"

**E** devo permanecer na tela "Checkout: Your Information"

---
CT-004

**Funcionalidade:** Validação de campos obrigatórios no checkout

Como um usuário.
Quero ser avisado ao tentar continuar sem preencher todos os campos obrigatórios.


**Cenário:** Tentar continuar preenchendo apenas o campo "LastName"

**Dado** que eu estou na tela "Checkout: Your Information"

**Quando** eu não preencho o campo "FirstName".

**E** eu preencho o campo "LastName" com "Costa"

**E** eu não preencho o campo "Postal Code"

**E** eu clico no botão "CONTINUE"

**Então** eu devo ver uma mensagem de erro "First Name is required"

**E** devo permanecer na tela "Checkout: Your Information"

---
CT-005

**Funcionalidade:** Validação de campos obrigatórios no checkout

Como um usuário
Quero ser avisado ao tentar continuar sem preencher todos os campos obrigatórios

**Cenário:** Tentar continuar preenchendo apenas o campo "Postal code"

**Dado** que eu estou na tela "Checkout: Your Information"

**Quando** eu não preencho o campo "FirstName".

**E** eu não preencho o campo "LastName"

**E** eu preencho o campo "Postal Code" com "90619-900"

**E** eu clico no botão "CONTINUE"

**Então** eu devo ver uma mensagem de erro "First Name is required"

**E** devo permanecer na tela "Checkout: Your Information"

---
CT-006

**Funcionalidade:** Validação de tamanho mínimo nos campos obrigatórios do checkout

Como um usuário
Quero ser avisado ao tentar continuar com informações abaixo do tamanho mínimo permitido

**Cenário:** Tentar continuar preenchendo os campos obrigatórios com apenas 2 caracteres

**Dado** que eu estou na tela "Checkout: Your Information"

**Quando** eu preencho o campo "FirstName" com "Ri"

**E** eu preencho o campo "LastName" com "Co"

**E** eu preencho o campo "Postal Code" com "90"

**E** eu clico no botão "CONTINUE"

**Então** eu devo ver uma mensagem de erro "Requires a minimum of 3 characters"

**E** devo permanecer na tela "Checkout: Your Information"

---
CT-007

**Funcionalidade:** Validação de tamanho máximo nos campos obrigatórios do checkout
Como um usuário
Quero ser avisado ao tentar continuar com informações que excedem o limite máximo permitido

**Cenário:** Tentar continuar preenchendo os campos obrigatórios com mais de caracteres permitidos

**Dado** que eu estou na tela "Checkout: Your Information"

**Quando** eu preencho o campo "FirstName" com mais de 225 caracteres

**E** eu preencho o campo "LastName" com com mais de 225 caracteres

**E** eu preencho o campo "Postal Code" com com mais de 225 caracteres

**E** eu clico no botão "CONTINUE"

**Então** eu devo ver uma mensagem de erro "Cannot be with values that exceed the limit!"

**E** devo permanecer na tela "Checkout: Your Information"

---
CT-008

**Funcionalidade:** Validação de caracteres inválidos nos campos obrigatórios do checkout

Como um usuário.
Quero ser avisado ao tentar continuar com informações que contenham números ou caracteres especiais.

**Cenário:** Tentar continuar preenchendo os campos obrigatórios com números e caracteres especiais

**Dado** que eu estou na tela "Checkout: Your Information"

**Quando** eu preencho o campo "FirstName" com "Ric@rd0!"

**E** eu preencho o campo "LastName" com "C0st@123"

**E** eu preencho o campo "Postal Code" com "#90619@90"

**E** eu clico no botão "CONTINUE"

**Então** eu devo ver uma mensagem de erro "Invalid data"

**E** devo permanecer na tela "Checkout: Your Information"

---
CT-009

**Funcionalidade:** Validação de inválidos no campo postal code do checkout

Como um usuário.
Quero ser avisado ao tentar continuar com informações que contenham letras.

**Cenário:** Tentar continuar preenchendo o campo postal code com letras

**Dado** que eu estou na tela "Checkout: Your Information"

**Quando** eu preencho o campo "FirstName" com "Ricardo"

**E** eu preencho o campo "LastName" com "Costa"

**E** eu preencho o campo "Postal Code" com "ASDAFDAASD"

**E** eu clico no botão "CONTINUE"

**Então** eu devo ver uma mensagem de erro "Invalid data"

**E** devo permanecer na tela "Checkout: Your Information"
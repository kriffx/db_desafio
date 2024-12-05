## Bloqueio de conta do usuario

---
CT-001

**Funcionalidade:** Bloqueio de Conta no Login

Como usuário. Não consigo acessar o sistema quando minha conta está bloqueada. Para garantir a segurança dos acessos

**Cenário:** Tentativa de login com conta bloqueada

**Dado** que estou na página de login

**Quando** eu preencho o campo de Username com "locked_out_user"

**E** eu preencho o campo de Password com "secret_sauce"

**E** clico no botão "Login"

**Então** o sistema deve exibir uma mensagem de erro indicando que a conta está bloqueada

**E** deve impedir o acesso ao sistema
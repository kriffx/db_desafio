## Bloqueio de conta do usuario

---
CT-001

**Funcionalidade:** Bloqueio de Conta no Login

Como usuário. Não consigo acessar o sistema quando minha conta está bloqueada. Para garantir a segurança dos acessos

**Cenário:** Valida o bloqueio de login ao tentar autenticar com um usuário bloqueado

**Dado** que estou na página de login

**Quando** eu preencho o campo de Username com "locked_out_user"

**E** eu preencho o campo de Password com "secret_sauce"

**E** clico no botão "Login"

**Então** o sistema deve exibir uma mensagem de erro 'Epic sadface: Sorry, this user has been locked out.'

**E** deve impedir o acesso ao sistema
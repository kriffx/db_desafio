### Login - BDD

---
CT-001

**Funcionalidade:** Login do Usuário

Como um usuário autenticado.
Quero realizar login no sistema.
Para acessar as funcionalidades disponíveis.

**Cenário:** Realizar login com credenciais válidas

**Dado** que eu estou na página de login

**Quando** eu preencho o campo "Username" com "standard_user"

**E** eu preencho o campo "Password" com "secret_sauce"

**E** eu clico no botão "Login"

**Então** eu devo ser redirecionado para a página product

---
CT-002

**Funcionalidade:** Login do Usuário

Como um usuário.
Quero receber um aviso ao tentar fazer login com credenciais inválidas.
Garantir que o sistema não permita e impeça o acesso ao login com dados que não sejam credenciais válidas.

**Cenário:** Tentar login com username inválido

**Dado** que eu estou na página de login

**Quando** eu preencho o campo "Username" com "test_01"

**E** eu preencho o campo "Password" com "secret_sauce"

**E** eu clico no botão "Login"

**Então** eu devo ver uma mensagem de erro "Username and password do not match any user in this service"

**E** devo permanecer na página de login

---
CT-003

**Funcionalidade:** Login do Usuário

Como um usuário.
Quero receber um aviso ao tentar fazer login com senha inválida.
Garantir que o sistema não permita e impeça o acesso ao login com dados que não sejam credenciais válidas.

**Cenário:** Tentar login com senha inválida

**Dado** que eu estou na página de login

**Quando** eu preencho o campo "Username" com "standard_user"

**E** eu preencho o campo "Password" com "1234"

**E** eu clico no botão "Login"

**Então** eu devo ver uma mensagem de erro "Username and password do not match any user in this service"

**E** devo permanecer na página de login

---
CT-004

**Funcionalidade:** Login do Usuário

Como um usuário.
Quero receber um aviso ao tentar fazer login sem preencher o campo de senha.
Garantir que o sistema não permita e impeça o acesso ao login com dados que não sejam credenciais válidas.

**Cenário:** Tentar login sem preencher a senha

**Dado** que eu estou na página de login

**Quando** eu preencho o campo "Username" com "standard_user"

**E** eu não preencho o campo "Password"

**E** eu clico no botão "Login"

**Então** eu devo ver uma mensagem de erro "Password is required"

**E** devo permanecer na página de login

---
CT-005

**Funcionalidade:** Login do Usuário

Como um usuário.
Quero receber um aviso ao tentar fazer login sem preencher o campo de username.
Garantir que o sistema não permita e impeça o acesso ao login com dados que não sejam credenciais válidas.

**Cenário:** Tentar login sem preencher o username

**Dado** que eu estou na página de login

**Quando** eu não preencho o campo "Username"

**E** eu preencho o campo "Password" com "secret_sauce"

**E** eu clico no botão "Login"

**Então** eu devo ver uma mensagem de erro "Username is required"

**E** devo permanecer na página de login

---
CT-006

**Funcionalidade:** Login do Usuário

Como um usuário.
Quero receber um aviso ao tentar fazer login sem preencher o username e a senha.
Garantir que o sistema não permita e impeça o acesso ao login com dados que não sejam credenciais válidas.

**Cenário:** Tentar login sem preencher username e senha

**Dado** que eu estou na página de login

**Quando** eu não preencho o campo "Username"

**E** eu não preencho o campo "Password"

**E** eu clico no botão "Login"

**Então** eu devo ver uma mensagem de erro "Username and password do not match any user in this service"

**E** devo permanecer na página de login

---
CT-007

**Funcionalidade:** Login do Usuário

Como um usuário.
Quero receber um aviso ao tentar fazer login com credenciais inválidas.
Garantir que o sistema não permita e impeça o acesso ao login com dados que não sejam credenciais válidas.

**Cenário:** Tentar login com username e senha inválidos

**Dado** que eu estou na página de login

**Quando** eu preencho o campo "Username" com "test_01"

**E** eu preencho o campo "Password" com "1234"

**E** eu clico no botão "Login"

**Então** eu devo ver uma mensagem de erro "Username and password do not match any user in this service"

**E** devo permanecer na página de login

---
CT-008

**Funcionalidade:** Login do Usuário

Como um usuário.
Quero verificar se consigo fazer login com o máximo de caracteres permitidos.
Para garantir que o sistema aceita entradas com limites máximos.

**Cenário:** Tentar login com username e senha mais de 255 caracteres

**Dado** que eu estou na página de login

**Quando** eu preencho o campo "Username" com mais de 255 caracteres

**E** eu preencho o campo "Password" com mais de 255 caracteres

**E** eu clico no botão "Login"

**Então** eu devo ver uma mensagem de erro "Username and password do not match any user in this service"

**E** devo permanecer na página de login

---
CT-009

**Funcionalidade:** Login do Usuário

Como um usuário.
Quero verificar se o sistema permite login com username e senha curtos.
Para garantir que o sistema não aceita entradas de 3 caracteres.

**Cenário:** Tentar login com username e senha de 3 caracteres

**Dado** que eu estou na página de login

**Quando** eu preencho o campo "Username" com 3 caracteres

**E** eu preencho o campo "Password" com 3 caracteres

**E** eu clico no botão "Login"

**Então** eu devo ver uma mensagem de erro "Username and password do not match any user in this service"

**E** devo permanecer na página de login

---
CT-010

**Funcionalidade:** Login do Usuário

Como um usuário.
Quero verificar se o sistema aceita username e a senha com caracteres especiais.
Para garantir que username e senha com caracteres especiais não sejam aceitos.

**Cenário:** Tentar login com username e senha com caracteres especiais

**Dado** que eu estou na página de login

**Quando** eu preencho o campo "Username" com "@#$%¨&*"

**E** eu preencho o campo "Password" com "*(#$#("

**E** eu clico no botão "Login"

**Então** eu devo ser redirecionado para a página de Products
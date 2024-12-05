## Imagens dos produtos na pagina de 'Products'

---
CT-001

**Funcionalidade:** Acesso de usuário com problemas e visualização de produtos

Como usuário. Quero realizar o login e verificar se as imagens dos produtos estão visíveis. 
Para garantir que o sistema está funcionando corretamente

**Cenário:** Login com usuário problemático e verificação das imagens dos produtos

**Dado** que estou na página de login

**Quando** eu preencho o campo de Username com "problem_user"

**E** eu preencho o campo de Password com "secret_sauce"

**E** clico no botão "Login"

**Então** eu devo ser redirecionado para a página de produtos

**E** as imagens dos produtos devem estar visíveis
## Desafio Tecnico DBServer

---

### [Sauce demo](https://www.saucedemo.com/v1/index.html)

>*O site contém uma interface simples de e-commerce, permitindo realizar tarefas como login, navegação por produtos, adicionar itens ao carrinho e finalizar compras.*
>
>*É para práticas de teste de software. Ele é fornecido pela Sauce Labs, uma plataforma de testes que permite simular diferentes cenários em ambientes web.*

---

#### O projeto é exclusivamente para [DBServer](https://db.tec.br/).

---  
### :open_file_folder: Cenários, Casos de Testes,  BDDs e Bugs:

#### :bookmark_tabs: Cenários e Casos de Testes:
:small_blue_diamond:[Suace Demo Table](documents/scenarios/Cenarios%20de%20Sauce%20Demo.xlsx)

#### :bookmark_tabs: BDDs:
:small_blue_diamond:[Login and Purchase](documents/BDDs/LoginAndPurchase.md)

:small_blue_diamond:[Login](documents/BDDs/Login.md)

:small_blue_diamond:[Products - Your Cart](documents/BDDs/Products.md)

:small_blue_diamond:[Checkout - Finish](documents/BDDs/Checkout_Finish.md)

:small_blue_diamond:[Locked User](documents/BDDs/LockedUser.md)

#### :bookmark_tabs: Bugs:
:small_blue_diamond: [Manual Testing](documents/bugs/manual%20testing/Descrição%20e%20o%20título%20do%20produto%20-%20BUG.pdf)

:small_blue_diamond: [Products - Your Cart](documents/bugs/product_your%20cart)

:small_blue_diamond: [Checkout - Finish](documents/bugs/checkout_finish)

:small_blue_diamond: [Problem User](documents/bugs/problem_user)

:small_blue_diamond: [Performance User](documents/bugs/performance_user)

---  

### Ferramentas que foi ulitizado?

#### Construido com a estrutura:

:pushpin: [MAVEN](https://maven.apache.org/download.cgi)

:pushpin: [JAVA 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

#### Dependencias:
:pushpin: [TestNG](https://mvnrepository.com/artifact/org.testng/testng/7.10.2)

:pushpin: [Selenium Java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.27.0)

:pushpin: [WebDriverManager](https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/5.9.2)

:pushpin: [Extent Reports TestNG Adapter](https://mvnrepository.com/artifact/com.aventstack/extentreports-testng-adapter/1.0.3)

:pushpin: [Java Faker](https://mvnrepository.com/artifact/com.github.javafaker/javafaker/1.0.2)

:pushpin: [Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.36)

---  

### Baixando o projeto:

Para baixar o projeto, abrir o comando ou dentro IDE:
```bash  
git clone https://github.com/loopfagundes/db_desafio.git
```  
  
#### Como executar?  
Para executar na sua máquina local, o comando ou através de sua IDE:  
```bash  
mvn clean
```
```bash  
mvn test
```
Padrão do browser Chrome.  
Para executar no Firefox ou Edge,  caminho para acessar de pastas dentro IDE:  
```  
src/main/java/com.saucedemo/utils/BaseTest
```  
```java  
@BeforeMethod DriverFactory.createInstance(BrowserEnum.CHROME);  
```  
`BrowserEnum.Chrome` ".Chrome" tem opção para Firefox ou Edge.

---

#### Report:
Após a execução do projeto, para visualizar o relatório:  
Abra a pasta de report e selecione o arquivo report.html.  
Clique com o botão direito do mouse, vá em "Open in", depois "Browser" e escolha o navegador da sua preferência.

#### Screenshot:
![](src/main/resources/img/report_All_Test.png)

---  
Feito com bug, café e muito esforço :beetle::coffee:
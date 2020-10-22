# # Cadastro de Contas

Projeto de execução de testes para criação de contas bancárias

## 🚀 Começando

Essas instruções permitirão que você obtenha uma cópia do projeto em operação na sua máquina local para fins de desenvolvimento e teste.

Consulte **Implantação** para saber como implantar o projeto.

### 📋 Pré-requisitos

Java JRE 1.8.0_261
Cucumber Eclipse Plugin
Dependência Cucumber-Java versão 4.8.0
Dependência Cucumber-Junit versão 4.8.0
Dependência Selenium-Java versão 3.11.0

```

## ⚙️ Executando os testes

Os testes serão executados a partir da classe RunnerFuncional, onde foram feitas as configurações necessárias para compreensão do sistema, como por exemplo, a localização 
do arquivo feature e o pacote da classe de steps.

### 🔩 Analise os testes de ponta a ponta

O cenário inicial irá realizar o teste do cadastramento de contas numa aplicação web (http://srbarriga.herokuapp.com) já em execução através do WebDriver.
Os principais testes irão acontecer conforme forem adicionadas as contas, onde irá testar o retorno de crição, não podendo passar criação de contas já existentes
e o campo com o nome da conta não poderá estar vazio.

## 📦 Desenvolvimento

Foi utilizado o WebDriver para realizar a conexão com uma aplicação web já em execução para que pudessem ser realizados os testes em tempo real desde o contato com a interface
até o retorno dos dados armazenados corretamente.

## 🛠️ Construído com

Mencione as ferramentas que você usou para criar seu projeto

* [WebDriver](https://chromedriver.chromium.org/downloads) - O framework web usado
* [Maven](https://maven.apache.org/) - Gerente de Dependência



---
⌨️ por [Andréa Rodrigues](https://github.com/andreaarv) 

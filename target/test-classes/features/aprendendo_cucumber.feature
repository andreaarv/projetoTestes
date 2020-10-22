@unitários
Feature: Aprender Cucumber
	Como um aluno
	Eu quero aprender a utilizar Cucumber
	Para que eu possa automatizar critérios de aceitação

Scenario: Deve executar especifição
	Given que criei o arquivo corretamente
	When executá-lo
	Then a especificação deve finalizar com sucesso

Scenario: Contador
	Given contador deverá iniciar com 15
	When contador for incrementado com 3
	Then contador será 18
	
Scenario: Calcular atraso da entrega
	Given que o prazo da entrega seja 05/04/2018
	When a entrega atrasar em 2 dias
	Then a entrega será efetuada em 07/04/2018
	
Scenario: Calcular atraso da entrega da china
	Given que o prazo da entrega seja 05/04/2018
	When a entrega atrasar em 2 meses
	Then a entrega será efetuada em 05/06/2018
	
Scenario: Deve criar steps genéricos para estes passos
    Given que o ticket é AF345
    Given que o valor da passagem é R$ 230,45
    Given que o nome do passageiro é "Fulano da Silva"
    Given que o telefone do passageiro é 9999-9999
    When criar os steps
    Then o teste vai funcionar

Scenario: Deve reaproveitar os steps "Dado" do cenário anterior
    Given que o ticket é AB167
    Given que o ticket especial é AB167
    Given que o valor da passagem é R$ 1120,23
    Given que o nome do passageiro é "Cicrano de Oliveira"
    Given que o telefone do passageiro é 9888-8888 

Scenario: Deve negar todos os steps "Dado" dos cenários anteriores
    Given que o ticket é CD123
    Given que o ticket é AG1234
    Given que o valor da passagem é R$ 1.1345,56
    Given que o nome do passageiro é "Beltrano Souza Matos de Alcântara Azevedo"
    Given que o telefone do passageiro é 1234-5678
    Given que o telefone do passageiro é 999-2223 
		
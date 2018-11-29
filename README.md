# Yellow Car

Este projeto consiste em um aplicativo de Taxi Driver, aonde um ou mais passegeiros, chamam taxis e o sistema encontra o melhor taxi disponível para aquele usuario e envia o mesmo ate seu encontro.

## Resumo

O Sistema  uma tela em Swing aonde os passageiros so plotados com o nome pass-XXXX e os carros com suas respectivas placas XXX-9999.
Quando um passagerio entra no sistema ele é capturado pelo sistema e um taxi vai ate ele, através de uma linha pega o passagerio e leva o mesmo ate o destino, ficando o taxi disponivel para outra corrida.

### Tecnico

A arquitetura do sistema é com o Clean Architecture, temos UseCases para camada de Negocio, Entities para classes de dominio e a view para a tela, tentando sempre usar os princípios do Solid.

Foi utilizado SpringBoot para desenvolvimento.

Para os passageiros foi criada um FSM(Máquina de estados finita) aonde eu controlo o estado do passageiro o mesmo foi feito para os taxis, ambas as FSM estão dentro de suas respectivas entidades.
Para a tela(Swing) existe um unico arquivo que é chamado toda vez que a tela precisa ser alterada.

Para a alteração da tela e controle de estados foi utilizado um design Pattern chamado Observer que observa todos os objetos que devem ser observados(Taxi e Passagerio neste caso) e notifica um observador, desse modo, toda vez que um taxi ou um passagerio é alterado o observador verifica quais ações ele deve chamar.

Para verificar o melhor taxi para um determinado passagerio foi utilizado um design Pattern chamado Chain of Responsability que encadeia várias restrições e obtém os melhores indicados, no arquivo application.properties, eu defino qual seletor usar para a escolha dos carros cab.selector=MinorDistance, menor distância  e qual cadeia de restrições devo utilizar cab.restriction=STATECAB_MAXDISTANCE, nesse caso é o estado do carro livre e a maxima distância em relação ao passageiro.



### Instalação -- ainda verificando como fazer um docker expor o swing

mvn package

sudo docker-compose up


## Authors

* **Renato Serra** - *Initial work* - [YellowCar](https://github.com/serrarenato/yellowcar)




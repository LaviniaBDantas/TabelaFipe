
# Desafio


Implementar uma aplicação para consultar o valor médio de veículos (carros, motos ou caminhões) de acordo com a tabela FIPE, que pode ser acessada através [desse site](https://veiculos.fipe.org.br/).

- A consulta aos valores dos veículos pelo site tem o seguinte fluxo:
- Primeiramente é necessário escolher o tipo do veículo: carro, moto ou caminhão.

![image](https://github.com/jacqueline-oliveira/3257-java-desafio/assets/66698429/c64bc1d1-2957-4bca-9965-0ce2bf9a6207)


- Depois disso, é necessário preencher a MARCA, MODELO e ANO para consulta.

![image](https://github.com/jacqueline-oliveira/3257-java-desafio/assets/66698429/6d85805f-d6b6-40e8-a65d-17cb13a740ed)


- Por fim, é exibida a avaliação apenas daquele ano escolhido.

  ![image](https://github.com/jacqueline-oliveira/3257-java-desafio/assets/66698429/94910321-15ed-49fe-bffc-25e1c4ab52dc)



## 🔨 Objetivos do projeto

- O objetivo do projeto é ter um fluxo similar ao que é feito no site acima, porém com algumas melhorias.
- O projeto utiliza a biblioteca Spring.
- É solicitado que o usuário digite o tipo de veículo desejado (carro, caminhão ou moto).
- Feito isso, há a listagem de todas as marcas daquele tipo de veículo, solicitando que o usuário escolha uma marca pelo código.
- Após essa escolha, há a listagem de todos os modelos de veículos daquela marca.
- É solicitado que o usuário digite um trecho do modelo que ele quer visualizar, por exemplo **PALIO**.
- Assim, a aplicação retorna apenas os modelos que tiverem a palavra **PALIO** no nome.
- Usuário escolherá um modelo específico pelo código e, diferente do site, são listadas as avaliações para **TODOS** os anos disponíveis daquele modelo, retornando uma lista mostrada na imagem abaixo:

![image](https://github.com/jacqueline-oliveira/3257-java-desafio/assets/66698429/3d0ac772-3eff-4bad-a1fd-e7c2f34a39bc)



## Observações:

- Para realização do desafio foi utilizada uma API, documentada [nesse link](https://deividfortuna.github.io/fipe/).
- Para  exibir as avaliações de todos os anos para determinado modelo, foi necessário trabalhar com as coleções e estruturas de repetição.
- Utilizei a biblioteca Jackson para a desserialização dos dados.
- Modelei as classes de acordo com o necessário para representar as marcas, modelos e dados dos veículos.

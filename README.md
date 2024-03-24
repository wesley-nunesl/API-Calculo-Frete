## API de Cálculo de Frete

Esta API foi tem como objetivo calcular o preço do frete e a data prevista de entrega com base em diversas variáveis, como peso da carga, CEP de origem e destino, entre outras.

## Tecnologias Utilizadas

- Java Spring Boot
- Arquitetura MVC
- DTO
- Swagger
- PostgreSQL(para integração com o banco de dados)
- API gratuita de consulta de CEP (viacep.com.br)

## Funcionalidades

- Cálculo do preço do frete com base no peso da carga, CEP de origem e destino, considerando descontos e prazos de entrega conforme especificado.
- Consulta da data prevista de entrega com base nas mesmas variáveis.

## Como Utilizar

1. Clone este repositório para o seu ambiente local.
2. Importe o projeto em sua IDE Java preferida.
3. Configure o banco de dados PostgreSQL com as informações necessárias (pode ser outro banco de dados de acordo a sua preferência).
4. Execute a aplicação Spring Boot.
5. Acesse a documentação da API gerada pelo Swagger para obter detalhes sobre os endpoints disponíveis e como utilizá-los.

## Documentação

A documentação da API pode ser acessada em http://localhost:8080/swagger-ui.html. Ela inclui informações sobre os endpoints disponíveis, os parâmetros necessários e os modelos de dados.

## Autor

Desenvolvido por Wesley Nunes

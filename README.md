# Visão geral

O projeto é um serviço back-end, com o objetivo de abordar de forma simples a utilização do protocolo SOAP, como cliente de uma comunicação com um servidor.

## Tecnologias

- [Spring Boot](https://projects.spring.io/spring-boot) é uma ferramenta que simplifica a configuração e execução de aplicações Java stand-alone, com conceitos de dependências “starters”, auto configuração e servlet container embutidos é proporcionado uma grande produtividade desde o start-up da aplicação até sua ida a produção.

- [Spring Data](https://spring.io/projects/spring-data) fornece um modelo familiar e consistente de programação, baseado em Spring, para acesso a dados, mantendo as características especiais do armazenamento de dados subjacente.
Facilita o uso de tecnologias de acesso a dados, bancos de dados relacionais e não relacionais, estruturas de redução de mapa e serviços de dados baseados em nuvem.

- [SOAP](https://pt.wikipedia.org/wiki/SOAP), em português Protocolo Simples de Acesso a Objetos) é um protocolo para troca de informações estruturadas em uma plataforma descentralizada e distribuída.
 
# Setup da aplicação (local)

## Pré-requisito

Antes de rodar a aplicação é preciso garantir que as seguintes dependências estejam corretamente instaladas:
```
Java 11
Maven
[Server API](https://github.com/ksgprod/soap-server-poc)
```

## Instalação da aplicação

Primeiramente, faça o clone do repositório:
```
git clone https://github.com/ksgprod/soap-client-poc
```
Baixe também a aplicação servidora:
```
git clone https://github.com/ksgprod/soap-server-poc
```
Feito isso, acesse o projeto:
```
cd soap-server-poc
```
É preciso compilar o código e baixar as dependências do projeto:
```
mvn clean install
```
Finalizado esse passo, vamos iniciar a aplicação:
```
mvn spring-boot:run
```
Acesse o projeto cliente:
```
cd soap-client-poc
```
É preciso compilar o código e baixar as dependências do projeto:
```
mvn clean install
```
Finalizado esse passo, vamos iniciar a aplicação:
```
mvn spring-boot:run
```
Pronto. A aplicação está disponível em http://localhost:8081
```
Tomcat started on port(s): 8081 (http) with context path ''
Started SoapClientPocApplication in XXXX seconds (JVM running for XXX)
```

# Sistema de para o MongoDB


## Introdu��o:

Este � um modelo de software para o uso do mongodb para treino em persistencia e consumo de banco n�o relacional


<h1 align="center">
  Desenvolvimento das APIs
</h1>

[GitLab](https://about.gitlab.com/):Plataforma de gerenciamento de ciclo de vida de desenvolvimento de software com versionamento de codigo git.

[GitLab](https://about.gitlab.com/):Plataforma de gerenciamento de ciclo de vida de desenvolvimento de software com versionamento de codigo git.
- [Spring Boot](https://spring.io/projects/spring-boot):Modulo derivado do Spring Framework que facilita desenvolvimento de aplica��es java implementando inje��o e invers�o de dependencias
- [H2](https://github.com/h2database/h2database/releases/download/version-2.2.220/h2.pdf): Gerenciador de banco de dados relacional
- [Postman](https://learning.postman.com/docs/developer/postman-api/intro-api/): Ferramenta destinada a desenvolvedores que possibilita testar chamadas API e gerar documenta��o de forma iterativa.Foi usado neste projeto para gerar collections e realizar teste de chamadas aos endpoints;
- [Tortoise](https://tortoisegit.org/docs/tortoisegit/): Ferramenta gerencial que facilita manipula��o de projetos em GIT. Foi usado neste projeto para resolu��o de conflitos.
- [Sourcetree](https://confluence.atlassian.com/get-started-with-sourcetree): Assim como o Tortoise � uma ferramenta gerencial para facilitar o desenvolvimento de projetos em Git, no entanto possui uma interface mais receptivel e navegabilidade facilitada.Foi usado neste projeto paa navega��o e cria��o de ramos.

## O que � MongoDB?

**MongoDB** � um banco de dados NoSQL orientado a documentos que armazena dados em um formato flex�vel de JSON (na verdade, um formato bin�rio chamado BSON - Binary JSON). Ele � projetado para lidar com grandes volumes de dados, escalabilidade horizontal e opera��es de leitura/escrita de alta velocidade.

### Principais Caracter�sticas do MongoDB

1. **Modelo de Dados Flex�vel**
    - MongoDB � orientado a documentos, permitindo flexibilidade para lidar com dados din�micos e n�o estruturados. Os dados s�o armazenados em documentos no formato BSON, semelhante ao JSON.

2. **Escalabilidade Horizontal**
    - Projetado para escalar horizontalmente atrav�s de um recurso chamado **Sharding**, permitindo distribuir dados automaticamente entre m�ltiplos servidores.

3. **Alta Performance**
    - Otimizado para leitura e escrita de alta velocidade, com suporte a opera��es em lote e �ndices complexos que melhoram a performance de busca e filtragem.

4. **Alta Disponibilidade**
    - Oferece alta disponibilidade atrav�s de **Replica Sets**, que s�o grupos de inst�ncias MongoDB que mant�m o mesmo conjunto de dados, garantindo redund�ncia e resili�ncia em caso de falhas.

5. **Consultas Ricas e Agrega��o**
    - Possui uma poderosa linguagem de consulta e um framework de agrega��o avan�ado que permite buscas complexas, agrega��es, filtros e proje��es de dados diretamente no servidor.

6. **Transa��es ACID**
    - Suporta transa��es ACID em m�ltiplos documentos desde a vers�o 4.0, garantindo consist�ncia de dados em opera��es complexas.

7. **Suporte a Indexa��o e Geoespacial**
    - Permite a cria��o de �ndices diversos, incluindo geoespaciais, de texto e de hash, otimizando a performance de consultas e filtros.

8. **Suporte a Agrega��es e Map-Reduce**
    - Inclui um framework de agrega��o para opera��es de processamento de dados e suporte ao modelo **Map-Reduce** para manipula��o de grandes conjuntos de dados.

### Casos de Uso Comuns

O MongoDB � ideal para:

- **Aplica��es Web em Tempo Real**: Como redes sociais, blogs, sites de e-commerce e aplicativos de chat.
- **Gerenciamento de Conte�do**: Sistemas de gerenciamento de conte�do (CMS) que requerem um armazenamento flex�vel de dados.
- **Big Data e Analytics**: Aplica��es que processam grandes volumes de dados n�o estruturados ou semiestruturados, como logs de servidor, dados de sensores, e streams de eventos.
- **Internet das Coisas (IoT)**: Aplica��es de IoT que coletam e analisam dados de dispositivos em tempo real.
- **Sistemas de Recomenda��o**: Plataformas que precisam adaptar rapidamente seu modelo de dados para responder a diferentes padr�es de comportamento do usu�rio.

### Vantagens

- **Flexibilidade de Modelagem**: Ideal para projetos onde os dados podem mudar frequentemente ou t�m uma estrutura n�o uniforme.
- **Escalabilidade**: F�cil de escalar horizontalmente, o que o torna adequado para grandes volumes de dados.
- **F�cil de Usar**: A API e as ferramentas do MongoDB s�o simples e intuitivas, facilitando o desenvolvimento.

### Desvantagens

- **Falta de Relacionamentos R�gidos**: Como � um banco NoSQL, o MongoDB n�o suporta diretamente **joins** complexos como em bancos relacionais, o que pode ser uma limita��o em alguns cen�rios.
- **Uso de Mem�ria**: Pode usar mais mem�ria do que um banco de dados relacional tradicional para armazenar o mesmo volume de dados.
- **Transa��es Complexas**: Embora suporte transa��es ACID, elas s�o mais limitadas em compara��o com bancos de dados relacionais.

### Quando Usar o MongoDB?

- Quando voc� precisa de uma base de dados flex�vel que possa crescer e mudar rapidamente com as necessidades do projeto.
- Quando sua aplica��o precisa lidar com grandes volumes de dados, ou dados que n�o possuem uma estrutura pr�-definida.
- Quando voc� precisa de um banco de dados que suporte leitura e escrita r�pidas.
- Quando voc� deseja escalar horizontalmente com facilidade.

MongoDB � uma excelente escolha para muitos tipos de aplica��es modernas, especialmente aquelas que requerem flexibilidade de dados, escalabilidade e alta performance.
## Pr�ticas adotadas
- Uso de DTOs para a API
- Inje��o de Depend�ncias

## Escalabilidade de sistema:
###############################################
##### Pipeline Gitlab-CI - v1.0           #####
##### MATTEC PROJETOS  - 08/03/2024       #####
##### JESSE PROJETO                       #####
###############################################


stages:
- teste
- build
- deploy


executar_teste:
stage: teste
before_script:
- echo "Preparando testes..."
- chmod +x ./script.sh
script:
- ./script.sh
after_script:
- echo "Apagando arquivos tempor�rios..."

executar_teste2:
image: node:19.1
needs:
- executar_teste
stage: teste
script:
- echo "Executando mais um teste..."
- npm version

criar_imagens:
stage: build
script:
- echo "Criando as imagens..."

push_imagens:
needs:
- criar_imagens
stage: build
script:
echo "Realizando upload das imagens..."

kubernetes:
stage: deploy
script:
- echo "Executando deploy..."

### Localmente
- Clonar reposit�rio git
- Construir o projeto:
```
./mvnw clean package
```
- Executar:


A API poder� ser acessada em [localhost:8080](http://localhost:8080)

O Swagger poder� ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Lista de artigos

- GET /artigos

```
http GET http://localhost:8080/artigos
[
    {
        "codigo": "66e1cff1b36d9a6e57f5a560",
        "titulo": "Teste",
        "data": "2024-09-11T14:14:25.487",
        "texto": "texto",
        "url": "http://",
        "status": 1,
        "autor": {
            "codigo": "66e1d0bfb36d9a6e57f5a561",
            "nome": "Jesse James",
            "biografia": null,
            "imagem": null
        }
    },
    {
        "codigo": "66e1f54efa43c3113c95d6d4",
        "titulo": "Jesse Show",
        "data": "2024-09-09T18:30:00",
        "texto": "Este � um evento imperd�vel para todos os f�s do Jesse. N�o perca a oportunidade de ver este show incr�vel!",
        "url": "https://www.jesseshow.com",
        "status": 1,
        "autor": null
    },
    {
        "codigo": "66e1f66b762d203662c30101",
        "titulo": "Jesse Parceiro",
        "data": "2024-09-09T18:30:00",
        "texto": "Este � um evento imperd�vel para todos os f�s do Jesse. N�o perca a oportunidade de ver este show incr�vel!",
        "url": "https://www.jesseparceiro.com",
        "status": 1,
        "autor": null
    },
    {
        "codigo": "66e21a6a84b8a0583cf50aa3",
        "titulo": "Jesse Parceiro",
        "data": "2024-09-09T18:30:00",
        "texto": "Este � um evento imperd�vel para todos os f�s do Jesse. N�o perca a oportunidade de ver este show incr�vel!",
        "url": "https://www.jesseparceiro.com",
        "status": 1,
        "autor": null
    },
    {
        "codigo": "66e21a7a84b8a0583cf50aa4",
        "titulo": "Jesse Parceiro",
        "data": "2024-09-09T18:30:00",
        "texto": "Este � um evento imperd�vel para todos os f�s do Jesse. N�o perca a oportunidade de ver este show incr�vel!",
        "url": "https://www.jesseparceiro.com",
        "status": 1,
        "autor": {
            "codigo": "66e219cf84b8a0583cf50aa2",
            "nome": "Acassio Bernardo",
            "biografia": "M�dico cientista",
            "imagem": "jpg"
        }
    },
    {
        "codigo": "66e33403de9e8e07072fa6da",
        "titulo": "Jerm Haroald",
        "data": "2024-09-12T18:02:20.756",
        "texto": "Este � um evento imperd�vel para todos os f�s do haroald. N�o perca a op�",
        "url": "https://www.harosald.com",
        "status": 1,
        "autor": null
    },
    {
        "codigo": "66e33514de9e8e07072fa6db",
        "titulo": "Jerm Haroald",
        "data": "2024-09-12T18:02:20.756",
        "texto": "Este � um evento imperd�vel para todos os f�s do haroald. N�o perca a op�",
        "url": "https://www.harosald.com",
        "status": 1,
        "autor": {
            "codigo": "66e219cf84b8a0583cf50aa2",
            "nome": "Acassio Bernardo",
            "biografia": "M�dico cientista",
            "imagem": "jpg"
        }
    }
]
```

CADASTRO DE ARTIGOS
* POST /artigos

```
http POST http://localhost:8080/artigos
HTTP/1.1 201 CREATED
Content-Length: 129
Content-Type: application/json

{
    "titulo": "Jerm Haroald",
    "data": "2024-09-12T18:02:20.756803",
    "texto": "Este � um evento imperd�vel para todos os f�s do haroald. N�o perca a op�",
    "url": "https://www.harosald.com",
    "status": 1,
    "autor": {
            "codigo": "66e219cf84b8a0583cf50aa2"
        }
}                         
```
OR 
```
http POST http://localhost:8080/artigos
HTTP/1.1 201 CREATED
Content-Length: 129
Content-Type: application/json

{
    "titulo": "Jerm Haroald",
    "data": "2024-09-12T18:02:20.756803",
    "texto": "Este � um evento imperd�vel para todos os f�s do haroald. N�o perca a op�",
    "url": "https://www.harosald.com",
    "status": 1,
    "autor": {
            "codigo": "66e219cf84b8a0583cf50aa2"
        }
}  
                       
or

    "titulo": "Jerm Haroald",
    "data": "2024-09-12T18:02:20.756803",
    "texto": "Este � um evento imperd�vel para todos os f�s do haroald. N�o perca a op�",
    "url": "https://www.harosald.com",
    "status": 1,
    "autor": {
            "codigo": null
        }
}

```
```
http://localhost:8080/artigos/66e33403de9e8e07072fa6da
HTTP/1.1 200 OK
Content-Length: 129
Content-Type: application/json

result
{
    "codigo": "66e33403de9e8e07072fa6da",
    "titulo": "Jerm Haroald",
    "data": "2024-09-12T18:02:20.756",
    "texto": "Este � um evento imperd�vel para todos os f�s do haroald. N�o perca a op�",
    "url": "https://www.harosald.com",
    "status": 1,
    "autor": null
}
```

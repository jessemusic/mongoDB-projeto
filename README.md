# Sistema de para o MongoDB


## Introdução:

Este é um modelo de software para o uso do mongodb para treino em persistencia e consumo de banco não relacional


<h1 align="center">
  Desenvolvimento das APIs
</h1>

[GitLab](https://about.gitlab.com/):Plataforma de gerenciamento de ciclo de vida de desenvolvimento de software com versionamento de codigo git.

[GitLab](https://about.gitlab.com/):Plataforma de gerenciamento de ciclo de vida de desenvolvimento de software com versionamento de codigo git.
- [Spring Boot](https://spring.io/projects/spring-boot):Modulo derivado do Spring Framework que facilita desenvolvimento de aplicações java implementando injeção e inversão de dependencias
- [H2](https://github.com/h2database/h2database/releases/download/version-2.2.220/h2.pdf): Gerenciador de banco de dados relacional
- [Postman](https://learning.postman.com/docs/developer/postman-api/intro-api/): Ferramenta destinada a desenvolvedores que possibilita testar chamadas API e gerar documentação de forma iterativa.Foi usado neste projeto para gerar collections e realizar teste de chamadas aos endpoints;
- [Tortoise](https://tortoisegit.org/docs/tortoisegit/): Ferramenta gerencial que facilita manipulação de projetos em GIT. Foi usado neste projeto para resolução de conflitos.
- [Sourcetree](https://confluence.atlassian.com/get-started-with-sourcetree): Assim como o Tortoise é uma ferramenta gerencial para facilitar o desenvolvimento de projetos em Git, no entanto possui uma interface mais receptivel e navegabilidade facilitada.Foi usado neste projeto paa navegação e criação de ramos.

## O que é MongoDB?

**MongoDB** é um banco de dados NoSQL orientado a documentos que armazena dados em um formato flexível de JSON (na verdade, um formato binário chamado BSON - Binary JSON). Ele é projetado para lidar com grandes volumes de dados, escalabilidade horizontal e operações de leitura/escrita de alta velocidade.

### Principais Características do MongoDB

1. **Modelo de Dados Flexível**
    - MongoDB é orientado a documentos, permitindo flexibilidade para lidar com dados dinâmicos e não estruturados. Os dados são armazenados em documentos no formato BSON, semelhante ao JSON.

2. **Escalabilidade Horizontal**
    - Projetado para escalar horizontalmente através de um recurso chamado **Sharding**, permitindo distribuir dados automaticamente entre múltiplos servidores.

3. **Alta Performance**
    - Otimizado para leitura e escrita de alta velocidade, com suporte a operações em lote e índices complexos que melhoram a performance de busca e filtragem.

4. **Alta Disponibilidade**
    - Oferece alta disponibilidade através de **Replica Sets**, que são grupos de instâncias MongoDB que mantêm o mesmo conjunto de dados, garantindo redundância e resiliência em caso de falhas.

5. **Consultas Ricas e Agregação**
    - Possui uma poderosa linguagem de consulta e um framework de agregação avançado que permite buscas complexas, agregações, filtros e projeções de dados diretamente no servidor.

6. **Transações ACID**
    - Suporta transações ACID em múltiplos documentos desde a versão 4.0, garantindo consistência de dados em operações complexas.

7. **Suporte a Indexação e Geoespacial**
    - Permite a criação de índices diversos, incluindo geoespaciais, de texto e de hash, otimizando a performance de consultas e filtros.

8. **Suporte a Agregações e Map-Reduce**
    - Inclui um framework de agregação para operações de processamento de dados e suporte ao modelo **Map-Reduce** para manipulação de grandes conjuntos de dados.

### Casos de Uso Comuns

O MongoDB é ideal para:

- **Aplicações Web em Tempo Real**: Como redes sociais, blogs, sites de e-commerce e aplicativos de chat.
- **Gerenciamento de Conteúdo**: Sistemas de gerenciamento de conteúdo (CMS) que requerem um armazenamento flexível de dados.
- **Big Data e Analytics**: Aplicações que processam grandes volumes de dados não estruturados ou semiestruturados, como logs de servidor, dados de sensores, e streams de eventos.
- **Internet das Coisas (IoT)**: Aplicações de IoT que coletam e analisam dados de dispositivos em tempo real.
- **Sistemas de Recomendação**: Plataformas que precisam adaptar rapidamente seu modelo de dados para responder a diferentes padrões de comportamento do usuário.

### Vantagens

- **Flexibilidade de Modelagem**: Ideal para projetos onde os dados podem mudar frequentemente ou têm uma estrutura não uniforme.
- **Escalabilidade**: Fácil de escalar horizontalmente, o que o torna adequado para grandes volumes de dados.
- **Fácil de Usar**: A API e as ferramentas do MongoDB são simples e intuitivas, facilitando o desenvolvimento.

### Desvantagens

- **Falta de Relacionamentos Rígidos**: Como é um banco NoSQL, o MongoDB não suporta diretamente **joins** complexos como em bancos relacionais, o que pode ser uma limitação em alguns cenários.
- **Uso de Memória**: Pode usar mais memória do que um banco de dados relacional tradicional para armazenar o mesmo volume de dados.
- **Transações Complexas**: Embora suporte transações ACID, elas são mais limitadas em comparação com bancos de dados relacionais.

### Quando Usar o MongoDB?

- Quando você precisa de uma base de dados flexível que possa crescer e mudar rapidamente com as necessidades do projeto.
- Quando sua aplicação precisa lidar com grandes volumes de dados, ou dados que não possuem uma estrutura pré-definida.
- Quando você precisa de um banco de dados que suporte leitura e escrita rápidas.
- Quando você deseja escalar horizontalmente com facilidade.

MongoDB é uma excelente escolha para muitos tipos de aplicações modernas, especialmente aquelas que requerem flexibilidade de dados, escalabilidade e alta performance.
## Práticas adotadas
- Uso de DTOs para a API
- Injeção de Dependências

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
- echo "Apagando arquivos temporários..."

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
- Clonar repositório git
- Construir o projeto:
```
./mvnw clean package
```
- Executar:


A API poderá ser acessada em [localhost:8080](http://localhost:8080)

O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Lista de estacionamento

- GET /alocacao

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
        "texto": "Este é um evento imperdível para todos os fãs do Jesse. Não perca a oportunidade de ver este show incrível!",
        "url": "https://www.jesseshow.com",
        "status": 1,
        "autor": null
    },
    {
        "codigo": "66e1f66b762d203662c30101",
        "titulo": "Jesse Parceiro",
        "data": "2024-09-09T18:30:00",
        "texto": "Este é um evento imperdível para todos os fãs do Jesse. Não perca a oportunidade de ver este show incrível!",
        "url": "https://www.jesseparceiro.com",
        "status": 1,
        "autor": null
    },
    {
        "codigo": "66e21a6a84b8a0583cf50aa3",
        "titulo": "Jesse Parceiro",
        "data": "2024-09-09T18:30:00",
        "texto": "Este é um evento imperdível para todos os fãs do Jesse. Não perca a oportunidade de ver este show incrível!",
        "url": "https://www.jesseparceiro.com",
        "status": 1,
        "autor": null
    },
    {
        "codigo": "66e21a7a84b8a0583cf50aa4",
        "titulo": "Jesse Parceiro",
        "data": "2024-09-09T18:30:00",
        "texto": "Este é um evento imperdível para todos os fãs do Jesse. Não perca a oportunidade de ver este show incrível!",
        "url": "https://www.jesseparceiro.com",
        "status": 1,
        "autor": {
            "codigo": "66e219cf84b8a0583cf50aa2",
            "nome": "Acassio Bernardo",
            "biografia": "Médico cientista",
            "imagem": "jpg"
        }
    },
    {
        "codigo": "66e33403de9e8e07072fa6da",
        "titulo": "Jerm Haroald",
        "data": "2024-09-12T18:02:20.756",
        "texto": "Este é um evento imperdível para todos os fãs do haroald. Não perca a op…",
        "url": "https://www.harosald.com",
        "status": 1,
        "autor": null
    },
    {
        "codigo": "66e33514de9e8e07072fa6db",
        "titulo": "Jerm Haroald",
        "data": "2024-09-12T18:02:20.756",
        "texto": "Este é um evento imperdível para todos os fãs do haroald. Não perca a op…",
        "url": "https://www.harosald.com",
        "status": 1,
        "autor": {
            "codigo": "66e219cf84b8a0583cf50aa2",
            "nome": "Acassio Bernardo",
            "biografia": "Médico cientista",
            "imagem": "jpg"
        }
    }
]
```

CADASTRO DE ESTACIONAMENTO
* POST /alocacao

```
http POST http://localhost:8080/artigos
HTTP/1.1 201 CREATED
Content-Length: 129
Content-Type: application/json

{
    "titulo": "Jerm Haroald",
    "data": "2024-09-12T18:02:20.756803",
    "texto": "Este é um evento imperdível para todos os fãs do haroald. Não perca a op…",
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
    "texto": "Este é um evento imperdível para todos os fãs do haroald. Não perca a op…",
    "url": "https://www.harosald.com",
    "status": 1,
    "autor": {
            "codigo": "66e219cf84b8a0583cf50aa2"
        }
}  
                       
or

    "titulo": "Jerm Haroald",
    "data": "2024-09-12T18:02:20.756803",
    "texto": "Este é um evento imperdível para todos os fãs do haroald. Não perca a op…",
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
    "texto": "Este é um evento imperdível para todos os fãs do haroald. Não perca a op…",
    "url": "https://www.harosald.com",
    "status": 1,
    "autor": null
}
```

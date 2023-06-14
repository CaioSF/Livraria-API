API de Cadastro de Livros
Este é um projeto de API de cadastro de livros, que permite adicionar, visualizar, editar e apagar livros. O backend do projeto foi desenvolvido utilizando o framework Spring Boot, enquanto o frontend utiliza o jQuery.

Funcionalidades
Adicionar um livro: Permite adicionar informações sobre um novo livro, como título, autor, ano de publicação, etc.
Visualizar livros: Exibe uma lista dos livros cadastrados no sistema, mostrando suas informações básicas.
Editar livro: Permite atualizar as informações de um livro existente no sistema.
Apagar livro: Remove um livro do sistema.



Autenticação
Para as operações de edição e adição de livros, é necessário que o usuário esteja autenticado. A autenticação pode ser feita por meio de um processo de login, que pode ser implementado utilizando JWT (JSON Web Tokens), por exemplo. Após a autenticação, o usuário recebe um token que deve ser enviado nas requisições para as operações protegidas.


Tecnologias Utilizadas
Spring Boot: Framework Java utilizado para o desenvolvimento do backend.
jQuery: Biblioteca JavaScript utilizada para o desenvolvimento do frontend.
Banco de Dados: O projeto utiliza um banco de dados para armazenar as informações dos livros cadastrados. É possível utilizar um banco de dados relacional (como MySQL ou PostgreSQL) ou um banco de dados NoSQL (como MongoDB).
Configuração e Execução
Para executar o projeto localmente, siga as instruções abaixo:

Certifique-se de ter o JDK (Java Development Kit) instalado em sua máquina.
Clone este repositório para o seu ambiente de desenvolvimento.
Importe o projeto em sua IDE favorita.
Configure as dependências e o arquivo de configuração do banco de dados.
Execute o projeto Spring Boot para iniciar o backend.
Link para o frontend https://github.com/CaioSF/LivrariaFront
Abra o arquivo index.html no seu navegador para acessar o frontend.

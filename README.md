- Projeto Hotel

Sistema de gerenciamento hoteleiro desenvolvido em Java, utilizando MySQL para armazenamento dos dados e JDBC para comunicação com o banco de dados.

- Sobre o projeto

O projeto tem como objetivo facilitar o gerenciamento das operações de um hotel, permitindo cadastrar e consultar clientes, funcionários, hotéis, quartos e check-ins.

O sistema utiliza uma organização em camadas, separando os modelos de dados, o acesso ao banco de dados e as funcionalidades executadas pelos menus.

- Tecnologias utilizadas

**Java** - desenvolvimento da aplicação.
**MySQL** - banco de dados relacional.
**JDBC** - conexão e execução de comandos SQL.
**PreparedStatement** - execução de consultas parametrizadas.
**IDE:** Visual Studio Code ou outra IDE compatível com Java.

- Organização do projeto

O projeto utiliza pacotes para separar as responsabilidades das classes.

```text
Src/
├── Actions/
│   ├── ClienteActions.java
│   ├── FuncionarioActions.java
│   ├── QuartosActions.java
│   ├── HotelActions.java
│   └── ChekinActions.java
│
├── DAO/
│   ├── ClienteDAO.java
│   ├── ClienteDAOimpl.java
│   ├── FuncionarioDAO.java
│   ├── FuncionarioDAOimpl.java
│   ├── HotelDAO.java
│   ├── HotelDAOimpl.java
│   ├── QuartosDAO.java
│   ├── QuartosDAOimpl.java
│   ├── ChekinDAO.java
│   └── ChekinDAOimpl.java
│
├── Model/
│   ├── Cliente.java
│   ├── Funcionario.java
│   ├── Hotel.java
│   ├── Quartos.java
│   └── Chekin.java
│
├── Menus/
│   └── MenuCheckin.java
│
├── Util/
│   └── Conexao.java
│
└── Main.java
```

*Observação: a estrutura acima representa as classes trabalhadas no projeto; confirme os nomes e os pacotes existentes no repositório antes de utilizá-la como árvore definitiva.*

- Arquitetura do sistema

O sistema segue o padrão DAO (*Data Access Object*), que separa as operações de acesso ao banco de dados da lógica da aplicação.

O fluxo geral é:

```text
Menu
  ↓
Actions
  ↓
DAO / DAOimpl
  ↓
JDBC
  ↓
MySQL
```

- Model

Contém as classes que representam as entidades do sistema e seus atributos, com métodos getters e setters.

- DAO

Define as operações disponíveis para cada entidade, como inserir, listar, buscar, alterar e excluir registros.

- DAOimpl

Implementa as operações definidas nas interfaces DAO, utilizando JDBC e comandos SQL para acessar o banco.

- Actions

Contém a lógica das operações e a interação com o usuário pelo console, incluindo a leitura dos dados e a chamada dos métodos DAO.

- Menus

Apresenta as opções disponíveis e encaminha a escolha do usuário para a funcionalidade correspondente.

- Util

Contém a classe `Conexao`, responsável por centralizar o estabelecimento da conexão com o banco de dados.

- Entidades do sistema

É importante distinguir as responsabilidades de cada entidade.

- Cliente

Representa o hóspede do hotel.

Principais dados:

* Código do cliente.
* Nome.
* Telefone.
* CPF.
* Endereço.
* Passaporte.
* RG.
* E-mail.
* Data de nascimento.
* País.

A classe `Cliente` é utilizada nas operações de cadastro, consulta, atualização e exclusão de hóspedes.

- Funcionário

Representa uma pessoa que trabalha no hotel e utiliza o sistema conforme suas permissões.

Os atributos trabalhados incluem:

* Código do funcionário.
* Nome.
* E-mail.
* Senha.
* Cargo.
* Código do hotel associado.

O funcionário não é o hóspede. Ele é responsável por executar as operações administrativas ou de atendimento.

- Hotel

Representa um hotel cadastrado no sistema.

Principais dados:

* Código.
* Nome.
* Endereço.
* Telefone.

As operações previstas incluem cadastro, listagem, busca, atualização e exclusão.

- Quartos

Representa os quartos relacionados ao hotel e ao check-in, de acordo com o modelo atual do banco.

A classe `Quartos` contém:

* Identificador do quarto.
* Número da reserva de check-in relacionada.
* Código do hotel.
* Tipo de quarto.

O relacionamento com o banco utiliza chaves estrangeiras para manter a integridade dos dados.

- Check-in

Representa o registro de uma hospedagem/reserva associado a um cliente e a um hotel.

A tabela `tbcheckin` contém:

* `N_reserva`: número da reserva, chave primária com incremento automático.
* `TBHotel_Codigo`: código do hotel.
* `data_entrada`: data de entrada.
* `data_saida`: data de saída.
* `N_adultos`: quantidade de adultos.
* `N_Crianca`: quantidade de crianças.
* `Tbcliente_codigo`: código do cliente associado.

O código da reserva é gerado pelo banco durante a inserção. O cliente é associado diretamente ao check-in por meio de `Tbcliente_codigo`.

- Funcionalidades desenvolvidas

- Gerenciamento de clientes

A classe `ClienteActions` concentra as operações de:

* Cadastro de clientes.
* Listagem de clientes.
* Busca por código.
* Atualização de dados.
* Exclusão de clientes.

Os dados são encaminhados ao `ClienteDAOimpl` para persistência no banco.

- Gerenciamento de funcionários

Foram desenvolvidas as classes de modelo e acesso a dados para funcionários, contemplando operações como cadastro, listagem, busca, alteração e exclusão.

A implementação deve ser validada em conjunto com a estrutura real da tabela `tbfuncionario`.

- Gerenciamento de hotéis

A classe `HotelActions` permite:

* Cadastrar hotéis.
* Listar hotéis.
* Buscar um hotel pelo código.
* Atualizar os dados de um hotel.
* Excluir um hotel.

O `HotelDAOimpl` executa as consultas SQL correspondentes. O código do hotel é gerado automaticamente quando a coluna está configurada como `AUTO_INCREMENT`.

- Gerenciamento de quartos

Foram criadas classes para representar os quartos e organizar as operações de acesso ao banco de dados e de interação pelo console.

O cadastro deve respeitar os relacionamentos definidos no banco, principalmente a chave estrangeira que referencia o hotel.

- Gerenciamento de check-ins

O sistema possui classes específicas para o check-in:

* `Chekin`: modelo dos dados.
* `ChekinDAO`: interface de acesso aos dados.
* `ChekinDAOimpl`: implementação das operações SQL.
* `ChekinActions`: interação com o usuário.

As operações implementadas no código trabalhado incluem:

* Realizar check-in.
* Listar check-ins.
* Buscar check-in pelo número da reserva.
* Atualizar check-in.
* Cancelar check-in.

O menu correspondente é `MenuCheckin`, que direciona as escolhas para `ChekinActions`.

- Histórico do cliente

O histórico pode ser consultado utilizando os registros de `tbcheckin` associados ao código do cliente.

Exemplo de consulta SQL:

```sql
SELECT *
FROM tbcheckin
WHERE Tbcliente_codigo = ?;
```

O parâmetro representa o código do cliente cujo histórico será consultado.

Como a tabela `tbcheckin` já possui a referência ao cliente, uma tabela separada chamada `tbhistorico` não é necessária quando seu único objetivo é relacionar clientes e check-ins.

A consulta de histórico deve ser integrada e testada no sistema para que seja considerada uma funcionalidade concluída.

- Banco de dados

O banco utilizado no projeto chama-se `dbhotel`.

As tabelas trabalhadas incluem:

* `tbcliente`
* `tbfuncionario`
* `tbhotel`
* `tbquartos`
* `tbcheckin`

Os relacionamentos são mantidos por chaves primárias e estrangeiras.

Por exemplo:

* Um check-in referencia um cliente.
* Um check-in referencia um hotel.
* Um quarto referencia o hotel e o check-in conforme a estrutura atual do banco.

As operações devem respeitar essas relações. Por exemplo, um registro referenciado por uma chave estrangeira pode não poder ser excluído enquanto houver registros dependentes.

- Conexão com o banco

A classe `Util.Conexao` centraliza a conexão JDBC com o MySQL.

Para executar o projeto, é necessário:

1. Instalar o JDK.
2. Instalar e iniciar o MySQL.
3. Criar o banco `dbhotel` e suas tabelas.
4. Configurar as credenciais de conexão na classe `Conexao`.
5. Adicionar o driver JDBC do MySQL ao projeto.
6. Executar a classe principal e testar as operações.

**Importante:** não publique senhas reais do banco, credenciais ou outros dados sensíveis no repositório.

- Como executar

1. Clone ou baixe o repositório.
2. Abra o projeto na IDE.
3. Configure o JDK e o driver JDBC.
4. Crie o banco de dados e configure a conexão.
5. Verifique se as tabelas e chaves estrangeiras correspondem às consultas utilizadas pelo código.
6. Execute `Main.java`.
7. Utilize as opções do menu para testar as funcionalidades disponíveis.

Os nomes dos pacotes e as classes chamadas pela classe principal devem corresponder à organização real do projeto.

- Testes recomendados

Antes da entrega, verificar:

* Cadastro e listagem de clientes.
* Busca, atualização e exclusão de clientes.
* Cadastro e consulta de funcionários.
* Cadastro, listagem e atualização de hotéis.
* Cadastro e consulta de quartos.
* Realização de check-in com códigos de cliente e hotel existentes.
* Busca de check-in por número de reserva.
* Atualização e cancelamento de check-ins.
* Consulta do histórico de um cliente.
* Tratamento de códigos inexistentes, datas inválidas e violações de chaves estrangeiras.

Também é importante conferir diretamente no MySQL se os registros foram inseridos ou alterados corretamente.

- Objetivo acadêmico

O projeto permite aplicar conceitos de programação orientada a objetos, organização em camadas, interfaces, implementação de DAO, consultas SQL, JDBC, integridade referencial e operações CRUD.

**Projeto desenvolvido para fins acadêmicos.**

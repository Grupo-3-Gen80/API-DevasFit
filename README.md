# Projeto Devas Fit

## Modelo: Sistema Aplicativo de Fitness Personalizado

### Integrantes
- [Daniele Silveira](https://github.com/daniele-silveira)
- [Juliana Assi]()
- [Maria Gabriela](https://github.com/mariagabrielat)
- [Rayanne Dias](https://github.com/DiasRay)
- [Sâmia França](https://github.com/miaelfk)
- [Verônica Santos](https://github.com/veronicaferreiradev)
- [Victoria Borges](https://github.com/VictoriaBorges)

## Descrição Geral
Um sistema de gerenciamento de treinos, onde usuários podem ter múltiplos treinos associados a diferentes categorias. O sistema possui uma estrutura relacional com três entidades principais conectadas através de relacionamentos de cardinalidade.

## Entidades e Atributos



### Entidade Usuário
| Atributo          | Descrição                         |
|-------------------|-----------------------------------|
| `id_usuario (PK)` | Identificador único do usuário    |
| `nome`            | Nome do usuário                   |
| `email`           | Endereço de email para contato    |
| `foto`            | Armazenamento de imagem do perfil |
| `senha`           | Credencial de acesso              |
| `peso`            | Informação física do usuário      |
| `altura`          | Informação física do usuário      |

### Entidade Treinos
| Atributo            | Descrição                           |
|---------------------|-------------------------------------|
| `id_treinos (PK)`   | Identificador único do treino       |
| `nome_treino`       | Nome descritivo do treino           |
| `modalidade`        | Tipo de atividade física            |
| `link`              | Vídeo ou material complementar      |
| `id_categoria (FK)` | Referência à categoria do treino    |
| `id_usuario (FK)`   | Referência ao usuário proprietário  |

### Entidade Categoria
| Atributo            | Descrição                           |
|---------------------|-------------------------------------|
| `id_categoria (PK)` | Identificador único da categoria    |
| `objetivo`          | Finalidade da categoria de treino   |
| `descricao`         | Detalhamento sobre a categoria      |

## Funcionalidades Principais

### CRUD de Usuário
- **CREATE**: Cadastro de novos usuários com informações pessoais
- **READ**: Consulta de perfis de usuários
- **UPDATE**: Modificação de dados pessoais, peso, altura
- **DELETE**: Remoção de contas de usuário

### CRUD de Treinos
- **CREATE**: Cadastro de novos treinos associados a usuários e categorias
- **READ**: Visualização de treinos disponíveis
- **UPDATE**: Modificação de informações do treino
- **DELETE**: Remoção de treinos do sistema

### CRUD de Categoria
- **CREATE**: Cadastro de novas categorias de treino
- **READ**: Consulta de categorias disponíveis
- **UPDATE**: Modificação de objetivos e descrições
- **DELETE**: Remoção de categorias (com tratamento para treinos associados)

## Tecnologias Utilizadas
- **MySQL Workbench**: Banco de dados
- **Spring Boot**: Backend
- **Insomnia**: API

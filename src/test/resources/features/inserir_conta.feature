#language: pt
Funcionalidade: Cadastro de contas
                Como um usuário
                Gostaria de cadastrar contas
                Para que eu possa distribuir meu dinheiro de uma forma mais organizada

#CENARIO DECLARATIVO
  Contexto:
    Dado que desejo adicionar uma conta

  Esquema do Cenario: Deve validar regras do cadastro de contas
    Quando adiciona a conta "<conta>"
    Então recebo a mensagem "<mensagem>"

    Exemplos:
      | conta            | mensagem                           |
      | Conta de teste   | Conta adicionada com sucesso!      |
      |                  | Informe o nome da conta            |
      | Conta mesmo nome | Já existe uma conta com esse nome! |

 # OUTRA FORMA DE ORGANIZAR OS CENARIOS E ATRAVES DO CONTEXTO
#  Contexto:
#    Dado que estou acessando a aplicacao
#    Quando informo o usuario "luisitalomoreirasouza@gmail.com"
#    E a senha "123456"
#    E seleciona entrar
#    Entao visualizo a pagina inicial
#    Quando seleciono Contas
#    E seleciona Adicionar

#  Esquema do Cenario: Deve valiadar regras cadastro contas
#    Quando informa a conta "<conta>"
#    E seleciono Salvar
#    Entao recebo a mensagem "<mensagem>"
#
#    Exemplos:
#      | conta           | mensagem                           |
#      | Conta de Teste  | Conta adicionada com sucesso!      |
#      |                 | Informe o nome da conta            |
#      | Conta mesmo nome| Já existe uma conta com esse nome! |

  #CENARIO IMPERATIVO
#  Cenario: Deve inserir uma conta com sucesso
#    Dado que estou acessando a aplicacao
#    Quando informo o usuario "luisitalomoreirasouza@gmail.com"
#    E a senha "123456"
#    E seleciona entrar
#    Entao visualizo a pagina inicial
#    Quando seleciono Contas
#    E seleciona Adicionar
#    E informa a conta "Conta de Teste"
#    E seleciono Salvar
#    Entao a conta e inserida com sucesso

#@ignore
#    Cenario: Nao deve inserir uma conta sem nome
#      Dado que estou acessando a aplicacao
#      Quando informo o usuario "luisitalomoreirasouza@gmail.com"
#      E a senha "123456"
#      E seleciona entrar
#      Entao visualizo a pagina inicial
#      Quando seleciono Contas
#      E seleciona Adicionar
#      E seleciono Salvar
#      Entao vou notificar que a conta e obrigatoria
#
#@ignore
#      Cenario: Nao deve inserir uma conta com nome ja existente
#        Dado que estou acessando a aplicacao
#        Quando informo o usuario "luisitalomoreirasouza@gmail.com"
#        E a senha "123456"
#        E seleciona entrar
#        Entao visualizo a pagina inicial
#        Quando seleciono Contas
#        E seleciona Adicionar
#        E informa a conta "nao existe"
#        E seleciono Salvar
#        Entao sou notificado que ja existe conta com esse nome


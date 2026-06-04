
Funcionalidades:

Cadastro de doador

Cadastro de beneficiário

Cadastro de item

Listagem de itens

----------------------------------------------------------------------
Modelagem das Classes

Classes Principais
Usuario
A classe Usuario é a classe base do sistema, responsável por representar qualquer pessoa cadastrada na plataforma. Ela reúne informações comuns aos usuários, como:

id
nome
telefone
email
endereço

Essa classe serve como base para especialização de outros tipos de usuários.

Doador
A classe Doador herda da classe Usuario e representa as pessoas que disponibilizam itens para doação no sistema.
Sua principal responsabilidade é cadastrar itens que poderão ser destinados aos beneficiários.

Beneficiario
A classe Beneficiario também herda da classe Usuario e representa os usuários que recebem as doações.
Além dos atributos herdados, possui informações adicionais, como:
tipo de beneficiário (família, ONG, escola, abrigo etc.)
prioridade
Esses dados ajudam o sistema a organizar atendimentos e priorizar casos mais urgentes.

ItemDoacao
A classe ItemDoacao representa os itens cadastrados para doação.
Ela contém informações como:

nome
categoria
quantidade
estado de conservação
status
data de cadastro

Essa classe é responsável por controlar os recursos disponíveis no sistema.

Solicitacao
A classe Solicitacao representa o pedido realizado por um beneficiário para receber determinado item.

Entre seus atributos principais estão:

quantidade solicitada
justificativa
status da solicitação

Essa classe registra todo o processo de pedido dos itens.

DoacaoEfetivada
A classe DoacaoEfetivada registra quando uma doação foi concluída com sucesso.

Ela armazena dados como:

data da entrega
observações
referência ao doador
referência ao beneficiário
referência ao item

---------------------------------------------------------------------------------------------------------------------------------------------
Diagrama de classe:

<img width="3575" height="2526" alt="mermaid-diagram (1)" src="https://github.com/user-attachments/assets/6e92be30-0654-4c2c-a922-5b371ad314cc" />


DOCUMENTAÇÃO

DOCUMENTAÇÃO TÉCNICA — SISTEMA REDE SOLIDÁRIA
Linguagem: Java | Paradigma: Programação Orientada a Objetos
Data: Junho de 2026

════════════════════════════════════════════════════════════════════


RESUMO

Este documento apresenta a documentação técnica do sistema Rede Solidária,
uma aplicação desenvolvida em linguagem Java utilizando os princípios da
Programação Orientada a Objetos (POO). O sistema tem como objetivo gerenciar
o fluxo de doações entre doadores e beneficiários, cobrindo o cadastro de
usuários e itens, o controle de solicitações, a entrega de doações e a
geração de relatórios em formato PDF. A aplicação opera via terminal (CLI)
e organiza seu código em quatro camadas: model, service, repository e main.


════════════════════════════════════════════════════════════════════
1. INTRODUÇÃO
════════════════════════════════════════════════════════════════════

O sistema Rede Solidária foi desenvolvido para informatizar e organizar a
distribuição de itens doados, conectando pessoas que desejam doar com
pessoas ou grupos que necessitam de assistência. A interação com o sistema
é feita por meio de um menu de linha de comando, onde o operador pode
realizar cadastros, consultas, registrar solicitações, confirmar entregas
e emitir relatórios.

O projeto aplica conceitos fundamentais de POO, em especial:

  - Herança: Doador e Beneficiario estendem a classe base Usuario.
  - Encapsulamento: atributos privados com acesso via métodos públicos.
  - Separação de responsabilidades: lógica de negócio nas classes de
    serviço, entidades no model e armazenamento no repository.


════════════════════════════════════════════════════════════════════
2. ESTRUTURA DE PACOTES
════════════════════════════════════════════════════════════════════

O projeto está organizado nos seguintes pacotes:

  main
  └── Main.java               Ponto de entrada; menu interativo

  model
  ├── Usuario.java             Classe base de usuário
  ├── Doador.java              Especialização de Usuario para doadores
  ├── Beneficiario.java        Especialização de Usuario para beneficiários
  ├── ItemDoacao.java          Representa um item disponível para doação
  ├── StatusItem.java          Enumerador de estados do item
  ├── Solicitacao.java         Representa um pedido de item por beneficiário
  └── DoacaoEfetivada.java     Registra uma doação concluída

  repository
  ├── BancoDados.java          Repositório em memória
  ├── IdGenerator.java         Gerador de IDs únicos incrementais
  └── PersistenciaJson.java    Utilitário para leitura/escrita de JSON

  service
  ├── CadastroService.java     Operações de cadastro
  ├── SolicitacaoService.java  Controle do ciclo de vida das solicitações
  └── RelatorioService.java    Geração de relatórios em PDF


════════════════════════════════════════════════════════════════════
3. DESCRIÇÃO DAS CLASSES
════════════════════════════════════════════════════════════════════

────────────────────────────────────────────────────────────────────
3.1 Classe Usuario  |  Pacote: model
────────────────────────────────────────────────────────────────────

Classe base que representa qualquer usuário do sistema. Define os atributos
comuns a doadores e beneficiários e realiza validações básicas no construtor.

Atributos (protected):

  id        int     Identificador único do usuário
  nome      String  Nome completo
  telefone  String  Número de telefone para contato
  email     String  Endereço de e-mail
  endereco  String  Endereço físico

Construtor:
  Usuario(int id, String nome, String telefone, String email, String endereco)

Validações:
  - Nome nulo ou vazio: substituído por "Não foi informado".
  - E-mail sem "@": substituído por "email@invalido.com".

Métodos:
  getId(), getNome(), getTelefone(), getEmail(), getEndereco()


────────────────────────────────────────────────────────────────────
3.2 Classe Doador  |  Pacote: model  |  Herança: extends Usuario
────────────────────────────────────────────────────────────────────

Representa a pessoa que disponibiliza itens para doação. Herda todos os
atributos e comportamentos de Usuario sem adicionar atributos próprios.

Construtor:
  Doador(int id, String nome, String telefone, String email, String endereco)
  — delega integralmente para super(...)


────────────────────────────────────────────────────────────────────
3.3 Classe Beneficiario  |  Pacote: model  |  Herança: extends Usuario
────────────────────────────────────────────────────────────────────

Representa a pessoa ou grupo que recebe doações. Acrescenta dois atributos
à herança de Usuario para categorização e priorização do atendimento.

Atributos adicionais (private):

  tipo        String  Categoria (ex.: Familia, ONG, Escola, Abrigo)
  prioridade  int     Nível de prioridade de atendimento

Construtor:
  Beneficiario(int id, String nome, String telefone, String email,
               String endereco, String tipo, int prioridade)

Métodos:
  getTipo(), getPrioridade()


────────────────────────────────────────────────────────────────────
3.4 Classe ItemDoacao  |  Pacote: model
────────────────────────────────────────────────────────────────────

Representa um item cadastrado para doação. Controla o ciclo de vida
por meio do enumerador StatusItem.

Atributos (private):

  id         int         Identificador único
  nome       String      Nome descritivo
  categoria  String      Categoria do item
  quantidade int         Quantidade disponível
  status     StatusItem  Estado atual no fluxo de doação

Construtor:
  ItemDoacao(int id, String nome, String categoria, int quantidade)
  — status inicia automaticamente como StatusItem.DISPONIVEL

Validações:
  - Nome nulo ou vazio: substituído por "Item sem nome".
  - Quantidade <= 0: substituída por 1.

Métodos:
  getId(), getNome(), getCategoria(), getQuantidade()
  getStatus(), setStatus(StatusItem)
  toString() — retorna: "ID: x | Nome: x | Categoria: x | Quantidade: x | Status: x"


────────────────────────────────────────────────────────────────────
3.5 Enumerador StatusItem  |  Pacote: model
────────────────────────────────────────────────────────────────────

Define os estados possíveis de um item:

  DISPONIVEL   Item pronto para ser solicitado
  SOLICITADO   Reservado por um beneficiário
  ENTREGUE     Entregue ao beneficiário
  CANCELADO    Solicitação cancelada


────────────────────────────────────────────────────────────────────
3.6 Classe Solicitacao  |  Pacote: model
────────────────────────────────────────────────────────────────────

Representa o pedido formal de um beneficiário por um item disponível.

Atributos (private):

  beneficiario  Beneficiario  Beneficiário que realizou o pedido
  item          ItemDoacao    Item solicitado

Construtor:
  Solicitacao(Beneficiario beneficiario, ItemDoacao item)

Métodos:
  getBeneficiario(), getItem()
  toString() — retorna: "Beneficiário: [nome] | Item: [nome]"


────────────────────────────────────────────────────────────────────
3.7 Classe DoacaoEfetivada  |  Pacote: model
────────────────────────────────────────────────────────────────────

Registra uma doação concluída. Na versão atual armazena somente uma
descrição textual, servindo como base para expansões futuras.

Atributo (private):

  descricao  String  Descrição livre da doação efetivada

Construtor:
  DoacaoEfetivada(String descricao)

Métodos:
  getDescricao()


────────────────────────────────────────────────────────────────────
3.8 Classe BancoDados  |  Pacote: repository
────────────────────────────────────────────────────────────────────

Repositório central em memória. Armazena as coleções de entidades em
listas estáticas acessíveis por todas as classes de serviço.

Atributos (public static):

  doadores      ArrayList<Doador>
  beneficiarios ArrayList<Beneficiario>
  itens         ArrayList<ItemDoacao>
  solicitacoes  ArrayList<Solicitacao>

Observação: dados são perdidos ao encerrar a aplicação.


────────────────────────────────────────────────────────────────────
3.9 Classe IdGenerator  |  Pacote: repository
────────────────────────────────────────────────────────────────────

Gera identificadores numéricos únicos e incrementais para usuários e itens.

Atributos (private static):

  usuarioId  int  Contador de IDs de usuários; inicia em 1
  itemId     int  Contador de IDs de itens; inicia em 1

Métodos (public static):

  novoUsuarioId()  Retorna próximo ID de usuário e incrementa
  novoItemId()     Retorna próximo ID de item e incrementa

Observação: implementado, mas não integrado ao Main.java na versão atual.
Os cadastros ainda passam o valor fixo 1 como ID.


────────────────────────────────────────────────────────────────────
3.10 Classe PersistenciaJson  |  Pacote: repository
────────────────────────────────────────────────────────────────────

Utilitário para leitura e escrita de dados em arquivos JSON, possibilitando
persistência entre execuções do sistema.

Métodos (public static):

  salvar(String json, String arquivo)
    — Escreve o conteúdo JSON no arquivo usando FileWriter.
    — Exceções são silenciadas.

  carregar(String arquivo)
    — Lê o arquivo e retorna seu conteúdo como String.
    — Retorna String vazia em caso de erro.

Observação: implementado, mas não integrado ao fluxo principal.


────────────────────────────────────────────────────────────────────
3.11 Classe CadastroService  |  Pacote: service
────────────────────────────────────────────────────────────────────

Responsável pelas operações de cadastro das entidades principais.

Métodos:

  cadastrarDoador(Doador d)
    — Adiciona em BancoDados.doadores.
    — Exibe "Doador cadastrado com sucesso."

  cadastrarBeneficiario(Beneficiario b)
    — Adiciona em BancoDados.beneficiarios.
    — Exibe "Beneficiário cadastrado com sucesso."

  cadastrarItem(ItemDoacao i)
    — Adiciona em BancoDados.itens.
    — Exibe "Item cadastrado com sucesso."


────────────────────────────────────────────────────────────────────
3.12 Classe SolicitacaoService  |  Pacote: service
────────────────────────────────────────────────────────────────────

Gerencia o ciclo de vida das solicitações de doação.

Métodos:

  solicitarItem(Beneficiario beneficiario, ItemDoacao item)
    — Verifica se status == DISPONIVEL.
    — Se sim: altera para SOLICITADO e registra Solicitacao no BancoDados.
    — Se não: exibe "Item indisponível."

  entregarItem(ItemDoacao item)
    — Verifica se status == SOLICITADO.
    — Se sim: altera para ENTREGUE.
    — Se não: exibe "Somente itens solicitados podem ser entregues."

  cancelarSolicitacao(ItemDoacao item)
    — Altera status para CANCELADO.

  listarItensDisponiveis()
    — Exibe todos os itens com status DISPONIVEL.

  filtrarPorCategoria(String categoria)
    — Exibe itens cuja categoria corresponda ao filtro (sem distinção
      de maiúsculas/minúsculas).


────────────────────────────────────────────────────────────────────
3.13 Classe RelatorioService  |  Pacote: service
────────────────────────────────────────────────────────────────────

Gera relatórios em PDF construindo a estrutura do arquivo manualmente
conforme a especificação PDF 1.4, sem bibliotecas externas.

Método privado:

  gerarPdf(String arquivo, String titulo, String conteudo)
    — Monta a estrutura do documento PDF com fonte Helvetica (Type1).
    — Salva o arquivo no diretório de execução.

Métodos públicos:

  gerarHistoricoDoacoesPDF()
    — Compila todos os itens registrados.
    — Gera "historico_doacoes.pdf".

  gerarItensEntreguesPDF()
    — Filtra itens com status ENTREGUE.
    — Gera "itens_entregues.pdf".

  gerarSolicitacoesPDF()
    — Compila todas as solicitações.
    — Gera "solicitacoes.pdf".


────────────────────────────────────────────────────────────────────
3.14 Classe Main  |  Pacote: main
────────────────────────────────────────────────────────────────────

Ponto de entrada da aplicação. Instancia os serviços, exibe o menu
interativo em loop do-while e delega as operações.

Serviços instanciados: CadastroService, SolicitacaoService, RelatorioService

Opções do menu:

  0   Encerrar o sistema
  1   Cadastrar Doador       (Nome, Telefone, Email, Endereço)
  2   Cadastrar Beneficiário (Nome, Telefone, Email, Endereço)
  3   Cadastrar Item         (Nome, Categoria, Quantidade)
  4   Listar Itens Disponíveis
  5   Solicitar Item
  6   Entregar Item
  7   Filtrar por Categoria
  8   Gerar PDF — Histórico de Doações
  9   Gerar PDF — Itens Entregues
  10  Gerar PDF — Solicitações


════════════════════════════════════════════════════════════════════
 HIERARQUIA DE CLASSES
════════════════════════════════════════════════════════════════════

  Usuario
  ├── id: int
  ├── nome: String
  ├── telefone: String
  ├── email: String
  └── endereco: String
       ├── Doador  (herda tudo de Usuario; sem atributos adicionais)
       └── Beneficiario  (herda tudo + tipo: String, prioridade: int)

  ItemDoacao
  ├── id: int
  ├── nome: String
  ├── categoria: String
  ├── quantidade: int
  └── status: StatusItem { DISPONIVEL | SOLICITADO | ENTREGUE | CANCELADO }

  Solicitacao
  ├── beneficiario: Beneficiario
  └── item: ItemDoacao

  DoacaoEfetivada
  └── descricao: String

  BancoDados  (repositório estático em memória)
  ├── doadores:      ArrayList<Doador>
  ├── beneficiarios: ArrayList<Beneficiario>
  ├── itens:         ArrayList<ItemDoacao>
  └── solicitacoes:  ArrayList<Solicitacao>


════════════════════════════════════════════════════════════════════
 FLUXO PRINCIPAL DE OPERAÇÃO
════════════════════════════════════════════════════════════════════

  Passo 1 — Cadastrar Doador (opção 1):
            Informar nome, telefone, e-mail e endereço.

  Passo 2 — Cadastrar Beneficiário (opção 2):
            Informar nome, telefone, e-mail e endereço.

  Passo 3 — Cadastrar Item (opção 3):
            Informar nome, categoria e quantidade.
            Item inicia com status DISPONIVEL.

  Passo 4 — Listar ou Filtrar itens (opções 4 e 7):
            Consultar itens disponíveis antes de prosseguir.

  Passo 5 — Solicitar Item (opção 5):
            Sistema verifica disponibilidade e altera status para SOLICITADO.

  Passo 6 — Entregar Item (opção 6):
            Sistema verifica solicitação e altera status para ENTREGUE.

  Passo 7 — Gerar Relatórios (opções 8, 9 ou 10):
            Arquivos PDF salvos no diretório de execução.


════════════════════════════════════════════════════════════════════
 CONSIDERAÇÕES TÉCNICAS
════════════════════════════════════════════════════════════════════

Leitura de entrada com Scanner
  O sc.nextInt() lê o número mas não consome o "\n" final. Sem tratamento,
  o próximo sc.nextLine() capturaria uma linha vazia. Por isso, aplica-se
  sc.nextLine() após cada sc.nextInt() para limpar o buffer.

Validação de dados
  Usuario e ItemDoacao aplicam validações no construtor, substituindo
  entradas inválidas por valores padrão em vez de lançar exceções,
  garantindo que o objeto seja criado em estado sempre utilizável.

Persistência em memória
  Todos os dados são perdidos ao encerrar o programa. Os PDFs gerados
  são a única saída persistida em disco.

Utilitários não integrados
  IdGenerator e PersistenciaJson estão implementados, mas não são
  acionados pelo fluxo atual. Os cadastros passam o valor fixo 1 como ID.

Geração de PDF sem biblioteca externa
  A estrutura PDF é montada manualmente conforme a especificação 1.4.
  Isso elimina dependências, mas limita suporte a caracteres acentuados,
  formatação avançada e paginação automática.


════════════════════════════════════════════════════════════════════
 CONCLUSÃO
════════════════════════════════════════════════════════════════════

O sistema Rede Solidária aplica de forma prática os princípios da
Programação Orientada a Objetos. A arquitetura em camadas favorece a
manutenibilidade e a separação de responsabilidades. O uso de herança
entre Usuario, Doador e Beneficiario elimina redundância e facilita
extensões futuras.

Melhorias recomendadas:

  - Integrar IdGenerator para geração automática de IDs únicos.
  - Integrar PersistenciaJson para salvar e recuperar dados entre sessões.
  - Permitir seleção interativa de beneficiário e item nas opções 5 e 6,
    em vez de usar sempre o primeiro elemento da lista.
  - Corrigir a validação do menu para cobrir as opções 8, 9 e 10.
  - Usar uma biblioteca PDF para suporte completo a acentuação e formatação.

════════════════════════════════════════════════════════════════════
Documentação elaborada com base no código-fonte do projeto Rede Solidária.
════════════════════════════════════════════════════════════════════

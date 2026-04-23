
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

<img width="571" height="501" alt="image" src="https://github.com/user-attachments/assets/e72d92ff-d1fc-4b7b-9b16-000253725cce" />


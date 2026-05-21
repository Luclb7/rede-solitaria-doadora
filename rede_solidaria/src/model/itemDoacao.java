package model;

public class ItemDoacao {

    private int id;
    private String nome;
    private String categoria;
    private int quantidade;
    private StatusItem status;

    public ItemDoacao(int id, String nome,String categoria, int quantidade) {

        if (nome == null || nome.isEmpty()) {
            System.out.println("Nome do item obrigatório.");
            nome = "Item sem nome";
        }

        if (quantidade <= 0) {
            System.out.println("Quantidade inválida.");
            quantidade = 1;
        }

        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.status = StatusItem.DISPONIVEL;
    }

    public int getId(){return id;}

    public String getNome() {return nome;}
    public String getCategoria() {return categoria;}
    public int getQuantidade() {return quantidade;}
    public StatusItem getStatus() {return status;}
    public void setStatus(StatusItem status) {this.status = status;}

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome +" | Categoria: " + categoria +" | Quantidade: " + quantidade +" | Status: " + status;
    }
}

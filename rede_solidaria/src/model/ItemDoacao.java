package model;

public class ItemDoacao {
    private int id;
    private String nome;
    private String categoria;
    private int quantidade;
    private String status;

    public ItemDoacao(int id, String nome, String categoria, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.status = "disponivel";
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getCategoria() { return categoria; }
    public int getQuantidade() { return quantidade; }
    public String getStatus() { return status; }
}

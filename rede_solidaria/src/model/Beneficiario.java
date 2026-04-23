package model;

public class Beneficiario extends Usuario {
    private String tipo;
    private int prioridade;

    public Beneficiario(int id, String nome, String telefone, String email, String endereco, String tipo, int prioridade) {
        super(id, nome, telefone, email, endereco);
        this.tipo = tipo;
        this.prioridade = prioridade;
    }

    public String getTipo() { return tipo; }
    public int getPrioridade() { return prioridade; }
}

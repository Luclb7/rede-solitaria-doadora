package model;

public class Usuario {

    protected int id;
    protected String nome;
    protected String telefone;
    protected String email;
    protected String endereco;

    public Usuario(int id, String nome, String telefone, String email, String endereco) {

        if (nome == null || nome.isEmpty()) {
            System.out.println("Nome obrigatório");
            nome = "Não foi informado";
        }

        if (email == null || !email.contains("@")) {
            System.out.println("Email inválido");
            email = "email@invalido.com";
        }

        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public int getId() {return id;}
    public String getNome() {return nome;}
    public String getTelefone() {return telefone;}
    public String getEmail() {return email;}
    public String getEndereco() {return endereco;}
}

package model;

public class Solicitacao {

    private Beneficiario beneficiario;
    private ItemDoacao item;

    public Solicitacao(Beneficiario beneficiario, ItemDoacao item) {
        this.beneficiario = beneficiario;
        this.item = item;
    }
  
    public Beneficiario getBeneficiario() {
        return beneficiario;
    }
  
    public ItemDoacao getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "Beneficiário: " + beneficiario.getNome() +" | Item: " + item.getNome();
    }
}

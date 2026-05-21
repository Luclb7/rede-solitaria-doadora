package service;

import model.*;
import repository.BancoDados;

public class CadastroService {

    public void cadastrarDoador(Doador d) {
        BancoDados.doadores.add(d);
        System.out.println("Doador cadastrado com sucesso.");
    }

    public void cadastrarBeneficiario(Beneficiario b) {
        BancoDados.beneficiarios.add(b);
        System.out.println("Beneficiário cadastrado com sucesso.");
    }

    public void cadastrarItem(ItemDoacao i) {
        BancoDados.itens.add(i);
        System.out.println("Item cadastrado com sucesso.");
    }
}

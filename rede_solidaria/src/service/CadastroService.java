package service;

import model.*;
import repository.BancoDados;

public class CadastroService {

    public void cadastrarDoador(Doador d) {
        BancoDados.doadores.add(d);
    }

    public void cadastrarBeneficiario(Beneficiario b) {
        BancoDados.beneficiarios.add(b);
    }

    public void cadastrarItem(ItemDoacao i) {
        BancoDados.itens.add(i);
    }
}

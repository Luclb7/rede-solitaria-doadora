package service;

import model.*;
import repository.BancoDados;

public class SolicitacaoService {

    public void solicitarItem(Beneficiario beneficiario, ItemDoacao item) {

        if (item.getStatus() != StatusItem.DISPONIVEL) {
            System.out.println("Item indisponível.");
            return;
        }

        item.setStatus(StatusItem.SOLICITADO);
        Solicitacao solicitacao = new Solicitacao(beneficiario, item);
        BancoDados.solicitacoes.add(solicitacao);
        System.out.println("Solicitação realizada com sucesso.");
    }

    public void entregarItem(ItemDoacao item) {

        if (item.getStatus() != StatusItem.SOLICITADO) {
            System.out.println("Somente itens solicitados podem ser entregues.");
            return;
        }

        item.setStatus(StatusItem.ENTREGUE);
        System.out.println("Item entregue com sucesso.");
    }

    public void cancelarSolicitacao(ItemDoacao item) {
        item.setStatus(StatusItem.CANCELADO);
        System.out.println("Solicitação cancelada.");
    }

    public void listarItensDisponiveis() {
        for (ItemDoacao item : BancoDados.itens) {
            if (item.getStatus() == StatusItem.DISPONIVEL) {
                System.out.println(item);
            }
        }
    }

    public void filtrarPorCategoria(String categoria) {
        for (ItemDoacao item : BancoDados.itens) {
            if (item.getCategoria().equalsIgnoreCase(categoria)) {
                System.out.println(item);
            }
        }
    }
}

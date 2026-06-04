package main;

import java.util.Scanner;
import model.*;
import repository.BancoDados;
import service.CadastroService;
import service.SolicitacaoService;
import service.RelatorioService;

public class Main {

            public static void main(String[] args) {            

        Scanner sc = new Scanner(System.in);

        CadastroService cadastroService = new CadastroService();
        SolicitacaoService solicitacaoService = new SolicitacaoService();
        RelatorioService relatorioService = new RelatorioService();

        int opcao;          

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar Doador");
            System.out.println("2 - Cadastrar Beneficiário");
            System.out.println("3 - Cadastrar Item");
            System.out.println("4 - Listar Itens Disponíveis");
            System.out.println("5 - Solicitar Item");
            System.out.println("6 - Entregar Item");
            System.out.println("7 - Filtrar por Categoria");
            System.out.println("8 - PDF Historico de Doacoes");
            System.out.println("9 - PDF Itens Entregues");
            System.out.println("10 - PDF Solicitacoes");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao < 0 || opcao > 7) {
              System.out.println("Validação errada, tente novamente!");
            }


            switch (opcao) {

                    case 1:

                        System.out.print("Nome: ");
                        String nomeD = sc.nextLine();

                        System.out.print("Telefone: ");
                        String telefoneD = sc.nextLine();

                        System.out.print("Email: ");
                        String emailD = sc.nextLine();

                        System.out.print("Endereço: ");
                        String enderecoD = sc.nextLine();

                        cadastroService.cadastrarDoador(new Doador(1, nomeD, telefoneD, emailD, enderecoD));

                        break;

                    case 2:

                        System.out.print("Nome: ");
                        String nomeB = sc.nextLine();
                        System.out.print("Telefone: ");
                        String telefoneB = sc.nextLine();
                        System.out.print("Email: ");
                        String emailB = sc.nextLine();
                        System.out.print("Endereço: ");
                        String enderecoB = sc.nextLine();
                        cadastroService.cadastrarBeneficiario(new Beneficiario(1, nomeB, telefoneB, emailB, enderecoB, "Familia", 1));

                        break;

                    case 3:

                        System.out.print("Nome do Item: ");
                        String nomeItem = sc.nextLine();
                        System.out.print("Categoria: ");
                        String categoria = sc.nextLine();
                        System.out.print("Quantidade: ");
                        int quantidade = sc.nextInt();

                        cadastroService.cadastrarItem(new ItemDoacao(1,nomeItem,categoria,quantidade));

                        break;

                    case 4:
                       solicitacaoService.listarItensDisponiveis();
                        break;

                    case 5:

                        if (BancoDados.beneficiarios.isEmpty() || BancoDados.itens.isEmpty()) {

                            System.out.println("Cadastre beneficiários e itens primeiro.");
                            break;
                        }
                        solicitacaoService.solicitarItem(BancoDados.beneficiarios.get(0),BancoDados.itens.get(0));

                        break;

                    case 6:

                        if (!BancoDados.itens.isEmpty()) {solicitacaoService.entregarItem(BancoDados.itens.get(0));
                        }

                        break;

                    case 7:

                        System.out.print("Categoria: ");
                        String filtro = sc.nextLine();
                        solicitacaoService.filtrarPorCategoria(filtro);
                        break;

                    case 8:
                        relatorioService.gerarHistoricoDoacoesPDF();
                        System.out.println("PDF gerado.");
                        break;

                    case 9:
                        relatorioService.gerarItensEntreguesPDF();
                        System.out.println("PDF gerado.");
                        break;

                    case 10:
                        relatorioService.gerarSolicitacoesPDF();
                        System.out.println("PDF gerado.");
                        break;
                }

        } while (opcao != 0);
        sc.close();
    }
}


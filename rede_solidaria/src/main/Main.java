package main;

import java.util.Scanner;
import model.*;
import service.CadastroService;
import repository.BancoDados;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CadastroService service = new CadastroService();

        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar Doador");
            System.out.println("2 - Cadastrar Beneficiario");
            System.out.println("3 - Cadastrar Item");
            System.out.println("4 - Listar Itens");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nomeD = sc.nextLine();
                    service.cadastrarDoador(new Doador(1, nomeD, "", "", ""));
                    break;

                case 2:
                    System.out.print("Nome: ");
                    String nomeB = sc.nextLine();
                    service.cadastrarBeneficiario(new Beneficiario(1, nomeB, "", "", "", "familia", 1));
                    break;

                case 3:
                    System.out.print("Nome do item: ");
                    String nomeI = sc.nextLine();
                    service.cadastrarItem(new ItemDoacao(1, nomeI, "geral", 1));
                    break;

                case 4:
                    for (ItemDoacao i : BancoDados.itens) {
                        System.out.println(i.getNome());
                    }
                    break;
            }

        } while(opcao != 0);

        sc.close();
    }
}

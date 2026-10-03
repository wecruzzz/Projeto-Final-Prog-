package Actions;

import java.util.Scanner;

public class MenuHotel {

    private Scanner scanner = new Scanner(System.in);

    public void abrirMenu() {

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n==============================");
            System.out.println("          MENU HOTEL");
            System.out.println("==============================");

            System.out.println("1 - Cadastrar hotel");
            System.out.println("2 - Listar hotéis");
            System.out.println("3 - Buscar hotel");
            System.out.println("4 - Atualizar hotel");
            System.out.println("5 - Excluir hotel");
            System.out.println("0 - Voltar");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("Cadastro de hotel ainda não implementado.");
                    break;

                case 2:
                    System.out.println("Listagem de hotéis ainda não implementada.");
                    break;

                case 3:
                    System.out.println("Busca de hotel ainda não implementada.");
                    break;

                case 4:
                    System.out.println("Atualização de hotel ainda não implementada.");
                    break;

                case 5:
                    System.out.println("Exclusão de hotel ainda não implementada.");
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
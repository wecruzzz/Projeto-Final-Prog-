package Menus;
import java.util.Scanner;

public class MenuCheckin {

    private Scanner scanner = new Scanner(System.in);

    public void abrirMenu() {

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n==============================");
            System.out.println("         MENU CHECK-IN");
            System.out.println("==============================");

            System.out.println("1 - Realizar check-in");
            System.out.println("2 - Listar check-ins");
            System.out.println("3 - Buscar check-in");
            System.out.println("4 - Atualizar check-in");
            System.out.println("5 - Cancelar check-in");
            System.out.println("0 - Voltar");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("Função de check-in ainda não implementada.");
                    break;

                case 2:
                    System.out.println("Função de listagem ainda não implementada.");
                    break;

                case 3:
                    System.out.println("Função de busca ainda não implementada.");
                    break;

                case 4:
                    System.out.println("Função de atualização ainda não implementada.");
                    break;

                case 5:
                    System.out.println("Função de cancelamento ainda não implementada.");
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
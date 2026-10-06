package Menus;

import Actions.ChekinActions;

import java.util.Scanner;

public class MenuCheckin {

    private Scanner scanner = new Scanner(System.in);

    public void abrirMenu() {

        ChekinActions chekinActions = new ChekinActions();

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
                    chekinActions.inserirChekin();
                    break;

                case 2:
                    chekinActions.listarChekin();
                    break;

                case 3:
                    chekinActions.buscarChekin();
                    break;

                case 4:
                    chekinActions.alterarChekin();
                    break;

                case 5:
                    chekinActions.removerChekin();
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
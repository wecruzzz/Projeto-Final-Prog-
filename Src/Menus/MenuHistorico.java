package Menus;

import java.util.Scanner;

public class MenuHistorico {

    private Scanner scanner = new Scanner(System.in);

    public void abrirMenu() {

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n==============================");
            System.out.println("        MENU HISTÓRICO");
            System.out.println("==============================");

            System.out.println("1 - Visualizar histórico");
            System.out.println("2 - Buscar histórico");
            System.out.println("0 - Voltar");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println(
                            "Histórico ainda não implementado.");
                    break;

                case 2:
                    System.out.println(
                            "Busca de histórico ainda não implementada.");
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
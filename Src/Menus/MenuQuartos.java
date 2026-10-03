package Actions;

import java.util.Scanner;

public class MenuQuartos {

    private Scanner scanner = new Scanner(System.in);

    public void abrirMenu() {

        QuartosActions quartoActions =
                new QuartosActions();

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n==============================");
            System.out.println("         MENU DE QUARTOS");
            System.out.println("==============================");

            System.out.println("1 - Cadastrar quarto");
            System.out.println("2 - Listar quartos");
            System.out.println("3 - Buscar quarto");
            System.out.println("4 - Atualizar quarto");
            System.out.println("5 - Excluir quarto");
            System.out.println("0 - Voltar");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    quartoActions.inserirQuarto();
                    break;

                case 2:
                    quartoActions.listarQuartos();
                    break;

                case 3:
                    quartoActions.buscarQuarto();
                    break;

                case 4:
                    quartoActions.alterarQuarto();
                    break;

                case 5:
                    quartoActions.removerQuarto();
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
package Actions;

import java.util.Scanner;

public class MenuFuncionario {

    private Scanner scanner = new Scanner(System.in);

    public void abrirMenu() {

        FuncionarioActions funcionarioActions =
                new FuncionarioActions();

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n==============================");
            System.out.println("      MENU DE FUNCIONÁRIOS");
            System.out.println("==============================");

            System.out.println("1 - Cadastrar funcionário");
            System.out.println("2 - Listar funcionários");
            System.out.println("3 - Buscar funcionário");
            System.out.println("4 - Atualizar funcionário");
            System.out.println("5 - Excluir funcionário");
            System.out.println("0 - Voltar");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    funcionarioActions.inserirFuncionario();
                    break;

                case 2:
                    funcionarioActions.listarFuncionario();
                    break;

                case 3:
                    funcionarioActions.buscarFuncionario();
                    break;

                case 4:
                    funcionarioActions.alterarFuncionario();
                    break;

                case 5:
                    funcionarioActions.removerFuncionario();
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
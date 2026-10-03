package Actions;

import java.util.Scanner;

public class MenuCliente {

    private Scanner scanner = new Scanner(System.in);

    public void abrirMenu() {

        ClienteActions clienteActions =
                new ClienteActions();

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n==============================");
            System.out.println("       MENU DE CLIENTES");
            System.out.println("==============================");

            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Buscar cliente");
            System.out.println("4 - Atualizar cliente");
            System.out.println("5 - Excluir cliente");
            System.out.println("0 - Voltar");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    clienteActions.inserirCliente();
                    break;

                case 2:
                    clienteActions.ListarCliente();
                    break;

                case 3:
                    clienteActions.buscarCliente();
                    break;

                case 4:
                    clienteActions.atualizarCliente();
                    break;

                case 5:
                    clienteActions.removerCliente();
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
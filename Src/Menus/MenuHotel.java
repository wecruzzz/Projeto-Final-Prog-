package Actions;

import java.util.Scanner;

public class MenuHotel {

    private Scanner scanner = new Scanner(System.in);

    public void abrirMenu() {

        HotelActions hotelActions = new HotelActions();

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
                    hotelActions.inserirHotel();
                    break;

                case 2:
                    hotelActions.listarHoteis();
                    break;

                case 3:
                    hotelActions.buscarHotel();
                    break;

                case 4:
                    hotelActions.alterarHotel();
                    break;

                case 5:
                    hotelActions.removerHotel();
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
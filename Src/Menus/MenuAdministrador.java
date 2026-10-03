package Menus;
import Actions.MenuCliente;
import Actions.MenuFuncionario;
import Actions.MenuHotel;
import Actions.MenuQuartos;
import Menus.MenuCheckin;
import Menus.MenuHistorico;
import java.util.Scanner;

public class MenuAdministrador {

    private Scanner scanner = new Scanner(System.in);

    public void abrirMenu() {

        MenuCliente menuCliente = new MenuCliente();
        MenuQuartos menuQuartos = new MenuQuartos();
        MenuCheckin menuCheckin = new MenuCheckin();
        MenuHistorico menuHistorico = new MenuHistorico();
        MenuHotel menuHotel = new MenuHotel();
        MenuFuncionario menuFuncionario = new MenuFuncionario();

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n================================");
            System.out.println("      MENU ADMINISTRADOR");
            System.out.println("================================");

            System.out.println("1 - Clientes");
            System.out.println("2 - Quartos");
            System.out.println("3 - Check-in");
            System.out.println("4 - Histórico");
            System.out.println("5 - Hotéis");
            System.out.println("6 - Funcionários");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    menuCliente.abrirMenu();
                    break;

                case 2:
                    menuQuartos.abrirMenu();
                    break;

                case 3:
                    menuCheckin.abrirMenu();
                    break;

                case 4:
                    menuHistorico.abrirMenu();
                    break;

                case 5:
                    menuHotel.abrirMenu();
                    break;

                case 6:
                    menuFuncionario.abrirMenu();
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
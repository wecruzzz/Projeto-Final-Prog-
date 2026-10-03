package Actions;

import DAO.QuartosDAOimpl;
import Model.Quartos;

import java.util.List;
import java.util.Scanner;

// Contém todas as funções relacionadas aos quartos "CRUD"
public class QuartosActions {

    Scanner scanner = new Scanner(System.in);

    // INSERIR QUARTO
    public void inserirQuarto() {

        Quartos quarto = new Quartos();

        System.out.print("Código do Hotel: ");
        quarto.setTBHotel_Codigo(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Número da reserva do Check-in: ");
        quarto.setTBchekin_N_reserva(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Tipo de quarto: ");
        quarto.setTipo_de_quarto(scanner.nextLine());

        QuartosDAOimpl quartoDAO = new QuartosDAOimpl();

        quartoDAO.inserir(quarto);
    }


    // LISTAR QUARTOS
    public void listarQuartos() {

        QuartosDAOimpl quartoDAO = new QuartosDAOimpl();

        List<Quartos> lista = quartoDAO.listar();

        System.out.println("\n===== LISTA DE QUARTOS =====");

        for (Quartos quarto : lista) {

            System.out.println("ID: " + quarto.getId());
            System.out.println("Número da reserva: "
                    + quarto.getTBchekin_N_reserva());
            System.out.println("Código do Hotel: "
                    + quarto.getTBHotel_Codigo());
            System.out.println("Tipo de quarto: "
                    + quarto.getTipo_de_quarto());

            System.out.println("-----------------------------");
        }
    }


    // ALTERAR QUARTO
    public void alterarQuarto() {

        QuartosDAOimpl quartoDAO = new QuartosDAOimpl();

        Quartos quarto = new Quartos();

        System.out.print("ID do quarto: ");
        quarto.setId(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Número da reserva do Check-in: ");
        quarto.setTBchekin_N_reserva(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Código do Hotel: ");
        quarto.setTBHotel_Codigo(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Tipo de quarto: ");
        quarto.setTipo_de_quarto(scanner.nextLine());

        quartoDAO.alterar(quarto);
    }


    // EXCLUIR QUARTO
    public void removerQuarto() {

        QuartosDAOimpl quartoDAO = new QuartosDAOimpl();

        System.out.print("ID do quarto: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        quartoDAO.excluir(id);
    }


    // BUSCAR QUARTO
    public Quartos buscarQuarto() {

        QuartosDAOimpl quartoDAO = new QuartosDAOimpl();

        Quartos quarto = new Quartos();

        System.out.print("ID do quarto: ");
        quarto.setId(scanner.nextInt());
        scanner.nextLine();

        Quartos resultado = quartoDAO.buscar(quarto);

        if (resultado != null) {

            System.out.println("\n===== QUARTO =====");

            System.out.println("ID: "
                    + resultado.getId());

            System.out.println("Número da reserva: "
                    + resultado.getTBchekin_N_reserva());

            System.out.println("Código do Hotel: "
                    + resultado.getTBHotel_Codigo());

            System.out.println("Tipo de quarto: "
                    + resultado.getTipo_de_quarto());

        } else {

            System.out.println("Quarto não encontrado.");
        }

        return resultado;
    }
}
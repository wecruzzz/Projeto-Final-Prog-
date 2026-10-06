package Actions;

import DAO.HotelDAOimpl;
import Model.Hotel;

import java.util.List;
import java.util.Scanner;

public class HotelActions {

    Scanner scanner = new Scanner(System.in);

    public void inserirHotel() {

        Hotel hotel = new Hotel();

        System.out.print("Nome do hotel: ");
        hotel.setNome(scanner.nextLine());

        System.out.print("Endereço: ");
        hotel.setEndereco(scanner.nextLine());

        System.out.print("Telefone: ");
        hotel.setTelefone(scanner.nextLine());

        HotelDAOimpl hotelDAO = new HotelDAOimpl();
        hotelDAO.inserir(hotel);
    }

    public void listarHoteis() {

        HotelDAOimpl hotelDAO = new HotelDAOimpl();
        List<Hotel> lista = hotelDAO.Listar();

        System.out.println("\n===== LISTA DE HOTÉIS =====");

        for (Hotel hotel : lista) {

            System.out.println("Código: " + hotel.getCodigo());
            System.out.println("Nome: " + hotel.getNome());
            System.out.println("Endereço: " + hotel.getEndereco());
            System.out.println("Telefone: " + hotel.getTelefone());
            System.out.println("-----------------------------");
        }
    }

    public void alterarHotel() {

        HotelDAOimpl hotelDAO = new HotelDAOimpl();
        Hotel hotel = new Hotel();

        System.out.print("Código do hotel: ");
        hotel.setCodigo(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Nome do hotel: ");
        hotel.setNome(scanner.nextLine());

        System.out.print("Endereço: ");
        hotel.setEndereco(scanner.nextLine());

        System.out.print("Telefone: ");
        hotel.setTelefone(scanner.nextLine());

        hotelDAO.alterar(hotel);
    }

    public void removerHotel() {

        HotelDAOimpl hotelDAO = new HotelDAOimpl();

        System.out.print("Código do hotel: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        hotelDAO.excluir(codigo);
    }

    public Hotel buscarHotel() {

        HotelDAOimpl hotelDAO = new HotelDAOimpl();
        Hotel hotel = new Hotel();

        System.out.print("Código do hotel: ");
        hotel.setCodigo(scanner.nextInt());
        scanner.nextLine();

        Hotel resultado = hotelDAO.buscar(hotel);

        if (resultado != null) {

            System.out.println("\n===== HOTEL =====");
            System.out.println("Código: " + resultado.getCodigo());
            System.out.println("Nome: " + resultado.getNome());
            System.out.println("Endereço: " + resultado.getEndereco());
            System.out.println("Telefone: " + resultado.getTelefone());

        } else {

            System.out.println("Hotel não encontrado.");
        }

        return resultado;
    }
}
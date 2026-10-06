package Actions;

import DAO.ChekinDAOimpl;
import Model.Chekin;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class ChekinActions {

    Scanner scanner = new Scanner(System.in);

    public void inserirChekin() {

        Chekin chekin = new Chekin();

        System.out.print("Código do Hotel: ");
        chekin.setTBHotel_Codigo(scanner.nextInt());
        scanner.nextLine();

        chekin.setData_entrada(lerData("Data de entrada"));

        chekin.setData_saida(lerData("Data de saída"));

        System.out.print("Número de adultos: ");
        chekin.setN_adultos(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Número de crianças: ");
        chekin.setN_Crianca(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Código do Cliente: ");
        chekin.setTbcliente_codigo(scanner.nextInt());
        scanner.nextLine();

        ChekinDAOimpl chekinDAO = new ChekinDAOimpl();

        chekinDAO.inserir(chekin);
    }

    public void listarChekin() {

        ChekinDAOimpl chekinDAO = new ChekinDAOimpl();

        List<Chekin> lista = chekinDAO.listar();

        System.out.println("\n===== LISTA DE CHECK-INS =====");

        for (Chekin chekin : lista) {

            System.out.println("Número da reserva: " + chekin.getN_reserva());
            System.out.println("Código do Hotel: " + chekin.getTBHotel_Codigo());
            System.out.println("Data de entrada: " + chekin.getData_entrada());
            System.out.println("Data de saída: " + chekin.getData_saida());
            System.out.println("Número de adultos: " + chekin.getN_adultos());
            System.out.println("Número de crianças: " + chekin.getN_Crianca());
            System.out.println("Código do Cliente: " + chekin.getTbcliente_codigo());

            System.out.println("-----------------------------");
        }
    }

    public void alterarChekin() {

        ChekinDAOimpl chekinDAO = new ChekinDAOimpl();

        Chekin chekin = new Chekin();

        System.out.print("Número da reserva: ");
        chekin.setN_reserva(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Código do Hotel: ");
        chekin.setTBHotel_Codigo(scanner.nextInt());
        scanner.nextLine();

        chekin.setData_entrada(lerData("Data de entrada"));

        chekin.setData_saida(lerData("Data de saída"));

        System.out.print("Número de adultos: ");
        chekin.setN_adultos(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Número de crianças: ");
        chekin.setN_Crianca(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Código do Cliente: ");
        chekin.setTbcliente_codigo(scanner.nextInt());
        scanner.nextLine();

        chekinDAO.alterar(chekin);
    }

    public void removerChekin() {

        ChekinDAOimpl chekinDAO = new ChekinDAOimpl();

        System.out.print("Número da reserva: ");
        int N_reserva = scanner.nextInt();
        scanner.nextLine();

        chekinDAO.excluir(N_reserva);
    }

    public Chekin buscarChekin() {

        ChekinDAOimpl chekinDAO = new ChekinDAOimpl();

        Chekin chekin = new Chekin();

        System.out.print("Número da reserva: ");
        chekin.setN_reserva(scanner.nextInt());
        scanner.nextLine();

        Chekin resultado = chekinDAO.buscar(chekin);

        if (resultado != null) {

            System.out.println("\n===== CHECK-IN =====");
            System.out.println("Número da reserva: " + resultado.getN_reserva());
            System.out.println("Código do Hotel: " + resultado.getTBHotel_Codigo());
            System.out.println("Data de entrada: " + resultado.getData_entrada());
            System.out.println("Data de saída: " + resultado.getData_saida());
            System.out.println("Número de adultos: " + resultado.getN_adultos());
            System.out.println("Número de crianças: " + resultado.getN_Crianca());
            System.out.println("Código do Cliente: " + resultado.getTbcliente_codigo());

        } else {

            System.out.println("Check-in não encontrado.");
        }

        return resultado;
    }

    private String lerData(String mensagem) {

        while (true) {

            System.out.print(mensagem + " (DD/MM/AAAA): ");

            String data = scanner.nextLine();

            try {

                DateTimeFormatter formato =
                        DateTimeFormatter.ofPattern("dd/MM/yyyy");

                LocalDate dataConvertida =
                        LocalDate.parse(data, formato);

                return dataConvertida.toString();

            } catch (DateTimeParseException e) {

                System.out.println("Data inválida!");
                System.out.println("Digite a data no formato DD/MM/AAAA.");
            }
        }
    }
}
package Actions;

import DAO.ClienteDAOimpl;
import Model.Cliente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

// Contém todas as funções relacionadas ao cliente "CRUD"
public class ClienteActions {

    Scanner scanner = new Scanner(System.in);

    // Converte a data brasileira para o formato aceito pelo MySQL
    private String lerData() {

        while (true) {

            System.out.print("Data de nascimento (DD/MM/AAAA): ");
            String data = scanner.nextLine();

            try {

                DateTimeFormatter formatoBrasileiro =
                        DateTimeFormatter.ofPattern("dd/MM/yyyy");

                LocalDate dataConvertida =
                        LocalDate.parse(data, formatoBrasileiro);

                return dataConvertida.toString();

            } catch (DateTimeParseException e) {

                System.out.println("Data inválida!");
                System.out.println("Digite a data no formato DD/MM/AAAA.");
            }
        }
    }

    // Adiciona os clientes
    public void inserirCliente() {

        Cliente cliente = new Cliente();

        System.out.print("Código: ");
        cliente.setCodigo(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Nome: ");
        cliente.setNome(scanner.nextLine());

        System.out.print("Telefone: ");
        cliente.setTelefone(scanner.nextLine());

        System.out.print("CPF: ");
        cliente.setCPF(scanner.nextLine());

        System.out.print("Endereço: ");
        cliente.setEndereco(scanner.nextLine());

        System.out.print("Passaporte: ");
        cliente.setPasaporte(scanner.nextLine());

        System.out.print("RG: ");
        cliente.setRG(scanner.nextLine());

        System.out.print("Email: ");
        cliente.setEmail(scanner.nextLine());

        cliente.setData_nascimento(lerData());

        System.out.print("País: ");
        cliente.setPais(scanner.nextLine());

        ClienteDAOimpl clienteDAO = new ClienteDAOimpl();

        clienteDAO.inserir(cliente);
    }

    // Lista os clientes
    public void ListarCliente() {

        ClienteDAOimpl clienteDAO = new ClienteDAOimpl();

        List<Cliente> lista = clienteDAO.listar();

        System.out.println("\n===== LISTA DE CLIENTES =====");

        for (Cliente cliente : lista) {

            System.out.println("Código: " + cliente.getCodigo());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("CPF: " + cliente.getCPF());
            System.out.println("Endereço: " + cliente.getEndereco());
            System.out.println("Passaporte: " + cliente.getPasaporte());
            System.out.println("RG: " + cliente.getRG());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Data de nascimento: " + cliente.getData_nascimento());
            System.out.println("País: " + cliente.getPais());

            System.out.println("-----------------------------");
        }
    }

    // Atualiza os clientes
    public void atualizarCliente() {

        ClienteDAOimpl clienteDAO = new ClienteDAOimpl();
        Cliente cliente = new Cliente();

        System.out.print("Código: ");
        cliente.setCodigo(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Nome: ");
        cliente.setNome(scanner.nextLine());

        System.out.print("Telefone: ");
        cliente.setTelefone(scanner.nextLine());

        System.out.print("CPF: ");
        cliente.setCPF(scanner.nextLine());

        System.out.print("Endereço: ");
        cliente.setEndereco(scanner.nextLine());

        System.out.print("Passaporte: ");
        cliente.setPasaporte(scanner.nextLine());

        System.out.print("RG: ");
        cliente.setRG(scanner.nextLine());

        System.out.print("Email: ");
        cliente.setEmail(scanner.nextLine());

        cliente.setData_nascimento(lerData());

        System.out.print("País: ");
        cliente.setPais(scanner.nextLine());

        clienteDAO.atualizar(cliente);
    }

    // Exclui cliente
    public void removerCliente() {

        ClienteDAOimpl clienteDAO = new ClienteDAOimpl();
        Cliente cliente = new Cliente();

        System.out.print("Código: ");
        cliente.setCodigo(scanner.nextInt());
        scanner.nextLine();

        clienteDAO.excluir(cliente.getCodigo());
    }

    // Busca cliente
    public Cliente buscarCliente() {

        ClienteDAOimpl clienteDAO = new ClienteDAOimpl();

        System.out.println("Codigo:");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = clienteDAO.buscar(codigo);

        if (cliente != null) {

            System.out.println("Código: " + cliente.getCodigo());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("CPF: " + cliente.getCPF());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Data de nascimento: " + cliente.getData_nascimento());
            System.out.println("RG: " + cliente.getRG());
            System.out.println("Passaporte: " + cliente.getPasaporte());
            System.out.println("Endereço: " + cliente.getEndereco());
            System.out.println("Pais: " + cliente.getPais());

        } else {

            System.out.println("Cliente não encontrado.");
        }

        return cliente;
    }
}
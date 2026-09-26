package Actions;
import DAO.ClienteDAO;
import DAO.ClienteDAOimpl;
import Model.Cliente;

import java.util.List;
import java.util.Scanner;
//contem todas as funçoes relacionadas ao cliente "CRUD"
public class ClienteActions {
    Scanner scanner = new Scanner(System.in);
//adiciona os clientes
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

        System.out.print("Data de nascimento (AAAA-MM-DD): ");
        cliente.setData_nascimento(scanner.nextLine());

        System.out.print("País: ");
        cliente.setPais(scanner.nextLine());

        ClienteDAOimpl clienteDAO = new ClienteDAOimpl();

        clienteDAO.inserir(cliente);
    }
//Lista os clientes
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
    }}
    //atualizaos clientes
        public void atualizarCliente(){
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

            System.out.print("Data de nascimento (AAAA-MM-DD): ");
            cliente.setData_nascimento(scanner.nextLine());

            System.out.print("País: ");
            cliente.setPais(scanner.nextLine());
            clienteDAO.atualizar(cliente);

        }
        //ExcluirCliente
    public void removerCliente(){
        ClienteDAOimpl clienteDAO = new ClienteDAOimpl();
        Cliente cliente = new Cliente();
        System.out.print("Código: ");
        cliente.setCodigo(scanner.nextInt());
        scanner.nextLine();
        clienteDAO.excluir(cliente.getCodigo());

    }
}
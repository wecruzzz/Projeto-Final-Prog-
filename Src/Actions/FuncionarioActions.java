package Actions;

import DAO.FuncionarioDAOimpl;
import Model.Funcionario;

import java.util.List;
import java.util.Scanner;

// Contém todas as funções relacionadas ao funcionário "CRUD"
public class FuncionarioActions {

    Scanner scanner = new Scanner(System.in);

    // Adiciona funcionário
    public void inserirFuncionario() {

        Funcionario funcionario = new Funcionario();

        System.out.print("Email: ");
        funcionario.setEmail(scanner.nextLine());

        System.out.print("Senha: ");
        funcionario.setSenha(scanner.nextLine());

        System.out.print("Cargo: ");
        funcionario.setCargo(scanner.nextLine());

        System.out.print("Nome: ");
        funcionario.setNome(scanner.nextLine());

        System.out.print("Código do Hotel: ");
        funcionario.setTBHotel_Codigo(scanner.nextInt());
        scanner.nextLine();

        FuncionarioDAOimpl funcionarioDAO = new FuncionarioDAOimpl();

        funcionarioDAO.inserir(funcionario);
    }

    // Lista funcionários
    public void listarFuncionario() {

        FuncionarioDAOimpl funcionarioDAO = new FuncionarioDAOimpl();

        List<Funcionario> lista = funcionarioDAO.Listar();

        System.out.println("\n===== LISTA DE FUNCIONÁRIOS =====");

        for (Funcionario funcionario : lista) {

            System.out.println("Código: " + funcionario.getCod_funcionario());
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Email: " + funcionario.getEmail());
            System.out.println("Cargo: " + funcionario.getCargo());
            System.out.println("Código do Hotel: " + funcionario.getTBHotel_Codigo());

            System.out.println("-----------------------------");
        }
    }

    // Altera funcionário
    public void alterarFuncionario() {

        FuncionarioDAOimpl funcionarioDAO = new FuncionarioDAOimpl();
        Funcionario funcionario = new Funcionario();

        System.out.print("Código do funcionário: ");
        funcionario.setCod_funcionario(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Nome: ");
        funcionario.setNome(scanner.nextLine());

        System.out.print("Email: ");
        funcionario.setEmail(scanner.nextLine());

        System.out.print("Senha: ");
        funcionario.setSenha(scanner.nextLine());

        System.out.print("Cargo: ");
        funcionario.setCargo(scanner.nextLine());

        funcionarioDAO.alterar(funcionario);
    }

    // Remove funcionário
    public void removerFuncionario() {

        FuncionarioDAOimpl funcionarioDAO = new FuncionarioDAOimpl();

        System.out.print("Código do funcionário: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        funcionarioDAO.excluir(codigo);
    }

    // Busca funcionário
    public Funcionario buscarFuncionario() {

        FuncionarioDAOimpl funcionarioDAO = new FuncionarioDAOimpl();

        Funcionario funcionario = new Funcionario();

        System.out.print("Código do funcionário: ");
        funcionario.setCod_funcionario(scanner.nextInt());
        scanner.nextLine();

        Funcionario resultado = funcionarioDAO.buscar(funcionario);

        if (resultado != null) {

            System.out.println("\n===== FUNCIONÁRIO =====");
            System.out.println("Código: " + resultado.getCod_funcionario());
            System.out.println("Nome: " + resultado.getNome());
            System.out.println("Email: " + resultado.getEmail());
            System.out.println("Cargo: " + resultado.getCargo());
            System.out.println("Código do Hotel: " + resultado.getTBHotel_Codigo());

        } else {

            System.out.println("Funcionário não encontrado.");
        }

        return resultado;
    }
}
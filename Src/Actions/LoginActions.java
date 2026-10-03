package Actions;

import DAO.FuncionarioDAOimpl;
import Model.Funcionario;

import java.util.Scanner;

public class LoginActions {

    Scanner scanner = new Scanner(System.in);

    public Funcionario fazerLogin() {

        FuncionarioDAOimpl funcionarioDAO = new FuncionarioDAOimpl();

        System.out.println("\n===== LOGIN =====");

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Funcionario funcionario = funcionarioDAO.login(email, senha);

        if (funcionario != null) {

            System.out.println("\nLogin realizado com sucesso!");
            System.out.println("Bem-vindo, " + funcionario.getNome());

            return funcionario;

        } else {

            System.out.println("\nEmail ou senha incorretos.");
            return null;
        }
    }
}
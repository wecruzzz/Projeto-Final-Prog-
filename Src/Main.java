import Actions.LoginActions;
import Menus.MenuAdministrador;
import Menus.MenuAtendente;
import Model.Funcionario;

void main() {

    LoginActions loginActions = new LoginActions();

    Funcionario funcionario = null;

    System.out.println("================================");
    System.out.println("       SISTEMA DO HOTEL");
    System.out.println("================================");

    while (funcionario == null) {

        funcionario = loginActions.fazerLogin();
    }

    if (funcionario.getCargo().equalsIgnoreCase("Administrador")) {

        MenuAdministrador menuAdministrador =
                new MenuAdministrador();

        menuAdministrador.abrirMenu();

    } else if (funcionario.getCargo().equalsIgnoreCase("Atendente")) {

        MenuAtendente menuAtendente =
                new MenuAtendente();

        menuAtendente.abrirMenu();

    } else {

        System.out.println(
                "Cargo não possui acesso ao sistema.");
    }

    System.out.println("\nSistema encerrado.");
}
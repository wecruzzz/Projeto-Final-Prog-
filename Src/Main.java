import DAO.ClienteDAO;
import DAO.ClienteDAOimpl;
import Model.Cliente;
import java.util.List;
import Actions.ClienteActions;

void main() {
    ClienteActions actions = new ClienteActions();
int opcao = 1;
Scanner scanner = new Scanner(System.in);

    System.out.println("\n===== MENU CLIENTE =====");
    System.out.println("1 - Inserir cliente");
    System.out.println("2 - Listar clientes");
    System.out.println("3 - Atualizar cliente");
    System.out.println("4 - Excluir cliente");
    System.out.println("5 - Buscar cliente");
    System.out.println("0 - Sair");
    System.out.print("Escolha uma opção: ");

while(opcao != 0) {


        opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                actions.inserirCliente();
                break;

            case 2:
                actions.ListarCliente();
                break;

            case 3:
                actions.atualizarCliente();
                break;
            case 4:
                actions.removerCliente();
                break;

            case 5:
                actions.buscarCliente();
        }




    }


    }

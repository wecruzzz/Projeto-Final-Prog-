import DAO.ClienteDAO;
import DAO.ClienteDAOimpl;
import Model.Cliente;
import java.util.List;

void main() {

    Cliente cliente = new Cliente();

    cliente.setCodigo(1);
    cliente.setNome("Welington");
    cliente.setTelefone("47991075280");
    cliente.setCPF("12958624927");
    cliente.setEndereco("Rua Fernando");
    cliente.setPasaporte("123");
    cliente.setRG("888");
    cliente.setEmail("welingtondacruz6@gmail.com");
    cliente.setData_nascimento("2006-08-31");
    cliente.setPais("Brasil");

    // ClienteDAO dao = new ClienteDAOimpl();
    // dao.inserir(cliente);

    ClienteDAO dao = new ClienteDAOimpl();

    List<Cliente> clientes = dao.listar();

    for (Cliente clienteLista : clientes) {

        System.out.println("Código: " + clienteLista.getCodigo());
        System.out.println("Nome: " + clienteLista.getNome());
        System.out.println("Telefone: " + clienteLista.getTelefone());
        System.out.println("CPF: " + clienteLista.getCPF());
        System.out.println("Email: " + clienteLista.getEmail());
        System.out.println("-------------------------");
    }
}
package DAO;
import java.util.List;

import Model.Cliente;

public interface ClienteDAO {

    void inserir (Cliente cliente);

    List<Cliente> listar();

    void atualizar(Cliente cliente);

    void excluir(int codigo);




}

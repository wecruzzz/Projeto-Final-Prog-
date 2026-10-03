package DAO;

import Model.Funcionario;
import java.util.List;

public interface FuncionarioDAO {

    void inserir(Funcionario funcionario);

    void alterar(Funcionario funcionario);

    void excluir(int codigo);

    Funcionario buscar(Funcionario funcionario);

    List<Funcionario> Listar();

    Funcionario login(String email, String senha);
}
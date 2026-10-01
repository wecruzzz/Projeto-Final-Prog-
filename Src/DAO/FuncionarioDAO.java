package DAO;

import Model.Funcionario;

import java.util.List;

public interface FuncionarioDAO {
    void inserir (Funcionario funcionario);

    void alterar (Funcionario funcionario);

    void excluir (int codigo);

    Funcionario buscar (Funcionario funcionario);

    List<Funcionario> Listar ();
}
///Cod_funcionario int UN AI PK
/// TBHotel_Codigo int UN
/// Email varchar(100)
/// Senha varchar(30)
/// cargo varchar(100)
/// Nome varchar(45)
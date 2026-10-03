package DAO;

import Model.Quartos;

import java.util.List;

public interface QuartosDAO {

    void inserir(Quartos quarto);

    List<Quartos> listar();

    void alterar(Quartos quarto);

    void excluir(int id);

    Quartos buscar(Quartos quarto);
}
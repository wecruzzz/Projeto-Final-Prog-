package DAO;

import Model.Chekin;

import java.util.List;

public interface ChekinDAO {

    void inserir(Chekin chekin);

    List<Chekin> listar();

    void alterar(Chekin chekin);

    void excluir(int N_reserva);

    Chekin buscar(Chekin chekin);
}
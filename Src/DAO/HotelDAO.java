package DAO;

import Model.Hotel;

import java.util.List;

public interface HotelDAO {

    void inserir (Hotel hotel);

    void alterar (Hotel hotel);

    void excluir (int codigo);

    Hotel buscar (Hotel funcionario);

    List<Hotel> Listar();




}

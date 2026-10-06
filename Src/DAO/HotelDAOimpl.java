package DAO;

import Model.Hotel;
import Util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelDAOimpl implements HotelDAO {

    @Override
    public void inserir(Hotel hotel) {

        String sql = "INSERT INTO tbhotel (nome, Endereco, Telefone) VALUES (?, ?, ?)";

        try {
            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, hotel.getNome());
            stmt.setString(2, hotel.getEndereco());
            stmt.setString(3, hotel.getTelefone());

            stmt.executeUpdate();

            System.out.println("Hotel inserido com sucesso!");

        } catch (SQLException ex) {

            System.out.println("Erro ao inserir hotel:");
            ex.printStackTrace();
        }
    }

    @Override
    public void alterar(Hotel hotel) {

        String sql = "UPDATE tbhotel SET nome = ?, Endereco = ?, Telefone = ? WHERE Codigo = ?";

        try {
            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, hotel.getNome());
            stmt.setString(2, hotel.getEndereco());
            stmt.setString(3, hotel.getTelefone());
            stmt.setInt(4, hotel.getCodigo());

            stmt.executeUpdate();

            System.out.println("Hotel alterado com sucesso!");

        } catch (SQLException ex) {

            System.out.println("Erro ao alterar hotel:");
            ex.printStackTrace();
        }
    }

    @Override
    public void excluir(int codigo) {

        String sql = "DELETE FROM tbhotel WHERE Codigo = ?";

        try {
            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, codigo);

            stmt.executeUpdate();

            System.out.println("Hotel excluído com sucesso!");

        } catch (SQLException ex) {

            System.out.println("Erro ao excluir hotel:");
            ex.printStackTrace();
        }
    }

    @Override
    public Hotel buscar(Hotel hotel) {

        String sql = "SELECT * FROM tbhotel WHERE Codigo = ?";

        try {
            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, hotel.getCodigo());

            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {

                hotel.setCodigo(resultado.getInt("Codigo"));
                hotel.setNome(resultado.getString("nome"));
                hotel.setEndereco(resultado.getString("Endereco"));
                hotel.setTelefone(resultado.getString("Telefone"));

                return hotel;
            }

        } catch (SQLException ex) {

            System.out.println("Erro ao buscar hotel:");
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Hotel> Listar() {

        List<Hotel> hoteis = new ArrayList<>();

        String sql = "SELECT * FROM tbhotel";

        try {
            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);

            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {

                Hotel hotel = new Hotel();

                hotel.setCodigo(resultado.getInt("Codigo"));
                hotel.setNome(resultado.getString("nome"));
                hotel.setEndereco(resultado.getString("Endereco"));
                hotel.setTelefone(resultado.getString("Telefone"));

                hoteis.add(hotel);
            }

        } catch (SQLException ex) {

            System.out.println("Erro ao listar hotéis:");
            ex.printStackTrace();
        }

        return hoteis;
    }
}
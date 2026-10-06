package DAO;

import Model.Chekin;
import Util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChekinDAOimpl implements ChekinDAO {

    @Override
    public void inserir(Chekin chekin) {

        String sql = "INSERT INTO tbcheckin " +
                "(TBHotel_Codigo, data_entrada, data_saida, N_adultos, N_Crianca, Tbcliente_codigo) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, chekin.getTBHotel_Codigo());
            stmt.setString(2, chekin.getData_entrada());
            stmt.setString(3, chekin.getData_saida());
            stmt.setInt(4, chekin.getN_adultos());
            stmt.setInt(5, chekin.getN_Crianca());
            stmt.setInt(6, chekin.getTbcliente_codigo());

            stmt.executeUpdate();

            System.out.println("Check-in realizado com sucesso!");

        } catch (SQLException ex) {

            System.out.println("Erro ao realizar check-in:");
            ex.printStackTrace();
        }
    }

    @Override
    public List<Chekin> listar() {

        List<Chekin> lista = new ArrayList<>();

        String sql = "SELECT * FROM tbcheckin";

        try {
            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);

            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {

                Chekin chekin = new Chekin();

                chekin.setN_reserva(resultado.getInt("N_reserva"));
                chekin.setTBHotel_Codigo(resultado.getInt("TBHotel_Codigo"));
                chekin.setData_entrada(resultado.getString("data_entrada"));
                chekin.setData_saida(resultado.getString("data_saida"));
                chekin.setN_adultos(resultado.getInt("N_adultos"));
                chekin.setN_Crianca(resultado.getInt("N_Crianca"));
                chekin.setTbcliente_codigo(resultado.getInt("Tbcliente_codigo"));

                lista.add(chekin);
            }

        } catch (SQLException ex) {

            System.out.println("Erro ao listar check-ins:");
            ex.printStackTrace();
        }

        return lista;
    }

    @Override
    public void alterar(Chekin chekin) {

        String sql = "UPDATE tbcheckin SET " +
                "TBHotel_Codigo = ?, " +
                "data_entrada = ?, " +
                "data_saida = ?, " +
                "N_adultos = ?, " +
                "N_Crianca = ?, " +
                "Tbcliente_codigo = ? " +
                "WHERE N_reserva = ?";

        try {
            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, chekin.getTBHotel_Codigo());
            stmt.setString(2, chekin.getData_entrada());
            stmt.setString(3, chekin.getData_saida());
            stmt.setInt(4, chekin.getN_adultos());
            stmt.setInt(5, chekin.getN_Crianca());
            stmt.setInt(6, chekin.getTbcliente_codigo());
            stmt.setInt(7, chekin.getN_reserva());

            stmt.executeUpdate();

            System.out.println("Check-in alterado com sucesso!");

        } catch (SQLException ex) {

            System.out.println("Erro ao alterar check-in:");
            ex.printStackTrace();
        }
    }

    @Override
    public void excluir(int N_reserva) {

        String sql = "DELETE FROM tbcheckin WHERE N_reserva = ?";

        try {
            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, N_reserva);

            stmt.executeUpdate();

            System.out.println("Check-in excluído com sucesso!");

        } catch (SQLException ex) {

            System.out.println("Erro ao excluir check-in:");
            ex.printStackTrace();
        }
    }

    @Override
    public Chekin buscar(Chekin chekin) {

        String sql = "SELECT * FROM tbcheckin WHERE N_reserva = ?";

        try {
            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, chekin.getN_reserva());

            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {

                chekin.setN_reserva(resultado.getInt("N_reserva"));
                chekin.setTBHotel_Codigo(resultado.getInt("TBHotel_Codigo"));
                chekin.setData_entrada(resultado.getString("data_entrada"));
                chekin.setData_saida(resultado.getString("data_saida"));
                chekin.setN_adultos(resultado.getInt("N_adultos"));
                chekin.setN_Crianca(resultado.getInt("N_Crianca"));
                chekin.setTbcliente_codigo(resultado.getInt("Tbcliente_codigo"));

                return chekin;
            }

        } catch (SQLException ex) {

            System.out.println("Erro ao buscar check-in:");
            ex.printStackTrace();
        }

        return null;
    }
}
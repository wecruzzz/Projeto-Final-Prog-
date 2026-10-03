package DAO;

import Model.Quartos;
import Util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuartosDAOimpl implements QuartosDAO {

    // INSERIR QUARTO
    @Override
    public void inserir(Quartos quarto) {

        String sql = "INSERT INTO tbquartos " +
                "(TBCheckin_N_reserva, TBHotel_Codigo, tipo_de_quarto) " +
                "VALUES (?, ?, ?)";

        try {

            Connection conexao = Conexao.conectar();

            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setInt(1, quarto.getTBchekin_N_reserva());
            statement.setInt(2, quarto.getTBHotel_Codigo());
            statement.setString(3, quarto.getTipo_de_quarto());

            statement.executeUpdate();

            System.out.println("Quarto cadastrado com sucesso!");

        } catch (SQLException e) {

            System.out.println("Erro ao cadastrar quarto:");
            e.printStackTrace();
        }
    }


    // ALTERAR QUARTO
    @Override
    public void alterar(Quartos quarto) {

        String sql = "UPDATE tbQuartos SET " +
                "TBCheckin_N_reserva = ?, " +
                "TBHotel_Codigo = ?, " +
                "tipo_de_quarto = ? " +
                "WHERE id = ?";

        try {

            Connection conexao = Conexao.conectar();

            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setInt(1, quarto.getTBchekin_N_reserva());
            statement.setInt(2, quarto.getTBHotel_Codigo());
            statement.setString(3, quarto.getTipo_de_quarto());
            statement.setInt(4, quarto.getId());

            statement.executeUpdate();

            System.out.println("Quarto alterado com sucesso!");

        } catch (SQLException e) {

            System.out.println("Erro ao alterar quarto:");
            e.printStackTrace();
        }
    }


    // EXCLUIR QUARTO
    @Override
    public void excluir(int id) {

        String sql = "DELETE FROM Quartos WHERE id = ?";

        try {

            Connection conexao = Conexao.conectar();

            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setInt(1, id);

            statement.executeUpdate();

            System.out.println("Quarto excluído com sucesso!");

        } catch (SQLException e) {

            System.out.println("Erro ao excluir quarto:");
            e.printStackTrace();
        }
    }


    // BUSCAR QUARTO
    @Override
    public Quartos buscar(Quartos quarto) {

        String sql = "SELECT * FROM Quartos WHERE id = ?";

        try {

            Connection conexao = Conexao.conectar();

            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setInt(1, quarto.getId());

            ResultSet resultado = statement.executeQuery();

            if (resultado.next()) {

                quarto.setId(resultado.getInt("id"));
                quarto.setTBchekin_N_reserva(
                        resultado.getInt("TBchekin_N_reserva")
                );
                quarto.setTBHotel_Codigo(
                        resultado.getInt("TBHotel_Codigo")
                );
                quarto.setTipo_de_quarto(
                        resultado.getString("tipo_de_quarto")
                );

                return quarto;
            }

        } catch (SQLException e) {

            System.out.println("Erro ao buscar quarto:");
            e.printStackTrace();
        }

        return null;
    }


    // LISTAR QUARTOS
    @Override
    public List<Quartos> listar() {

        List<Quartos> quartos = new ArrayList<>();

        String sql = "SELECT * FROM Quartos";

        try {

            Connection conexao = Conexao.conectar();

            PreparedStatement statement = conexao.prepareStatement(sql);

            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {

                Quartos quarto = new Quartos();

                quarto.setId(resultado.getInt("id"));

                quarto.setTBchekin_N_reserva(
                        resultado.getInt("TBchekin_N_reserva")
                );

                quarto.setTBHotel_Codigo(
                        resultado.getInt("TBHotel_Codigo")
                );

                quarto.setTipo_de_quarto(
                        resultado.getString("tipo_de_quarto")
                );

                quartos.add(quarto);
            }

        } catch (SQLException e) {

            System.out.println("Erro ao listar quartos:");
            e.printStackTrace();
        }

        return quartos;
    }
}
package DAO;

import Model.Funcionario;
import Util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAOimpl implements FuncionarioDAO {

    // INSERIR FUNCIONÁRIO
    @Override
    public void inserir(Funcionario funcionario) {

        String sql = "INSERT INTO tbfuncionario " +
                "(Email, Senha, Cargo, Nome, TBHotel_Codigo) " +
                "VALUES (?, ?, ?, ?, ?)";

        try {

            Connection conexao = Conexao.conectar();

            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setString(1, funcionario.getEmail());
            statement.setString(2, funcionario.getSenha());
            statement.setString(3, funcionario.getCargo());
            statement.setString(4, funcionario.getNome());
            statement.setInt(5, funcionario.getTBHotel_Codigo());

            statement.executeUpdate();

            System.out.println("Funcionário cadastrado com sucesso!");

        } catch (SQLException e) {

            System.out.println("Erro ao cadastrar funcionário:");
            e.printStackTrace();
        }
    }


    // ALTERAR FUNCIONÁRIO
    @Override
    public void alterar(Funcionario funcionario) {

        String sql = "UPDATE tbfuncionario SET " +
                "Nome = ?, " +
                "Senha = ?, " +
                "Cargo = ?, " +
                "Email = ? " +
                "WHERE Cod_funcionario = ?";

        try {

            Connection conexao = Conexao.conectar();

            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getSenha());
            statement.setString(3, funcionario.getCargo());
            statement.setString(4, funcionario.getEmail());
            statement.setInt(5, funcionario.getCod_funcionario());

            statement.executeUpdate();

            System.out.println("Funcionário alterado com sucesso!");

        } catch (SQLException e) {

            System.out.println("Erro ao alterar funcionário:");
            e.printStackTrace();
        }
    }


    // EXCLUIR FUNCIONÁRIO
    @Override
    public void excluir(int codigo) {

        String sql = "DELETE FROM tbfuncionario WHERE Cod_funcionario = ?";

        try {

            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, codigo);

            stmt.executeUpdate();

            System.out.println("Funcionário excluído com sucesso!");

        } catch (SQLException e) {

            System.out.println("Erro ao excluir funcionário:");
            e.printStackTrace();
        }
    }


    // BUSCAR FUNCIONÁRIO
    @Override
    public Funcionario buscar(Funcionario funcionario) {

        String sql = "SELECT * FROM tbfuncionario WHERE Cod_funcionario = ?";

        try {

            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, funcionario.getCod_funcionario());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                funcionario.setNome(rs.getString("Nome"));
                funcionario.setEmail(rs.getString("Email"));
                funcionario.setCod_funcionario(rs.getInt("Cod_funcionario"));
                funcionario.setCargo(rs.getString("Cargo"));
                funcionario.setTBHotel_Codigo(rs.getInt("TBHotel_Codigo"));

                return funcionario;
            }

        } catch (SQLException e) {

            System.out.println("Erro ao buscar funcionário:");
            e.printStackTrace();
        }

        return null;
    }


    // LISTAR FUNCIONÁRIOS
    @Override
    public List<Funcionario> Listar() {

        List<Funcionario> funcionarios = new ArrayList<>();

        String sql = "SELECT * FROM tbfuncionario";

        try {

            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);

            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {

                Funcionario funcionario = new Funcionario();

                funcionario.setNome(resultado.getString("Nome"));
                funcionario.setEmail(resultado.getString("Email"));
                funcionario.setCod_funcionario(
                        resultado.getInt("Cod_funcionario")
                );
                funcionario.setCargo(resultado.getString("Cargo"));
                funcionario.setTBHotel_Codigo(
                        resultado.getInt("TBHotel_Codigo")
                );

                funcionarios.add(funcionario);
            }

        } catch (SQLException e) {

            System.out.println("Erro ao listar funcionários:");
            e.printStackTrace();
        }

        return funcionarios;
    }

    @Override
    public Funcionario login(String email, String senha) {

        String sql = "SELECT * FROM fucionario WHERE Email = ? AND Senha = ?";

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setString(1, email);
            statement.setString(2, senha);

            ResultSet resultado = statement.executeQuery();

            if (resultado.next()) {

                Funcionario funcionario = new Funcionario();

                funcionario.setCod_funcionario(
                        resultado.getInt("Cod_funcionario")
                );

                funcionario.setNome(
                        resultado.getString("Nome")
                );

                funcionario.setEmail(
                        resultado.getString("Email")
                );

                funcionario.setSenha(
                        resultado.getString("Senha")
                );

                funcionario.setCargo(
                        resultado.getString("Cargo")
                );

                funcionario.setTBHotel_Codigo(
                        resultado.getInt("TBHotel_Codigo")
                );

                return funcionario;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao realizar login:");
            e.printStackTrace();
        }

        return null;
    }
    }

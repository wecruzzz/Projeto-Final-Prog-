package DAO;

import Model.Cliente;
import Model.Funcionario;
import Util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAOimpl implements FuncionarioDAO {

    @Override
    public void inserir(Funcionario funcionario) {
        String sql = "INSERT INTO tbfuncionario " +
                "(Email, Senha, cargo, Nome, TBHotel_Codigo)" + "VALEUS (?, ?, ?, ?, ?)";
        try {
            Connection conexao = Conexao.conectar();

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, funcionario.getEmail());
            statement.setString(2, funcionario.getSenha());
            statement.setString(3, funcionario.getCargo());
            statement.setString(4, funcionario.getNome());
            statement.setInt(5, funcionario.getTBHotel_Codigo());

            System.out.println("Funcionario cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Funcionario:");
            throw new RuntimeException(e);

        }

    }

    @Override
    public void alterar(Funcionario funcionario) {
        String sql = "UPDATE FROM * tbfuncionario"
                +"Nome = ?, Senha = ?, Cargo = ?, Email = ?";
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getSenha());
            statement.setString(3, funcionario.getCargo());
            statement.setString(4, funcionario.getEmail());

            System.out.println("Funcionario alterado com sucesso!");

        } catch(SQLException e){
            System.out.println("Erro ao alterar Funcionario:");
            throw  new RuntimeException(e);
        }


    }

    @Override
    public void excluir (int codigo) {

        String sql = "DELETE FROM tbfuncionario WHERE Codigo = ?";

        try {

            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, codigo);

            stmt.executeUpdate();

            System.out.println("funcionario excluído com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Funcionario buscar(Funcionario funcionario) {

        String sql = "SELECT * FROM tbfuncionario WHERE Codigo = ?";
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1,funcionario.getCod_funcionario());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                funcionario.setNome(rs.getString("Nome"));
                funcionario.setEmail(rs.getString("Email"));
                funcionario.setCod_funcionario(rs.getInt("Cod_funcionario"));
                funcionario.setCargo(rs.getString("Cargo"));
                funcionario.setTBHotel_Codigo(rs.getInt("TBHotel_Codigo"));
            }



        }catch(Exception e){}




        return null;
    }

    @Override
    public List<Funcionario> Listar() {

        List<Funcionario> clientes = new ArrayList<>();

        String sql = "SELECT * FROM TBFuncionario";

        try {

            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);

            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {

                Funcionario funcionario = new Funcionario();


                funcionario.setNome(resultado.getString("Nome"));
                funcionario.setEmail(resultado.getString("Email"));
                funcionario.setCod_funcionario(resultado.getInt("Cod_funcionario"));
                funcionario.setCargo(resultado.getString("Cargo"));
                funcionario.setTBHotel_Codigo(resultado.getInt("TBHotel_Codigo"));

                clientes.add(funcionario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }
}

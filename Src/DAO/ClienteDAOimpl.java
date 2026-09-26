package DAO;

import Model.Cliente;
import Util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAOimpl implements ClienteDAO {

    @Override
    public void inserir(Cliente cliente) {

        String sql = "INSERT INTO tbCliente " +
                "(Codigo, Nome, Telefone, CPF, Endereco, Passaporte, RG, Email, data_nascimento, pais) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, cliente.getCodigo());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getCPF());
            stmt.setString(5, cliente.getEndereco());
            stmt.setString(6, cliente.getPasaporte());
            stmt.setString(7, cliente.getRG());
            stmt.setString(8, cliente.getEmail());
            stmt.setString(9, cliente.getData_nascimento());
            stmt.setString(10, cliente.getPais());

            stmt.executeUpdate();

            System.out.println("Cliente cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar cliente:");
            e.printStackTrace();
        }
    }

    @Override
    public List<Cliente> listar() {

        List<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT * FROM TBCliente";

        try {

            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);

            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {

                Cliente cliente = new Cliente();

                cliente.setCodigo(resultado.getInt("Codigo"));
                cliente.setNome(resultado.getString("Nome"));
                cliente.setTelefone(resultado.getString("Telefone"));
                cliente.setCPF(resultado.getString("CPF"));
                cliente.setEndereco(resultado.getString("Endereco"));
                cliente.setPasaporte(resultado.getString("Passaporte"));
                cliente.setRG(resultado.getString("RG"));
                cliente.setEmail(resultado.getString("Email"));
                cliente.setData_nascimento(resultado.getString("data_nascimento"));
                cliente.setPais(resultado.getString("pais"));

                clientes.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    @Override
    public void atualizar(Cliente cliente) {

        String sql = "UPDATE TBCliente SET " +
                "Nome = ?, " +
                "Telefone = ?, " +
                "CPF = ?, " +
                "Endereco = ?, " +
                "Passaporte = ?, " +
                "RG = ?, " +
                "Email = ?, " +
                "data_nascimento = ?, " +
                "pais = ? " +
                "WHERE Codigo = ?";

        try {

            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getCPF());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getPasaporte());
            stmt.setString(6, cliente.getRG());
            stmt.setString(7, cliente.getEmail());
            stmt.setString(8, cliente.getData_nascimento());
            stmt.setString(9, cliente.getPais());
            stmt.setInt(10, cliente.getCodigo());

            stmt.executeUpdate();

            System.out.println("Cliente atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(int codigo) {

        String sql = "DELETE FROM TBCliente WHERE Codigo = ?";

        try {

            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, codigo);

            stmt.executeUpdate();

            System.out.println("Cliente excluído com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

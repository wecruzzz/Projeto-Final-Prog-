import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/dbhotel";
        String usuario = "SysHotel";
        String senha = "SysHotel00";

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            System.out.println("Conexão realizada com sucesso!");

            conexao.close();

            System.out.println("Conexão encerrada!");

        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco:");
            e.printStackTrace();
        }
    }
}
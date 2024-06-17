package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    // Class.forName("com.mysql.cj.jdbc.Driver");

     private static final String url = "jdbc:mysql://localhost:3306/bd_estoque"; 
     private static final String user = "root"; 
     private static final String password = "";

    private static Connection conn;

    public static Connection pegarConexao () {

        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            } else {
                return conn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    //     try {
    //         return DriverManager.getConnection(url, user, password);
    //     } catch (SQLException erro) {
    //         // o erro escrito a cimma, mostrará qual foi o erro que deu
    //         JOptionPane.showMessageDialog(null, "Erro ao se conectar ao banco de dados!" + erro);
    //     }
    //     return null;
        
    // }
}

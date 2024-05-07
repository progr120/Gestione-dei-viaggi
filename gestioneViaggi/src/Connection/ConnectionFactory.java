package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author gabri
 */
public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/gestioneviaggi";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection getConnection() {

        try {
            Class.forName(DRIVER);

            return DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão: ", ex);
        }
    }

    public static void closeConnection(Connection con) {
        try {

            if (con != null) {
                con.close();
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fechar a conexão: ", ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);

        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fechar a conexão: ", ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fechar a conexão: ", ex);
        }
    }

    public static void closeConnection(Connection con, ResultSet rs) {
        try {

            if (con != null) {
                rs.close();
                con.close();
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fechar a conexão: ", ex);
        }
    }

    public static void closeConnection(PreparedStatement stmt) {
        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fechar a conexão: ", ex);
        }
    }
}

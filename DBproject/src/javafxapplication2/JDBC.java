package javafxapplication2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBC {

    private static final String url = "jdbc:postgresql://localhost:5432/BusDepot";
    private static final String user = "postgres";
    private static final String password = "almat999";
    private static Connection connection=connect();

    public static Connection connect() {

        Connection conn = null;

        try {
         Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conn;
    }

    public static Connection getConnection() {
        return connection;
    }
}

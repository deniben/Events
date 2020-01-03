package dbconnection;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


public class JDBCPostgresSQLConnection {

    private JDBCPostgresSQLConnection() {

    }

    public static Connection getPostgresSQLConnection()
            throws SQLException, ClassNotFoundException {
        //  Database credentials
        String hostName = "localhost";
        String dbName = "event"; //
        String user = "postgres";
        String pass = "postgres"; //postgres or root
        return getPostgresSQLConnection(hostName, dbName, user, pass);
    }

    public static Connection getPostgresSQLConnection(String hostName, String dbName,
                                                      String userName, String password) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        String connectionURL = "jdbc:postgresql://" + hostName + ":5432/" + dbName; //5432 or 5433

        return DriverManager.getConnection(connectionURL, userName, password);
    }
}

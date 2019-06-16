package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection implements AutoCloseable  {
    private Connection connection;

    public OracleConnection() throws BankAccountException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void open() throws BankAccountException {
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:ORCL", "demo", "oracle");
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
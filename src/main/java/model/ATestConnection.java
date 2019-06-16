package model;

import java.sql.Connection;
import java.sql.SQLException;

public class ATestConnection {
    public static void main(String[] args) {
        try (OracleConnection oracleConnection = new OracleConnection()) {
            oracleConnection.open();
            Connection connection = oracleConnection.getConnection();
            System.out.println(connection.getMetaData().getDatabaseMajorVersion());
        } catch (BankAccountException | SQLException e) {
            e.printStackTrace();
        }
    }
}

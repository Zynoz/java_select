package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ATestConnection {
    public static void main(String[] args) {
        try (OracleConnection oracleConnection = new OracleConnection()) {
            oracleConnection.open();
            Connection connection = oracleConnection.getConnection();
            CallableStatement csTable = connection.prepareCall("{call dm/CREATE_CUSTOMER.plsql}");
            CallableStatement csRights = connection.prepareCall("{call dm/rights.plsqsl}");
            csTable.execute();
            csTable.close();
            csRights.execute();
            csRights.close();
            connection.close();
            System.out.println("done");
        } catch (BankAccountException | SQLException e) {
            e.printStackTrace();
        }
    }
}

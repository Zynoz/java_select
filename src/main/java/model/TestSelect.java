package model;

public class TestSelect {
    public static void main(String[] args) throws BankAccountException {
        OracleConnection oracleConnection = new OracleConnection();
        CustomerAccountService customerAccountService = new CustomerAccountService(oracleConnection.getConnection());

        customerAccountService.getCustomerAccounts();
        oracleConnection.close();

    }
}

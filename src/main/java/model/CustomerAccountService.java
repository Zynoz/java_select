package model;

import java.sql.Connection;

public class CustomerAccountService {
    private Connection connection;
    private BankAccountRepository bankAccountRepository;

    public CustomerAccountService(Connection connection) {
        this.connection = connection;
        this.bankAccountRepository = new BankAccountRepository();
    }

    public void getCustomerAccounts() {
        try {
            System.out.println(bankAccountRepository.selectAll(connection));
        } catch (BankAccountException e) {
            e.printStackTrace();
        }
    }


}

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BankAccountRepository {
    private static final String SQL_SELECT_ALL = "SELECT * FROM CUSTOMER";

    private PreparedStatement preparedStatement;

    public List<Customer> selectAll(Connection connection) throws BankAccountException {
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet != null) {
                        List<Customer> customers = new ArrayList<>();
                        while (resultSet.next()) {
                            long accNum = resultSet.getLong(1);
                            String email = resultSet.getString(2);
                            String firstName = resultSet.getString(3);
                            String lastName = resultSet.getString(4);
                            String gender = resultSet.getString(5);
                            LocalDate birthDate = resultSet.getDate(6).toLocalDate();
                            double credits = resultSet.getDouble(7);
                            customers.add(new Customer(accNum, email, firstName, lastName, gender, birthDate, credits));
                            return customers;
                        }
                    }
                }
            } else {
                System.out.println("connection is null");
            }

        } catch (SQLException e) {
            throw new BankAccountException(e.getMessage());
        }
        return null;
    }
}

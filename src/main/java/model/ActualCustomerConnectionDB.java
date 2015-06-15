package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActualCustomerConnectionDB {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/dbtest?useUnicode=true&characterEncoding=utf-8";
    private final static String USER_NAME = "root";
    private final static String PASSWORD = "root";
    static Connection dbConnection = null;
    static PreparedStatement preparedStatement = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            dbConnection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static int insertActualCustomer(ActualCustomer actualCustomer) {
        try {
            preparedStatement = dbConnection.prepareStatement("Insert into customer value()");
            preparedStatement.executeUpdate();
            ResultSet customerResult = preparedStatement.executeQuery("SELECT @@IDENTITY");
            customerResult.next();
            int customerId = customerResult.getInt(1);
            preparedStatement = dbConnection.prepareStatement("insert into actualcustomer "
                    + " values (?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, customerId);
            preparedStatement.setString(2, actualCustomer.getNationalCode());
            preparedStatement.setString(3, actualCustomer.getLastName());
            preparedStatement.setString(4, actualCustomer.getFirstName());
            preparedStatement.setString(5, actualCustomer.getFatherName());
            preparedStatement.setDate(6, java.sql.Date.valueOf(actualCustomer.getDateOfBirthday()));
            int resultNum = preparedStatement.executeUpdate();
            if (resultNum == 1) {
                return customerId;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static List<ActualCustomer> selectActualCustomer(ActualCustomer actualCustomer) {
        List<ActualCustomer> customers = new ArrayList<ActualCustomer>();
        try {
            String queryString = "Select * from customer,actualcustomer where id=customer_id";
            if (actualCustomer.getId() != null) {
                queryString = queryString + " AND id= ?";
            }
            if (actualCustomer.getFirstName() != null) {
                queryString = queryString + " AND first_name=?";
            }
            if (actualCustomer.getLastName() != null) {
                queryString = queryString + " AND last_name=?";
            }
            if (actualCustomer.getNationalCode() != null) {
                queryString = queryString + " AND national_code=?";
            }
            preparedStatement = dbConnection.prepareStatement(queryString);
            int i = 1;
            if (actualCustomer.getId() != null) {
                preparedStatement.setInt(i++, Integer.parseInt(actualCustomer.getId()));
            }
            if (actualCustomer.getFirstName() != null) {
                preparedStatement.setString(i++, actualCustomer.getFirstName());
            }
            if (actualCustomer.getLastName() != null) {
                preparedStatement.setString(i++, actualCustomer.getLastName());
            }
            if (actualCustomer.getNationalCode() != null) {
                preparedStatement.setString(i, actualCustomer.getNationalCode());
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ActualCustomer actualCustomer1 = new ActualCustomer(resultSet.getString("customer_id"), resultSet.getString("firstName"), resultSet.getString("lastName"), resultSet.getString("fatherName"),
                        resultSet.getString("birthdayDate").toString(), resultSet.getString("nationalCode"));
                customers.add(actualCustomer1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static boolean deleteActualCustomerById(String id) {
        try {
            preparedStatement = dbConnection.prepareStatement("DELETE FROM actualcustomer\n" +
                    "WHERE customer_id=?;");
            preparedStatement.setInt(1, Integer.parseInt(id));
            int result = preparedStatement.executeUpdate();
            if (result > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updateActualCustomer(ActualCustomer actualCustomer) {
        try {
            preparedStatement = dbConnection.prepareStatement("UPDATE actualcustomer\n" +
                    "SET firstName=?,lastName=?, fatherName=?, birthdayDate=?, nationalCode=?\n" +
                    "WHERE customer_id=?;");
            preparedStatement.setString(1, actualCustomer.getFirstName());
            preparedStatement.setString(2, actualCustomer.getLastName());
            preparedStatement.setString(3, actualCustomer.getFatherName());
            preparedStatement.setDate(4, java.sql.Date.valueOf(actualCustomer.getDateOfBirthday()));
            preparedStatement.setString(5, actualCustomer.getNationalCode());
            preparedStatement.setInt(6, Integer.parseInt(actualCustomer.getId()));
            int result = preparedStatement.executeUpdate();
            if (result > 0)
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public static boolean nationalCodeExists(String nationalCode) {
        try {

            preparedStatement = dbConnection.prepareStatement("SELECT * FROM actualcustomer WHERE nationalCode=" + nationalCode);
            ResultSet result = preparedStatement.executeQuery();
            if (!result.next())
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}

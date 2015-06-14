package DAL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LegalCustomerConnectionDB {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/dbtest?useUnicode=true&characterEncoding=utf-8&connectTimeout=0&socketTimeout=0&autoReconnect=true";
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

    public static int insertLegalCustomer(LegalCustomer legalCustomer) {
        try {
            preparedStatement = dbConnection.prepareStatement("Insert into customer value()");
            preparedStatement.executeUpdate();
            ResultSet customerResult = preparedStatement.executeQuery("SELECT @@IDENTITY");
            customerResult.next();
            int customerId = customerResult.getInt(1);
            preparedStatement = dbConnection.prepareStatement("insert into legalcustomer "
                    + " values (?, ?, ?, ?)");
            preparedStatement.setInt(1, customerId);
            preparedStatement.setString(2, legalCustomer.getName());
            preparedStatement.setString(3, legalCustomer.getEconomicCode());
            preparedStatement.setDate(4, java.sql.Date.valueOf(legalCustomer.getRegisteringDate()));
            int resultNum = preparedStatement.executeUpdate();
            if (resultNum == 1) {
                return customerId;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static List<LegalCustomer> selectLegalCustomer(LegalCustomer legalCustomer) {
        List<LegalCustomer> customers = new ArrayList<LegalCustomer>();
        try {
            //Statement statement = dbConnection.createStatement();
            String query = "Select * from customer,legalcustomer where id=customer_id";
            if (legalCustomer.getId() != null) {
                query = query + " AND id= ?";
            }
            if (legalCustomer.getName() != null) {
                query = query + " AND name=?";
            }
            if (legalCustomer.getEconomicCode() != null) {
                query = query + " AND economicCode=?";
            }
            preparedStatement = dbConnection.prepareStatement(query);
            int i = 1;
            if (legalCustomer.getId() != null) {
                preparedStatement.setInt(i++, Integer.parseInt(legalCustomer.getId()));
            }
            if (legalCustomer.getName() != null) {
                preparedStatement.setString(i++, legalCustomer.getName());
            }
            if (legalCustomer.getEconomicCode() != null) {
                preparedStatement.setString(i, legalCustomer.getEconomicCode());
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                LegalCustomer lc = new LegalCustomer(resultSet.getString("customer_id"), resultSet.getString("name"), resultSet.getString("registeringDate"),
                        resultSet.getString("economicCode"));
                customers.add(lc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static boolean deleteLegalCustomerByID(String id) {
        try {
            preparedStatement = dbConnection.prepareStatement("DELETE FROM legalcustomer\n" +
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

    public static boolean updateLegalCustomer(LegalCustomer legalCustomer) {
        try {
            preparedStatement = dbConnection.prepareStatement("UPDATE legalcustomer\n" +
                    "SET name=?,economicCode=?,registeringDate=?\n" +
                    "WHERE customer_id=?;");
            preparedStatement.setString(1, legalCustomer.getName());
            preparedStatement.setString(2, legalCustomer.getEconomicCode());
            preparedStatement.setDate(3, java.sql.Date.valueOf(legalCustomer.getRegisteringDate()));
            preparedStatement.setInt(4, Integer.parseInt(legalCustomer.getId()));
            int result = preparedStatement.executeUpdate();
            if (result > 0)
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }


    public static boolean economicCodeExists(String economicCode) {
        try {
            preparedStatement = dbConnection.prepareStatement("SELECT * FROM legalcustomer WHERE economicCode=" + economicCode);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next())
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}

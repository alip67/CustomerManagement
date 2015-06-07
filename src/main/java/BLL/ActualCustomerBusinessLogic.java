package BLL;


import DAL.ActualCustomer;
import DAL.ActualCustomerConnectionDB;

import java.util.List;

public class ActualCustomerBusinessLogic {

    public static int registerCustomer(ActualCustomer actualCustomer) {
        if (!ActualCustomerConnectionDB.nationalCodeExists(actualCustomer.getNationalCode())) {
            return ActualCustomerConnectionDB.insertActualCustomer(actualCustomer);
        }
        return -1;
    }

    public static List<ActualCustomer> searchActualCustomer(ActualCustomer actualCustomer) {
        return ActualCustomerConnectionDB.selectActualCustomer(actualCustomer);
    }

    public static boolean deleteRealCustomerById(String id) {
        return ActualCustomerConnectionDB.deleteActualCustomerById(id);
    }
}

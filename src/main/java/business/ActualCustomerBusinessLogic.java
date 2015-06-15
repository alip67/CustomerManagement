package business;


import model.ActualCustomer;
import model.ActualCustomerConnectionDB;

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

    public static boolean deleteActualCustomerById(String id) {
        return ActualCustomerConnectionDB.deleteActualCustomerById(id);
    }

    public static int updateCustomer(ActualCustomer actualCustomer, String oldNationalCode) {
        if (!actualCustomer.getNationalCode().equals(oldNationalCode) && !ActualCustomerConnectionDB.nationalCodeExists(actualCustomer.getNationalCode())) {
            if (ActualCustomerConnectionDB.updateActualCustomer(actualCustomer))
                return 1;
        } else if (actualCustomer.getNationalCode().equals(oldNationalCode)) {
            if (ActualCustomerConnectionDB.updateActualCustomer(actualCustomer))
                return -1;
        }
        return -1;
    }
}

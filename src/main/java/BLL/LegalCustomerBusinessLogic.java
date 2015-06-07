package BLL;

import DAL.LegalCustomer;
import DAL.LegalCustomerConnectionDB;

import java.util.List;


public class LegalCustomerBusinessLogic {


    public static List<LegalCustomer> searchLegalCustomer(LegalCustomer legalCustomer) {
        return LegalCustomerConnectionDB.selectLegalCustomer(legalCustomer);
    }

    public static int registerCustomer(LegalCustomer legalCustomer) {
        if (!LegalCustomerConnectionDB.economicCodeExists(legalCustomer.getEconomicCode())) {
            return LegalCustomerConnectionDB.insertLegalCustomer(legalCustomer);
        }
        return -1;
    }

    public static boolean deleteLegalCustomerById(String id) {
        return LegalCustomerConnectionDB.deleteLegalCustomerByID(id);
    }
}

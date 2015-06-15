package business;

import model.LegalCustomer;
import model.LegalCustomerConnectionDB;

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

    public static int updateCustomer(LegalCustomer legalCustomer, String oldEconomicCode){
        if(!legalCustomer.getEconomicCode().equals(oldEconomicCode) && !LegalCustomerConnectionDB.economicCodeExists(legalCustomer.getEconomicCode())){
            if(LegalCustomerConnectionDB.updateLegalCustomer(legalCustomer))
                return 1;
        }else if(legalCustomer.getEconomicCode().equals(oldEconomicCode)){
            if(LegalCustomerConnectionDB.updateLegalCustomer(legalCustomer))
                return -1;
        }
        return -1;
    }
}

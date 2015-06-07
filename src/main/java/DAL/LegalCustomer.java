package DAL;

public class LegalCustomer extends Customer {
    private String name;
    private String registeringDate;
    private String economicCode;

    public LegalCustomer(String id, String name, String registeringDate, String economicCode) {
        super(id);
        this.name = name;
        this.registeringDate = registeringDate;
        this.economicCode = economicCode;
    }

    public LegalCustomer(String name, String registeringDate, String economicCode) {
        this.name = name;
        this.registeringDate = registeringDate;
        this.economicCode = economicCode;
    }

    public LegalCustomer() {

    }

    public String getRegisteringDate() {
        return registeringDate;
    }

    public void setRegisteringDate(String registeringDate) {
        this.registeringDate = registeringDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEconomicCode() {
        return economicCode;
    }

    public void setEconomicCode(String economicCode) {
        this.economicCode = economicCode;
    }

    @Override
    public String toString() {
        return "LegalCustomer :: " + "name='" + this.name + ", registeringDate='" + registeringDate + '\'' + ", economicCode =' " + economicCode;
    }
}

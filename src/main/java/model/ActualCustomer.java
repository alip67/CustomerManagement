package model;

public class ActualCustomer extends Customer {
    private String firstName;
    private String lastName;
    private String fatherName;
    private String dateOfBirthday;
    private String nationalCode;

    public ActualCustomer(String id, String firstName, String lastName, String fatherName, String dateOfBirthday, String nationalCode) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.dateOfBirthday = dateOfBirthday;
        this.nationalCode = nationalCode;
    }

    public ActualCustomer(String firstName, String lastName, String fatherName, String dateOfBirthday, String nationalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.dateOfBirthday = dateOfBirthday;
        this.nationalCode = nationalCode;
    }

    public ActualCustomer() {

    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "ActualCustomer ::" + "firstName='" + this.firstName + ", lastName='" + this.lastName + ", fatherName='" + this.fatherName + ", dateOfBirthday='" + this.dateOfBirthday + ", nationalCode='" + this.nationalCode;
    }
}

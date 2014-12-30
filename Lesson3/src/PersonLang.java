/**
 * Created by tom on 30.12.14.
 */
public class PersonLang {
    private String Firstname;
    private String Lastname;
    private String BithDate;
    private String MotherName;
    private String Fathername;
    private String number;
    private String accountStatus;


    public PersonLang(String firstname, String lastname, String bithDate, String motherName, String fathername, String number, String accountStatus) {
        Firstname = firstname;
        Lastname = lastname;
        BithDate = bithDate;
        MotherName = motherName;
        Fathername = fathername;
        this.number = number;
        this.accountStatus = accountStatus;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getBithDate() {
        return BithDate;
    }

    public void setBithDate(String bithDate) {
        BithDate = bithDate;
    }

    public String getMotherName() {
        return MotherName;
    }

    public void setMotherName(String motherName) {
        MotherName = motherName;
    }

    public String getFathername() {
        return Fathername;
    }

    public void setFathername(String fathername) {
        Fathername = fathername;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
}

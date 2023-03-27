//w1867413
//20200216
//Irushi Perera

public class Person {

    private String name;
    private String surname;
    private String dateOfBirth;
    private String mobileNumber;

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }
    public String getMobileNumber(){
        return mobileNumber;
    }
    public String getDateOfBirth(){
        return dateOfBirth;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setDateOfBirth(String dateOfBirth){this.dateOfBirth = dateOfBirth;
    }
    public void setMobileNumber(String mobileNumber){
        this.mobileNumber = mobileNumber;
    }
    //The Constructor
    public Person(String name, String surname){
        this.name = name;
        this.surname = surname;
    }
}


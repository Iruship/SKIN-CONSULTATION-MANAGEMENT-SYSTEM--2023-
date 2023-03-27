
//w1867413
//20200216
//Irushi Perera

public class Patient extends Person{
    private int uniqueId;
    //The constructor
    public Patient(String name, String surname, String dateOfBirth, String mobileNo, int uniqueId) {
        super(name, surname);
        super.setDateOfBirth(dateOfBirth);
        super.setMobileNumber(mobileNo);
        this.uniqueId = uniqueId;
    }
    public int getUniqueId(){
        return uniqueId;
    }
    public void setUniqueId(int uniqueId){
        this.uniqueId = uniqueId;
    }
}

//w1867413
//20200216
//Irushi Perera


public class Doctor extends Person{
    private String medicalLicenceNo;
    private String specialisation;
    public static int numberOfDoctors;


    public Doctor(String name, String surname, String medicalLicenceNo, String specialisation){
        super(name, surname);
        this.medicalLicenceNo = medicalLicenceNo;
        this.specialisation = specialisation;
    }

    public String getMedicalLicenceNo(){
        return medicalLicenceNo;
    }

    public String getSpecialisation(){
        return specialisation;
    }

    public void setSpecialisation(String specialisation){
        this.specialisation = specialisation;
    }

    public void setMedicalLicenceNumber(String medicalLicenceNumber){
        this.medicalLicenceNo = medicalLicenceNumber;
    }

}

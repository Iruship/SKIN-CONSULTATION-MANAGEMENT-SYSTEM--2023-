import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;

//w1867413
//20200216
//Irushi Perera

public class WestminsterSkinConsultationManager implements SkinConsultationManager{
    public static ArrayList <Doctor> doctorList = new ArrayList<>(10);
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList <Consultation> consultationRecords = new ArrayList<>();

    public static void main (String[] args) throws IOException {
        System.out.println(LocalDateTime.of(2023,12,03,2,30));

        //Looping the menu
        while (true) {
            System.out.println();
            System.out.println("========================================================"); //To give a clean output
            System.out.println("");
            System.out.println("--------------------------Menu--------------------------");
            System.out.println("Enter 'A' to add a new Doctor - A");
            System.out.println("Enter 'D' to Delete a Doctor - D");
            System.out.println("Enter 'P' to Print the list of the Doctors - P");
            System.out.println("Enter 'S' to Save them in a file - S");
            System.out.println("Enter 'R' to Read the information from file - R");
            System.out.println("Enter 'G' to Open the Graphical User Interface(GUI) - G");
            System.out.println("Enter 'E' to Exit  - E");
            System.out.println("=======================================================");
            System.out.println();

            System.out.println("Type in the  menu choice: ");
            String menuChoice = scanner.next();

            if (menuChoice.equalsIgnoreCase("A")) {
                addDoctorToSys();
            } else if (menuChoice.equalsIgnoreCase("D")) {
                deleteDoctorFromSys();
            } else if (menuChoice.equalsIgnoreCase("P")) {
                printDoctorList(doctorList);
            } else if (menuChoice.equalsIgnoreCase("S")) {
                savingToAFile();
            } else if (menuChoice.equalsIgnoreCase("R")){
                readingFromFile();
            } else if (menuChoice.equalsIgnoreCase("G")){
                openTheGUI();
            } else if (menuChoice.equalsIgnoreCase("E")) {
                System.out.println("Exited program");
                break;
            } else {
                System.out.println("The choice you entered is Invalid!");
            }
        }
    }

    public static void addDoctorToSys() {

        //Getting details of the doctor from user
        System.out.println("Enter the  first name of doctor: ");
        String name = scanner.next();

        System.out.println("Enter the  surname of doctor: ");
        String surname = scanner.next();

        System.out.println("Enter the medical Licence number of the doctor: ");
        String medicalLicenceNumber = scanner.next();

        System.out.println("Enter specialisation of doctor: ");
        String specialisation = scanner.next();

        //Checks if there are 10 doctors already
        if (Doctor.numberOfDoctors < 10){

            //Creating an object called 'Doctor'
            Doctor doctor = new Doctor(name ,surname, medicalLicenceNumber, specialisation);

            //Adding 'Doctor' object to list of Doctors
            doctorList.add(doctor);

            //Increasing Doctor count
            Doctor.numberOfDoctors += 1;

            System.out.println("Dr.  " + name + "  " + surname + " was added to centre." );
            System.out.println();

        }else{
            System.out.println("The centre has 10 doctors already!..");
        }
    }

    public static void deleteDoctorFromSys(){

        //Getting the medical licence number of the relevant doctor, to be deleted, from user
        System.out.println("Type in the medical Licence number of the doctor to be deleted: ");
        String medicalLicenceNumber = scanner.next();

        //Traversing through the array of Doctors
        for (int i = 0; i < doctorList.size(); i ++){

            //Finds the Doctor with the given medical licence number
            if(doctorList.get(i).getMedicalLicenceNo().equals(medicalLicenceNumber)){
                Doctor doctor  = doctorList.get(i);

                //Printing information of the doctor
                System.out.println("doctor name : " + doctor.getName() + " " + doctor.getSurname() );
                System.out.println("medical license number :" + doctor.getMedicalLicenceNo());
                System.out.println("specialisation : " + doctor.getSpecialisation());
                System.out.println(); // To get a clean output

                //Deleting a doctor
                doctorList.remove(doctorList.get(i));
            }
            else{
                System.out.println("Doctor with the inserted medical licence number is not in the centre!");
            }
        }

        //Updating the Doctor Count
        Doctor.numberOfDoctors -=1;

        //Displaying the  Doctor count
        System.out.println("Number of Doctors in the centre: " + Doctor.numberOfDoctors);

        System.out.println(doctorList.get(0).getName());

    }


    public static void printDoctorList(ArrayList<Doctor> doctorList) {

        //Getting a sorted list of doctors
        ArrayList<Doctor> sortedDoctorList = sortDoctors(doctorList);


        //Displaying a list of doctors and the relevant  info
        for(int i = 0; i < sortedDoctorList.size(); i ++){
            Doctor doctor  = sortedDoctorList.get(i);
            System.out.println("Name of the Doctor : " + doctor.getName() + " " + doctor.getSurname() );
            System.out.println("Medical license number :" + doctor.getMedicalLicenceNo());
            System.out.println("Specialization : " + doctor.getSpecialisation());
            System.out.println();
        }

    }

    public static ArrayList<Doctor> sortDoctors(ArrayList<Doctor> doctorList){

        //Creating a copy of the doctor list
        ArrayList<Doctor> sortedDoctorList = (ArrayList<Doctor>)doctorList.clone();

        for(int i = 0; i < sortedDoctorList.size(); i++){
            for(int j = i + 1; j < sortedDoctorList.size(); j++){

                Doctor temp;
                //Sorting doctors alphabetically  (With surname)
                if(sortedDoctorList.get(i).getSurname().compareTo(sortedDoctorList.get(j).getSurname()) > 0){
                    temp = sortedDoctorList.get(i);
                    sortedDoctorList.set(i, sortedDoctorList.get(j));
                    sortedDoctorList.set(j, temp);
                }
            }
        }

        return sortedDoctorList;
    }

    public static void savingToAFile() throws IOException {



        //The File to store Doctors' info
        FileWriter fileWriter = new FileWriter("doctorsInfomation.txt");

        for(int i = 0; i< doctorList.size(); i ++) {
            Doctor doctor = doctorList.get(i);
            fileWriter.write(doctor.getName() + ",");
            fileWriter.write(doctor.getSurname() + ",");
            fileWriter.write(doctor.getMedicalLicenceNo() + ",");
            fileWriter.write(doctor.getSpecialisation() + ",");
            fileWriter.write('\n');
        }
        fileWriter.close();

        System.out.println("System information was saved to the file.");
    }

    public static void readingFromFile() throws FileNotFoundException {
        File myObj = new File("doctorsInfomation.txt");
        Scanner fileReader = new Scanner(myObj);
        while (fileReader.hasNextLine()) {

            //Saves the data  as a String
            String data = fileReader.nextLine();

            //Splitting the String
            String[] doctorDataRow = data.split(","); //holding doctor values in an array

            //Saving doctors' info
            String name = doctorDataRow[0];
            String surname = doctorDataRow[1];
            String medicalLicenceNumber = doctorDataRow[2];
            String specialisation = doctorDataRow[3];


            //Creating an object called 'Doctor'
            Doctor doctor = new Doctor(name, surname, medicalLicenceNumber, specialisation);


            //Adding to the list of Doctors
            doctorList.add(doctor);

            //Updating Doctor count
            Doctor.numberOfDoctors += 1;
        }
        fileReader.close();
        //Message to the user
        System.out.println("'Doctor information' is now  recovered.");
    }

    public static Consultation createConsultation(Doctor doctor, Patient patient){
        Consultation consultation = new Consultation(doctor, patient);
        consultation.determineCost(consultationRecords);
        //the consultation record is being saved
        consultationRecords.add(consultation);
        return consultation;
    }

    public static void openTheGUI(){
        String [] args = new String[0];

        GUI gui = new GUI();
        GUI.main(args);
    }


}

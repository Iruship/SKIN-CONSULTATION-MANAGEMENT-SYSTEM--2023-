//w1867413
//20200216
//Irushi Perera

import java.util.ArrayList;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import java.security.*;
import java.time.LocalDateTime;
import java.io.UnsupportedEncodingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Consultation {
    private int cost;
    private LocalDateTime dateAndTime;
    private String notes;

    private Patient patient;
    private Doctor doctor;


    //constructor (default)
    public Consultation(){
    }
    public Consultation(Doctor doctor, Patient patient){
        this.dateAndTime = LocalDateTime.now();
        this.doctor = doctor;
        this.patient = patient;
    }

    public int getCost(){
        return cost;
    }

    public LocalDateTime getDateAndTime(){
        return dateAndTime;
    }

    public String getNotes(){
        return notes;
    }

    public Patient getPatient(){
        return patient;
    }


    public Doctor getDoctor(){
        return doctor;
    }


    public void setDateAndTime(LocalDateTime dateAndTime){
        this.dateAndTime = dateAndTime;
    }


    public void setCost(int cost){
        this.cost = cost;
    }


    public void setNotes(String notes){
        this.notes = notes;
    }


    public void setPatient(Patient patient){
        this.patient = patient;
    }


    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }


    public void determineCost(ArrayList<Consultation> consultationHistory){

        if(consultationHistory.isEmpty()){
            System.out.println("This is the patient's first consultation. Cost will be : 15 per hour");
            setCost(15);
        }

        //assessing if this is the patient's first consultation
        for (int i = 0; i < consultationHistory.size(); i++ ){
            if(consultationHistory.get(i).getPatient().getUniqueId() == (this.getPatient().getUniqueId())){
                System.out.println("This is not Patient's first consultation. Cost will be: 25 per hour");
                setCost(25);
            }else{
                System.out.println("This is the patient's first consultation. Cost will be : 15 per hour");
                setCost(15);
            }
        }
    }
    private KeyPair keyPair;
    private Cipher cipher;
    private byte[] cipherText;

    public byte[] encryptNotes(String notes) throws Exception {
        //(Java Cryptography - Encrypting Data, no date)
        //Constructing a Signature object
        Signature signature = Signature.getInstance("SHA256withRSA");

        //Creating the KeyPair generator object
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");

        //Initialization of the key pair generator
        keyPairGen.initialize(2048);

        //Generating the pair of keys
        keyPair = keyPairGen.generateKeyPair();

        PublicKey publicKey = keyPair.getPublic();

        //Creation of  a Cipher object
        cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        //Initialization of a Cipher object
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        //Adding the data to the cipher
        byte[] input = notes.getBytes();
        cipher.update(input);

        //encryption of the data
        cipherText = cipher.doFinal();
        System.out.println( new String(cipherText, "UTF8"));
        return cipherText;
    }
    public byte[] decryptingNotes(int uniqueId) throws Exception{
        byte[] decipherText = new byte[0];

        if(patient.getUniqueId() == uniqueId) {
            System.out.println("Decrypting the notes");

            //Initializing the same cipher for decryption
            cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());

            //Decrypting the text
            decipherText = cipher.doFinal(cipherText);
            System.out.println(new String(decipherText));

            return decipherText;

        }else{
            System.out.println("Patient ID is invalid!");
            return decipherText;
        }
    }
}

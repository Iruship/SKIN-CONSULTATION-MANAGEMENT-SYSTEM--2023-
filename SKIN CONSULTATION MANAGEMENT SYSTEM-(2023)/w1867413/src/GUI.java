//w1867413
//20200216
//Irushi Perera

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class GUI {

    public static ArrayList<Doctor> doctorList = WestminsterSkinConsultationManager.doctorList;

    // The constructor
    public GUI(){
    }
    public static void main(String[] args){
        //Creating the main frame of  the GUI
        JFrame frame = new JFrame();


        //Adding a label called "westminster Consultation"
        JLabel label = new JLabel("Westminster Consultation");
        label.setBounds(540,0, 2000, 30);
        frame.add(label);

        //List of the headings of the table
        String[] headings = {"First Name", "Surname", "Medical License Number", "The Specialization"};

        //Data for the doctors' table
        Object[][] tableData = new String[10][4];

        for(int i = 0; i < doctorList.size(); i++) {
            tableData[i][0] = doctorList.get(i).getName();
            tableData[i][1] = doctorList.get(i).getSurname();
            tableData[i][2] = doctorList.get(i).getMedicalLicenceNo();
            tableData[i][3] = doctorList.get(i).getSpecialisation();
        }
        //(JTable in JAVA Swing | ADD Data into JTable, no date)
        //Creating table to display doctor information
        JTable jTable = new JTable(tableData, headings);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setBounds(0,80, 1080, 190);
        frame.add(jScrollPane);

        ListSelectionModel model = jTable.getSelectionModel();

        model.addListSelectionListener(new ListSelectionListener() {
            @Override

            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()) {
                    //Get selected row
                    int selectedRow = model.getMinSelectionIndex();

                    openTheConsultationForm(tableData, selectedRow);
                }
            }
        });

        //Adding a button for sorting called "Sort"
        JButton sortBtn = new JButton("'Sort'");
        sortBtn.setBounds(250, 350, 150, 40);
        frame.add(sortBtn);


        //Setting the frame size.
        frame.setSize(1080, 1080);


        frame.setLayout(null);

        //Making the  frame visible.
        frame.setVisible(true);


        sortBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Sorting Doctors according to surname
                doctorList = WestminsterSkinConsultationManager.sortDoctors(doctorList);

                //Refreshing the table to show the sorted doctors' information
                refreshTable(jTable, tableData);
            }
        });
    }

    public static void refreshTable(JTable jTable, Object[][] tableData){

        jTable.setVisible(false);
        //Updating data that are in doctors' table
        for(int i = 0; i < doctorList.size(); i++) {
            tableData[i][0] = doctorList.get(i).getName();
            tableData[i][1] = doctorList.get(i).getSurname();
            tableData[i][2] = doctorList.get(i).getMedicalLicenceNo();
            tableData[i][3] = doctorList.get(i).getSpecialisation();
        }

        jTable.setVisible(true);
    }

    //(Java Swing | Simple User Registration Form, 2019)
    public static void openTheConsultationForm(Object[][] tableData, int selectedRow){

        JFrame consultationJFrame = new JFrame();
        consultationJFrame.setTitle("Consultation-Form");
        consultationJFrame.setBounds(300, 90, 900, 600);
        consultationJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        consultationJFrame.setResizable(false);




        Container c;
        JLabel Title;
        JLabel labelDoc;
        JLabel doctorName;
        JLabel labelName;
        JTextField nameArea;
        JLabel labelSurname;
        JTextField surnameArea;
        JLabel dOB;
        JComboBox date;
        JComboBox month;
        JComboBox year;
        JLabel mobileNo;
        JTextField mobileNoArea;
        JLabel id;
        JTextField idArea;
        JLabel notesL;
        JTextArea noteArea;
        JButton subBtn;
        JButton viewButton;
        JTextArea consultationInformation;
        JTextArea notePane;
        JLabel checkId;
        JTextField checkIdArea;
        JButton decryptingButton;

        String dates[]
                = { "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25",
                "26", "27", "28", "29", "30",
                "31" };
        String months[]
                = { "Jan", "Feb", "Mar", "Apr",
                "May", "Jun", "Jul", "Aug",
                "Sep", "Oct", "Nov", "Dec" };
        String years[]
                = { "1995", "1996", "1997", "1998",
                "1999", "2000", "2001", "2002",
                "2003", "2004", "2005", "2006",
                "2007", "2008", "2009", "2010",
                "2011", "2012", "2013", "2014",
                "2015", "2016", "2017", "2018",
                "2019", "2020", "2021", "2022",
                "2023" };


        // Form label
        //(How to set the Font on Java Swing components (JTextArea, JLabel, JList) | alvinalexander.com, no date)
        Title = new JLabel("Consultation Form");
        Title.setFont(new Font("Monaco", Font.BOLD, 20));
        Title.setSize(300, 30);
        Title.setLocation(375, 30);
        consultationJFrame.add(Title);

        labelDoc = new JLabel("Doctor:");
        labelDoc.setFont(new Font("Monaco", Font.BOLD, 13));
        labelDoc.setSize(200, 20);
        labelDoc.setLocation(300, 80);
        consultationJFrame.add(labelDoc);

        doctorName = new JLabel("Dr. " + doctorList.get(selectedRow).getName() + " "
                + doctorList.get(selectedRow).getSurname());
        doctorName.setFont(new Font("Monaco", Font.BOLD, 13));
        doctorName.setSize(510, 25);
        doctorName.setLocation(425, 80);
        consultationJFrame.add(doctorName);

        labelName = new JLabel("Name");
        labelName.setFont(new Font("Monaco", Font.BOLD, 13));
        labelName.setSize(100, 25);
        labelName.setLocation(300, 160);
        consultationJFrame.add(labelName);

        nameArea = new JTextField();
        nameArea.setFont(new Font("Monaco", Font.BOLD, 13));
        nameArea.setSize(190, 25);
        nameArea.setLocation(400, 160);
        consultationJFrame.add(nameArea);

        labelSurname = new JLabel("Surname");
        labelSurname.setFont(new Font("Monaco", Font.BOLD, 13));
        labelSurname.setSize(100, 25);
        labelSurname.setLocation(300, 200);
        consultationJFrame.add(labelSurname);

        surnameArea = new JTextField();
        surnameArea.setFont(new Font("Monaco", Font.BOLD, 13));
        surnameArea.setSize(190, 20);
        surnameArea.setLocation(400, 200);
        consultationJFrame.add(surnameArea);

        dOB = new JLabel("dOB");
        dOB.setFont(new Font("Monaco", Font.BOLD, 13));
        dOB.setSize(100, 25);
        dOB.setLocation(300, 240);
        consultationJFrame.add(dOB);

        date = new JComboBox(dates);
        date.setFont(new Font("Monaco", Font.BOLD, 13));
        date.setSize(50, 25);
        date.setLocation(400, 240);
        consultationJFrame.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Monaco", Font.BOLD, 13));
        month.setSize(60, 25);
        month.setLocation(450, 240);
        consultationJFrame.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Monaco", Font.BOLD, 13));
        year.setSize(60, 25);
        year.setLocation(520, 240);
        consultationJFrame.add(year);

        mobileNo = new JLabel("Mobile No");
        mobileNo.setFont(new Font("Monaco", Font.BOLD, 13));
        mobileNo.setSize(100, 25);
        mobileNo.setLocation(300, 280);
        consultationJFrame.add(mobileNo);

        mobileNoArea = new JTextField();
        mobileNoArea.setFont(new Font("Monaco", Font.BOLD, 13));
        mobileNoArea.setSize(150, 25);
        mobileNoArea.setLocation(400, 280);
        consultationJFrame.add(mobileNoArea);

        id = new JLabel("Unique ID");
        id.setFont(new Font("Monaco", Font.BOLD, 13));
        id.setSize(100, 25);
        id.setLocation(300, 320);
        consultationJFrame.add(id);

        idArea = new JTextField();
        idArea.setFont(new Font("Monaco", Font.BOLD, 13));
        idArea.setSize(190, 25);
        idArea.setLocation(400, 320);
        consultationJFrame.add(idArea);

        notesL = new JLabel("Notes:");
        notesL.setFont(new Font("Monaco", Font.BOLD, 13));
        notesL.setSize(100, 20);
        notesL.setLocation(300, 360);
        consultationJFrame.add(notesL);

        noteArea = new JTextArea();
        noteArea.setFont(new Font("Monaco", Font.BOLD, 13));
        noteArea.setSize(205, 75);
        noteArea.setLocation(400, 360);
        noteArea.setLineWrap(true);
        consultationJFrame.add(noteArea);

        consultationInformation = new JTextArea();
        consultationInformation.setFont(new Font("Monaco", Font.BOLD, 13));
        consultationInformation.setSize(300, 150);
        consultationInformation.setLocation(350, 100);
        consultationInformation.setLineWrap(true);
        consultationInformation.setEditable(false);
        consultationJFrame.add(consultationInformation);
        consultationInformation.setVisible(false);

        notePane = new JTextArea();
        notePane.setFont(new Font("Monaco", Font.BOLD, 13));
        notePane.setSize(300, 150);
        notePane.setLocation(355, 300);
        notePane.setLineWrap(true);
        notePane.setEditable(false);
        consultationJFrame.add(notePane);
        notePane.setVisible(false);

        subBtn = new JButton("SUBMIT");
        subBtn.setFont(new Font("Monaco", Font.BOLD, 13));
        subBtn.setSize(100, 20);
        subBtn.setLocation(350, 490);
        consultationJFrame.add(subBtn);

        viewButton = new JButton("VIEW Consultation");
        viewButton.setFont(new Font("Monaco", Font.BOLD, 13));
        viewButton.setSize(180, 20);
        viewButton.setLocation(470, 490);
        consultationJFrame.add(viewButton);
        viewButton.setVisible(false);

        checkId = new JLabel("Enter unique id to view notes.");
        checkId.setFont(new Font("Monaco", Font.BOLD, 13));
        checkId.setSize(300, 20);
        checkId.setLocation(400, 480);
        consultationJFrame.add(checkId);
        checkId.setVisible(false);

        checkIdArea = new JTextField();
        checkIdArea.setFont(new Font("Monaco", Font.BOLD, 13));
        checkIdArea.setSize(100, 20);
        checkIdArea.setLocation(400, 510);
        consultationJFrame.add(checkIdArea);
        checkIdArea.setVisible(false);

        decryptingButton = new JButton("Submit");
        decryptingButton.setFont(new Font("Monaco", Font.BOLD, 13));
        decryptingButton.setSize(100, 20);
        decryptingButton.setLocation(500, 510);
        consultationJFrame.add(decryptingButton);
        decryptingButton.setVisible(false);

        //Frame size
        consultationJFrame.setSize(1080, 720);
        consultationJFrame.setLayout(null);
        consultationJFrame.setVisible(true);
        subBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Doctor doctor = new Doctor(
                        doctorList.get(selectedRow).getName(),
                        doctorList.get(selectedRow).getSurname(),
                        doctorList.get(selectedRow).getMedicalLicenceNo(),
                        doctorList.get(selectedRow).getSpecialisation()
                );

                //Getting patients' info
                String name = nameArea.getText();
                String surname = surnameArea.getText();
                String mobileNum = mobileNoArea.getText();
                String dateOfBirth = date.getSelectedItem() + "/" + month.getSelectedItem() + "/" + year.getSelectedItem();
                String uniqueId = idArea.getText();

                //Getting 'consultation' notes
                String notes = noteArea.getText();

                Patient patient = new Patient(name, surname, dateOfBirth, mobileNum, Integer.parseInt(uniqueId));

                Consultation consultation = WestminsterSkinConsultationManager.createConsultation(doctor, patient);
                byte[] encryptedNotes = new byte[0];
                try {
                    encryptedNotes = consultation.encryptNotes(notes);
                    consultation.setNotes(new String(encryptedNotes));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }



                JOptionPane.showMessageDialog(null, "Consultation was saved.");

                viewButton.setVisible(true);

                viewButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        Title.setText("Information on Consultation");

                        String data
                                = "Doctor :  " +  "Dr " + doctorList.get(selectedRow).getName() + " "
                                + doctorList.get(selectedRow).getSurname() + "\n"

                                + "Patient Name : "  //Getting user input
                                + nameArea.getText() + " " + surnameArea.getText() + "\n"
                                + "Mobile No : "    //Getting user input
                                + mobileNoArea.getText() + "\n"
                                + "dOB : "       //Getting user input
                                + (String)date.getSelectedItem()
                                + "/" + (String)month.getSelectedItem()
                                + "/" + (String)year.getSelectedItem() + "\n"
                                + "UNIQUE ID: "
                                + "#########" + "\n"
                                + "Cost (per hour)"
                                + consultation.getCost();

                        String notesData = "Notes " + consultation.getNotes();

                        consultationInformation.setText(data);
                        consultationInformation.setVisible(true);
                        notePane.setText(notesData);
                        notePane.setVisible(true);
                        checkId.setVisible(true);
                        checkIdArea.setVisible(true);
                        decryptingButton.setVisible(true);

                        decryptingButton.addActionListener(new ActionListener() {
                            @Override

                            public void actionPerformed(ActionEvent e) {
                                try {
                                    byte[] decipheredTxt = consultation.decryptingNotes(
                                            Integer.parseInt(checkIdArea.getText()));
                                    String notes = new String(decipheredTxt);
                                    notePane.setText(notes);
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }
                        });

                        Title.setVisible(false);
                        labelDoc.setVisible(false);
                        doctorName.setVisible(false);
                        labelName.setVisible(false);
                        nameArea.setVisible(false);
                        labelSurname.setVisible(false);
                        surnameArea.setVisible(false);
                        mobileNo.setVisible(false);
                        mobileNoArea.setVisible(false);
                        dOB.setVisible(false);
                        year.setVisible(false);
                        month.setVisible(false);
                        date.setVisible(false);
                        id.setVisible(false);
                        idArea.setVisible(false);
                        notesL.setVisible(false);
                        noteArea.setVisible(false);
                        viewButton.setVisible(false);
                        subBtn.setVisible(false);


                    }
                });
            }
        });
    }
}


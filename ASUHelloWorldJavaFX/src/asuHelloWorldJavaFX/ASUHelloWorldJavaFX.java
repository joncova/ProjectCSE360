package asuHelloWorldJavaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javafx.geometry.Insets;
import java.io.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class ASUHelloWorldJavaFX extends Application {
	
	Random rand = new Random();
	String ID;
	String HOLDER;
	String personname;
	int secHold;
	
	String parameter1;
	String parameter2;
	String parameter3;
	String parameter4;
	String parameter5;
	String parameter6;
	
	private Stage stage;
	
	private Scene Homepage;
	private Pane pane1;
	private Button PatientIntake;
	private Button CTScan;
    private Button PatientUI;
    private TextField Dverification;
    private TextField VERIFY;
    private Label Error3;
    //private Button DoctorUI;
    private Label Hearthealth;
	
    // Patient intake form
	private Scene Patientform;
	private Pane pane2;
	private Label Patientheader;
	private Label Firstname;
	private Label Lastname;
	private Label Email;
	private Label Phonenumber;
	private Label Healthhist;
	private Label InsuranceID;
	private Label generatedID;
	private Label Error;
	private TextField Input_First_name;
	private TextField Input_Last_name;
	private TextField Input_email;
	private TextField Input_phone_number;
	private TextField Input_healthhist;
	private TextField Input_Insurance;
	private Button save;
	private Button back;
	
	// CT scan tech view
	private Scene CTtechview;
	private Pane pane3;
	private Label patient_ID;
	private Label Total_aga;
	private Label vessl_level;
	private Label LM;
	private Label LAD;
	private Label LCX;
	private Label RCA;
	private Label PDA;
	private Label Error1;
	private TextField Input_patient_ID;
	private TextField Input_agile;
	private TextField Input_LM;
	private TextField Input_LAD;
	private TextField Input_LCX;
	private TextField Input_RCA;
	private TextField Input_PDA;
	private Button save2;
	private Button back2;
	
	// Patient view
	private Scene Patientview;
	private Pane pane4;
	private Label Total_aga1;
	private Label Information1;
	private Label LM1;
	private Label LAD1;
	private Label LCX1;
	private Label RCA1;
	private Label PDA1;
	private TextField Input_aga_score1;
	private TextField Input_LM1;
	private TextField Input_LAD1;
	private TextField Input_LCX1;
	private TextField Input_RCA1;
	private TextField Input_PDA1;
	private Button back3;

	/* message doctor view
	private Scene messagedoctorscene;
	private Pane pane5;
	private Label Header;
	private Label message;
	private TextField messagefield;
	private Button send;
	private Button back4;
	*/
	// Doctor view
	//private Scene Doctorview;
	//private Pane pane6;
	
	public void newpatient() {
		// String.format("%05d", ID);
		String IDnew = ID;
		//String.format("%05d", ID);
		File patientIDD = new File(IDnew + "_PatientInfo.txt");
		//(BufferedWriter patientintake = new BufferedWriter(new FileWriter(ID + "_PatientInfo.txt"));)
		try {
		
			patientIDD.createNewFile();
			//patientIDD = new PrintWriter(ID + "_PatientInfo.txt");
			BufferedWriter patientintake = new BufferedWriter(new FileWriter(IDnew + "_PatientInfo.txt"));
			patientintake.write(Input_First_name.getText());
			patientintake.newLine();
			patientintake.write(Input_Last_name.getText());
			patientintake.newLine();
			patientintake.write(Input_email.getText());
			patientintake.newLine();
			patientintake.write(Input_phone_number.getText());
			patientintake.newLine();
			patientintake.write(Input_healthhist.getText());
			patientintake.newLine();
			patientintake.write(Input_Insurance.getText());
			patientintake.newLine();
			patientintake.close();
			//patientIDD.close();
			//patientIdent = new FileWriter(ID + "_PatientInfo.txt");
			//BufferedWriter patientintake = new BufferedWriter(patientIdent);
		} catch(IOException e) {
			e.printStackTrace();
			//patientIDD.close();
		}
	}
	
	public void patientdata() {
		
		String patientidentification = Input_patient_ID.getText();
		try {
			
			BufferedWriter patientdataintake = new BufferedWriter(new FileWriter(patientidentification + "_Patientdata.txt"));
			patientdataintake.write(Input_agile.getText());
			patientdataintake.newLine();
			patientdataintake.write(Input_LM.getText());
			patientdataintake.newLine();
			patientdataintake.write(Input_LAD.getText());
			patientdataintake.newLine();
			patientdataintake.write(Input_LCX.getText());
			patientdataintake.newLine();
			patientdataintake.write(Input_RCA.getText());
			patientdataintake.newLine();
			patientdataintake.write(Input_PDA.getText());
			patientdataintake.newLine();
			patientdataintake.close();
			//patientIdent = new FileWriter(ID + "_PatientInfo.txt");
			//BufferedWriter patientintake = new BufferedWriter(patientIdent);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void grabpatientdata() {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(HOLDER + "_PatientInfo.txt"));
			personname = reader.readLine();
			Information1.setText("Hello " + personname);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(HOLDER + "_Patientdata.txt"));
			parameter1 = reader.readLine();
			parameter2 = reader.readLine();
			parameter3 = reader.readLine();
			parameter4 = reader.readLine();
			parameter5 = reader.readLine();
			parameter6 = reader.readLine();
			Input_aga_score1.setText(parameter1);
			Input_LM1.setText(parameter2);
			Input_LAD1.setText(parameter3);
			Input_LCX1.setText(parameter4);
			Input_RCA1.setText(parameter5);
			Input_PDA1.setText(parameter6);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*try (BufferedReader reader2 = new BufferedReader(new FileReader(HOLDER + "_Patientdata.txt"))){
			
			reader2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
	
	public void start(Stage OfficeUI) throws Exception{
		
		stage = OfficeUI;
		stage.setTitle("");
		
		Homepage = createSceneHomepage();
		Patientform = createScenePatientform();
		CTtechview = createSceneCTtechview();
		Patientview = createScenePatientview();
		// Doctorview = createSceneDoctorview();
		// messagedoctorscene = createScenemessagedoctor();
		
		stage.setScene(Homepage);
		
		stage.show();
		
	}
	
	private Scene createSceneHomepage() {
	      
		   Hearthealth = new Label("Welcome to Heart Health Imaging and Recording Systems");
	       Hearthealth.setLayoutX(250);
	       Hearthealth.setLayoutY(50);
			
	       PatientIntake = new Button("Patient Intake");
	       PatientIntake.setPrefSize(250, 75);
	       PatientIntake.setLayoutX(275);
	       PatientIntake.setLayoutY(100);
	       PatientIntake.setStyle("-fx-background-color: #4473c5");
	       PatientIntake.setOnAction(e -> switchScenes(Patientform));
			
	       CTScan = new Button("CT Scan Tech View");
	       CTScan.setPrefSize(250, 75);
	       CTScan.setLayoutX(275);
	       CTScan.setLayoutY(200);
	       CTScan.setStyle("-fx-background-color: #4473c5");
	       CTScan.setOnAction(e -> switchScenes(CTtechview));
			
	       VERIFY = new TextField();
	       VERIFY.setLayoutX(275);
	       VERIFY.setLayoutY(400);
	       VERIFY.prefWidth(300);
	       VERIFY.prefHeight(100);
	       
	       PatientUI = new Button("Patient View: Enter patient ID below");
	       PatientUI.setPrefSize(250, 75);
	       PatientUI.setLayoutX(275);
	       PatientUI.setLayoutY(300);
	       PatientUI.setStyle("-fx-background-color: #4473c5");  
	       PatientUI.setOnAction(new EventHandler<>() {
	            public void handle(ActionEvent event) {
	            	
	            	
	            	File temporaryinfo = new File(VERIFY.getText() + "_PatientInfo.txt");
	            	File temporarydata = new File(VERIFY.getText() + "_Patientdata.txt");
	            	if(temporaryinfo.exists() && temporarydata.exists()) {
	            		HOLDER = VERIFY.getText();
	         	       secHold = Integer.parseInt(HOLDER);
	         	       System.out.println(secHold);
	            		switchScenes(Patientview);
	            		grabpatientdata();
	            		Error3.setText("");
	            	}else if(temporaryinfo.exists() && !temporarydata.exists()) {
	            		Error3.setText("Patient's data is not yet in the database");
	            	} else {
	            		Error3.setText("The Patient ID you entered is not valid");
	            	}
	            }
			});
	   
	       Error3 = new Label("");
	       Error3.setLayoutX(275);
	       Error3.setLayoutY(435);
	       /*
	       DoctorUI = new Button("Doctor View");
	       DoctorUI.setPrefSize(250, 75);
	       DoctorUI.setLayoutX(275);
	       DoctorUI.setLayoutY(400);
	       DoctorUI.setStyle("-fx-background-color: #4473c5");
	       DoctorUI.setOnAction(e -> switchScenes(Doctorview));
			*/
	       pane1 = new Pane(Hearthealth, PatientIntake, CTScan, PatientUI, Error3, VERIFY);
	       pane1.setPrefSize(800, 500);
	      
	       Homepage = new Scene(pane1);
		
	       return Homepage;
	}	
	
	private Scene createScenePatientform() {
		
		   Patientheader = new Label("Patient Intake Form");
		   Patientheader.setLayoutX(250);
		   Patientheader.setLayoutY(50);
		   
		   Firstname = new Label("First Name:");
		   Firstname.setLayoutX(100);
		   Firstname.setLayoutY(100);
		   
		   Lastname = new Label("Last Name:");
		   Lastname.setLayoutX(100);
		   Lastname.setLayoutY(150);
		   
		   Email = new Label("Email:");
		   Email.setLayoutX(100);
		   Email.setLayoutY(200);
		   
		   Phonenumber = new Label("Phone Number:");
		   Phonenumber.setLayoutX(100);
		   Phonenumber.setLayoutY(250);
		   
		   Healthhist = new Label("Health History:");
		   Healthhist.setLayoutX(100);
		   Healthhist.setLayoutY(300);
		   
		   InsuranceID = new Label("Insurance ID:");
		   InsuranceID.setLayoutX(100);
		   InsuranceID.setLayoutY(350);
		   
		   Input_First_name = new TextField();
		   Input_First_name.setLayoutX(200);
		   Input_First_name.setLayoutY(100);
		   Input_First_name.setPrefWidth(250);
		   
		   Input_Last_name = new TextField();
		   Input_Last_name.setLayoutX(200);
		   Input_Last_name.setLayoutY(150);
		   Input_Last_name.setPrefWidth(250);
		   
		   Input_email = new TextField();
		   Input_email.setLayoutX(200);
		   Input_email.setLayoutY(200);
		   Input_email.setPrefWidth(250);
		   
		   Input_phone_number = new TextField();
		   Input_phone_number.setLayoutX(200);
		   Input_phone_number.setLayoutY(250);
		   Input_phone_number.setPrefWidth(250);
		   
		   Input_healthhist = new TextField();
		   Input_healthhist.setLayoutX(200);
		   Input_healthhist.setLayoutY(300);
		   Input_healthhist.setPrefWidth(250);
		   
		   Input_Insurance = new TextField();
		   Input_Insurance.setLayoutX(200);
		   Input_Insurance.setLayoutY(350);
		   Input_Insurance.setPrefWidth(250);
		   
		   generatedID = new Label("");
		   generatedID.setLayoutX(100);
		   generatedID.setLayoutY(450);
		   
		   Error = new Label("");
		   Error.setLayoutX(475);
		   Error.setLayoutY(200);
		   
		   save = new Button("Save");
		   save.setPrefSize(150, 50);
		   save.setLayoutX(600);
		   save.setLayoutY(300);
		   save.setStyle("-fx-background-color: #4473c5");
		   save.setOnAction(new EventHandler<>() {
	            public void handle(ActionEvent event) {
	            	if(Input_First_name.getText().equals("") |  Input_Last_name.getText().equals("") | Input_email.getText().equals("") | Input_phone_number.getText().equals("") | Input_healthhist.getText().equals("") | Input_Insurance.getText().equals("")) {
	            		Error.setText("You have not filled out all the fields: Fill out everything");
	            	}else {
	            		Error.setText("");
	            		int holder = rand.nextInt(10000) + 10000;
	            		String.format("%05d", holder);
	            		ID = String.format("%05d", holder);
		            	generatedID.setText("Generated ID: " + ID);
		            	newpatient();
		            	Input_First_name.setText("");
	            		Input_Last_name.setText("");
	            		Input_email.setText("");
	            		Input_phone_number.setText("");
	            		Input_healthhist.setText("");
	         		    Input_Insurance.setText("");
	            	}
	            }
			});
		   
		   back = new Button("Back");
		   back.setPrefSize(150, 50);
		   back.setLayoutX(600);
		   back.setLayoutY(400);
		   back.setStyle("-fx-background-color: #4473c5");
		   back.setOnAction(new EventHandler<>() {
		            public void handle(ActionEvent event) {
		            	generatedID.setText("");
		            	Error.setText("");
		            	Input_First_name.setText("");
	            		Input_Last_name.setText("");
	            		Input_email.setText("");
	            		Input_phone_number.setText("");
	            		Input_healthhist.setText("");
	         		    Input_Insurance.setText("");
		            	switchScenes(Homepage);
		            }
			});
		   
		   pane2 = new Pane(Error, generatedID, Patientheader, Firstname, Lastname, Email, Phonenumber, Healthhist, InsuranceID, Input_First_name, Input_Last_name, Input_email, Input_phone_number, Input_healthhist, Input_Insurance, save, back);
	       pane2.setPrefSize(800, 500);
	       
	       Patientform = new Scene(pane2);
	       
		   return Patientform;
		}
	
	private Scene createSceneCTtechview() {
		
		patient_ID = new Label("Patient ID:");
		patient_ID.setLayoutX(100);
		patient_ID.setLayoutY(20);
		
		Input_patient_ID = new TextField();
		Input_patient_ID.setLayoutX(300);
		Input_patient_ID.setLayoutY(20);
		Input_patient_ID.setPrefWidth(250);
		
		Total_aga = new Label("The total Agatston CAC score");
		Total_aga.setLayoutX(100);
		Total_aga.setLayoutY(50);
		
		Input_agile = new TextField();
		Input_agile.setLayoutX(300);
		Input_agile.setLayoutY(50);
		Input_agile.setPrefWidth(250);
		
		vessl_level = new Label("Vessel level Agatston CAC score");
		vessl_level.setLayoutX(100);
		vessl_level.setLayoutY(80);
		
		
		LM = new Label("LM:");
		LM.setLayoutX(100);
		LM.setLayoutY(100);
		   
		LAD = new Label("LAD:");
		LAD.setLayoutX(100);
		LAD.setLayoutY(150);
		   
		LCX = new Label("LCX:");
		LCX.setLayoutX(100);
		LCX.setLayoutY(200);
		   
		RCA = new Label("RCA:");
		RCA.setLayoutX(100);
		RCA.setLayoutY(250);
		   
		PDA = new Label("PDA:");
		PDA.setLayoutX(100);
		PDA.setLayoutY(300);
		
		Input_LM = new TextField();
		Input_LM.setLayoutX(200);
		Input_LM.setLayoutY(100);
		Input_LM.setPrefWidth(250);
		   
		Input_LAD = new TextField();
		Input_LAD.setLayoutX(200);
		Input_LAD.setLayoutY(150);
		Input_LAD.setPrefWidth(250);
		   
		Input_LCX = new TextField();
		Input_LCX.setLayoutX(200);
		Input_LCX.setLayoutY(200);
		Input_LCX.setPrefWidth(250);
		   
		Input_RCA = new TextField();
		Input_RCA.setLayoutX(200);
		Input_RCA.setLayoutY(250);
		Input_RCA.setPrefWidth(250);
		   
		Input_PDA = new TextField();
		Input_PDA.setLayoutX(200);
		Input_PDA.setLayoutY(300);
		Input_PDA.setPrefWidth(250);
		
		Error1 = new Label("");
		Error1.setLayoutX(475);
		Error1.setLayoutY(200);
		   
		save2 = new Button("Save");
		save2.setPrefSize(150, 50);
		save2.setLayoutX(600);
		save2.setLayoutY(300);
		save2.setStyle("-fx-background-color: #4473c5");
		save2.setOnAction(new EventHandler<>() {
			public void handle(ActionEvent event) {
            	if(Input_patient_ID.getText().equals("") ||  Input_agile.getText().equals("")  || Input_LM.getText().equals("") || Input_LAD.getText().equals("") || Input_LCX.getText().equals("") || Input_RCA.getText().equals("") ||  Input_PDA.getText().equals("")) {
            		Error1.setText("You have not filled out all the fields: Fill out everything");
            	}else {
            		Error1.setText("");
            		//String.format("%05d", holder);
            		//ID = String.format("%05d", holder);
	            	//generatedID.setText("Generated ID: " + ID);
	            	//newpatient();
            		patientdata();
	            	Input_patient_ID.setText("");
            		Input_agile.setText("");
            		Input_LM.setText("");
            		Input_LAD.setText("");
            		Input_LCX.setText("");
         		    Input_RCA.setText("");
         		    Input_PDA.setText("");
            	}
            }
		});
		
		back2 = new Button("Back");
		back2.setPrefSize(150, 50);
		back2.setLayoutX(600);
		back2.setLayoutY(400);
		back2.setStyle("-fx-background-color: #4473c5");
		back2.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
            	Error1.setText("");
            	Input_patient_ID.setText("");
            	Input_agile.setText("");
            	Input_LM.setText("");
        		Input_LAD.setText("");
        		Input_LCX.setText("");
        		Input_RCA.setText("");
        		Input_PDA.setText("");
            	switchScenes(Homepage);
            }
		});
		
		 pane3 = new Pane(Error1, Input_agile, patient_ID, Total_aga, vessl_level, LM, LAD, LCX, RCA, PDA, Input_patient_ID, Input_LM, Input_LAD, Input_LCX, Input_RCA, Input_PDA, save2, back2);
	     pane3.setPrefSize(800, 500);
	     
	     CTtechview = new Scene(pane3);
	     
		return CTtechview;
	}
	
	private Scene createScenePatientview() {
		
		Information1 = new Label("");
		Information1.setLayoutX(350);
		Information1.setLayoutY(25);
		
		Total_aga1 = new Label("The total Agatston CAC score");
		Total_aga1.setLayoutX(100);
		Total_aga1.setLayoutY(50);
		
		Input_aga_score1 = new TextField();
		Input_aga_score1.setLayoutX(300);
		Input_aga_score1.setLayoutY(50);
		Input_aga_score1.setPrefWidth(250);
		
		LM1 = new Label("LM:");
		LM1.setLayoutX(100);
		LM1.setLayoutY(100);
		   
		LAD1 = new Label("LAD:");
		LAD1.setLayoutX(100);
		LAD1.setLayoutY(150);
		   
		LCX1 = new Label("LCX:");
		LCX1.setLayoutX(100);
		LCX1.setLayoutY(200);
		   
		RCA1 = new Label("RCA:");
		RCA1.setLayoutX(100);
		RCA1.setLayoutY(250);
		   
		PDA1 = new Label("PDA:");
		PDA1.setLayoutX(100);
		PDA1.setLayoutY(300);
		
		Input_LM1 = new TextField();
		Input_LM1.setLayoutX(200);
		Input_LM1.setLayoutY(100);
		Input_LM1.setPrefWidth(250);
		   
		Input_LAD1 = new TextField();
		Input_LAD1.setLayoutX(200);
		Input_LAD1.setLayoutY(150);
		Input_LAD1.setPrefWidth(250);
		   
		Input_LCX1 = new TextField();
		Input_LCX1.setLayoutX(200);
		Input_LCX1.setLayoutY(200);
		Input_LCX1.setPrefWidth(250);
		   
		Input_RCA1 = new TextField();
		Input_RCA1.setLayoutX(200);
		Input_RCA1.setLayoutY(250);
		Input_RCA1.setPrefWidth(250);
		   
		Input_PDA1 = new TextField();
		Input_PDA1.setLayoutX(200);
		Input_PDA1.setLayoutY(300);
		Input_PDA1.setPrefWidth(250);
		
		back3 = new Button("Back");
		back3.setPrefSize(150, 50);
		back3.setLayoutX(600);
		back3.setLayoutY(400);
		back3.setStyle("-fx-background-color: #4473c5");
		back3.setOnAction(e -> switchScenes(Homepage));
		

		Information1.setText("Hello " + personname);
		
	    pane4 = new Pane(Information1, Total_aga1, LM1, LAD1, LCX1, RCA1, PDA1, Input_LM1, Input_LAD1, Input_LCX1, Input_RCA1, Input_PDA1, back3, Input_aga_score1);
	    pane4.setPrefSize(800, 500);
	     
	    Patientview = new Scene(pane4);
	     
		return Patientview;
	}
	
/*private Scene createScenemessagedoctor() {
		
		Header = new Label("Please write your message to the doctor below");
		Header.setLayoutX(350);
		Header.setLayoutY(50);
		
		message = new Label("Message:");
		message.setLayoutX(100);
		message.setLayoutY(100);
		
		messagefield = new TextField();
		messagefield.setLayoutX(200);
		messagefield.setLayoutY(100);
		messagefield.setPrefWidth(250);
		messagefield.setPrefHeight(150);
		
		send = new Button("Send");
		send.setPrefSize(150, 50);
		send.setLayoutX(600);
		send.setLayoutY(300);
		send.setStyle("-fx-background-color: #4473c5");
		
		back4 = new Button("Back");
		back4.setPrefSize(150, 50);
		back4.setLayoutX(600);
		back4.setLayoutY(400);
		back4.setStyle("-fx-background-color: #4473c5");
		back4.setOnAction(e -> switchScenes(Patientview));
		
		pane5 = new Pane(Header, message, messagefield, send, back4);
	    pane5.setPrefSize(800, 500);
	     
	    messagedoctorscene = new Scene(pane5);
	    
		return messagedoctorscene;
	}
*/
	/*private Scene createSceneDoctorview() {
		
		return Doctorview;
	}
	*/
	public void switchScenes(Scene scene) {
		stage.setScene(scene);
	}
    
}
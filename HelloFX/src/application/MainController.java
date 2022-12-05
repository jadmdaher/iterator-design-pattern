package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ChoiceBox;

public class MainController {
	@FXML
	private Label fullDep;
	@FXML
	private ChoiceBox<String> checkBox1;
	@FXML
	private ChoiceBox<String> checkBox2;
	@FXML
	private Label fullTime;
	@FXML
	private Label fullDest;
	@FXML
	private ChoiceBox<String> checkBox3;
	@FXML
	private Label fullName;
	@FXML
	private Label fullNumber;
	@FXML
	private TextField myNumber;
	@FXML
	private TextField myName;
	@FXML
	private Button fullButton;
	@FXML
	private ChoiceBox<String> checkBox4;
	@FXML
	private Label fullType;
	@FXML
	private Label exitMessage;
	@FXML
	private Button Button;

	ObservableList<String> Locations = FXCollections.observableArrayList("Aanjar","Aarsal","Baabda","Baalbek",
			"Baskinta","Batroun","Beirut","Bsharri","Byblos","Chekka","Chtoura","Damour","Dbayeh","Faraiya",
			"Hasbaiyya","Hermel","Jezzine","Jiyeh","Jounieh","Nabatieh","Rachaiya","Saida","Tripoli","Tyre",
			"Zgharta","Zahle");
	
	ObservableList<String> Timings = FXCollections.observableArrayList("00:00","01:00","2:00","3:00","4:00",
			"5:00","6:00","7:00","8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00",
			"17:00","18:00","19:00","20:00","21:00","22:00","23:00");
	
	ObservableList<String> Car = FXCollections.observableArrayList("Rider","Driver");
	
	//Stores (K,V)===>(user, info) for each drivers
	HashMap<String,String> map1 = new HashMap<>();
	//Stores (K,V)===>(user, info) for each riders
	HashMap<String,String> map2 = new HashMap<>();
	
	Set<String> set = new HashSet<String>();
	
	
	@FXML
	private void initialize() {
		checkBox1.setItems(Locations);
		checkBox1.setValue("Departure");
		checkBox2.setItems(Timings);
		checkBox2.setValue("Time");
		checkBox3.setItems(Locations);
		checkBox3.setValue("Destination");
		checkBox4.setItems(Car);
		checkBox4.setValue("Type");
	}

	protected String Name;
	protected String number;
	protected String Departure;
	protected String Time;
	protected String Destination;
	protected String Type;
	protected String rider;
	protected String driver;

	// Event Listener on Button.onAction
	@FXML
	public void Submit(ActionEvent event) throws FileNotFoundException, IOException, 
	ConcurrentModificationException {
		//String sp = " ";
		Name = this.myName.getText();
		number = this.myNumber.getText();
		Departure = this.checkBox1.getValue();
		Time = this.checkBox2.getValue();
		Destination = this.checkBox3.getValue();
		Type = this.checkBox4.getValue();
		//System.out.println(Name + sp + number + sp + Departure + sp + Time + sp + Destination + sp +
				//Type);
		
		Scanner scan = new Scanner(System.in);
		
		File database1 = new File("driversdb.txt");
		
		if(!database1.exists()) {
			database1.createNewFile();
		}
		
		//Reads data from drivers data base
		Scanner driverScan = new Scanner(database1);
		
		// Writing to, and reading from the drivers data base text file
		FileWriter fw1 = new FileWriter(database1, true);
		BufferedWriter bw1 = new BufferedWriter(fw1);
		PrintWriter outToFile1 = new PrintWriter(bw1);
		
		FileReader fr1 = new FileReader(database1);
		BufferedReader br1 = new BufferedReader(fr1);
		//.
		
		File database2 = new File("ridersdb.txt");
		
		if(!database2.exists()) {
			database2.createNewFile();
		}
		
		//Reads data from riders data base
		Scanner riderScan = new Scanner(database2);
		
		// Writing to, and reading from the riders data base text file
		FileWriter fw2 = new FileWriter(database2, true);
		BufferedWriter bw2 = new BufferedWriter(fw2);
		PrintWriter outToFile2 = new PrintWriter(bw2);
		
		FileReader fr2 = new FileReader(database2);
		BufferedReader br2 = new BufferedReader(fr2);
		//.
		
		File temp1 = new File("driversdbtemp.txt");
		
		if(!temp1.exists()) {
			temp1.createNewFile();
		}
		
		// Writing to, and reading from the temporary drivers data base text file
		FileWriter tfw1 = new FileWriter(temp1, true);
		BufferedWriter tbw1 = new BufferedWriter(tfw1);
		PrintWriter outToTempFile1 = new PrintWriter(tbw1);
				
		FileReader tfr1 = new FileReader(temp1);
		BufferedReader tbr1 = new BufferedReader(tfr1);
		//.
		
		File temp2 = new File("ridersdbtemp.txt");
		
		if(!temp2.exists()) {
			temp2.createNewFile();
		}
		
		// Writing to, and reading from the temporary riders data base text file
		FileWriter tfw2 = new FileWriter(temp2, true);
		BufferedWriter tbw2 = new BufferedWriter(tfw2);
		PrintWriter outToTempFile2 = new PrintWriter(tbw2);
				
		FileReader tfr2 = new FileReader(temp2);
		BufferedReader tbr2 = new BufferedReader(tfr2);
		//.
			
			String user_Type = Type;
			String first_Name = Name;
			String phone = number;
			String depart = Departure;
			String arrive = Destination;
			String clock = Time;
				
			String user = first_Name + " " + phone;
			String info = clock + " " + depart + " " + arrive;
//			
//			try {
//			root = FXMLLoader.load(getClass().getResource("Exit.fxml"));
//			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//			scene = new Scene(root);
//			stage.setScene(scene);
//			stage.show();
//			}catch (Exception e) {
//				System.out.println("rip");
//			}
//			
			if(user_Type.equals("Driver")) {
				outToFile1.print(user + "\n" + info + "\n");
					
				int count2 = 0;
				String key2 = "";
				String val2 = "";
					
				while(riderScan.hasNextLine() && !riderScan.nextLine().equals(null)) {
					if(count2 == 0) {
						key2 = br2.readLine();
						count2++;
					} else {
						val2 = br2.readLine();
						map2.put(key2, val2);
						count2 = 0;
					}
				}
					
				database1.delete();
				database2.delete();
				
				//database1.createNewFile();
				//database2.createNewFile();
				
//				for(String rider : map2.keySet()) {
//					set.add(rider);
//				}
				
				for(String rider : map2.keySet()) {
					if(info.equals(map2.get(rider))) {
						//System.out.println(rider + " could use a ride.");
						exitMessage.setOpacity(1);
						exitMessage.setText(rider + " could use a ride.");
						myNumber.setOpacity(0);
						myName.setOpacity(0);
						checkBox1.setOpacity(0);
						checkBox2.setOpacity(0);
						checkBox3.setOpacity(0);
						checkBox4.setOpacity(0);
						fullName.setOpacity(0);
						fullNumber.setOpacity(0);
						fullType.setOpacity(0);
						fullDest.setOpacity(0);
						fullDep.setOpacity(0);
						fullTime.setOpacity(0);
						fullButton.setOpacity(0);
						Button.setOpacity(1);
						this.rider = rider;
						map1.remove(user, info);
						map2.remove(rider, info);
						break;
							
					}else {
						//System.out.println("Everyone has a ride :)");
						exitMessage.setOpacity(1);
						exitMessage.setText("Everyone has a ride :)");
						myNumber.setOpacity(0);
						myName.setOpacity(0);
						checkBox1.setOpacity(0);
						checkBox2.setOpacity(0);
						checkBox3.setOpacity(0);
						checkBox4.setOpacity(0);
						fullName.setOpacity(0);
						fullNumber.setOpacity(0);
						fullType.setOpacity(0);
						fullDest.setOpacity(0);
						fullDep.setOpacity(0);
						fullTime.setOpacity(0);
						fullButton.setOpacity(0);
								
					}
				}
						
				for(String drivers : map1.keySet()) {
					String values = map1.get(drivers);
					outToTempFile1.print(drivers + "\n" + values + "\n");
					
				}
					
				for(String riders : map2.keySet()) {
					String values = map2.get(riders);
					outToTempFile2.print(riders + "\n" + values + "\n");
						
				}
					
				map1.clear();
				map2.clear();
					
				temp1.renameTo(database1);
				temp2.renameTo(database2);
					
				temp1.deleteOnExit();
				temp2.deleteOnExit();
					
			}else if(user_Type.equals("Rider")) {
				outToFile2.print(user + "\n" + info + "\n");
					
				int count1 = 0;
				String key1 = "";
				String val1 = "";
					
				while(driverScan.hasNextLine() && !driverScan.nextLine().equals(null)) {
					if(count1 == 0) {
						key1 = br1.readLine();
						count1++;
					} else {
						val1 = br1.readLine();
						map1.put(key1, val1);
						count1 = 0;
					}
				}
					
				database1.delete();
				database2.delete();
				
				//database1.createNewFile();
				//database2.createNewFile();
				
				for(String driver : map1.keySet()) {
					if(info.equals(map1.get(driver))) {
						//System.out.println(driver + " could give a ride.");
						exitMessage.setOpacity(1);
						exitMessage.setText(driver + " could give a ride.");
						myNumber.setOpacity(0);
						myName.setOpacity(0);
						checkBox1.setOpacity(0);
						checkBox2.setOpacity(0);
						checkBox3.setOpacity(0);
						checkBox4.setOpacity(0);
						fullName.setOpacity(0);
						fullNumber.setOpacity(0);
						fullType.setOpacity(0);
						fullDest.setOpacity(0);
						fullDep.setOpacity(0);
						fullTime.setOpacity(0);
						fullButton.setOpacity(0);
						Button.setOpacity(1);
						map1.remove(driver, info);
						map2.remove(user, info);
						break;
							
					}else {
						//System.out.println("No available rides :(");
						exitMessage.setOpacity(1);
						exitMessage.setText("No available rides :(");
						myNumber.setOpacity(0);
						myName.setOpacity(0);
						checkBox1.setOpacity(0);
						checkBox2.setOpacity(0);
						checkBox3.setOpacity(0);
						checkBox4.setOpacity(0);
						fullName.setOpacity(0);
						fullNumber.setOpacity(0);
						fullType.setOpacity(0);
						fullDest.setOpacity(0);
						fullDep.setOpacity(0);
						fullTime.setOpacity(0);
						fullButton.setOpacity(0);
								
					}
				}
						
				for(String drivers : map1.keySet()) {
					String values = map1.get(drivers);
					outToTempFile1.print(drivers + "\n" + values + "\n");
				
				}
					
				for(String riders : map2.keySet()) {
					String values = map2.get(riders);
					outToTempFile2.print(riders + "\n" + values + "\n");
						
				}
					
				map1.clear();
				map2.clear();
					
				temp1.renameTo(database1);
				temp2.renameTo(database2);
					
				temp1.deleteOnExit();
				temp2.deleteOnExit();
					
			}
			
			driverScan.close();
			outToFile1.close();
			br1.close();
			riderScan.close();
			outToFile2.close();
			br2.close();
			outToTempFile1.close();
			tbr1.close();
			outToTempFile2.close();
			tbr2.close();

		scan.close();
	}
	
	@FXML
	public void Connect(ActionEvent event) {
		String user_Type = Type;
		String first_Name = Name;
		String phone = number;
		String depart = Departure;
		String arrive = Destination;
		String clock = Time;
		String user = first_Name + " " + phone;
		String info = clock + " " + depart + " " + arrive;
		exitMessage.setOpacity(0);
		myNumber.setOpacity(1);
		myName.setOpacity(1);
		checkBox1.setOpacity(1);
		checkBox2.setOpacity(1);
		checkBox3.setOpacity(1);
		checkBox4.setOpacity(1);
		fullName.setOpacity(1);
		fullNumber.setOpacity(1);
		fullType.setOpacity(1);
		fullDest.setOpacity(1);
		fullDep.setOpacity(1);
		fullTime.setOpacity(1);
		fullButton.setOpacity(1);
		Button.setOpacity(0);
		if(user_Type.equals("rider")) {
			map1.remove(user, info);
			map2.remove(rider, info);
		}
		if(user_Type.equals("driver")) {
			map1.remove(driver, info);
			map2.remove(user, info);
		}
		
	}
}

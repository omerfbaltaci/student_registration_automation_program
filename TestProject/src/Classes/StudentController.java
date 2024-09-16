package Classes;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import Interfaces.StudentControllerInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class StudentController implements Initializable, StudentControllerInterface {

	private static String name;
	
	public String getName() {
		return name;
	}
	
	Alert alert = new Alert(AlertType.INFORMATION);
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try {
			
			File file = new File("src/users.txt");
			
			if(!file.exists()) {
				
				file.createNewFile();
			}
		}
		catch(Exception e) {
			
			System.out.println("Error code is: " + e);
		}
	}
	
	private static Scanner x;
	
	Stage stage;
	Scene scene;
	Parent root;

	  	@FXML
	    private TextField idtextline;

	    @FXML
	    private Button loginbutton;

	    @FXML
	    private PasswordField passwordtextline;

	    @FXML
	    private Label studentlabel;

	    @FXML
	    private Button switchbutton;
	   
	    
	    public void switchToAdmin(ActionEvent event) throws IOException {
			
			root = FXMLLoader.load(getClass().getResource("/FXML/Admin.fxml"));
			
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}

	    public void login(ActionEvent event) {
	    	
	    	boolean found = false;
	    	
	    	String tempid = "";
	    	String temppassword = "";
	    	
	    	name = idtextline.getText();
	    	
	    	try {
	    	
	    		x = new Scanner(new File("src/users.txt"));
	    		x.useDelimiter("[,\n]");
	    	
	    		while(x.hasNext() && !found) {
	    			
	    			tempid = x.next();
	    		
	    			temppassword = x.next();
	    			
	    			if(!idtextline.getText().isBlank() && !passwordtextline.getText().isBlank()) {
	    				
	    				if(tempid != null && temppassword != null) {
	    					
	    					if(tempid.trim().equals(idtextline.getText().toString().trim()) && temppassword.trim().equals(passwordtextline.getText().toString().trim())) {
		    				
	    						root = FXMLLoader.load(getClass().getResource("/FXML/StudentPage.fxml"));
	    						
	    						stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    						scene = new Scene(root);
	    						stage.setScene(scene);
	    						stage.show();
		    				found = true;
	    					}
	    					
	    					else {
	    						
	    						studentlabel.setText("Wrong Student ID or Password!");
	    					}
	    				}
	    				
	    				else {
	    					
	    					studentlabel.setText("Wrong Student ID or Password!");
	    				}
		    		}
	    			
	    			else {
	    				studentlabel.setText("The ID or Password field cannot be empty!");
	    			}
	    		}
	    				
	    		x.close();
	    	}
	    	
	    	catch(Exception e) {
	    		
	    		alert.setTitle("Error");
	    		alert.setHeaderText("An error occured. Error Code is: " + e);
	    		alert.showAndWait();
	    	}
	    }

		
}
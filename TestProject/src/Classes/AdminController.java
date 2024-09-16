package Classes;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import Interfaces.AdminControllerInterface;
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

public class AdminController implements Initializable, AdminControllerInterface {
	
	private static String name;
		
	public String getName() {
		return name;
	}

	Stage stage;
	Scene scene;
	Parent root;
	
	Alert alert = new Alert(AlertType.INFORMATION);
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try {
			
			File file = new File("src/adminusers.txt");
			
			if(!file.exists()) {
				
				file.createNewFile();
			}
		}
		catch(Exception e) {
			
			System.out.println("Error code is: " + e);
		}
	}
	
	private static Scanner x;

	
	@FXML
    private Label adminlabel;

    @FXML
    private TextField idtextline;

    @FXML
    private Button loginbutton;

    @FXML
    private PasswordField passwordtextline;

    @FXML
    private Button switchbutton;
    
    
    public void switchToStudent(ActionEvent event) throws IOException {
		
		root = FXMLLoader.load(getClass().getResource("/FXML/Student.fxml"));
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    
    public void login(ActionEvent event) {
    	
    	boolean found = false;
    	
    	String tempid = "";
    	String temppassword = "";
    	
    	try {
    		
    		x = new Scanner(new File("src/adminusers.txt"));
    		x.useDelimiter("[,\n]");
    		
    		while(x.hasNext() && !found) {
    			
    			tempid = x.next();
    			temppassword = x.next();
    			
    			if(idtextline.getText().isBlank() || passwordtextline.getText().isBlank()) {
    				
    				adminlabel.setText("The ID or Password field cannot be empty!");
    			}
    			
    			else if(tempid.trim().equals(idtextline.getText().toString().trim()) && temppassword.trim().equals(passwordtextline.getText().toString().trim())) {
    				
    				found = true;
    				
    				name = idtextline.getText().toString();
    				
    				root = FXMLLoader.load(getClass().getResource("/FXML/AdminPage.fxml"));
    				
    				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    				scene = new Scene(root);
    				stage.setScene(scene);
    				stage.show();
    			}
    			
    			else {
    				
    				adminlabel.setText("Wrong Student ID or Password!");
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
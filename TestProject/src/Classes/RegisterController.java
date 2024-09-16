package Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Interfaces.RegisterControllerInterface;
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

public class RegisterController implements Initializable, RegisterControllerInterface {

	Alert alert = new Alert(AlertType.INFORMATION);

	File file = new File("src/users.txt");

	Stage stage;
	Scene scene;
	Parent root;

	public int idcalculator;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		try {

			if (!file.exists()) {

				idcalculator = 0;

				file.createNewFile();
			}
		} catch (Exception e) {

			System.out.println("Error code is: " + e);
		}
	}

	@FXML
	private PasswordField passwordtextline;

	@FXML
	private Button registerbutton;

	@FXML
	private Button returntoadmin;

	@FXML
	private Label studentlabel;

	@FXML
	private TextField studenttextline;

	@FXML
	private Button returntologin;

	@FXML
	public void register(ActionEvent event) {

		idcalculator = idcalculator + 1;

		StringBuilder sb = new StringBuilder();

		sb.append(studenttextline.getText().toString() + ",");
		sb.append(passwordtextline.getText().toString());

		try {

			if (passwordtextline.getText().isBlank() || studenttextline.getText().isBlank()) {

				studentlabel.setText("The ID or Password field cannot be empty!");
			}

			else {

				StringBuilder users = new StringBuilder();
				BufferedReader breader = new BufferedReader(new FileReader(file));
				String line;
				
				while ((line = breader.readLine()) != null) {

					users.append(line + "\n");
				}
				
				breader.close();
				
				String text = users.toString();
				
				if (!text.contains(studenttextline.getText())) {

					FileWriter fwriter = new FileWriter(file, true);
					BufferedWriter bwriter = new BufferedWriter(fwriter);

					studentlabel.setText("You've successfully registered!");

					bwriter.write(sb.toString() + "\n");
					bwriter.close();						
				} else {
					
					alert.setTitle("Error");
					alert.setHeaderText("You cannot add a student log with the same name!");
					alert.showAndWait();
				}
			}
		}

		catch (Exception e) {

			alert.setTitle("Error");
			alert.setHeaderText("An error occured. Error Code is: " + e);
			alert.showAndWait();
		}
	}

	@FXML
	public void switchToAdmin(ActionEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("/FXML/AdminPage.fxml"));

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void switchtologin(ActionEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("/FXML/Admin.fxml"));

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
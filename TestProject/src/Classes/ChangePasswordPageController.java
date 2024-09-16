package Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import Interfaces.ChangePasswordPageControllerInterface;
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
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ChangePasswordPageController implements Initializable, ChangePasswordPageControllerInterface {

	Alert alert = new Alert(AlertType.INFORMATION);
	StudentController controller = new StudentController();
	
	File file = new File("src/users.txt");
	File file2 = new File("src/tempusers.txt");
	
	Parent root;
	Stage stage;
	Scene scene;

	@FXML
	private Button changePasswordButton;

	@FXML
	private PasswordField newPasswordText;

	@FXML
	private PasswordField newPasswordText2;

	@FXML
	private Button returnToStudentPage;

	@FXML
	private Label studentlabel;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		try {
			if(!file.exists()) {
				
				file.createNewFile();
			} 
		}catch(Exception e) {
			
		}
		
		try {
			if(!file2.exists()) {
				
				file2.createNewFile();
			}
		}catch(Exception e) {
			
		}
	}

	@FXML
	public void changePasswordButtonClicked(ActionEvent event) throws IOException {

		if (newPasswordText.getText().isBlank() == false && newPasswordText2.getText().isBlank() == false) {

			if ((newPasswordText.getText()).equals(newPasswordText2.getText())) {

				Path source = Paths.get("src/tempusers.txt");

				BufferedReader breader = new BufferedReader((new FileReader(file)));
				BufferedWriter bwriter = new BufferedWriter((new FileWriter(file2, true)));

				String line;

				while ((line = breader.readLine()) != null) {

					if (line.startsWith(controller.getName())) {

						bwriter.write(controller.getName() + "," + newPasswordText.getText() + "\n");
					}
					else {

						bwriter.write(line);
						bwriter.newLine();
					}
				}
				breader.close();
				bwriter.close();
				file.delete();
				Files.move(source, source.resolveSibling("users.txt"));
			} else {

				alert.setTitle("Error");
				alert.setHeaderText("The passwords you entered are not the same!");
				alert.showAndWait();
			}
		} else {

			alert.setTitle("Error");
			alert.setHeaderText("The 'New Password' field cannot be empty!");
			alert.showAndWait();
		}
	}

	@FXML
	public void switchToStudentPageClicked(ActionEvent event) throws IOException {

		root = FXMLLoader.load(getClass().getResource("/FXML/StudentPage.fxml"));

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
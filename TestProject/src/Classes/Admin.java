package Classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import Interfaces.AdminInterface;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Admin implements AdminInterface {
	
	Alert alert = new Alert(AlertType.INFORMATION);	

	public void register(String name, String password) {
		
		alert.setTitle("Error");
		alert.setHeaderText("Users.txt was not where it should be, so it was created during the process.");

		StringBuilder sb = new StringBuilder();

		sb.append(name + ",");
		sb.append(password);

		try {

			File file = new File("src/users.txt");
			FileWriter fwriter = new FileWriter(file, true);
			BufferedWriter bwriter = new BufferedWriter(fwriter);

			if (file.exists() == false) {

				file.createNewFile();
				alert.showAndWait();
			}

			bwriter.write(sb.toString() + "\n");
			bwriter.close();
		}

		catch (Exception e) {

			alert.setHeaderText("Admin - register: An error occured. Error code: " + e);
			alert.showAndWait();
		}
	}
}
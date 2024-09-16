package Interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

public interface ChangePasswordPageControllerInterface {

	public void initialize(URL arg0, ResourceBundle arg1);
	
	void changePasswordButtonClicked(ActionEvent event) throws IOException;
	
	void switchToStudentPageClicked(ActionEvent event) throws IOException;
}

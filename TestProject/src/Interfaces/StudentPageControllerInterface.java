package Interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

public interface StudentPageControllerInterface {

	void switchToChangePassword(ActionEvent event);
	
	void switchtologin(ActionEvent event) throws IOException;
	
	public void initialize(URL arg0, ResourceBundle arg1);
}

package Interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

public interface RegisterControllerInterface {

	public void initialize(URL arg0, ResourceBundle arg1);
	
	void register(ActionEvent event);
	
	public void switchToAdmin(ActionEvent event) throws IOException;
	
	public void switchtologin(ActionEvent event) throws IOException;
}

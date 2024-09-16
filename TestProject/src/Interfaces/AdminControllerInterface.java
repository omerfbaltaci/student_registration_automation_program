package Interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

public interface AdminControllerInterface {

	public void initialize(URL arg0, ResourceBundle arg1);

	public void switchToStudent(ActionEvent event) throws IOException;

	public void login(ActionEvent event);
}

package Interfaces;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

public interface AdminPageControllerInterface {

	public void initialize(URL arg0, ResourceBundle arg1);
	
	public void getName(MouseEvent event);
	
	public void submitscore(ActionEvent event) throws Exception;
	
	public void updateButtonClicked(ActionEvent event) throws Exception;
	
	public void deleteButtonClicked(ActionEvent event);
	
	public void switchtoregister(ActionEvent event) throws Exception;
	
	public void switchtologin(ActionEvent event) throws Exception;
}

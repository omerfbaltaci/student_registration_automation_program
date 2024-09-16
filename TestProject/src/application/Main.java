package application;
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Main extends Application {
	
	@Override
	public void start(Stage stage) {
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/FXML/Student.fxml"));
			Scene scene = new Scene(root);
			Image image = new Image(getClass().getResource("/png/icon.png").toString());
			
			stage.setResizable(false);
			stage.setTitle("Nişantaşı Üniversitesi Yönetim ve Bilgilendirme Sistemi");
			stage.getIcons().add(image);
			stage.setScene(scene);
			stage.show();
		} 
		catch(Exception e) {
			System.out.println("Error code: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


/*@FXML
void register(ActionEvent event) {

	StringBuilder sb = new StringBuilder();
	
	sb.append(studenttextline.getText().toString() + ",");
	sb.append(passwordtextline.getText().toString());
	

	try {
		
		if(passwordtextline.getText().isBlank() || studenttextline.getText().isBlank()) {
			
			studentlabel.setText("The ID or Password field cannot be empty!");
		}
		
		else {

    		File file = new File("src/users.txt");
    		
    		if(file.exists() == false) {
    			
    			file.createNewFile();
    			System.out.println("Users.txt was not where it should be, so it was created during the process.");
    		}
    		
    		FileWriter fwriter = new FileWriter(file, true);
	    	
	    	BufferedWriter bwriter = new BufferedWriter(fwriter);
	    	
	    	studentlabel.setText("You've successfully registered!");
	    	
	    	bwriter.write(sb.toString() + "\n");
	    	bwriter.close();
		}
	}
	
	catch(Exception e) {
		
		studentlabel.setText("An error occured. Error code is: " + e);
	}
}*/

/* objectColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("objscore"));
linearColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("linearscore"));
differentialColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("diffscore"));
probabilityColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("probscore"));
digitalColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("digitalscore"));

tableView.setItems(list); */


/*try {
	
	Student student = new Student();

	student.setName(nameText.getText());
	student.setObjscore(Integer.parseInt(objectText.getText()));
	student.setLinearscore(Integer.parseInt(linearText.getText()));
	student.setDiffscore(Integer.parseInt(differentialText.getText()));
	student.setProbscore(Integer.parseInt(probabilityText.getText()));
	student.setDigitalscore(Integer.parseInt(digitalText.getText()));

	tableView.getItems().add(student);

	objectText.clear();
	linearText.clear();
	differentialText.clear();
	probabilityText.clear();
	digitalText.clear();
}
catch(NumberFormatException e) {
	
	alert.setTitle("Error");
	alert.setHeaderText("You cannot submit empty fields. Please fill them correctly, then try again.\n\n Error Code is: " + e);
	alert.showAndWait();
}*/


/*try {
ObservableList<Student>	studentSelected, allStudents;
allStudents = tableView.getItems();
studentSelected = tableView.getSelectionModel().getSelectedItems();

studentSelected.forEach(allStudents :: remove);
}
catch(Exception e) {
	
	
}*/

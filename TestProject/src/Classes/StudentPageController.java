package Classes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Interfaces.StudentPageControllerInterface;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class StudentPageController implements Initializable, StudentPageControllerInterface {
	
	Alert alert = new Alert(AlertType.INFORMATION);
	
	StudentController controller = new StudentController();
	Student student = new Student();
	
	Parent root;
	Stage stage;
	Scene scene;

    @FXML
    private Label adminlabel;

    @FXML
    private Button changePasswordButton;

    @FXML
    private TableColumn<Student, String> differentialColumn;

    @FXML
    private TableColumn<Student, String> digitalColumn;

    @FXML
    private TableColumn<Student, String> linearColumn;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, String> objectColumn;

    @FXML
    private TableColumn<Student, String> probabilityColumn;

    @FXML
    private Button returntologin;

    @FXML
    private Label studentName;

    @FXML
    private TableView<Student> tableView;

    @FXML
    public void switchToChangePassword(ActionEvent event) {

    	try {
    	root = FXMLLoader.load(getClass().getResource("/FXML/ChangePasswordPage.fxml"));
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    	} catch(Exception e) {
    		
    		System.out.println("switchToChangePassword error. Error code is: " + e);
    	}
    }

    @FXML
    public void switchtologin(ActionEvent event) throws IOException {

    	root = FXMLLoader.load(getClass().getResource("/FXML/Student.fxml"));
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		studentName.setText(controller.getName());
		
		nameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
		objectColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("objscore"));
		linearColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("linearscore"));
		differentialColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("diffscore"));
		probabilityColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("probscore"));
		digitalColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("digitalscore"));

		tableView.setItems(student.getStudents());
	}

}

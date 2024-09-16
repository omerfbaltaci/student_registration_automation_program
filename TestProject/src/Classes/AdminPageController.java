package Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import Interfaces.AdminPageControllerInterface;
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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AdminPageController extends Student implements Initializable, AdminPageControllerInterface {

	public static boolean containsNumbers(String string) {
		if (string == null || string.isEmpty()) {
			return false;
		}
		for (int i = 0; i < string.length(); ++i) {
			if (Character.isDigit(string.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	Alert alert = new Alert(AlertType.INFORMATION);
	File file = new File("src/studentinfo.txt");
	File file2 = new File("src/tempstudentinfo.txt");

	Stage stage;
	Scene scene;
	Parent root;

	String line;

	Admin admin = new Admin();
	AdminController admincontroller = new AdminController();
	RegisterController rcontroller = new RegisterController();
	Student student = new Student();

	@FXML
	private TableView<Student> tableView;

	@FXML
	private TableColumn<Student, String> nameColumn;

	@FXML
	private TableColumn<Student, String> objectColumn;

	@FXML
	private TableColumn<Student, String> linearColumn;

	@FXML
	private TableColumn<Student, String> differentialColumn;

	@FXML
	private TableColumn<Student, String> probabilityColumn;

	@FXML
	private TableColumn<Student, String> digitalColumn;

	@FXML
	private Label adminlabel;

	@FXML
	private TextField nameText;

	@FXML
	private TextField differentialText;

	@FXML
	private TextField digitalText;

	@FXML
	private TextField linearText;

	@FXML
	private TextField objectText;

	@FXML
	private TextField probabilityText;

	@FXML
	private Label studentname;

	@FXML
	private Button registerbutton;

	@FXML
	private Button returntologin;

	@FXML
	private Button updateButton;

	@FXML
	private Button saveButton;

	@FXML
	private Button deleteButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		adminlabel.setText("Welcome, " + admincontroller.getName());

		if (!file.exists()) {

			try {
				file.createNewFile();

			} catch (Exception e) {

				System.out.println("Error occured at AdminPageController/Initializable");
			}
		}
		
		if (!file2.exists()) {

			try {
				file2.createNewFile();

			} catch (Exception e) {

				System.out.println("Error occured at AdminPageController/Initializable");
			}
		}

		nameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
		objectColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("objscore"));
		linearColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("linearscore"));
		differentialColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("diffscore"));
		probabilityColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("probscore"));
		digitalColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("digitalscore"));

		tableView.setItems(student.getStudents());
	}

	@FXML
	public void getName(MouseEvent event) {

		try {
			studentname.setText(tableView.getSelectionModel().getSelectedItem().name);
		} catch (Exception e) {

			System.out.println("Student name - Label / Error code:" + e.getMessage());
		}

		nameText.setText(tableView.getSelectionModel().getSelectedItem().name);
		objectText.setText(tableView.getSelectionModel().getSelectedItem().objscore);
		linearText.setText(tableView.getSelectionModel().getSelectedItem().linearscore);
		differentialText.setText(tableView.getSelectionModel().getSelectedItem().diffscore);
		probabilityText.setText(tableView.getSelectionModel().getSelectedItem().probscore);
		digitalText.setText(tableView.getSelectionModel().getSelectedItem().digitalscore);
	}

	@FXML
	public void submitscore(ActionEvent event) throws Exception {

		try {

			if (!nameText.getText().isBlank() && !objectText.getText().isBlank() && !linearText.getText().isBlank()
					&& !differentialText.getText().isBlank() && !probabilityText.getText().isBlank()
					&& !digitalText.getText().isBlank()) {

				if (objectText.getText().matches("[0-9]*") && linearText.getText().matches("[0-9]*")
						&& differentialText.getText().matches("[0-9]*") && probabilityText.getText().matches("[0-9]*")
						&& digitalText.getText().matches("[0-9]*")) {

					if ((0 <= Integer.parseInt(objectText.getText())) && (Integer.parseInt(objectText.getText()) <= 100)
							&& (0 <= Integer.parseInt(linearText.getText()))
							&& (Integer.parseInt(linearText.getText()) <= 100)
							&& (0 <= Integer.parseInt(differentialText.getText()))
							&& (Integer.parseInt(differentialText.getText()) <= 100)
							&& (0 <= Integer.parseInt(probabilityText.getText()))
							&& (Integer.parseInt(probabilityText.getText()) <= 100)
							&& (0 <= Integer.parseInt(digitalText.getText()))
							&& (Integer.parseInt(digitalText.getText()) <= 100)) {

						if (containsNumbers(nameText.getText()) == false) {

							BufferedReader breader = new BufferedReader(new FileReader(new File("src/users.txt")));
							BufferedReader breader2 = new BufferedReader(
									new FileReader(new File("src/studentinfo.txt")));

							boolean a = false;

							StringBuilder sb = new StringBuilder();
							String line2;

							while ((line = breader.readLine()) != null) {

								if (!line.startsWith(nameText.getText())) {

									a = true;
								} else {

									while ((line2 = breader2.readLine()) != null) {

										sb.append(line2 + "\n");
									}
									
									breader2.close();
									String text = sb.toString();

									if (!text.contains(nameText.getText())) {

										BufferedWriter bwriter = new BufferedWriter(
												(new FileWriter("src/studentinfo.txt", true)));

										bwriter.write(nameText.getText() + "," + objectText.getText() + ","
												+ linearText.getText() + "," + differentialText.getText() + ","
												+ probabilityText.getText() + "," + digitalText.getText() + "\n");
										bwriter.close();
										tableView.setItems(student.getStudents());

										nameText.clear();
										objectText.clear();
										linearText.clear();
										differentialText.clear();
										probabilityText.clear();
										digitalText.clear();

										a = false;
										break;
									} else {
										
										alert.setTitle("Error");
										alert.setHeaderText("You can't add a student log with the same name!");
										alert.showAndWait();
									}
								}
							}
							if (a == true) {

								alert.setTitle("Error");
								alert.setHeaderText(
										"You need to register that student name before you enter a score for the name.");
								alert.showAndWait();
							}
							
							breader.close();
						} else {

							alert.setTitle("Error");
							alert.setHeaderText("The 'Student Name' field can only contain character but no number!");
							alert.showAndWait();
						}

					} else {

						alert.setTitle("Error");
						alert.setHeaderText("The scores should between 0-100!");
						alert.showAndWait();
					}

				} else {

					alert.setTitle("Error");
					alert.setHeaderText("The score fields cannot contain character but only number.");
					alert.showAndWait();
				}
			} else {

				alert.setTitle("Error");
				alert.setHeaderText("The score fields cannot be empty!");
				alert.showAndWait();
			}

		} catch (Exception e) {

			System.out.println("Submit Button error: " + e);
		}

	}

	@FXML
	public void updateButtonClicked(ActionEvent event) throws Exception {

		try {

			if (!nameText.getText().isBlank() && !objectText.getText().isBlank() && !linearText.getText().isBlank()
					&& !differentialText.getText().isBlank() && !probabilityText.getText().isBlank()
					&& !digitalText.getText().isBlank()) {

				if (objectText.getText().matches("[0-9]*") && linearText.getText().matches("[0-9]*")
						&& differentialText.getText().matches("[0-9]*") && probabilityText.getText().matches("[0-9]*")
						&& digitalText.getText().matches("[0-9]*")) {

					if ((0 <= Integer.parseInt(objectText.getText())) && (Integer.parseInt(objectText.getText()) <= 100)
							&& (0 <= Integer.parseInt(linearText.getText()))
							&& (Integer.parseInt(linearText.getText()) <= 100)
							&& (0 <= Integer.parseInt(differentialText.getText()))
							&& (Integer.parseInt(differentialText.getText()) <= 100)
							&& (0 <= Integer.parseInt(probabilityText.getText()))
							&& (Integer.parseInt(probabilityText.getText()) <= 100)
							&& (0 <= Integer.parseInt(digitalText.getText()))
							&& (Integer.parseInt(digitalText.getText()) <= 100)) {

						if (containsNumbers(nameText.getText()) == false) {

							Student students2 = tableView.getSelectionModel().getSelectedItem();

							Path source = Paths.get("src/tempstudentinfo.txt");
							BufferedReader bReader = new BufferedReader(new FileReader(file));
							BufferedWriter bWriter = new BufferedWriter(new FileWriter(file2));

							String line;
							while ((line = bReader.readLine()) != null) {
								if (!line.startsWith(students2.name)) {

									bWriter.write(line);
									bWriter.newLine();
								}
							}

							bReader.close();
							bWriter.close();
							file.delete();
							Files.move(source, source.resolveSibling("studentinfo.txt"));
							tableView.setItems(student.getStudents());
							studentname.setText("");

							BufferedWriter bwriter = new BufferedWriter((new FileWriter("src/studentinfo.txt", true)));

							bwriter.write(nameText.getText() + "," + objectText.getText() + "," + linearText.getText()
									+ "," + differentialText.getText() + "," + probabilityText.getText() + ","
									+ digitalText.getText() + "\n");
							bwriter.close();
							tableView.setItems(student.getStudents());

							nameText.clear();
							objectText.clear();
							linearText.clear();
							differentialText.clear();
							probabilityText.clear();
							digitalText.clear();

						} else {

							alert.setTitle("Error");
							alert.setHeaderText("The 'Student Name' field can only contain character but no number!");
							alert.showAndWait();
						}

					} else {

						alert.setTitle("Error");
						alert.setHeaderText("The scores should between 0-100!");
						alert.showAndWait();
					}

				} else {

					alert.setTitle("Error");
					alert.setHeaderText("The score fields cannot contain character but only number.");
					alert.showAndWait();
				}
			} else {

				alert.setTitle("Error");
				alert.setHeaderText("The score fields cannot be empty!");
				alert.showAndWait();
			}

		} catch (Exception e) {

			alert.setTitle("Error");
			alert.setHeaderText("You need to select a line from the table to update a student log.");
			alert.showAndWait();
		}
	}

	@FXML
	public void deleteButtonClicked(ActionEvent event) {

		try {
			Student students2 = tableView.getSelectionModel().getSelectedItem();

			Path source = Paths.get("src/tempstudentinfo.txt");
			BufferedReader bReader = new BufferedReader(new FileReader(file));
			BufferedWriter bWriter = new BufferedWriter(new FileWriter("src/tempstudentinfo.txt"));

			String line;
			while ((line = bReader.readLine()) != null) {
				if (!line.startsWith(students2.name)) {

					bWriter.write(line);
					bWriter.newLine();
				}
			}
			bReader.close();
			bWriter.close();
			file.delete();
			Files.move(source, source.resolveSibling("studentinfo.txt"));
			tableView.setItems(student.getStudents());
			studentname.setText("");

			nameText.clear();
			objectText.clear();
			linearText.clear();
			differentialText.clear();
			probabilityText.clear();
			digitalText.clear();
		} catch (Exception e) {

			System.out.println("Delete button error occured.\nError: " + e);
		}
	}

	@FXML
	public void switchtoregister(ActionEvent event) throws Exception {

		root = FXMLLoader.load(getClass().getResource("/FXML/Register.fxml"));

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void switchtologin(ActionEvent event) throws Exception {

		root = FXMLLoader.load(getClass().getResource("/FXML/Admin.fxml"));

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
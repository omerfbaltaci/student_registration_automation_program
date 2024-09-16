package Classes;

import java.io.BufferedReader;
import java.io.FileReader;

import Interfaces.StudentInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Student implements StudentInterface {
	
	Alert alert = new Alert(AlertType.INFORMATION);
	
	public String name;
	public String objscore;
	public String linearscore;
	public String diffscore;
	public String probscore;
	public String digitalscore;
	
	public Student() {
		
		this.name = "";
		this.objscore = "";
		this.linearscore = "";
		this.diffscore = "";
		this.probscore = "";
		this.digitalscore = "";
	}
	
	public Student(String name, String objscore, String linearscore, String diffscore, String probscore, String digitalscore) {
		
		this.name = name;
		this.objscore = objscore;
		this.linearscore = linearscore;
		this.diffscore = diffscore;
		this.probscore = probscore;
		this.digitalscore = digitalscore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getObjscore() {
		return objscore;
	}

	public void setObjscore(String objscore) {
		this.objscore = objscore;
	}

	public String getLinearscore() {
		return linearscore;
	}

	public void setLinearscore(String linearscore) {
		this.linearscore = linearscore;
	}

	public String getDiffscore() {
		return diffscore;
	}

	public void setDiffscore(String diffscore) {
		this.diffscore = diffscore;
	}

	public String getProbscore() {
		return probscore;
	}

	public void setProbscore(String probscore) {
		this.probscore = probscore;
	}

	public String getDigitalscore() {
		return digitalscore;
	}

	public void setDigitalscore(String digitalscore) {
		this.digitalscore = digitalscore;;	}
	
	public ObservableList<Student> getStudents() {
        ObservableList<Student> students = FXCollections.observableArrayList();
        try {
            String[] student;
            BufferedReader bReader = new BufferedReader(new FileReader("src/studentinfo.txt"));
            String line;
            while ((line = bReader.readLine()) != null) {
                student = line.split(",");
                students.add(new Student(student[0], student[1], student[2], student[4], student[3], student[5]));
            }
            bReader.close();
        } catch (Exception e) {
        	
        	alert.setTitle("Error");
    		alert.setHeaderText("An error occured. Error Code is: " + e);
    		alert.showAndWait();
        }
        return students;
    }
}

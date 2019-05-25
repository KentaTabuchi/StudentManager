package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableViewController implements Initializable{
    @FXML private TableView<Student> tableView;
    @FXML private TableColumn<Student,Integer> idColumn;
    @FXML private TableColumn<Student,String> nameColumn;
    @FXML private TableColumn<Student,String> emailColumn;
    @FXML private TableColumn<Student,String> addressColumn;
    @FXML private TableColumn<Student,String> phoneColumn;
    @FXML private TableColumn<Student,String> graduationColumn;

    @FXML private TextField idText;
    @FXML private TextField nameText;
    
    private List<Student> students;
    private List<Student> matchedStudents; //this variable used for filtering students;
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		setCellValueFactoryes();
		loadFromCsv();
		printAllStudents();
	}
    
    /**
     * This method adds record to TableView.
     */
	private void loadFromCsv(){
		CsvReader cvsReader = new CsvReader();
    	students = cvsReader.readFromCvs("student.csv");
	}
    private void printAllStudents() {

    	students.forEach(student->{
    		ObservableList<Student> data = tableView.getItems();
    		data.add(student);
    	});
    }
    /**
     * This method print record of matched with find by user to tableView.
     */
    private void printMatchedStudents() {

    	matchedStudents.forEach(matchedStudents->{
    		ObservableList<Student> data = tableView.getItems();
    		data.add(matchedStudents);
    	});
    }
	/**
	 * This method make RelationShip between TableColumn and Student instance (that is DataModel Entity). 
	 */
	private void setCellValueFactoryes(){

		idColumn.setCellValueFactory(new PropertyValueFactory<Student,Integer>("id"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
		emailColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
		addressColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("address"));
		phoneColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("phone"));
		graduationColumn.setCellValueFactory(new PropertyValueFactory<Student,String>("graduation"));
	}
	
	/**
	 * This is the button click event.
	 * When find button clicked,Table searches matching data by id or name. 
	 */
	@FXML protected void onFindButtonClick(){
		System.out.println("onFindButtonClick Start");
		int id = Integer.valueOf(idText.getText());
		String name = nameText.getText(); 
		this.matchedStudents = this.students.stream().filter(student -> student.getId() == id).collect(Collectors.toList());
		printMatchedStudents();
	}
}
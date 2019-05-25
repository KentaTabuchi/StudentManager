package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
    
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		setCellValueFactoryes();
		addPerson();
	}
    
    /**
     * This method adds record to TableView.
     */

    protected void addPerson() {

    	CsvReader cvsReader = new CsvReader();
    	ArrayList<Student> students = cvsReader.readFromCvs("student.csv");

    	students.forEach(student->{
    		ObservableList<Student> data = tableView.getItems();
    		data.add(student);
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
		String id = idText.getText();
		String name = nameText.getText();
	}
}
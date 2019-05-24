package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableViewController implements Initializable{
    @FXML private TableView<Student> tableView;
    @FXML private TableColumn<Student,Integer> idColumn;
    @FXML private TableColumn<Student,String> nameColumn;
    @FXML private TableColumn<Student,String> emailColumn;
    @FXML private TableColumn<Student,String> addressColumn;
    @FXML private TableColumn<Student,String> phoneColumn;
    @FXML private TableColumn<Student,String> graduationColumn;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		setCellValueFactoryes();
		addPerson();
	}
    
    /**
     * This method adds record to TableView.
     */
    @FXML
    protected void addPerson() {
    	
    	int id;
    	String name;
    	String email;
    	String address;
    	String phone;
    	String graduation;
    	
    	//his block is test code.
    	id=5;
    	name="taro";
    	email="taro.google.com";
    	address="大阪府中央区本町";
    	phone="090-1234-9876";
    	graduation="2013";
    	//End Test
    	
    	Student student = new Student(id,name,email,address,phone,graduation);
        ObservableList<Student> data = tableView.getItems();
        data.add(student);

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
}
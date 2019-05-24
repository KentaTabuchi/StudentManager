/**
 * 
 */
package application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 * @author misskabu
 * This is Entity class.Implements by JavaBeans.
 */
public class Student {
	   private final SimpleIntegerProperty id = new SimpleIntegerProperty();
	   private final SimpleStringProperty name = new SimpleStringProperty("");
	   private final SimpleStringProperty email = new SimpleStringProperty("");
	   private final SimpleStringProperty address = new SimpleStringProperty("");
	   private final SimpleStringProperty phone = new SimpleStringProperty("");
	   private final SimpleStringProperty graduation = new SimpleStringProperty("");
	/**
	 * 
	 */
	public Student() {

	}
	public int getId(){
		return id.get();
	}
	public void setId(int id){
		this.id.set(id);
	}
	public String getName(){
		return name.get();
	}
	public void setName(String name){
		this.name.set(name);
	}
	public String getEmail(){
		return email.get();
	}
	public void setEmail(String mail){
		this.email.set(mail);
	}
	public String getAddress(){
		return address.get();
	}
	public void setAddress(String address){
		this.address.set(address);
	}
	public String getPhone(){
		return this.phone.get();
	}
	public void setPhone(String phone){
		this.phone.set(phone);
	}
	public String getGraduation(){
		return graduation.get();
	}
	public void setGraduation(String graduation){
		this.graduation.set(graduation);
	}

}

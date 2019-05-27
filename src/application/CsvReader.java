/**
 * 
 */
package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author misskabu
 * This class reads CVS file for instancing Student entity.
 */
public class CsvReader {

	/**
	 * 
	 */
	public CsvReader() {
		
	}
	public ArrayList<Student> readFromCvs(String fileName){
		ArrayList<Student> students = new ArrayList<Student>();
		try {
			InputStreamReader in = new InputStreamReader(this.getClass().getResourceAsStream(fileName),"UTF-8");
			BufferedReader br = new BufferedReader(in);
			
			String line;
			while((line = br.readLine()) !=null){
			   	int id;
		    	String name;
		    	String email;
		    	String address;
		    	String phone;
		    	String graduation;
		    	
		    	String item[] = line.split(",", -1);//the second argument "-1" means get all Strings,in spite of the string == null. 
		    	id 			= Integer.valueOf(item[0]);
		    	name 		= item[1];
		    	email 		= item[2];
		    	address 	= item[3];
		    	phone 		= item[4];
		    	graduation 	= item[5];
				Student student = new Student(id,name,email,address,phone,graduation);
				students.add(student);
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return students;
	}
	

}

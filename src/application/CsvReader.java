/**
 * 
 */
package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	public ArrayList<Student> readFromCvs(String url){
		ArrayList<Student> students = new ArrayList<Student>();
		File file = new File(url);
		try {
			String path = System.getProperty("user.dir");
			BufferedReader br = new BufferedReader(new FileReader(path +"/csv/"+file));
			
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

//Description following this is the sample that I referenced from someone's site. 
/*
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
 
class Sample {
  public static void main(String args[]) {
    try {
      File f = new File("sample.csv");
      BufferedReader br = new BufferedReader(new FileReader(f));
 
      String line;
      // 1行ずつCSVファイルを読み込む
      while ((line = br.readLine()) != null) {
        String[] data = line.split(",", 0); // 行をカンマ区切りで配列に変換
 
        for (String elem : data) {
          System.out.println(elem);
        }
      }
      br.close();
 
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}
*/
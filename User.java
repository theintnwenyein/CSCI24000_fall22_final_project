import java.util.*;
import java.io.*;

public class User extends Person implements Serializable{

	private static final long serialVersionUID = -290574181213484794L;
	
	public static void main(String[] args){
		new User();
	//	System.out.println(java.io.ObjectStreamClass.lookup(u.getClass()).getSerialVersionUID());
	}// end main

	public User(){
		setID(123);
	}// end constructor

	public void testing(){
		welcome();
		storePerson();
	}// end testing

	// Serialize the User object
	public void storePerson(){
		try{
			FileOutputStream fos = new FileOutputStream("Data.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			oos.close();
			fos.close();
		}// end try
		catch(Exception e){
			System.out.println("Failed to save");
			//e.printStackTrace();
		}// end catch
	}// end storePerson
}// end class

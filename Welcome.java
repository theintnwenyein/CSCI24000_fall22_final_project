import java.util.*;
import java.io.*;

public class Welcome{

	private int userID;

	public static void main(String[] args){
		Welcome w = new Welcome();
		w.verify();
	}// end main
	
	// Verifying the user - ID = 123
	public void verify(){
		User u = new User();
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter your id: ");
		userID = input.nextInt();
		if(userID == u.id){
			loadPerson();
		}// end if
		else{
			System.out.println("Invalid User.");
		}// end else
	}// end verify
	
	// Loading the serialized User object
	public void loadPerson(){
		User u = new User();
		int correct = 1;
		try{
			FileInputStream fis = new FileInputStream("Data.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			u = (User)ois.readObject();
			ois.close();
			fis.close();
		}// end try
		catch(Exception e){
			System.out.println("Failed to load");
			e.printStackTrace();
			correct = 0;
		}// end catch

		if(correct == 1){
			u.testing();

		}// end if
	}// end loadPerson
}// end class

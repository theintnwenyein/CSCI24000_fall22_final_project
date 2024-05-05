import java.util.*;
import java.io.*;

public abstract class Food implements Serializable{
	private static final long serialVersionUID = -1407777286002639596L;
	
	protected String name;
	protected int calories;
	protected int amount;
	protected double price;
	
	Food(){
		this.amount = 0;
	}//end constructor

	public void setName(String name){
		this.name = name;
	}// end setName
	
	public void setCalories(int calories){
		this.calories = calories;
	}// end setCalories

	public void setAmount(int amount){
		this.amount += amount;
	}// end setAmount

	public void setPrice(double price){
		this.price = price;
	}// end setPrice

}// end class

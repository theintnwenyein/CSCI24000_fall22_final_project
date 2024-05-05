import java.util.*;
import java.io.*;
import java.text.*; // for DecimalFormat

// For sending email
import javax.mail.internet.*;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;


public abstract class Person implements Serializable{

	private static final long serialVersionUID = -7988440363353782226L;
	private static final DecimalFormat df = new DecimalFormat("0.00");

	private String recipe;	
	protected int id;
	private String cal;
	protected Meat meat;
	protected Veggies veggies;
	protected Fruits fruits;
	protected Snacks snacks;
	protected Drinks drinks;
	private int allergyNo;
	private int choice;
	private String listName;
	private String action;
	private int servingSize;
	private int refillAmount;
	private int upperCalories;
	private int lowerCalories;
	private int correct;
	private double money;
	private double addedMoney;
	private double totalCost;
	private int randomMeatCalories;
	private int randomVeggieCalories;
	private int caloriesTracker;
	protected AllFood allfood = new AllFood();
	String newLine = System.getProperty("line.separator"); // A line separator 

	public Person(){
		caloriesTracker = 0;
		correct = 0;
		listName = "";
		action = "";
		setMoney(0.0);
	}// end constructor
	
	public abstract void storePerson();

	public void setID(int id){
		this.id = id;
	}// end setName

	public void setMoney(double money){
		this.money = money;
	}// end setMoney

	public double getMoney(){
		return this.money;
	}// end getMoney

	public void welcome(){
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("Welcome! What do you want to do today?");
		System.out.println("1) Preparing food");
	   	System.out.println("2) Refilling the items");
		System.out.println("3) View the Pantry");
		System.out.println("4) Add Fund to the Grocery Account");
		System.out.println("5) Add new items");
		System.out.println("6) Get customized recipes for the week");
		System.out.println("7) Check your calories input status");
		System.out.println("8) Send me an email for this week's customized meal options");
		System.out.println();
		System.out.print("Please enter your choice: ");
		choice = input.nextInt();

		while(choice <= 0 || choice >= 9){
			System.out.print("Invalid input. Please enter again: ");
			choice = input.nextInt();
		}// end while
		switch(choice){
			case 1:
				prepare();
				break;
			case 2:
				refill();
				break;
			case 3:
				System.out.println("\nMeat	Calories per 100g   Amount left");
				allfood.meatShowAll();
				System.out.println("\nVeggies	Calories per 100g   Amount left");
				allfood.veggieShowAll();
				System.out.println("\nFruits	Calories per 100g   Amount left");
				allfood.fruitsShowAll();
				System.out.println("\nSnacks	Calories per 10oz   Amount left");
				allfood.snacksShowAll();
				System.out.println("\nDrinks	Calories per 100g   Amount left");
				allfood.drinksShowAll();
				break;
				
			case 4:
				System.out.println("Current amount in the account: $" + df.format(getMoney()));
				System.out.print("Please enter the amount you want to add: ");
				addedMoney = input.nextDouble();
				setMoney(getMoney() + addedMoney);
				System.out.println("Updated amount: $" + df.format(getMoney()));
				//System.out.printf("Updated amount: $ %.2f" + getMoney());
				break;
			case 5:
				allfood.addFood();
				break;
			case 6:
				System.out.println("Day 1: " + "\n" + weekOptions() + "\n" + "Day 2: \n"  + weekOptions() + "\n" + "Day 3: \n" + weekOptions() + "\n" + "Day 4: \n"  + weekOptions() + "\n" + "Day 5: \n" +  weekOptions() + "\n" + "Day 6: \n" + weekOptions() + "\n" + "Day 7: \n" +  weekOptions()); 
				break;
			case 7:
				if(caloriesTracker >= 8000 || caloriesTracker <= 0){
					System.out.println("Too much or too little data. Please make sure you have used 5 to 7 recommendations from the system.");
					caloriesTracker = 0;
				}// end if
				else{
					if(caloriesTracker <= 3500){
						System.out.println("You are going too low. You have to eat more to have a standard healthy diet.");
					}// end if
					else if(caloriesTracker <= 6850){
						System.out.println("Way to go! You are on the right track to have a standard healthy deit.");
					}// end else if
					else if(caloriesTracker > 6850){
						System.out.println("You are beyond the range. Please consider consuming less calories.");
					}// end esle if
				}// end else
				break;
			case 8:
			String recipient = "thnyein@iu.edu";
			String sender = "theintnwenyein@gmail.com";
			String host = "127.0.0.1"; // using localhost ipv4 address

			Properties properties = System.getProperties(); //properly setting the server
			properties.put("mail.smtp.auth", "true"); // saying that the smtp authentication is required
			properties.put("mail.smtp.starttls.enable", "true"); // Encrypting 
			properties.put("mail.smtp.port", "587"); // the port for Gmail smtp server
			properties.put("mail.smtp.host", "smtp.gmail.com"); // the smtp server for gmail
			
			// Password authentication for theintnwenyein@gmail.com
			Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator(){
				protected PasswordAuthentication getPasswordAuthentication(){
					return new PasswordAuthentication("theintnwenyein@gmail.com", "xqrzvbvgopdutoah"); // one time app password 
				}// end
			});// end
			try{
				MimeMessage message = new MimeMessage(session); // composing the message using the current provided session by passing it in the constructor
				message.setFrom(new InternetAddress(sender)); // sender
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); // recipient
				message.setSubject("Meal Options for the week"); // Subject of the email
				String newLine = System.getProperty("line.separator"); // A line separator 
				// Body of the email
				message.setText("Hello! Thank you for using our program. Please see the recommended meal options for this week below.\n" + newLine + "Day 1: " + newLine + weekOptions() + newLine + "Day 2: " + newLine + weekOptions() + newLine + "Day 3: " + weekOptions() + newLine + "Day 4: " + newLine + weekOptions() + newLine + "Day 5: " + newLine + weekOptions() + newLine + "Day 6: " + weekOptions() + newLine + "Day 7: " + newLine + weekOptions() + newLine + "Have a great rest of your day!");
				Transport.send(message);

				System.out.println("Successfully sent!");
			}// end try
			catch(MessagingException mex){
				//mex.printStackTrace();
				System.out.println("Failed to send.");
			}// end catch
	
				break;
		}// end switch
	}// end welcome

	public String weekOptions(){
		Random random = new Random();
		Meat suggestedMeat = allfood.meatList.get(random.nextInt(allfood.meatList.size()));
		Veggies suggestedVeggie = allfood.veggiesList.get(random.nextInt(allfood.veggiesList.size()));
		Fruits suggestedFruit = allfood.fruitsList.get(random.nextInt(allfood.fruitsList.size()));
		Drinks suggestedDrink = allfood.drinksList.get(random.nextInt(allfood.drinksList.size()));
		Snacks suggestedSnack = allfood.snacksList.get(random.nextInt(allfood.snacksList.size()));
		
		
		String meatCookingMethod = allfood.meatMethods.get(random.nextInt(allfood.meatMethods.size()));
		switch(meatCookingMethod){
			case "Stir-fried":
				randomMeatCalories = suggestedMeat.calories + 180;
				break;
			case "Air-fried":
				randomMeatCalories = suggestedMeat.calories + 20;
				break;
			case "Broiled":
				randomMeatCalories = suggestedMeat.calories + 40;
				break;
			case "Roasted":
				randomMeatCalories = suggestedMeat.calories + 90;
				break;
			case "Grilled":
				randomMeatCalories = suggestedMeat.calories + 90;
				break;
		}// end switch 

		String veggieCookingMethod = allfood.veggieMethods.get(random.nextInt(allfood.veggieMethods.size()));
		switch(veggieCookingMethod){
			case "Roasted":
				randomVeggieCalories = suggestedVeggie.calories + 25;
				break;
			case "Stir-fried":
				randomVeggieCalories = suggestedVeggie.calories + 100;
				break;
			case "Griddled":
				randomVeggieCalories = suggestedVeggie.calories + 20;
				break;
			default:
				suggestedVeggie.calories += 0;
		}// end switch

		int totalCalories = randomMeatCalories + randomVeggieCalories + suggestedFruit.calories + suggestedDrink.calories + suggestedSnack.calories;
		recipe = veggieCookingMethod + " " + suggestedVeggie.name + "," + meatCookingMethod + " " + suggestedMeat.name + "," + suggestedFruit.name + "," + suggestedDrink.name + "," + suggestedSnack.name;

		cal = "This is the total calories for the meal: " + totalCalories;
		String newLine = System.getProperty("line.separator"); // A line separator 
		return recipe + newLine + cal + newLine;
	}// end sendEmail

	public void remove(){
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("Please enter 0 if you are done.");
		System.out.print("Please enter the No. of the item: ");
		allergyNo = input.nextInt();
		
		while(allergyNo < 0 || allergyNo >= 10){
			System.out.print("Invalid input. Please enter again: ");
                        allergyNo = input.nextInt();
  		}// end while
		
		if(listName == "meat" && action == "remove"){
			if(allergyNo == 0){
				System.out.println("Great! Let's move on.");
			}// end if
			else{
				allfood.meatList.remove(allergyNo - 1);
				allfood.meatShowAll();
			}// end else
		}// end if

		else if(listName == "meat" && action == "refill"){
			if(allergyNo == 0){
				System.out.println("Exiting the program...");
			}// end if
			else{
				System.out.print("Please enter the amount to refill(Must be less than 15): ");
				refillAmount = input.nextInt();
				while(refillAmount > 15 || refillAmount < 0){
					System.out.print("Invalid input. Please enter again: ");
					refillAmount = input.nextInt();
				}// end while 
				totalCost = refillAmount * (allfood.meatList.get(allergyNo - 1).price);
				System.out.println("Total Cost is $" + totalCost);
				if(getMoney() < totalCost){
					System.out.println("You do not have enough funds. Consider adding funds to your account.");
				}// end if
				else{

					setMoney(getMoney() - totalCost);
					System.out.println("Your updated money amount: $" + df.format(getMoney()));
					allfood.meatList.get(allergyNo - 1).setAmount(refillAmount);
					allfood.meatShowAll();
				}// end else
			}// end else
		}// end if


		else if(listName == "veggie" && action == "remove"){
			if(allergyNo == 0){
				System.out.println("Great! Let's move on");
			}// end if
			else{
				allfood.veggiesList.remove(allergyNo - 1);
				allfood.veggieShowAll();
			}// end else
		}// end if
		
		else if(listName == "veggie" && action == "refill"){
		//	allfood.showVeggiesPrice();
			if(allergyNo == 0){
				System.out.println("Exiting the program...");
			}// end if
			else{

				System.out.print("Please enter the amount to refill(Must be less than 15): ");
				refillAmount = input.nextInt();
				while(refillAmount > 15 || refillAmount < 0){
					System.out.print("Invalid input. Please enter again: ");
					refillAmount = input.nextInt();
				}// end while
				totalCost = refillAmount * (allfood.veggiesList.get(allergyNo - 1).price);
				System.out.println("Total Cost is $" + totalCost);
				if(getMoney() < totalCost){
					System.out.println("You do not have enough funds. Consider adding funds to your account.");
				}// end if
				else{
					setMoney(getMoney() - totalCost);
					System.out.println("Your updated money amount: $" + df.format(getMoney()));
					allfood.veggiesList.get(allergyNo - 1).setAmount(refillAmount);
					allfood.veggieShowAll();
				}// end else
			}// end else
		}// end else if


		else if(listName == "fruit" && action == "remove"){
			if(allergyNo == 0){
				System.out.println("Great! Let's move on");
			}// end if
			else{
				allfood.fruitsList.remove(allergyNo - 1);
				allfood.fruitsShowAll();
			}//end else
		}// end if

		else if(listName == "fruit" && action == "refill"){
			if(allergyNo == 0){
				System.out.println("Exiting the program...");
			}// end if
			else{
				System.out.print("Please enter the amount to refill(Must be less than 15): ");
				refillAmount = input.nextInt();
				while(refillAmount > 15 || refillAmount < 0){
					System.out.print("Invalid input. Please enter again: ");
					refillAmount = input.nextInt();
			        }// end while
				totalCost = refillAmount * (allfood.fruitsList.get(allergyNo - 1).price);
				System.out.println("Total Cost is $" + totalCost);
				if(getMoney() < totalCost){
					System.out.println("You do not have enough funds. Consider adding funds to your account.");
				}// end if
				else{
					setMoney(getMoney() - totalCost);
					System.out.println("Your updated money amount: $" + df.format(getMoney()));
					allfood.fruitsList.get(allergyNo - 1).setAmount(refillAmount);
					allfood.fruitsShowAll();
				}// end else
			}// end else
		}// end else if

		else if(listName == "snack" && action == "remove"){
			if(allergyNo == 0){
				System.out.println("Great! Let's move on");
			}// end if
			else{
				allfood.snacksList.remove(allergyNo - 1);
				allfood.snacksShowAll();
			}// end else
		}// end if

		else if(listName == "snack" && action == "refill"){
			if(allergyNo == 0){
				System.out.println("Exiting the program...");
			}// end if
			else{
				System.out.print("Please enter the amount to refill(Must be less than 15): ");
	    			refillAmount = input.nextInt();
				while(refillAmount > 15 || refillAmount < 0){
					System.out.print("Invalid input. Please enter again: ");
					refillAmount = input.nextInt();
				}// end while 
				totalCost = refillAmount * (allfood.snacksList.get(allergyNo - 1).price);
				System.out.println("Total Cost is $" + totalCost);
				if(getMoney() < totalCost){
					System.out.println("You do not have enough funds. Consider adding funds to your account.");
				}// end if
				else{
					setMoney(getMoney() - totalCost);
					System.out.println("Your updated money amount: $" + df.format(getMoney()));
					allfood.snacksList.get(allergyNo - 1).setAmount(refillAmount);
					allfood.snacksShowAll();
				}// end else
			}// end else
		}// end else if


		else if(listName == "drink" && action == "remove"){
			if(allergyNo == 0){
				System.out.println("Great! Let's move on");
			}// end if
			else{
				allfood.drinksList.remove(allergyNo - 1);
				allfood.drinksShowAll();
			}// end else
		}// end if

		else if(listName == "drink" && action == "refill"){
			if(allergyNo == 0){
				System.out.println("Exiting the program...");
			}// end if
			else{
			       System.out.print("Please enter the amount to refill(Must be less than 15): ");
			       refillAmount = input.nextInt();
			       while(refillAmount > 15 || refillAmount < 0){
				       System.out.print("Invalid input. Please enter again: ");
				       refillAmount = input.nextInt();
			       }// end while
				totalCost = refillAmount * (allfood.drinksList.get(allergyNo - 1).price);
				System.out.println("Total Cost is $" + totalCost);
				if(getMoney() < totalCost){
					System.out.println("You do not have enough funds. Consider adding funds to your account.");
				}// end if
				else{
					setMoney(getMoney() - totalCost);
					System.out.println("Your updated money amount: $" + df.format(getMoney()));
					allfood.drinksList.get(allergyNo - 1).setAmount(refillAmount);
					allfood.drinksShowAll();
				}// end else
			}// end else
		}// end else if		
	}// end remove

	public void checkAllergy(){
		Scanner input = new Scanner(System.in);
		System.out.println("Do you need to remove anything from the list above?		1) YES   0) NO");
		System.out.print("Please enter your choice: ");
		choice = input.nextInt();
		while(choice != 1 && choice != 0){
			System.out.print("Invalid input! Please enter again: ");
			choice = input.nextInt();
		}// end while
		if(choice == 1){
			remove();
			while(allergyNo != 0){
				remove();
			}// end while
		}// end if
		else if(choice == 0){
			System.out.println("Great! Let's move on.");
		}// end else if
	}// end checkAllergy

	public int chooseRandom(){
		Random random = new Random();
	//	System.out.println("Here is the suggested meal.");
		Meat suggestedMeat = allfood.meatList.get(random.nextInt(allfood.meatList.size()));
		Veggies suggestedVeggie = allfood.veggiesList.get(random.nextInt(allfood.veggiesList.size()));
		Fruits suggestedFruit = allfood.fruitsList.get(random.nextInt(allfood.fruitsList.size()));
		Drinks suggestedDrink = allfood.drinksList.get(random.nextInt(allfood.drinksList.size()));
		Snacks suggestedSnack = allfood.snacksList.get(random.nextInt(allfood.snacksList.size()));
		
		
		String meatCookingMethod = allfood.meatMethods.get(random.nextInt(allfood.meatMethods.size()));
		switch(meatCookingMethod){
			case "Stir-fried":
				randomMeatCalories = suggestedMeat.calories + 180;
				break;
			case "Air-fried":
				randomMeatCalories = suggestedMeat.calories + 20;
				break;
			case "Broiled":
				randomMeatCalories = suggestedMeat.calories + 40;
				break;
			case "Roasted":
				randomMeatCalories = suggestedMeat.calories + 90;
				break;
			case "Grilled":
				randomMeatCalories = suggestedMeat.calories + 90;
				break;
		}// end switch 

		String veggieCookingMethod = allfood.veggieMethods.get(random.nextInt(allfood.veggieMethods.size()));
		switch(veggieCookingMethod){
			case "Roasted":
				randomVeggieCalories = suggestedVeggie.calories + 25;
				break;
			case "Stir-fried":
				randomVeggieCalories = suggestedVeggie.calories + 100;
				break;
			case "Griddled":
				randomVeggieCalories = suggestedVeggie.calories + 20;
				break;
			default:
				suggestedVeggie.calories += 0;
		}// end switch

		int totalCalories = randomMeatCalories + randomVeggieCalories + suggestedFruit.calories + suggestedDrink.calories + suggestedSnack.calories;
		if(correct == 1){
			System.out.println(veggieCookingMethod + " " + suggestedVeggie.name + "," + meatCookingMethod + " " + suggestedMeat.name + "," + suggestedFruit.name + "," + suggestedDrink.name + "," + suggestedSnack.name);
			
			System.out.println();
			System.out.println("Total Calories per 1 serving: " + totalCalories);		
			caloriesTracker += totalCalories;
			System.out.println("Total Calories for " + servingSize + " : " + (totalCalories * servingSize));
			System.out.println();
		}// end if
		if(suggestedMeat.amount > 0 && suggestedVeggie.amount > 0 && suggestedSnack.amount > 0 && suggestedFruit.amount > 0 && suggestedDrink.amount >0){
			suggestedMeat.amount -= servingSize;
			suggestedVeggie.amount -= servingSize;
			suggestedSnack.amount -= servingSize;
			suggestedFruit.amount -= servingSize;
			suggestedDrink.amount -= servingSize;
		}// end if
		else{
			System.out.println("Out of stock! Please consider going grocery shopping ASAP.");
		}// end esle	
		return totalCalories;
	}// end chooseRandom

	public void prepare(){
		action = "remove";
		//AllFood allfood = new AllFood();
	//	allfood = new AllFood();
		Scanner input = new Scanner(System.in);
		System.out.print("For how many people are you preparing?: ");
		servingSize = input.nextInt();
		while(servingSize <= 0 || servingSize > 6){
			System.out.print("The input must be between 1 and 6! Please enter again: ");
			servingSize = input.nextInt();
		}// end while

		System.out.println();
		System.out.println("Sounds great! Please see if there are any meat you need to remove below.");
		System.out.println("No. Item   Calories per 100g    Amount left");
		listName = "meat";
		allfood.meatShowAll();
		checkAllergy();
		System.out.println();
		
		System.out.println();
		System.out.println("Please see if there are any veggies you need to remove below.");
		System.out.println("No. Item   Calories per 100g    Amount left");
		listName = "veggie";
		allfood.veggieShowAll();
		checkAllergy();
		System.out.println();
		
		System.out.println();
		System.out.println("Please see if there are any fruits you need to remove below.");
		System.out.println("No. Item   Calories per 100g    Amount left");
		listName = "fruit";
		allfood.fruitsShowAll();
		checkAllergy();
		System.out.println();

		System.out.println();
		System.out.println("Please see if there are any drinks you need to remove below.");
		System.out.println("No. Item   Calories per 100g    Amount left");
		listName = "drink";
		allfood.drinksShowAll();
		checkAllergy();
		System.out.println();
		
		System.out.println();
		System.out.println("Please see if there are any snacks you need to remove below.");
		System.out.println("No. Item   Calories per 100g    Amount left");
		listName = "snack";
		allfood.snacksShowAll();
		checkAllergy();
		System.out.println();

		System.out.println("The lower limit for calories per person should be between 300 and 800.");
		System.out.print("Please enter the lower limit for calories per 1 person: ");
		lowerCalories = input.nextInt();

		while(lowerCalories < 300 || lowerCalories > 650){
			System.out.print("Invalid input. Please enter again: ");
			lowerCalories = input.nextInt();
		}// end while
		
		System.out.println();
		System.out.println("The limit for calories per person should be less than 900.");
		System.out.print("Please enter the upper limit for calories per 1 person: ");
		upperCalories = input.nextInt();

		while(upperCalories > 900 || upperCalories < lowerCalories){
			System.out.print("Invalid input. Please enter again: ");
			upperCalories = input.nextInt();
		}// end while
		
		System.out.println();
		if(chooseRandom() < upperCalories){
			correct = 1;
			System.out.println();
			chooseRandom();
			System.out.println();
		}// end if
	}// end welcome

	public void refill(){
		//AllFood allfood = new AllFood();
		Scanner input = new Scanner(System.in);
		action = "refill";
		System.out.println("Which food category are you refilling?");
		System.out.println("1) Meat   2) Veggie   3) Fruits   4) Drinks   5) Snacks");
		System.out.print("Please enter your choice: ");
		choice = input.nextInt();
		while(choice < 1 || choice >= 6){
			System.out.print("Invalid input! Please enter again: ");
			choice = input.nextInt();
		}// end while
		switch(choice){
			case 1:
				allfood.showMeatPrice();
				System.out.println("\n");
				allfood.meatShowAll();
				listName = "meat";
				remove();
				break;
			case 2:
				allfood.showVeggiesPrice();
				System.out.println("\n");
				allfood.veggieShowAll();
				listName = "veggie";
				remove();
				break;
			case 3:
				allfood.showFruitsPrice();
				System.out.println("\n");
				allfood.fruitsShowAll();
				listName = "fruit";
				remove();
				break;
			case 4:
				allfood.showDrinksPrice();
				System.out.println("\n");
				allfood.drinksShowAll();
				listName = "drink";
				remove();
				break;
			case 5:
				allfood.showSnacksPrice();
				System.out.println("\n");
				allfood.snacksShowAll();
				listName = "snack";
				remove();
				break;
		}// end switch
	}//end refill
}// end class	

import java.util.*;
import java.io.*;

public class AllFood implements Serializable {
	private static final long serialVersionUID =-290574181213484794L;
	
	private int choice;
	protected String addedFoodName;
	protected int addedFoodCalories;
	protected int addedFoodAmount;
	protected double addedFoodPrice;

	Meat chicken = new Meat();
	Meat beef = new Meat();
	Meat pork = new Meat();
	Meat sausage = new Meat();
	Meat bacon = new Meat();
	Meat turkey = new Meat();
	ArrayList<Meat> meatList = new ArrayList<Meat>();

	Veggies broccoli = new Veggies();
	Veggies cauliflower = new Veggies();
	Veggies bokchoy = new Veggies();
	Veggies beans = new Veggies();
	Veggies cabbage = new Veggies();
	Veggies carrot = new Veggies();
	ArrayList<Veggies> veggiesList = new ArrayList<Veggies>();

	Fruits apple = new Fruits();
	Fruits orange = new Fruits();
	Fruits strawberry = new Fruits();
	Fruits blueberry = new Fruits();
	Fruits kiwi = new Fruits();
	Fruits melon = new Fruits();
	ArrayList<Fruits> fruitsList = new ArrayList<Fruits>();

	Snacks doritos = new Snacks();
	Snacks chips = new Snacks();
	Snacks pretzels = new Snacks();
	Snacks veggieStraw = new Snacks();
	Snacks cookies = new Snacks();
	Snacks cheetos = new Snacks();
	ArrayList<Snacks> snacksList = new ArrayList<Snacks>();

	Drinks coke = new Drinks();
	Drinks appleCider = new Drinks();
	Drinks orangeJuice = new Drinks();
	Drinks pepsi = new Drinks();
	Drinks fanta = new Drinks();
	Drinks sweetTea = new Drinks();
	ArrayList<Drinks> drinksList = new ArrayList<Drinks>();
	
	ArrayList<String> meatMethods = new ArrayList<String>(Arrays.asList(new String[]{"Stir-fried", "Air-fried", "Broiled", "Roasted", "Grilled"}));
	ArrayList<String> veggieMethods = new ArrayList<String>(Arrays.asList(new String[] {"Boiled", "Steamed", "Roasted", "Stir-fried", "Griddled"}));
	
	public static void main(String[] args){
		new AllFood();
	}// end main

	public AllFood(){
		
		meatList.add(chicken);
		chicken.setName("Chicken");
		chicken.setCalories(165);
		chicken.setPrice(2);		

		meatList.add(beef);
		beef.setName("Beef");
		beef.setCalories(350);
		beef.setPrice(2.5);

		meatList.add(pork);
		pork.setName("Pork");
		pork.setCalories(242);
		pork.setPrice(1.8);

		meatList.add(sausage);
		sausage.setName("Sausage");
		sausage.setCalories(301);
		sausage.setPrice(2.2);

		meatList.add(bacon);
		bacon.setName("Bacon");
		bacon.setCalories(417);
		bacon.setPrice(4);

		meatList.add(turkey);
		turkey.setName("Turkey");
		turkey.setCalories(141);
		turkey.setPrice(4.3);
		
		veggiesList.add(broccoli);
		broccoli.setName("Broccoli");
		broccoli.setCalories(34);
		broccoli.setPrice(1.1);

		veggiesList.add(cauliflower);
		cauliflower.setName("Cauliflower");
		cauliflower.setCalories(25);
		cauliflower.setPrice(1.5);

		veggiesList.add(bokchoy);
		bokchoy.setName("Bok choy");
		bokchoy.setCalories(13);
		bokchoy.setPrice(1.8);

		veggiesList.add(beans);
		beans.setName("Beans");
		beans.setCalories(31);
		beans.setPrice(0.9);

		veggiesList.add(cabbage);
		cabbage.setName("Napa Cabbage");
		cabbage.setCalories(12);
		cabbage.setPrice(2.49);

		veggiesList.add(carrot);
		carrot.setName("Carrot");
		carrot.setCalories(41);
		carrot.setPrice(0.7);

		fruitsList.add(apple);
		apple.setName("Apple");
		apple.setCalories(52);
		apple.setPrice(2.3);

		fruitsList.add(orange);
		orange.setName("Orange");
		orange.setCalories(47);
		orange.setPrice(2.29);

		fruitsList.add(strawberry);
		strawberry.setName("Strawberry");
		strawberry.setCalories(33);
		strawberry.setPrice(3.29);

		fruitsList.add(blueberry);
		blueberry.setName("Blueberry");
		blueberry.setCalories(57);
		blueberry.setPrice(3.29);

		fruitsList.add(kiwi);
		kiwi.setName("Kiwi");
		kiwi.setCalories(61);
		kiwi.setPrice(3.5);

		fruitsList.add(melon);
		melon.setName("Melon");
		melon.setCalories(34);
		melon.setPrice(3.79);
		
		drinksList.add(coke);
		coke.setName("Coke");
		coke.setCalories(39);
		coke.setPrice(1.2);

		drinksList.add(pepsi);
		pepsi.setName("Pepsi");
		pepsi.setCalories(27);
		pepsi.setPrice(1.2);

		drinksList.add(appleCider);
		appleCider.setName("Apple Cider");
		appleCider.setCalories(20);
		appleCider.setPrice(3.5);

		drinksList.add(orangeJuice);
		orangeJuice.setName("Orange Juice");
		orangeJuice.setCalories(47);
		orangeJuice.setPrice(3.29);

		drinksList.add(fanta);
		fanta.setName("Fanta");
		fanta.setCalories(19);
		fanta.setPrice(1.2);

		drinksList.add(sweetTea);
		sweetTea.setName("Sweet Tea");
		sweetTea.setCalories(35);
		sweetTea.setPrice(2.29);
		
		snacksList.add(doritos);
		doritos.setName("Doritos");
		doritos.setCalories(130);
		doritos.setPrice(4.49);

		snacksList.add(chips);
		chips.setName("Potato Chips");
		chips.setCalories(152);
		chips.setPrice(3.79);

		snacksList.add(pretzels);
		pretzels.setName("Pretzels");
		pretzels.setCalories(108);
		pretzels.setPrice(2.3);

		snacksList.add(veggieStraw);
		veggieStraw.setName("Veggie Straws");
		veggieStraw.setCalories(134);
		veggieStraw.setPrice(2.3);

		snacksList.add(cookies);
		cookies.setName("Chocolate chip cookies");
		cookies.setCalories(142);
		cookies.setPrice(4.79);

		snacksList.add(cheetos);
		cheetos.setName("Cheetos");
		cheetos.setCalories(160);
		cheetos.setPrice(2.79);

		originalAmount(); // Setting the initial amount of every food item
	}// end constructor

	public void originalAmount(){
		for(int i = 0; i < meatList.size(); i++){
			meatList.get(i).setAmount(5);
		}// end for

		for(int i = 0; i < veggiesList.size(); i++){
			veggiesList.get(i).setAmount(5);
		}// end for

		for(int i = 0; i < fruitsList.size(); i++){
			fruitsList.get(i).setAmount(5);
		}// end for

		for(int i = 0; i < drinksList.size(); i++){
			drinksList.get(i).setAmount(5);
		}// end for

		for(int i = 0; i < snacksList.size(); i++){
			snacksList.get(i).setAmount(5);
		}// end for
	}// end starting
	

	// Showing the whole list of each food category
	public void meatShowAll(){
		for(int i = 0; i < meatList.size(); i++){
			System.out.println(i+1 + " " + meatList.get(i).name + "," + meatList.get(i).calories + "," + meatList.get(i).amount);

		}// end for
	}// end meatShowAll

	public void veggieShowAll(){
		for(int i = 0; i < veggiesList.size(); i++){
			System.out.println(i+1 + " " + veggiesList.get(i).name + ", " + veggiesList.get(i).calories + ", " + veggiesList.get(i).amount);
		}// end for			        
	}// end veggieShowAll

	public void fruitsShowAll(){
		for(int i = 0; i < fruitsList.size(); i++){
			System.out.println(i+1 + " " + fruitsList.get(i).name + ", " + fruitsList.get(i).calories + ", " + fruitsList.get(i).amount);
		}// end for
	}// end fruitsShowAll

	public void snacksShowAll(){
		for(int i = 0; i < snacksList.size(); i++){
			System.out.println(i+1 + " " + snacksList.get(i).name + ", " + snacksList.get(i).calories + ", " + snacksList.get(i).amount);
		}// end for
	}// end snacksShowAll

	public void drinksShowAll(){
		for(int i = 0; i < drinksList.size(); i++){
			System.out.println(i+1 + " " + drinksList.get(i).name + ", " + drinksList.get(i).calories + ", " + drinksList.get(i).amount);
		}// end for
	}// end drinksShowAll


	// Showing the prices of each food item
	public void showMeatPrice(){
		for(int i = 0; i < meatList.size(); i++){
			System.out.println(meatList.get(i).name + "'s price is $" + meatList.get(i).price);
		}// end for
	}// end showMeatPrice

	public void showVeggiesPrice(){
		 for(int i = 0; i < veggiesList.size(); i++){
		     System.out.println(veggiesList.get(i).name + "'s price is $" + veggiesList.get(i).price);
		 }// end for
	}// end showVeggiePrice

	public void showFruitsPrice(){
	       	for(int i = 0; i < fruitsList.size(); i++){
			System.out.println(fruitsList.get(i).name + "'s price is $" + fruitsList.get(i).price);
		}// end for
	}// end showFruitsPrices

	public void showDrinksPrice(){
		for(int i = 0; i < drinksList.size(); i++){
			System.out.println(drinksList.get(i).name + "'s price is $" + drinksList.get(i).price);
		}// end for
	}// end showDrinksPrices

	public void showSnacksPrice(){
		for(int i = 0; i < snacksList.size(); i++){
			System.out.println(snacksList.get(i).name + "'s price is $" + snacksList.get(i).price);
		}// end for
	}// end showSnacksPrices


	// Adding new food item to the lists
	public void addFood(){
		Scanner input = new Scanner(System.in);
		System.out.println("Please choose the right category to add your new item. \n");
		System.out.println("1) Meat	2) Veggies	3) Fruits	4) Drinks	5) Snacks");
		System.out.print("\n Please enter your choice: ");
		choice = input.nextInt();
		if(choice == 0){
			System.out.println("Exiting the program...");
		}// end if
		else{
			while(choice < 0 || choice >= 6){
				System.out.print("Invalid input. Please enter again: ");
				choice = input.nextInt();
			}// end while
			System.out.println("Please enter the new item's information below.");
			System.out.print("Name: ");
			addedFoodName = input.next();
			System.out.print("Calories per 100g: ");
			addedFoodCalories = input.nextInt();
			System.out.print("Current Total Amount: ");
			addedFoodAmount = input.nextInt();
			System.out.print("Price per 100g: ");
			addedFoodPrice = input.nextDouble();
	
			switch(choice){
				case 1:
					if(meatList.size() == 10){
						System.out.println("You can't add new meat now! There is no space left in the fridge.");
					}// end if
					else{
						Meat addedFood = new Meat();
						meatList.add(addedFood);
						addedFood.setName(addedFoodName);
						addedFood.setCalories(addedFoodCalories);
						addedFood.setAmount(addedFoodAmount);
						addedFood.setPrice(addedFoodPrice);
						System.out.println();
						System.out.println("Successfully added \n");
						meatShowAll();
					}// end else
					break;

				case 2:
					if(veggiesList.size() == 10){
						System.out.println("You can't add new veggies now! There is no space left in the fridge.");
					}// end if
					else{
						Veggies addedFood = new Veggies();
						veggiesList.add(addedFood);
						addedFood.setName(addedFoodName);
						addedFood.setCalories(addedFoodCalories);
						addedFood.setAmount(addedFoodAmount);
						addedFood.setPrice(addedFoodPrice);
						System.out.println();
						System.out.println("Successfulyy Added \n");
						veggieShowAll();
					}// end else
					break;
	
				case 3:
					if(fruitsList.size() == 10){
						System.out.println("You can't add new fruits now! There is no space left in the fridge.");
					}// end if
					else{
						Fruits addedFood = new Fruits();
						fruitsList.add(addedFood);
						addedFood.setName(addedFoodName);
						addedFood.setCalories(addedFoodCalories);
						addedFood.setAmount(addedFoodAmount);
						addedFood.setPrice(addedFoodPrice);
						System.out.println();
						System.out.println("Successfulyy Added \n");
						fruitsShowAll();
					}// end else
					break;
				
				case 4:
					if(drinksList.size() == 10){
						System.out.println("You can't add new drinks now! There is no space left in the fridge.");
					}// end if
					else{
						Drinks addedFood = new Drinks();
						drinksList.add(addedFood);
						addedFood.setName(addedFoodName);
						addedFood.setCalories(addedFoodCalories);
						addedFood.setAmount(addedFoodAmount);
						addedFood.setPrice(addedFoodPrice);
						System.out.println();
						System.out.println("Successfulyy Added \n");
						drinksShowAll();
					}// end else
					break;

				case 5:
					if(snacksList.size() == 10){
						System.out.println("You can't add new snacks now! There is no space left in the pantry.");
					}// end if
					else{
						Snacks addedFood = new Snacks();
						snacksList.add(addedFood);
						addedFood.setName(addedFoodName);
						addedFood.setCalories(addedFoodCalories);
						addedFood.setAmount(addedFoodAmount);
						addedFood.setPrice(addedFoodPrice);
						System.out.println();
						System.out.println("Successfulyy Added \n");
						snacksShowAll();
					}// end else
					break;
			}// end switch
		} // end else
	}// end addFood
}// end class

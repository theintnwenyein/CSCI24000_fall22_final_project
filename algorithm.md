# The example User ID to run this program is "123".

- Goal: The program is a Healthy Meal Recommender and Calories Tracker. The goal of this program is 
	- to recommend the recipes depending on the available food items in the user's fridge and pantry, and depending on the user's wanted calories intake range
	- to remove food items which are allergic to the user
	- to let the user shop and refill the items with the shopper card
	- to let the user manage the funds in the shopper card
	- to add new items which are not already in the fridge and the pantry, and 
	- to give the user the customized recipes for the whole week.
	- to track the calories input and determine whether the user is on the right track or too extreme 
	- to send the user an email for a week's meal options

Input: The program will have the serialized data file, named "Data.txt" about the user's information and current stocks. It will also take the user inputed data ocasionally.

Output: An UI Diagram is provided depending on the user's choices.

Steps:

- Create an abstract Food class to inherit from for the Meat, Veggies, Fruits, Drinks, and Snacks classes
- Create the child classes of Food: Meat, Veggies, Fruits, Drinks, and Snacks
- Create an AllFood class to add food items to each food category including their associated price, calories, and amount
	- This class will also include some methods such as showing the full list of each category, and managing the suggested item
- Create an abstract Person class to inherit from for the User class
	- This class will have some methods such as producing the recommended meal, grocery shopping, adding new items, and managing the shooper card. 
- Create a User class which is a child class of the Person class
	- This class will use the driver method from the Person class, and have an additional method to serialize the user
- Create a Welcome class which will be the main class of the program with a method to load the serialized User

Abstract Food class

- Goal: To have the common characteristics of every food items
- Input: Nothing from the user
- Output: Nothing to the console
- Steps: 
	- Create variables such as name, price, calories, and amount
	- Create setters and getters for each variables

Meat, Veggies, Fruits, Drinks, Snacks Classes

- Goal: To be extended from the abstract Food class
- Input: Nothing from the user
- Output: Nothing to the console
- Steps:
	- Have a main method for the purpose of testing
	- Have a constructor for the purpose of using them in future classes

AllFood class

- Goal: To manage all the food items in each category including setting initial items and creating some necessary methods
- Input: It will take the user's choices as inputs to know how to proceed the program
- Output: Vary depending on the input although it will not have direct communication with the user. It will be aggregated in future classes as an instance of them.
- Steps:
	- Create necessary variables starting from adding the initial food items
		- Meat will have chicken, beef, pork, sausage, bacon, and turkey. They all will be the type of Meat.
		- Veggies will have broccoli, cauliflower, bokchoy, beans, cabbage, and carrot. They all will be the type of Veggies.
		- Fruits will have apple, orange, strawberry, blueberry, kiwi, and melon. They all will be the type of Fruits.
		- Snacks will have doritos, chips, pretzels, veggieStraw, cookies, and cheetos. They all will be the type of Snacks.
		- Drinks will have coke, appleCider, orangeJuice, pepsi, fanta, and sweetTea. They all will be the type of Drinks.
		
	- Create arraylist for each food category such as an arraylist for Meat, and Veggies, and so on..
	- Create two arraylists for the methods of cooking meat and veggies 
		- Meat cooking methods will be "Stir-frying, Air-frying, Broiling, Roasting, and Grilling"
		- Veggies cooking methods will be "Boiling, Steaming, Roasting, Stir-frying, and Griddling"
	- Set the name, calories, price, and amount for each food item
	- Create methods to show the whole list of each food category with their name, calories, and amount left
	- Create a separate method to show the price of each food item 
	- Create a method to add new food item into the arraylist
		- First, ask the user into which food category she wants to add the new item, and keep the input in a variable "choice"
		- Ask new item's name, price, calories, and initial amount
		- Put all those information into the related arraylist depending on the value of "choice"

Person Abstract Class

- Goal: To be the parent class of the User class, and to have every necessary variables and functions a user should have
- Input: User input choices
- Output: Vary depending on what the user wants to do
- Steps:
	- Create necessary variables and have an instance of AllFood class
	- An user will have an ID, and make a setter for the ID.
	- Make setters and getters for the money in the shopper's card.
	- First, create a method "remove()" in order to remove any allergic items and grocery shop in each food category: action will be either "remove" or "refill"
		- Accept the No of the item the user wants to remove until she enters 0, if entered 0, the program must exit and move on
		- Make sure to show the result after removing something
		- Let this method also refill the amount of the items because it is the same for accepting the input
			- It will behave differently depending on whether the user is removing or refilling something
			- If refilling, make sure there are sufficient funds in the shopper's card to grocery shop
			- Print out an error message if there is not enough fund
	- Then, make a "checkAllergy()" method which uses "remove()" in order to remove some items
		- Show the current food items in each category to the user first, then ask if she wants to remove something from the above list
		- If yes, set "action = remove" and call "remove()"
	- Make a "refill()" method which uses "remove()" in order to refill the items
		- Ask the user for which food category she is shopping
		- If a valid input is entered, set "action = refill" and call "remove()"
		- Make sure to show the prices of each item to the user first, and the total cost of shopping and the updated amount in the shopper's card
	- Then, create a method to randomly choose items from the lists "chooseRandom()" which will return the total calories per person
		- For the meat and veggies, also choose the cooking methods randomly
		- Increase the calories of meat and veggies according to their chosen cooking method
		- Then, add up all the calories of meat, veggie, fruit, drinks, and snack
		- Print out the suggest meal combination followed by the total calories
		- Subtract the amount of each food item in that meal combination
		- If they are out of stock, remind the user to go grocery shopping asap
	- Make a "prepare()" method to put all the methods together 
		- If the user chooses to prepare food, ask for how many people she is preparing, and keep that in a variable "servingSize"
		- Then, use "checkAllergy()" for each food category to let the user remove any allergic items
		- After that, ask the lower limit and upper limit for the total calories per meal per person
		- Then, call "chooseRandom()" to randomly pair the food items and print out only the ones which are within the caloreis range
	- Make a "weekOptions()" method to suggest the meal combinations for the whole week without affecting the amount of each item like "chooseRandom()"
		- Everything will be similar to "chooseRandom()" expect that this method does not subtract the amount from the lists
	- Finally, make a "welcome()" method as the driver method of this class
		- Greet the user and show the available options and ask her what she wants to do. An example would be:
			- "1) Preparing food	2) Refilling the items	3) View the Pantry	4) Adding fund to the shopper's card	5) Add new items	6) Get customized meal combinations for the week	7) Track my calories input	8) Send me an email for the week's meal options"
			- User switch case for all the above options
			- If it is 1) Preparing food, simply call "prepare()" method
			- If it is 2) Refilling the items, simply call "refill()" method
			- If it is 3) View the pantry, call the methods from AllFood class to show the whole lists of each food category
			- If it is 4) Adding fund, show the current amount first, and then ask how much she wants to add, and simply add that amount to the original amount, and show the updated amount
			- If it is 5) Add new items, simply call the "addFood()" from allFood class
			- If it is 6) Get customized ideas for the week, simply call the "weekOptions()" 7 times
			- If it is 7) Tracking the calories input of the week, first check the current calories 
				- if it is below 0 or above 8000, print an error message saying that the data is too little or too much
				- otherwise, if it is below 3500, print out a statment that she is consuming too little calories for a standard healthy body
				- if it is below 6850, print out a statement that she is on the right track
				- if it is above 6850, print out a statement that she is consuming way too much calories
			- If it is 8) Sending an eamil for the week's meal options,
				- Properly set the sender's email and recipient's email
				- Use the localhost as the server whose the IPv4 address is "127.0.0.1"
				- Properly set the mail server with its properties by using the Session object, and use one time app password for Gmail for network connection authentication
				- Get the MimeMessage object to write the actual email with subject and body
				- User javax.mail.Transport to actually send the composed email
				- After sending it, print out a message like "Successfuly sent!"

User class (inherited from Person)
- Goal: To be the child of Person class and be the actual user
- Input: Nothing from the console
- Output: Vary depending on the user's input
- Steps:
	- set the ID of the user as 123 in the constructor
	- make a method to serialize the User object into Data.txt: named "storePerson()" 
	- make a method to run the program which puts "welcome()" method from Person class and "storePerson()" together: named "testing()"

Welcome class (Main class of this program)
- Goals: To put everything together and run as the driver 
- Input: The user ID
- Output: The whole program
- Steps:
	- make a method to deserialize or load the User object: named "loadPerson()"
		- If able to load, call the "testing()" method from User class
	- make a method to verify the user's input ID is the same as 123
		- If so, call "loadPerson()"
		- If not, print out an error message

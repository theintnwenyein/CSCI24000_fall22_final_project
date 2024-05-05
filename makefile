Food.class: Food.java
	javac Food.java

Meat.class: Meat.java Food.class
	javac Meat.java

Veggies.class: Veggies.java Food.class
	javac Veggies.java

Fruits.class: Fruits.java Food.class
	javac Fruits.java

Snacks.class: Snacks.java Food.class
	javac Snacks.java

Drinks.class: Drinks.java Food.class
	javac Drinks.java

AllFood.class: AllFood.java Meat.class Veggies.class Fruits.class Drinks.class Snacks.class
	javac AllFood.java

Welcome.class: Welcome.java User.class AllFood.class
	javac -cp "./javax.mail.jar:activation.jar:." Welcome.java

Person.class: Person.java AllFood.class
	javac -cp "./javax.mail.jar:activation.jar:." Person.java

User.class: User.java Person.class
	javac User.java

run: Welcome.class
	java -cp "./javax.mail.jar:activation.jar:." Welcome

clean:
	rm *.class

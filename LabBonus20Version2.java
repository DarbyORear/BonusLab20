package labBonus20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LabBonus20Version2 {
			
			String universalVariable = "Hello World!";

			public static void main(String[] args) {
				
				//key is item as a String
				//value is price as a Double
				
				HashMap<String, Double> inventory = new HashMap<String, Double>();		
				//create a shoppingCart ArrayList
				ArrayList<String> shoppingCart = new ArrayList<String>();
				Scanner scan = new Scanner(System.in);
				String cont;
				
				
				//fills the inventory
				inventory = fillInventory(inventory);
				
				//displays the inventory
				displayInventory(inventory);
				
				
				do {
					//scanner, inventory, prompt, 
					//could return a String, then add to shoppingCart
					//"Enter item name: "
					String prompt = "What would you like to order? ";
					String newItem = enterItem(scan, inventory, prompt);
					//add that item to the shoppingCart
					
		//FIX ME: I'M TRYING TO ADD IT SO THAT INVALID ITEMS DON'T DISPLAY:	
//					if(newItem == //array.contains(index of))
//					shoppingCart.add(newItem);

					//"Add another item? (y/n)"
					System.out.println("Add another item? (y/n) ");
					cont = scan.nextLine();
					cont = cont.toLowerCase();
					
					//if yes, then repeat to the top
				} while (cont.startsWith("y"));
				
					//if no, display:
				
				System.out.println("Here are the items in your cart: "); //DARBY MODIFIED LINE
				System.out.println(shoppingCart); //NOTE: THIS SHOULD ALSO DISPLAY PRICE OF EACH ITEM
				
					
					//average(); this displays average price of all items
				average(shoppingCart, inventory);
				//DO I HAVE A VARIABLE FOR JUST THE PRICE
				
					//highest(); this displays highest price item
				highest(shoppingCart, inventory);
				
				
					//lowest(); this display lowest price item
				lowest(shoppingCart, inventory);
			}


			private static void lowest(ArrayList<String> shoppingCart, HashMap<String, Double> inventory) {
				// TODO Auto-generated method stub
				
			}


			private static void highest(ArrayList<String> shoppingCart, HashMap<String, Double> inventory) {
				double highest = 0.0;
				
				for ( String fruit : shoppingCart) {
					
					if (highest < inventory.get(fruit)   ) {
						highest = inventory.get(fruit);
					}
					System.out.println(highest);   //DARBY ADDED LINE
					
				}
				
			}


			private static void average(ArrayList<String> shoppingCart, HashMap<String, Double> inventory) {
				double sum = 0;//the total price, added together
				int count = 0; //the number of individual items
				for ( String fruit : shoppingCart ) {
					
					//sum get from the inventory,
					//the "value" of the "key" in this case fruit!
					sum += inventory.get(fruit);
					count++;
					
				}
				
				System.out.println("Average price: " + sum/count);
			}


			private static String enterItem(Scanner scan, HashMap<String, Double> inventory, String prompt) {
				String userInput = "";
//				boolean validInput;  //DARBY ADDED LINE
				
				System.out.println(prompt);
				
				userInput = scan.nextLine();
				
				//if userInput is in our inventory, then return userInput
				if (inventory.containsKey(userInput) == true) {
//					validInput = true; //DARBY ADDED LINE
					System.out.println("Confirmation! " + userInput + " added to cart!");					
					
					//else, repeat the method
				} else {
//					validInput = false;  //DARBY ADDED LINE
					System.out.println("Sorry, we cannot help you find your " + userInput + "! :(");
					enterItem(scan, inventory, prompt);
				}
				
//				if(validInput == true) { //DARBY ADDED LINE
				return userInput; 
				}
					//NOTE: RIGHT NOW, IT RETURNS THE ARRAY OF ITEMS INCLUDING INVALID ITEMS. ANYTHING THE USERINPUT




			private static HashMap<String, Double> fillInventory(
										HashMap<String, Double> tempinventory) {
				tempinventory.put("grapefruit", 1.99);		
				tempinventory.put("apple", 0.99);
				tempinventory.put("banana", 0.59);
				tempinventory.put("cauliflower", 1.59);
				tempinventory.put("dragonfruit", 2.19);
				tempinventory.put("figs", 2.09);
				
				return tempinventory;		
			}

			private static void displayInventory(HashMap<String, Double> inventory) {
				//we want to use a for loop!
				String format = "%s\t\t%s";
				String format2 = "%-12s : %s%n";
				System.out.printf(format2, "Item","Price");
				System.out.println();
				System.out.println("=======================");
				
				//loop through our inventory, by key (which is the
				// list of fruits)
				for (String fruit : inventory.keySet()) {
					
					//this line print out for each individual fruit
					System.out.printf(format2, fruit, inventory.get(fruit));
					//System.out.println();
					
				}
				
				
				
				
				
			}

		}



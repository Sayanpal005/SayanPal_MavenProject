package newyeargift;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class GiftAnalysis {
	
	static Scanner input = new Scanner(System.in);
	
	static ArrayList<Chocolate> chocolates = new ArrayList<Chocolate>();
	static ArrayList<Sweet> sweets = new ArrayList<Sweet>();
	
	static HashMap<String, Integer> nameToPrice = new HashMap<String, Integer>();
	static HashMap<String, Integer> nameToWeight = new HashMap<String, Integer>();
	
	public static void main(String[] args) {
		inputChocolates();
		inputSweets();
		calRange();
	}
	
	public static void inputChocolates() {
		System.out.print("Enter number of chocloates: ");
		int chocoCount = input.nextInt();
		for(int i = 0; i < chocoCount; i++) {
			System.out.print("Enter your choice: 1. Candy 2. Kitkat: ");
			int chocoType = input.nextInt();
			System.out.print("Enter the name of chocloate: ");
			String name = input.next();
			System.out.print("Enter the price of chocolate: ");
			int price = input.nextInt();
			System.out.print("Enter the weight of chocolate: ");
			int weight = input.nextInt();
			Chocolate choco;
			if(chocoType == 1) choco = new Candy(price, weight);
			else choco = new Kitkat(price, weight);
			chocolates.add(choco);
			
			if(nameToPrice.containsKey(name)) {
				nameToPrice.put(name, (int)nameToPrice.get(name) + price);
			} else {
				nameToPrice.put(name, price);
			}
			
			if(nameToWeight.containsKey(name)) {
				nameToWeight.put(name, (int)nameToWeight.get(name) + weight);
			} else {
				nameToWeight.put(name, weight);
			}
		}
	}
	
	public static void inputSweets() {
		System.out.print("Enter the number of sweets: ");
		int sweetCount = input.nextInt();
		for(int i = 0; i < sweetCount; i++) {
			System.out.print("Enter your choice: 1. GulabJamun 2. Barfi ");
			int sweetType = input.nextInt();
			System.out.print("Enter the price of sweet: ");
			int price = input.nextInt();
			System.out.print("Enter the weight of sweet: ");
			int weight = input.nextInt();
			Sweet swt;
			String name;
			if(sweetType == 1) {
				swt = new GulabJamun(price, weight);
				name = "GulabJamun";
			} else {
				swt = new Barfi(price, weight);
				name = "Barfi";
			}
			sweets.add(swt);
			
			if(nameToPrice.containsKey(name)) {
				nameToPrice.put(name, (int)nameToPrice.get(name) + price);
			} else {
				nameToPrice.put(name, price);
			}
			
			if(nameToWeight.containsKey(name)) {
				nameToWeight.put(name, (int)nameToWeight.get(name) + weight);
			} else {
				nameToWeight.put(name, weight);
			}
		}
	}
	
	public static int calcTotalWeight() {
		int totalWeight = 0;
		for(Sweet swt : sweets) totalWeight += swt.getWeight();
		for(Chocolate choco : chocolates) totalWeight += choco.getWeight();
		return totalWeight;
	}
	
	public static int calcTotalPrice() {
		int totalPrice = 0;
		for(Sweet swt : sweets) totalPrice += swt.getPrice();
		for(Chocolate choco : chocolates) totalPrice += choco.getPrice();
		return totalPrice;
	}
	
	public static void calRange() {
		System.out.print("Choose the way to calculte range 1. Price 2. Weight: ");
		int type = input.nextInt();
		System.out.print("Enter the lower limit: ");
		int lowerLimit = input.nextInt();
		System.out.print("Enter the higher limit: ");
		int higherLimit = input.nextInt();
		if(type == 1) {
			for(Map.Entry<String, Integer> gift : nameToPrice.entrySet()) {
				int price = gift.getValue();
				if(price >= lowerLimit && price <= higherLimit) {
					System.out.println(gift.getKey());
				}
			}
		} else {
			for(Map.Entry<String, Integer> gift : nameToWeight.entrySet()) {
				int price = gift.getValue();
				if(price >= lowerLimit && price <= higherLimit) {
					System.out.println(gift.getKey());
				}
			}
		}
	}
}
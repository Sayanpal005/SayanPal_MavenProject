package newyeargift;
public class Kitkat extends Chocolate {
	Kitkat(int price, int weight) {
		super(price, weight);
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public int getPrice() {
		return this.price;
	}
}
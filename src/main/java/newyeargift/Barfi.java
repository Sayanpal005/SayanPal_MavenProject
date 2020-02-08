package newyeargift;
public class Barfi extends Sweet {
	Barfi(int price, int weight) {
		super(price, weight);
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public int getPrice() {
		return this.price;
	}
}
package exercise_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlyWeightPattern {

	public static void main(String[] args) {
		
		long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();

		CakeBox milkCake = new CakeBox("milk", 500000, 15);
		CakeBox chocoCake = new CakeBox("chocolate", 50000, 15);
//		CakeBox fruitCake = new CakeBox("fruit", 500000, 15);
//		CakeBox butterCake = new CakeBox("butter", 500000, 15);
		
		long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();

		long actualMemUsed=afterUsedMem-beforeUsedMem;
		System.out.println(actualMemUsed % 1000 + "kb");
		
		System.out.println(milkCake);
		System.out.println(chocoCake);
		
	}

}


class CakeBox{
	int count;
	Cake cakeType;
	int price;
	List<Cake> cakes;
	
	public CakeBox(String flavour, int count, int price){
		cakes = new ArrayList<>();
		IntStream.range(0, count).forEach((int index) -> {
			Cake newCake = CakeFactory.getCake(flavour, price);
			cakes.add(newCake);
		});
		this.count = count;
		this.price = price;
	}
	
	void showBox() {
		Stream<Cake> stream = cakes.stream();
		stream.forEach(System.out::println);
	}
}


interface Cake {
    public String getFlavour();
    public void setPrice(int price);
}


enum CakeFlavours{
	Milk,
	Butter,
	Chocolate,
	Fruits
}

class MilkCake implements Cake{
	private String flavour;
	private int price;
	private List<String> steps;
	
	MilkCake(int price){
		flavour = "Milk";
		this.price = price;
		steps = new ArrayList<>();
		IntStream.range(0, 1000).forEach((int index) -> {
			steps.add("Mix milk and flour thoroughly!");
		});
		
	}

	@Override
	public String getFlavour() {
		return flavour;
	}

	@Override
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return flavour + " flavoured cake with MRP Rs. " + price;
	}

	
}

class ButterCake implements Cake{

	private String flavour;
	private int price;
	private List<String> steps;
	
	ButterCake(int price){
		flavour = "Milk";
		this.price = price;
		steps = new ArrayList<>();
		IntStream.range(0, 1000).forEach((int index) -> {
			steps.add("Mix milk and flour thoroughly!");
		});
	}

	@Override
	public String getFlavour() {
		return flavour;
	}

	@Override
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return flavour + " flavoured cake with MRP Rs. " + price;
	}
	
}

class ChocolateCake implements Cake{

	private String flavour;
	private int price;
	private List<String> steps;
	
	ChocolateCake(int price){
		flavour = "Milk";
		this.price = price;
		steps = new ArrayList<>();
		IntStream.range(0, 1000).forEach((int index) -> {
			steps.add("Mix milk and flour thoroughly!");
		});
	}

	@Override
	public String getFlavour() {
		return flavour;
	}

	@Override
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return flavour + " flavoured cake with MRP Rs. " + price;
	}

}

class FruitCake implements Cake{

	private String flavour;
	private int price;
	private List<String> steps;
	
	FruitCake(int price){
		flavour = "Milk";
		this.price = price;
		
		steps = new ArrayList<>();
		IntStream.range(0, 1000).forEach((int index) -> {
			steps.add("Mix milk and flour thoroughly!");
		});
	}

	@Override
	public String getFlavour() {
		return flavour;
	}

	@Override
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return flavour + " flavoured cake with MRP Rs. " + price;
	}
	
}


class CakeFactory{
	private static Map<String, Cake> flyweight = new HashMap<>();
	
	public static Cake getCake(String flavour, int price) {
		flavour = flavour.toLowerCase();
		String key = flavour + "-" + price;
		if(flyweight.containsKey(key))
			return flyweight.get(key);
		
		Cake newCake;
		switch(flavour) {
			case "milk":
				newCake = new MilkCake(price);
				break;
				
			case "butter":
				newCake = new ButterCake(price);
				break;
			
			case "chocolate":
				newCake = new ChocolateCake(price);
				break;
			
			case "fruit":
				newCake = new FruitCake(price);
				break;
			
			default:
				throw new IllegalArgumentException("Invalid cake flavour");				
		}
		flyweight.put(key, newCake);
		return newCake;
	}
}







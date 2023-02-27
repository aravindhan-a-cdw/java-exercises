package exercise_3;

import exercise_1.MyLinkedList;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class D5_03_Producer_Consumer {

	public static void main(String[] args) {
		Inventory inv = new Inventory();
		Producer prod1 = new Producer(inv);
		Consumer cons1 = new Consumer(inv);
				
		ExecutorService exe = Executors.newFixedThreadPool(2);
		
		exe.execute(() -> {
			for(int index = 0; index < 10; ++index) {
				try {
					prod1.create();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		exe.execute(() -> {
			for(int index = 0; index < 10; ++index) {
				try {
					cons1.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		exe.shutdown();
	}

}

class Producer{
	private Inventory inv;
	
	public Producer(Inventory inv) {
		this.inv = inv;
	}
	
	void create() throws InterruptedException {
		inv.addProduct(new Product("Cycle"));		
	}
}

class Consumer{
	private Inventory inv;
	
	public Consumer(Inventory inv) {
		this.inv = inv;
	}
	
	void consume() throws InterruptedException {
		inv.removeProduct();
	}
}


class Inventory{
	private MyLinkedList<Product> products;
	
	public Inventory() {
		products = new MyLinkedList<>();
	}
	
	synchronized void addProduct(Product newProduct) {
		if(getCount() == 5)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		products.insert(newProduct);
		System.out.println("New Product added");		
		notify();
	}
	
	synchronized void removeProduct() {
		if(getCount() == 1)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		products.remove();
		System.out.println("Product sold");	
		notify();
	}
	
	int getCount() {
		return products.size();
	}
	
}


class Product{
	String name;
	
	public Product(String name){
		this.name = name;
	}
}


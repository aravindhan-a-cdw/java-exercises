//package exercise_3;
//
//public class D5_03_Producer_Consumer_LL_Fail {
//
//	public static void main(String[] args) {
//		Inventory inv = new Inventory();
//		
//		inv.printProduct();
//		for(int index = 0; index < 10; index++) {
//			Product pd = new Product("Prod" + index);
//			inv.addProduct(pd);
////			System.out.println(inv.getProductCount());
//		}
//		inv.printProduct();
//	}
//
//}
//
//
//class Inventory{
//	private Node nodeHead = null;
//	private int productCount = 0;
//	
//	void addProduct(Product newProd) {
//		productCount++;
//		Node node = new Node();
//		if(nodeHead == null) {
//			node.prev = null;
//			node.product = newProd;
//			node.next = null;
//			nodeHead = node;
//			return;
//		}else {			
//			node.prev = nodeHead;
//			node.next = null;
//			node.product = newProd;
//			nodeHead.next = node;
//			System.out.println(nodeHead.prev.product.name);
//		}
//		
//	}
//	
//	void printProduct() {
//		if (nodeHead == null) {
//			System.out.println("Add some product to print");
//		}
//		Node currNode = nodeHead;
////		int count = productCount;
//		while(currNode != null) {
//			System.out.println(currNode.product.name);
//			currNode = currNode.prev;
//		}
//	}
//	
//	int getProductCount() {
//		return productCount;
//	}
//	
//}
//
//class Node{
//	Node prev;
//	Product product;
//	Node next;
//}
//
//class Product{
//	String name;
//	
//	public Product(String name){
//		this.name = name;
//	}
//}
//

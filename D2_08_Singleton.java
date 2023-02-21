package exercise_1;

public class D2_08_Singleton {

	public static void main(String[] args) {
		System.out.println(Singleton.getInstance().getValue());
	}

}

class Singleton{
	private static Singleton instance;
	private int x;
	
	private Singleton(int x) {
		this.x = x;
	}
	
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton(10);
		}
		return instance;
	}
	
	public int getValue() {
		return this.x;
	}
}

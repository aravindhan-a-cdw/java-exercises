package exercise_1;

public class D3_03_Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

abstract class Stack{
	
	abstract public int pop();
	abstract public void push(int element);
	
}


class StaticStack extends Stack{
	
	private int size;
	private int currentIndex;
	private int[] stackArray;
	
	public StaticStack(int size) {
		this.size = size;
		this.currentIndex = 0;
		this.stackArray = new int[size];
	}

	@Override
	public int pop() {
		this.currentIndex--;
		return this.stackArray[this.currentIndex + 1];
	}

	@Override
	public void push(int element) {
		stackArray[this.currentIndex] = element;
		this.currentIndex++;
	}
	
}

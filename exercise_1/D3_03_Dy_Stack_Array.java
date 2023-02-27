package exercise_1;

public class D3_03_Dy_Stack_Array {

	public static void main(String[] args) throws Exception {
		Stack stack = new FixedStack(10);
		
		for(int index = 0; index < 10; index++) {
			stack.push(index);
		}
		
		
		for(int index = 0; index < 10; index++) {
//			System.out.println(stack.pop());
		}
//		stack.pop();
		
		stack = new DynamicStack(10);
		
		for(int index = 0; index < 100; index++) {
			stack.push(index);
		}
		
		stack.push(10);
		stack.push(11);
		
		
		for(int index = 0; index < 10; index++) {
			System.out.println(stack.pop());
		}
		stack.pop();
		stack.pop();
	}

}

abstract class Stack{
	
	abstract public int pop() throws StackUnderFlowException;
	abstract public void push(int element) throws StackOverFlowException;
	
}


class FixedStack extends Stack{
	
	private int size;
	private int currentIndex;
	private int[] stackArray;
	
	public FixedStack(int size) {
		this.size = size;
		this.currentIndex = -1;
		this.stackArray = new int[size];
	}

	@Override
	public int pop() throws StackUnderFlowException {
		if(this.currentIndex == -1) throw new StackUnderFlowException();
		this.currentIndex--;
		return this.stackArray[this.currentIndex + 1];
	}

	@Override
	public void push(int element) throws StackOverFlowException {
		if(this.currentIndex == this.size - 1) throw new StackOverFlowException();
		this.currentIndex++;
		stackArray[this.currentIndex] = element;
	}
	
}


class DynamicStack extends Stack{
	
	private int size;
	private int currentIndex;
	private int[] stackArray;
	
	public DynamicStack(int size) {
		this.size = size;
		this.currentIndex = -1;
		this.stackArray = new int[size];
	}

	@Override
	public int pop() throws StackUnderFlowException {
		if(this.currentIndex < 0) throw new StackUnderFlowException();
		this.currentIndex--;
		return this.stackArray[this.currentIndex + 1];
	}

	@Override
	public void push(int element) throws StackOverFlowException {
		if(this.currentIndex == this.size - 1) {
//			throw new StackOverFlowException();
			this.extend();
		}
		this.currentIndex++;
		stackArray[this.currentIndex] = element;
	}
	
	private void extend() {
		this.size *= 2;
		int[] copy = this.stackArray;
		this.stackArray = new int[this.size];
		for(int index = 0; index < this.size / 2; ++index) {
			this.stackArray[index] = copy[index];
		}
	}
	
}



class StackUnderFlowException extends Exception{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "The stack is underflow means no element to pop!";
	}
	
	
}

class StackOverFlowException extends Exception{
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "The stack is overflow means the size of stack is full!";
	}
}

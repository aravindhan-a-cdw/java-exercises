package exercise_1;

public class D3_03_Dy_Stack_LL {

	public static void main(String[] args) throws Exception {
		
		
		DynamicStackLL stack = new DynamicStackLL();
		
		for(int index = 0; index < 100; index++) {
			stack.push(index);
		}
		
		stack.push(10);
		stack.push(11);
		
		
		for(int index = 0; index < 100; index++) {
			System.out.println(stack.pop());
		}
		stack.pop();
		stack.pop();
	}

}

class DynamicStackLL extends Stack{
	
	private MyLinkedList<Integer> dll;
	
	public DynamicStackLL() {
		dll = new MyLinkedList<>();
	}

	@Override
	public int pop() throws StackUnderFlowException {
		if(dll.size() == 0) throw new StackUnderFlowException();
		int toRemove = dll.peek();
		dll.remove();
		return toRemove;
	}

	@Override
	public void push(int element) {
		dll.insert(element);
	}
	
}

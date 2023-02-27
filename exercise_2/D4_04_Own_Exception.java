package exercise_2;

public class D4_04_Own_Exception {

	public static void main(String[] args) {
		try {
			throw new OwnException();			
		}catch(OwnException excep) {
			excep.printStackTrace();
		}
	}

}

class OwnException extends Exception{
	@Override
	public String toString() {
		return "This is a exception created by me!";
	}
}

package exercise_2;

public class D4_05_Throw_Without_Catch {

	public static void main(String[] args) throws OwnException {
		throwException();
	}
	
	public static void throwException() throws OwnException {
		throw new OwnException();
		// Exception cannot be throwed without try catch or throws
	}

}

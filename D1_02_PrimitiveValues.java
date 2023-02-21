package exercise_1;

public class D1_02_PrimitiveValues {

		static byte bytePrimitive;	// 8 bit signed with range -128 to 127
		
		// Numbers 
		static short shortPrimitive;	// 16 bit signed with range -32768 to 32767
		static int intPrimitive;	// 32 bit signed with range -2^31 to 2^31 - 1
		static long longPrimitive;	// 64 bit signed with range -2^63 to 2^63 - 1
		
		// decimal
		static float floatPrimitive;	// 32 bit 
		static double doublePrimitive;	// 64 bit
		
		static boolean boolPrimitive;	// true or false
		static char charPrimitive;	// 16 bit unsigned with range 0 to 2^16
		
	public static void main(String[] args) {
		System.out.println("Default values are: ");
		System.out.print("Byte: ");
		System.out.println(bytePrimitive);
		System.out.print("Short: ");
		System.out.println(shortPrimitive);
		System.out.print("Int: ");
		System.out.println(intPrimitive);
		System.out.print("Long: ");
		System.out.println(longPrimitive);
		System.out.print("Float: ");
		System.out.println(floatPrimitive);
		System.out.print("Double: ");
		System.out.println(doublePrimitive);
		System.out.print("Bool: ");
		System.out.println(boolPrimitive);
		System.out.print("Char: ");
		System.out.println(charPrimitive);
	}

}

/*	
 * Questions
 * 1. Why does the JLS chose to initialize a class member but not local member?
 * 2. How is class member stored differently than a local member?
 * 3. 


*/

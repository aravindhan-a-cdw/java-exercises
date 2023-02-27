package exercise_1;

public class PrimitiveValuesReassign {

		
	public static void main(String[] args) {
		byte bytePrimitive = 120;	// 8 bit signed with range -128 to 127
		// Numbers 
		short shortPrimitive = 1112;	// 16 bit signed with range -32768 to 32767
		int intPrimitive = 111112;	// 32 bit signed with range -2^31 to 2^31 - 1
		long d1 = 1111111199999999999l;
		long d2 = 4782874812344545341l;
		long longPrimitive =  d1*d2 ;	// 64 bit signed with range -2^63 to 2^63 - 1
		// decimal
		float floatPrimitive = 1.00002f;	// 32 bit 
		double doublePrimitive = 1111.000000005;	// 64 bit
		
		boolean boolPrimitive = true;	// true or false
		char charPrimitive = 's';	// 16 bit unsigned with range 0 to 2^16
		
		System.out.println("Byte Initialization are: ");
		
		System.out.println("Byte Initialized with char 'a': ");
		bytePrimitive = 'a';	// char values can be assigned to byte
		System.out.println(bytePrimitive);
		
		System.out.println("Byte Initialized with integer 128 with explicit type cast: ");
		bytePrimitive = (byte)128;	// Till 127 it explicitly type casts to byte
		System.out.println(bytePrimitive);
		
		System.out.println("Byte Initialized with decimal with explicit type cast: ");
		bytePrimitive = (byte)5.5;	// Till 127 it explicitly type casts to byte
		System.out.println(bytePrimitive);
		
		System.out.println("\nBoolean cannot be type casted to byte\n");
//		bytePrimitive = (byte) true;
//		System.out.println(bytePrimitive);
		
		
		System.out.println("Short Initialization are: ");
		
		System.out.println("Short Initialized with char 'a': ");
		shortPrimitive = 'a';	// char values can be assigned to byte
		System.out.println(shortPrimitive);
		
		System.out.println("Short Initialized with integer 128 with explicit type cast: ");
		shortPrimitive = 12344;	// Till 127 it explicitly type casts to byte
		System.out.println(shortPrimitive);
		
		System.out.println("Short Initialized with decimal with explicit type cast: ");
		shortPrimitive = (byte)5.5;	// Till 127 it explicitly type casts to byte
		System.out.println(shortPrimitive);
		
		System.out.println("\nBoolean cannot be type casted to short\n");
//		shortPrimitive = (short) true;
//		System.out.println(shortPrimitive);
		
		
		
		
		
		
//		System.out.println(((Object)128).getClass().getSimpleName());
//		System.out.println(((Object)bytePrimitive).getClass().getSimpleName());
		
		bytePrimitive = (byte) shortPrimitive; // byte is of size 8 bits and hence no
		
		System.out.print("Byte: ");
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
 * Note
 * 1. By default Java chooses to store decimal numbers as double to increase precision.
 * 2. Java stores integer values in 32 bits by default for optimization
 * 3. boolean cannot be type casted to other type
 * 
 * Questions
 * 1. If I want to initialize a long variable with 11111111 * 4782874812345612l value which is out of 
 * 	  32 bit integer range what should be done?
 * 2. Autoboxing


*/

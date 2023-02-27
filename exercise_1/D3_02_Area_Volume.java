package exercise_1;

public class D3_02_Area_Volume {

	public static void main(String[] args) {
		Circle circle = new Circle(10);
		System.out.println(circle.Area());
		
		Square square = new Square(100);
		System.out.println(square.Area());
		
		Triangle triangle = new Triangle(5, 10, 15);
		System.out.println(triangle.Area());
		
		Sphere sphere = new Sphere(20);
		System.out.println(sphere.Area());
		System.out.println(sphere.Volume());
		
		Cuboid cuboid = new Cuboid(10);
		System.out.println(cuboid.Area());
		System.out.println(cuboid.Volume());
	}
	

}

interface calcArea {
	public double Area();
}

interface calcVolume{
	public double Volume();
}

class Circle implements calcArea{
	private int side;
	
	public Circle(int side) {
		this.side = side;
	}
	
	public double Area() {
		return 3.14 * this.side * this.side;
	}
}

class Square implements calcArea{
	private int side;
	
	public Square(int side) {
		this.side = side;
	}
	
	public double Area() {
		return this.side * this.side;
	}
}

class Triangle implements calcArea{
	private int side1;
	private int side2;
	private int side3;
	
	public Triangle(int side1, int side2, int side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	public double Area() {
		return (this.side1 + this.side2 + this.side3) / 3;
	}
}

class Sphere implements calcArea, calcVolume{
	int side;
	
	public Sphere(int side) {
		this.side = side;
	}
	
	public double Area() {
		return 3.14 * this.side * this.side;
	}
	
	public double Volume() {
		return 4/3 * 3.14 * this.side * this.side * this.side;
	}
}

class Cuboid implements calcArea, calcVolume{
	int side;
	
	public Cuboid(int side) {
		this.side = side;
	}
	
	public double Area() {
		return this.side * this.side;
	}
	
	public double Volume() {
		return this.side * this.side * this.side;
	}
	
}



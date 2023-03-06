package exercise_4.behavioural_pattern;

public class StrategyPattern {

	public static void main(String[] args) {
		Brush brush1 = new Brush();
		Paint paint = new RedPaint();
		brush1.doPaint(paint);
		paint = new BluePaint();
		brush1.doPaint(paint);
	}

}

class Brush{
	void doPaint(Paint p) {
		p.apply();
	}
}

abstract class Paint{
	abstract void apply();
}

class RedPaint extends Paint{
	void apply() {
		System.out.println("Red color paint");
	}
}

class BluePaint extends Paint{
	void apply() {
		System.out.println("Blue color paint");
	}
}




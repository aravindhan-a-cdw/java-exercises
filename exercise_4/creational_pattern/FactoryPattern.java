package exercise_4.creational_pattern;

public class FactoryPattern {

	public static void main(String[] args) {
		Printer press = new ScienceMagazinePress();
		Magazine mg1 = press.getMagazine();
		
		Person p1 = new Person();
		
		p1.read(mg1);
		
		press = new BusinessMagazinePress();
		mg1 = press.getMagazine();
		p1.read(mg1);
		
	}
}

class Person{
	public void read(Magazine mg) {
		System.out.println(mg.getContent());
	}
}


interface Printer{
	public Magazine getMagazine();
}

class ScienceMagazinePress implements Printer{
	
	ScienceMagazinePress() {}
	
	public Magazine getMagazine() {
		return new ScienceMagazine();
	}
	
}

class BusinessMagazinePress implements Printer{

	public Magazine getMagazine() {
		return new BusinessMagazine();
	}
	
}


interface Magazine{
	public String getContent();
}


class ScienceMagazine implements Magazine{

	@Override
	public String getContent() {
		return "Science, Technology and stuff";
	}
	
}


class BusinessMagazine implements Magazine{

	@Override
	public String getContent() {
		return "Business, global market and stocks";
	}
	
}

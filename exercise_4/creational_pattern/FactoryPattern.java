package exercise_4.creational_pattern;

public class FactoryPattern {

	public static void main(String[] args) {
		
		Person p1 = new Person("Student");
		Magazine mg1 = MagazineShop.buyMagazine(p1);
		p1.read(mg1);
		
		p1 = new Person("Business Man");
		mg1 = MagazineShop.buyMagazine(p1);
		p1.read(mg1);
		
	}
}

class Person{
	String type;
	
	Person(String type){
		this.type = type;
	}
	
	public void read(Magazine mg) {
		if(mg == null) System.out.println("No magazine to read");
		System.out.println(mg.getContent());
	}
	
	public String getType() {
		return type;
	}
}

class MagazineShop{
	public static Magazine buyMagazine(Person person) {
		if(person.getType() == "Student") {
			return new ScienceMagazine();
		}
		if(person.getType() == "Business Man") {
			return new BusinessMagazine();
		}
		return null;
	}
}


//interface Printer{
//	public Magazine getMagazine();
//}
//
//class ScienceMagazinePress implements Printer{
//	
//	public Magazine getMagazine() {
//		return new ScienceMagazine();
//	}
//	
//}
//
//class BusinessMagazinePress implements Printer{
//
//	public Magazine getMagazine() {
//		return new BusinessMagazine();
//	}
//	
//}


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

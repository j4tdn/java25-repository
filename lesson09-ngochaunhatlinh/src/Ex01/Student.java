package Ex01;

public class Student {
	int id;
	String name;
	char ranking;
	public Student() {
		
	}
	public Student(int id, String name, char ranking) {
		this.id = id;
		this.name = name;
		this.ranking = ranking;
	}
	
	@Override
	public String toString(){
		return id + ", " + name + ", " + ranking;
	}
	
	
}

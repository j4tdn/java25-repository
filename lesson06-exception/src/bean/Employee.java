package bean;

public class Employee {
	
	private int id;
	private String nane;
	private int age;
	
	public Employee() {
		
	}

	public Employee(int id, String nane, int age) {
		super();
		this.id = id;
		this.nane = nane;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNane() {
		return nane;
	}

	public void setNane(String nane) {
		this.nane = nane;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", nane=" + nane + ", age=" + age + "]";
	}
	

}

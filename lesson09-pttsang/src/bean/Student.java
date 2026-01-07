package bean;

public class Student {
	private int id;
	private String name;
	private char xeploai;
	
	public Student() {
		
	}
	public Student(int id, String name, char xeploai) {
		this.id = id;
		this.name = name;
		this.xeploai = xeploai;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getXeploai() {
		return xeploai;
	}
	public void setXeploai(char xeploai) {
		this.xeploai = xeploai;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", xeploai=" + xeploai + "]";
	}
	
	
	


}

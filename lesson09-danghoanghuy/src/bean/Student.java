package bean;

public class Student {

	/*
	 Mã sinh viên, Họ tên, Xếp loại
Xếp loại học lực được phân loại: A, B, C, D, E, F
	 */
	
	private int id;
	private String name;
	private String scope; 
	
	public Student() {
	}

	public Student(int id, String name, String scope) {
		this.id = id;
		this.name = name;
		this.scope = scope;
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

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", scope=" + scope + "]";
	}
	
}

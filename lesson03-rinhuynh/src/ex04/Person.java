package ex04;

import java.util.List;


public class Person {
	private String name;
	private String gender;
	private String address;
	private List<String> hobbies;
	private int birthOfYear;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, String gender, String address, List<String> hobbies, int birthOfYear) {
		super();
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.hobbies = hobbies;
		this.birthOfYear = birthOfYear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public int getBirthOfYear() {
		return birthOfYear;
	}

	public void setBirthOfYear(int birthOfYear) {
		this.birthOfYear = birthOfYear;
	}
	
	public int getAge() {
		return 2025 - birthOfYear;
	}

	@Override
	public String toString() {
		return "Thông tin [Tên=" + name + ", giới tính=" + gender + ", địa chỉ=" + address+ ", Năm sinh=" + birthOfYear + ", sở thích=" + hobbies
				 + "]";
	}

	
	
	

}

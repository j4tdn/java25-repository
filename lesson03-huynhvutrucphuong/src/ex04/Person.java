package ex04;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;


public class Person {
	private String name;
    private String gender;
    private String address;
    private List<String> hobbies;
    private LocalDate birthDate;
    public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String name, String gender, String address, List<String> hobbies, LocalDate birthDate) {
		super();
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.hobbies = hobbies;
		this.birthDate = birthDate;
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
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	 @Override
	    public String toString() {
	        return "Tên: " + name + ", Giới tính: " + gender + ", Địa chỉ: " + address + ", Ngày sinh: " + birthDate;
	    }
	}


package bean;

import java.time.LocalDate;
import java.util.Arrays;

public class Person {
	private String name;
	private String gender;
	private String address;
	private String[] hobbies;
	private LocalDate birthday;

	public Person() {
	}

	public Person(String name, String gender, String address, String[] hobbies, LocalDate birthday) {
		super();
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.hobbies = hobbies;
		this.birthday = birthday;
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

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "person [name=" + name + ", gender=" + gender + ", address=" + address + ", hobbies="
				+ Arrays.toString(hobbies) + ", birthday=" + birthday + "]";
	}

}

package Bai4;

import java.util.List;
import java.util.stream.Collectors;

public class Person {
	private String name;
	private String gender;
	private String address;
	private List<String> hobbies;
	private int birthYear;

	public Person(String name, String gender, String address, List<String> hobbies, int birthYear) {
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.hobbies = hobbies;
		this.birthYear = birthYear;
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

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", address=" + address + ", hobbies=" + hobbies
				+ ", birthYear=" + birthYear + "]";
	}

	private String normalizeHobby(String hobby) {
		if (hobby == null)
			return "";

		String normalized = hobby.toLowerCase().replaceAll("\\s+", "");

		if (normalized.contains("muahat")) {
			normalized = "muahat";
		}

		return normalized;
	}

	public List<String> getNormalizedHobbies() {
		return hobbies.stream().map(this::normalizeHobby).collect(Collectors.toList());
	}

}
package bean;

import java.time.LocalDate;
import java.util.Arrays;

public class Player {
	
	private String name;
	private boolean gender;
	private String address;
	private String[] hobbies;
	private LocalDate dateOfBirth;
	
public Player() {
		
	}

	public Player(String name, boolean gender, String address, String[] hobbies, LocalDate dateOfBirth) {
		super();
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.hobbies = hobbies;
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", gender=" + gender + ", address=" + address + ", hobbies="
				+ Arrays.toString(hobbies) + ", dateOfBirth=" + dateOfBirth + "]";
	}

}

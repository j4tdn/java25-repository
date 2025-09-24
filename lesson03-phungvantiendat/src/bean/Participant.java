package bean;

import java.util.List;

public class Participant {

	private String fullName;
	private String gender;
	private String address;
	private List<String> hobbies;
	private String dateOfBirth;
	
	public Participant(String fullName, String gender, String address,List<String> hobbies, String dateOfBirth) {
		this.fullName = fullName;
		this.gender = gender;
		this.address = address;
		this.hobbies = hobbies;
		this.dateOfBirth = dateOfBirth;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Participant [fullName=" + fullName + ", gender=" + gender + ", address=" + address + ", hobbies="
				+ hobbies + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	
}

package matchmaking;

import java.time.LocalDate;
import java.util.Arrays;

public class Participants {
	private String name;
	private boolean gender;
	private String address;
	private String[] listHobby;
	private LocalDate birthDay;
	
	public Participants() {

	}

	public Participants(String name, boolean gender, String address, String[] listHobby, LocalDate birthDay) {
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.listHobby = listHobby;
		this.birthDay = birthDay;
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

	public String[] getListHobby() {
		return listHobby;
	}

	public void setListHobby(String[] listHobby) {
		this.listHobby = listHobby;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public String toString() {
		return "Ten = " + name + ", Gioi Tinh = " + gender + ", Dia Chi = " + address  + ", Ngay Sinh = " + birthDay + ", So Thich = "
				+ Arrays.toString(listHobby);
	}

	
}

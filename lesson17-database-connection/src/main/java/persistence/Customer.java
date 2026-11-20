package persistence;

import java.util.Objects;

public class Customer {

	private Long id;
	private String name;
	private String email;
	private String phone;
	private String address;
	private String password;
	private String socialMedia;
	private String token;

	public static Customer newInstance() {
		return new Customer();
	}

	public Long getId() {
		return id;
	}

	public Customer withId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Customer withName(String name) {
		this.name = name;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Customer withEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public Customer withPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public Customer withAddress(String address) {
		this.address = address;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Customer withPassword(String password) {
		this.password = password;
		return this;
	}

	public String getSocialMedia() {
		return socialMedia;
	}

	public Customer withSocialMedia(String socialMedia) {
		this.socialMedia = socialMedia;
		return this;
	}

	public String getToken() {
		return token;
	}

	public Customer withToken(String token) {
		this.token = token;
		return this;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Customer that)) {
			return false;
		}
		return Objects.equals(getId(), that.getId());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address="
				+ address + ", socialMedia=" + socialMedia + "]";
	}

}

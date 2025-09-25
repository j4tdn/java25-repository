package Bai2;


public class Xe {
	private String Customer;
	private String type;
	private int xilanh;
	private double saleprice;
	
	public Xe() {
	}

	public Xe(String customer, String type, int xilanh, double saleprice) {
		this.Customer = customer;
		this.type = type;
		this.xilanh = xilanh;
		this.saleprice = saleprice;
	}
	
	public String getCustomer() {
		return Customer;
	}

	public void setCustomer(String customer) {
		this.Customer = customer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getXilanh() {
		return xilanh;
	}

	public void setXilanh(int xilanh) {
		this.xilanh = xilanh;
	}

	public double getSaleprice() {
		return saleprice;
	}

	public void setSaleprice(double saleprice) {
		this.saleprice = saleprice;
	}

	@Override
	public String toString() {
		return "Xe [Customer=" + Customer + ", type=" + type + ", xilanh=" + xilanh + ", saleprice=" + saleprice + "]";
	}
	
	 public double tinhthue() {
	        if (xilanh < 100) {
	            return saleprice * 0.01;
	        } else if (xilanh <= 200) {
	            return saleprice * 0.03;
	        } else {
	            return saleprice * 0.05;
	        }
	    }
	

}

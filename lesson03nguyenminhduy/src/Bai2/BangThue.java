package Bai2;
import java.util.Arrays;
public class BangThue {
	
	private Customer customers;
	private Xe[] xe;
	
	public BangThue() {
	}

	public BangThue(Customer customers, Xe[] xe) {
		this.customers = customers;
		this.xe = xe;
	}

	public Customer getCustomers() {
		return customers;
	}

	public void setCustomers(Customer customers) {
		this.customers = customers;
	}

	public Xe[] getXe() {
		return xe;
	}

	public void setXe(Xe[] xe) {
		this.xe = xe;
	}

	
	
	@Override
	public String toString() {
		return "BangThue [customers=" + customers + ", xe=" + Arrays.toString(xe) + "]";
	}

	public double tinhthue() {
		double tongthue = 0;
		Xe[] ids = getXe();
		for(Xe id: ids) {
			if(id.getXilanh() < 100) {
				 tongthue += id.getSaleprice() * 0.01;
			}else if(id.getXilanh() <= 200) {
				 tongthue += id.getSaleprice() * 0.03;
			}else {
				 tongthue += id.getSaleprice() * 0.05;
			}
		}
		return tongthue;
	}
	
	public void in() {
		System.out.println("Tên Chủ Xe: " + customers.getName());
		Xe[] ids = getXe();
		for(Xe id: ids) {
			double thue;
			if(id.getXilanh() < 100) {
				 thue = id.getSaleprice() * 0.01;
			}else if(id.getXilanh() <= 200) {
				 thue = id.getSaleprice() * 0.03;
			}else {
				 thue = id.getSaleprice() * 0.05;
			}
			System.out.println("Loại Xe: " + id.getType());
			System.out.println("Dung Tích: " + id.getXilanh());
			System.out.println("Trị Giá: " + id.getSaleprice());
			System.out.println("Thuế Phải Nộp: " + tinhthue());
		}
		System.out.println("Tổng Thuế cúa tất cả xe: " + tinhthue());
	
	}
}

package bean;

import utils.Status;

public class Textbook extends Book{
	//▪ Sách giáo khoa: Mã sách, đơn giá, nhà xuất bản, tình trạng (mới, cũ).
	
	private Status status;
	
	public Textbook() {
	}

	public Textbook(String id, double price, String publisher, Status status) {
		super(id, price, publisher);
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Override
	public double pay() {
		if(this.getStatus() == Status.OLD) return this.getPrice()*0.7;
		else return this.getPrice();
	}

	@Override
	public String toString() {
		return "Textbook [status=" + status + ", Id=" + getId() + ", Price=" + getPrice()
				+ ", Publisher=" + getPublisher() + "]";
	}
	
}
package lesson05.exam.bean;

@FunctionalInterface
public interface BookBill {
	double getTotalBill(Book[] books);
}

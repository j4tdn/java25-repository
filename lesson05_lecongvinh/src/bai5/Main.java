package bai5;

public class Main {
	public static void main(String[] args) {
		
	
	Books b1 = new Books("SGK1",150,"Nhi Đồng","Mới"  );
	Books b2 = new Books("SGK2",120,"Le Vinh","Mới"  );
	Books b3 = new Books("SGK3",30,"Le Vinh","Cũ"  );
	ReferenceBooks b4 = new ReferenceBooks("STK 1",40,"TH", 0.05f);
	ReferenceBooks b5 = new ReferenceBooks("STK 2",70,"TH", 0.02f);
	
	
	Books[] list= {b1,b2,b3};
	System.out.println("Toàn bộ sách giáo khoa có đơn giá từ 100 đến 200: là");
	for(int i=0; i<list.length;i++) {
		if(list[i].FindPrice()) {
			System.out.println(list[i]);
			
		}
	}
	
	}

	
	
}

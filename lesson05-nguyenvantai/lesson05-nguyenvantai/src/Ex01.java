//Bài 1 (20đ): Viết hàm kiểm tra một số có phải là lũy thừa của số còn lại không
//▪ VD: (8, 2)(true), (2, 8)(true), (6, 2)(false), (20, 4)(false), (64, 4)(true)
//Method signature: boolean isPowerOf(...)
//Dạ anh ơi em đi vệ sinh miếng


public class Ex01 {
	public static void main(String[] args) {
		
		System.out.println("Chạy");
		System.out.println(isPowerOf(4, 64));
	}
	public static  boolean isPowerOf(int n,int base) {
		
	if(n==1 || base<2) {
		return false;
	}
	if(n<base) {
		swap(base=n,n);
	}
	while(n%base==0) {
		n/=base;
		
	}
	return n==1;
	}
	public static int swap(int a,int b) {
		return b;
		
	}

}

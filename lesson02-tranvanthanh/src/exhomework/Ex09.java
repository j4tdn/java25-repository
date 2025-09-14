package exhomework;

public class Ex09 {
    public static void main(String[] args) {        
        int count = 0; 
        int number = 1; 
        int a=0;
        while (count < 200) {
            number++;  // số nguyên tố cần kiểm tra                         
            //Kiểm tra SNT
        	for (int i = 1; i <= number; i++) {
    			if(number % i ==0) {
    				a++;
    			}			
    		}
        	if(a == 2) {
    			count++;
    		}
       
        }
        System.out.println("Số nguyên tố thứ 200 là: " + number); 
    }
}
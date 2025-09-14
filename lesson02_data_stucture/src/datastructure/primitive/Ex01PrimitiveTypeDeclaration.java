package datastructure.primitive;

public class Ex01PrimitiveTypeDeclaration {
     public static void main(String[] args) {
    	 System.out.println("=== Start Main method ===");
    	 
    	 
    	 // khai baó và gán giá trị măc định cho các biến a,b,c,d
    	 // kiểm tra giá trị trong phạm vi cho phép của KDL lúc compile
		
    	 int a = 12;
    	 int b = 24;
    	 
    	 float c = 7.8f;
    	 double d = 22.6;
    	 
    	 // khai báo một biến e có KDL là char
    	 char e;
    	 
    	 // trong java không thể in ra một biến mà chỉ mới khai báo biến - chưa sử dụng đẻ tính toán hay gán giá trị lại 
    	 // System.out.println("e1 -->" + e);
    	 
    	 // gán giá trị % cho e
    	 e = '^';
    	 
    	 boolean f1 = true;
    	 boolean f2 = false;
    	 
    	 // println: in ket qua ra xong xuong dong
    	 // print: in ket qua ra
    	 // printf: in voi format
    	 
    	 System.out.println("a -->"+ a);
    	 System.out.println("b -->"+ b);
    	 System.out.println("c -->"+ c);
    	 System.out.println("d -->"+ d);
    	 
    	 System.out.printf("e --> %s\n", e);
    	 System.out.println("f1 -->" + f1 + "f2 -->" + f2);
    	 System.out.printf("f1(%s) -->", "f2(%s) -->", f1, f2);
    	 
    	 
    	 
    	 logging();
    	 
    	 
    	 
    	 
    	 
    	 System.out.println("=== Finish Main Method ===");
	}
     
     private static void logging() {
    	 System.out.println("logging >> final result 999");
     }
}

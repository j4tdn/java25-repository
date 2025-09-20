package view;

public class Ex04StaticMethod {
    private int a;
    private int b;

    public Ex04StaticMethod(int a, int b){
        this.a = b;
        this.b = b;
    }

    public static void main(String[] args) {

        System.out.println("sm1: " Ex04StaticMethod.sum(1, 2));
        System.out.println("sm2: " Ex04StaticMethod.sum(2, 2));

        Ex04StaticMethod sb = new Ex04StaticMethod();
        System.out.println("sb: " sb.sub(5, 3));

    }
    //Hàm sum không phụ thuộc vào tham số a, b
    private static int sum(int a, int b){
        return a + b;
    }

    // Hàm sub phụ thuộc vào dối tượng đang gọi
    private int sub(){
        return a - b;
    }
}
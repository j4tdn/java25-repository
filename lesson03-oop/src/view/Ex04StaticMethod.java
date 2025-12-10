package view;

public class Ex04StaticMethod {

    private int a;
    private int b;

    public Ex04StaticMethod(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int sub() {
        return a - b;
    }

    private static int sum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println("sm1 : " + Ex04StaticMethod.sum(1, 2));
        System.out.println("sm2 : " + Ex04StaticMethod.sum(2, 2));

        Ex04StaticMethod obj = new Ex04StaticMethod(10, 4);
        System.out.println("sub: " + obj.sub());
    }
}

package view;
import bean.Car;
public class Ex06EqualsMethod{
    public static void main(String[] args) {

        /*
        * Lý thuyết
         Biến KDL nguyên thủy

        - Stack: giá trị thực tế

        Biến KDL đối tượng

        Stack: địa chỉ của ô nhớ tại HEAP mà nó đang trỏ đến

        Heap: giá trị thực tế của đối tượng

        Để so sánh giá trị của 2 biến có bằng, giống nhau không --> thường sử dụng toán tử ==

        Toán tử == (so sánh giá trị của biển ở stack)

        Như vậy

        Dùng toàn tử == để so sánh 2 biển nguyên thủy --> so sánh giá trị --> OK
        Dùng toán tử == để so sánh 2 biển đối tượng --> so sánh địa chỉ (so xem 2 biến này có đang trỏ đến cùng 1 địa ch
        --> Muôn so sánh giá trị của 2 biến đối tượng ?
        --> Đối tượng có thể có 1 hoặc N thuộc tính, khi so sánh cần đặt câu hỏi 2 đối tượng đó ntn là bằng nhau
        *
        *
        *
        *
        *
        * */

        Car c1 = new Car(1, "honda", "crv", 1240d);
        Car c2 = new Car(1, "honda", "crv", 1240d);
        Car c3 = new Car(2, "honda", "brv", 720d);
        System.out.println("(c1==c2): " + (c1==c2));// false
        System.out.println("c1 eq c2 " + (c1.equals(c2))); //true
        System.out.println("c1 eq c3 " + (c1.equals(c3))); //false

        String s1 = "hello";
        String s2 = "hello";
        System.out.println("(c1==c2): " + (c1==c2));//true


    }
}
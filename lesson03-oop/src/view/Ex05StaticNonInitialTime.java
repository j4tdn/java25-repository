package view;
public class Ex05StaticNonInitalTime(){


    public static void main(String[] args) {
        s1();
        s2();

        Ex05StaticNonInitalTime x1 = new Ex05StaticNonInitalTime();
        x1.ns1();
        x1.ns2();

    }
    //Hàm, thuộc tính static được khờii tạo cùng thời điểm thực thi class (trươc)
    //Hàm, thuộc tính non-static chỉ được khờii tạo khi tạo ra đối tượng từ class đó (sau)


    //Ví dụ với 2 hàm static
    private static void s1(){
        s2();
        Ex05StaticNonInitalTime o1 = new Ex05StaticNonInitalTime();
        o1.ns2();
    }
    private static void s2(){

    }

    //Ví dụ với 2 hàm non-static
    private void ns1(){
        ns2();
        s2(); //Từ hàm non-static có thể gọi trực tiếp hàm static,
            // vì hàm static kh phụ thuộc dối tượng đang gọi và được khởi tạo cùng thời  điểm với class
    }
    private void ns2(){

    }

}
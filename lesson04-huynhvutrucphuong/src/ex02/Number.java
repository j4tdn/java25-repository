package ex02;

public class Number {
	private int[] arr;

    public Number(int[] arr) {
        this.arr = arr;
    }

    public void process() {
        StringBuilder chia7 = new StringBuilder();
        StringBuilder giua = new StringBuilder();
        StringBuilder chia5 = new StringBuilder();

        for (int x : arr) {
            if (x % 7 == 0 && x % 5 != 0)
                chia7.append(x).append(", ");
            else if (x % 5 == 0 && x % 7 != 0)
                chia5.append(x).append(", ");
            else
                giua.append(x).append(", ");
        }

        // Xóa dấu ", " thừa ở cuối
        String s1 = trim(chia7);
        String s2 = trim(giua);
        String s3 = trim(chia5);

        System.out.println(s1 + " | " + s2 + " | " + s3);
    }
    private String trim(StringBuilder sb) {
        if (sb.length() >= 2)
            sb.setLength(sb.length() - 2);
        return sb.toString();
    }

}

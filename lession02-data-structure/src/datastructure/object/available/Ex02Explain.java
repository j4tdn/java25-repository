package datastructure.object.available;

public class Ex02Explain {
	public static void main(String[] args) {
		String o1 = new String("today");
		String o2 = new String("today is a new day");
		String o3 = new String("today");
		System.out.printf("o1 [value=%s] [hash=%s]\n", o1 , System.identityHashCode(o1));
		System.out.printf("o2 [value=%s] [hash=%s]\n", o2 , System.identityHashCode(o2));
		System.out.printf("o3 [value=%s] [hash=%s]\n", o3 , System.identityHashCode(o3));
		
		String s1 = "homnay";
		String s2 = "ngaymai";
		String s3 = "homnay";
		String s4 = "homnay";
		System.out.printf("s1 [value=%s] [hash=%s]\n", s1 , System.identityHashCode(s1));
		System.out.printf("s2 [value=%s] [hash=%s]\n", s2 , System.identityHashCode(s2));
		System.out.printf("s3 [value=%s] [hash=%s]\n", s3 , System.identityHashCode(s3));
		System.out.printf("s4 [value=%s] [hash=%s]\n", s4 , System.identityHashCode(s4));
		System.out.println("\n");
		s3 = "ngaykia";
		System.out.printf("s1 [value=%s] [hash=%s]\n", s1 , System.identityHashCode(s1));
		System.out.printf("s2 [value=%s] [hash=%s]\n", s2 , System.identityHashCode(s2));
		System.out.printf("s3 [value=%s] [hash=%s]\n", s3 , System.identityHashCode(s3));
		System.out.printf("s4 [value=%s] [hash=%s]\n", s4 , System.identityHashCode(s4));
		
	}
}

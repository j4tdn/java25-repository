package Ex02;

public class NumberFormatter {
	public static void main(String[] args) {
        int[] arr = {12, 21, 25, 19, 32, 35, 49, 10, 33, 14, 18};
        int n = arr.length;

        int[] div7 = new int[n];
        int[] div5 = new int[n];
        int[] mid = new int[n];
        int i7 = 0, i5 = 0, imid = 0;

        for(int x : arr) {
        	if(x % 5 == 0 && x% 7 ==0) {
        		mid[imid++] = x;
        	}else if(x%7==0){
        		div7[i7++] =x;
        	}else if(x%5 == 0) {
        		div5[i5++] = x;
        	}else {
        		mid[imid++] = x;
        	}
        }

        System.out.print("Output: ");
        printArray(div7, i7);
        System.out.print(" | ");
        printArray(mid, imid);
        System.out.print(" | ");
        printArray(div5, i5);
    }

    public static void printArray(int[] arr, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i]);
            if (i < length - 1) System.out.print(", ");
        }
    }
}

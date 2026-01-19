package view;

import bean.Reducer;

public class Ex05Test02 {

	/*
		 Cho một mảng số nguyên gồm N phần tử
		 Viết chương trình
		 + Tìm tổng các phần tử trong mảng
		 + Tìm tích các phần tử trong mảng
		 + Tìm giá trị lớn nhất trong mảng
		 + Tìm giá trị nhỏ nhất trong mảng
		 
		 1: Mỗi yêu cầu viết 1 hàm để xử lý
		 2: Viết duy nhất 1 hàm để xử lý cho 4 yêu cầu trên
	 */
	public static void main(String[] args) {
		int[] arr = { 1,2,3,4,5,6,7,8,9,10 };
		System.out.println("Tìm giá trị lớn nhất trong mảng --> " +
				calcByReducer(arr, new Reducer() {			
					@Override
					public int reducer(int cur, int next) {
						return cur > next ? cur : next;
					}
			
					@Override
					public int initial() {
						return Integer.MIN_VALUE;
					}
				}));
	}
	
	private static int calcSum(int[] arr) {
        int sum = 0;
        for (int x : arr) {
        	sum += x;
        }
        return sum;
    }
	
	private static int calcMutiple(int[] arr) {
        int mul = 1;
        for (int x : arr) {
        	mul *= x;
        }
        return mul;
    }
	
	private static int calcMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int x : arr) {
        	if (x > max) {
        		max = x;
        	}
        }
        return max;
    }
	
	private static int calcMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int x : arr) {
        	if (x < min) {
        		min = x;
        	}
        }
        return min;
    }
	
	private static int calcByReducer(int[] arr, Reducer reducer) {
		int reuslt = reducer.initial();
		for (int x : arr) {
        	reuslt = reducer.reducer(reuslt, x);
        }
		return reuslt;	
	}
	
}

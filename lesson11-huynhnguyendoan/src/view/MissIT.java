package view;

import java.util.Scanner;

public class MissIT {

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        int n = sc.nextInt();

	        int MAX = 1000000;

	        int[] score = new int[MAX + 1];
	        int[] top1 = new int[MAX + 1];
	        int[] top2 = new int[MAX + 1];
	        boolean[] exist = new boolean[MAX + 1];

	        for (int i = 0; i < n; i++) {

	            int k = sc.nextInt();

	            for (int j = 1; j <= k; j++) {

	                int id = sc.nextInt();
	                exist[id] = true;

	            }
	        }
	    }
	}
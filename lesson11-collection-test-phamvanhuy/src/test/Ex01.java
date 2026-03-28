package test;

import java.util.*;

public class Ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < k; j++) {
                list.add(sc.nextInt());
            }

            for (int j = 0; j < list.size(); j++) {
                int id = list.get(j);
                map.putIfAbsent(id, new int[3]);
                int[] arr = map.get(id);

                if (j == 0) {
                    arr[0] += 3; 
                    arr[1] += 1; 
                } else if (j == 1) {
                    arr[0] += 2;
                    arr[2] += 1; 
                } else if (j == 2) {
                    arr[0] += 1;
                }
            }
        }

        int maxScore = -1, maxTop1 = -1, maxTop2 = -1;

        for (int id : map.keySet()) {
            int[] a = map.get(id);

            if (a[0] > maxScore ||
               (a[0] == maxScore && a[1] > maxTop1) ||
               (a[0] == maxScore && a[1] == maxTop1 && a[2] > maxTop2)) {

                maxScore = a[0];
                maxTop1 = a[1];
                maxTop2 = a[2];
            }
        }

        List<Integer> winners = new ArrayList<>();

        for (int id : map.keySet()) {
            int[] a = map.get(id);
            if (a[0] == maxScore && a[1] == maxTop1 && a[2] == maxTop2) {
                winners.add(id);
            }
        }

        Collections.sort(winners);
        for (int id : winners) {
            System.out.print(id + " ");
        }
    }
}

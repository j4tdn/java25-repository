import java.util.*;

public class MissIT {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap so luong judge:");
        int N = sc.nextInt();
        sc.nextLine();

        Map<Integer, int[]> map = new HashMap<>();

        System.out.println("Nhap du lieu moi judge:");

        for (int i = 0; i < N; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");
            int k = Integer.parseInt(input[0]);

            for (int j = 0; j < k; j++) {
                int id = Integer.parseInt(input[j + 1]);

                map.putIfAbsent(id, new int[3]);

                int[] stats = map.get(id);

                if (j == 0) {
                    stats[0] += 3;
                    stats[1] += 1;
                } else if (j == 1) {
                    stats[0] += 2;
                    stats[2] += 1;
                } else if (j == 2) {
                    stats[0] += 1;
                }
            }
        }

        int maxScore = -1;
        int maxTop1 = -1;
        int maxTop2 = -1;

        for (int[] v : map.values()) {
            maxScore = Math.max(maxScore, v[0]);
        }

        List<Integer> candidates = new ArrayList<>();

        for (Map.Entry<Integer, int[]> e : map.entrySet()) {
            if (e.getValue()[0] == maxScore) {
                candidates.add(e.getKey());
                maxTop1 = Math.max(maxTop1, e.getValue()[1]);
            }
        }

        List<Integer> next = new ArrayList<>();
        for (int id : candidates) {
            if (map.get(id)[1] == maxTop1) {
                next.add(id);
                maxTop2 = Math.max(maxTop2, map.get(id)[2]);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int id : next) {
            if (map.get(id)[2] == maxTop2) {
                result.add(id);
            }
        }

        Collections.sort(result);

        System.out.println("Ket qua:");
        for (int id : result) {
            System.out.print(id + " ");
        }
    }
}
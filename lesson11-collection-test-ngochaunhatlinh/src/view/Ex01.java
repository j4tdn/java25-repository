package view;

import functional.ContestService;
import java.util.*;

public class Ex01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        ContestService service = new ContestService();

        for (int i = 0; i < N; i++) {
            int k = sc.nextInt();
            int[] ids = new int[k];

            for (int j = 0; j < k; j++) {
                ids[j] = sc.nextInt();
            }

            service.addJudgeChoices(ids);
        }

        List<Integer> winners = service.getWinners();

        for (int id : winners) {
            System.out.print(id + " ");
        }
    }
}
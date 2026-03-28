package utils;

import model.ContestantResult;
import java.util.Map;

public class ScoreCalculator {

    public static void updateScore(Map<Integer, ContestantResult> map, int[] ids) {
        for (int i = 0; i < ids.length && i < 3; i++) {
            int id = ids[i];

            map.putIfAbsent(id, new ContestantResult(id));
            map.get(id).addScore(i + 1);
        }
    }
}
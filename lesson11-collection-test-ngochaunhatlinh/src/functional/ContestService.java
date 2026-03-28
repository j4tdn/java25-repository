package functional;

import model.ContestantResult;
import utils.ScoreCalculator;
import utils.ResultComparator;

import java.util.*;

public class ContestService {

    private Map<Integer, ContestantResult> results = new HashMap<>();

    public void addJudgeChoices(int[] ids) {
        ScoreCalculator.updateScore(results, ids);
    }

    public List<Integer> getWinners() {
        List<ContestantResult> list = new ArrayList<>(results.values());

        if (list.isEmpty()) return new ArrayList<>();

        ResultComparator comparator = new ResultComparator();
        list.sort(comparator);

        ContestantResult best = list.get(0);
        List<Integer> winners = new ArrayList<>();
        winners.add(best.getId());

        for (int i = 1; i < list.size(); i++) {
            ContestantResult c = list.get(i);
            if (comparator.compare(best, c) == 0) {
                winners.add(c.getId());
            } else {
                break;
            }
        }

        return winners;
    }
}
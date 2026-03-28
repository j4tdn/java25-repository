package utils;

import model.ContestantResult;
import java.util.Comparator;

public class ResultComparator implements Comparator<ContestantResult> {

    @Override
    public int compare(ContestantResult a, ContestantResult b) {
        if (b.getTotalScore() != a.getTotalScore()) {
            return b.getTotalScore() - a.getTotalScore();
        }
        if (b.getFirstCount() != a.getFirstCount()) {
            return b.getFirstCount() - a.getFirstCount();
        }
        if (b.getSecondCount() != a.getSecondCount()) {
            return b.getSecondCount() - a.getSecondCount();
        }
        return 0;
    }
}
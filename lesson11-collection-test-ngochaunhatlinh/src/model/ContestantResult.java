package model;

public class ContestantResult {
    private int id;
    private int totalScore;
    private int firstCount;
    private int secondCount;

    public ContestantResult(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getFirstCount() {
        return firstCount;
    }

    public int getSecondCount() {
        return secondCount;
    }

    public void addScore(int position) {
        if (position == 1) {
            totalScore += 3;
            firstCount++;
        } else if (position == 2) {
            totalScore += 2;
            secondCount++;
        } else if (position == 3) {
            totalScore += 1;
        }
    }
}
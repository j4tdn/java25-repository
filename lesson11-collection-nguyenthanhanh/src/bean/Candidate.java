package bean;

public class Candidate {
	
	private int id;
    private int totalScore;
    private int countRank1;
    private int countRank2;
    
    public Candidate() {
    	
    }
    
    public Candidate(int id) {
    	this.id = id;
        this.totalScore = 0;
        this.countRank1 = 0;
        this.countRank2 = 0;
    }
    
    public void addScoreFromRank(int rank) {
        if (rank == 1) {
        	this.totalScore += 3;
            this.countRank1 += 1;
        } else if (rank == 2) {
            this.totalScore += 2;
            this.countRank2 += 1;
        } else if (rank == 3) {
            this.totalScore += 1;
        }
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getCountRank1() {
		return countRank1;
	}

	public void setCountRank1(int countRank1) {
		this.countRank1 = countRank1;
	}

	public int getCountRank2() {
		return countRank2;
	}

	public void setCountRank2(int countRank2) {
		this.countRank2 = countRank2;
	}

}

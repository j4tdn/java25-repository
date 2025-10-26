package bai1;

public class InforOfStudents {
		public int id;
		public String name;
		public float TheoScore;
		public float PractScore;
		
		public InforOfStudents() {
			
		}

		public InforOfStudents(int id, String name, float theoScore, float practScore) {
			
			this.id = id;
			this.name = name;
			this.TheoScore = theoScore;
			this.PractScore = practScore;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public float getTheoScore() {
			return TheoScore;
		}

		public void setTheoScore(float theoScore) {
			TheoScore = theoScore;
		}

		public float getPractScore() {
			return PractScore;
		}

		public void setPractScore(float practScore) {
			PractScore = practScore;
		}
		public float AvarScore() {
			return (this.TheoScore + this.PractScore)/2;
		}
		public boolean AvarScoretGreaterThan8() {
			return AvarScore() > 8.5d;
		} 
		public boolean TheoGreaterThanPract() {
			return this.TheoScore > this.PractScore;
		}
		
		@Override
		public String toString() {
			return "InforOfStudents [id=" + id + ", name=" + name + ", TheoScore=" + TheoScore + ", PractScore="
					+ PractScore  + ", avgPoint= "+ AvarScore() + "]";
		}
		
		
}

package ex01;

public class Student {
 private Integer studentId;
 private String fullName;
 private Double theoryScore;
 private Double practiceScore;

 public Student(Integer studentId, String fullName, Double theoryScore, Double practiceScore) {
     this.studentId = studentId;
     this.fullName = fullName;
     this.theoryScore = theoryScore;
     this.practiceScore = practiceScore;
 }

 public Integer getStudentId() {
     return studentId;
 }
 public void setStudentId(Integer studentId) {
     this.studentId = studentId;
 }
 public String getFullName() {
     return fullName;
 }
 public void setFullName(String fullName) {
     this.fullName = fullName;
 }
 public Double getTheoryScore() {
     return theoryScore;
 }
 public void setTheoryScore(Double theoryScore) {
     this.theoryScore = theoryScore;
 }
 public Double getPracticeScore() {
     return practiceScore;
 }
 public void setPracticeScore(Double practiceScore) {
     this.practiceScore = practiceScore;
 }

 public double getAverage() {
	 double t = 0.0;
	 double p = 0.0;
	 if (theoryScore != null) {
		 t = theoryScore;
	 }
	 if (practiceScore != null) {
		 p = practiceScore;
	 }
	 return (t + p)/ 2.0;
 }

 @Override
 public String toString() {
     return "Student { \n id = " + studentId + 
    		          "\n name = " + fullName +
    		          "\n theory = "+ theoryScore +
    	        	  "\n practice = " + practiceScore + "\n }";
    }
}


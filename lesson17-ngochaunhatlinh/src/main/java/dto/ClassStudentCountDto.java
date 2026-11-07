package dto;

public class ClassStudentCountDto {

    private int classId;
    private String className;
    private String teacher;
    private int studentCount;

    public ClassStudentCountDto() {
    }

    public ClassStudentCountDto(int classId, String className, String teacher, int studentCount) {
        this.classId = classId;
        this.className = className;
        this.teacher = teacher;
        this.studentCount = studentCount;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    @Override
    public String toString() {
        return "ClassStudentCountDto [classId=" + classId
                + ", className=" + className
                + ", teacher=" + teacher
                + ", studentCount=" + studentCount + "]";
    }
}

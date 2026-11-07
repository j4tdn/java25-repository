package dto;

public class GoodStudentByClassDto {

    private String className;
    private int studentCount;
    private String studentNames;

    public GoodStudentByClassDto() {
    }

    public GoodStudentByClassDto(String className, int studentCount, String studentNames) {
        this.className = className;
        this.studentCount = studentCount;
        this.studentNames = studentNames;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public String getStudentNames() {
        return studentNames;
    }

    public void setStudentNames(String studentNames) {
        this.studentNames = studentNames;
    }

    @Override
    public String toString() {
        return "GoodStudentByClassDto [className=" + className
                + ", studentCount=" + studentCount
                + ", studentNames=" + studentNames + "]";
    }
}

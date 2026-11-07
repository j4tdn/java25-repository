package persistence;

public class Student {

    private int id;
    private String name;
    private boolean gender;
    private int cid;

    public Student() {
    }

    public Student(int id, String name, boolean gender, int cid) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.cid = cid;
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", gender=" + (gender ? 1 : 0) + ", cid=" + cid + "]";
    }
}

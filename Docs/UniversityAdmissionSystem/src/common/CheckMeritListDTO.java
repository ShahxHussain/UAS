package common;

public class CheckMeritListDTO {
    private int studentID;
    private String studentName;
    private String course;
    private int matricMarks;
    private int fscMarks;
    private int testMarks;
    private double percentage;
    private String rank;

    public CheckMeritListDTO(int studentID, String studentName, String course, int matricMarks, int fscMarks, int testMarks, double percentage, String rank) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.course = course;
        this.matricMarks = matricMarks;
        this.fscMarks = fscMarks;
        this.testMarks = testMarks;
        this.percentage = percentage;
        this.rank = rank;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getMatricMarks() {
        return matricMarks;
    }

    public void setMatricMarks(int matricMarks) {
        this.matricMarks = matricMarks;
    }

    public int getFscMarks() {
        return fscMarks;
    }

    public void setFscMarks(int fscMarks) {
        this.fscMarks = fscMarks;
    }

    public int getTestMarks() {
        return testMarks;
    }

    public void setTestMarks(int testMarks) {
        this.testMarks = testMarks;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Object getRollNumber() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getScore() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

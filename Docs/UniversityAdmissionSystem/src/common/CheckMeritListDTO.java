package common;

public class CheckMeritListDTO {
    private int studentID;
    private String studentName;
    private int fscMarks;
    private int matricMarks;
    private int testMarks;
    private double percentage;
    private String rank;

    public CheckMeritListDTO(int studentID, String studentName, int fscMarks, int matricMarks, int testMarks, double percentage, String rank) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.fscMarks = fscMarks;
        this.matricMarks = matricMarks;
        this.testMarks = testMarks;
        this.percentage = percentage;
        this.rank = rank;
    }
 public CheckMeritListDTO(int studentID, String studentName, int testMarks, double percentage) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.testMarks = testMarks;
        this.percentage = percentage;
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

    public int getFscMarks() {
        return fscMarks;
    }

    public void setFscMarks(int fscMarks) {
        this.fscMarks = fscMarks;
    }

    public int getMatricMarks() {
        return matricMarks;
    }

    public void setMatricMarks(int matricMarks) {
        this.matricMarks = matricMarks;
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
}

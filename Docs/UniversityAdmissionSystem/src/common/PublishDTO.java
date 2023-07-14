package common;

public class PublishDTO {
    private int studentID;
    private String studentName;
    private int testResult;
    private double percentage;

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

   public String getStudentName() {
    if (studentName == null) {
        return "";
    }
    return studentName;
}


    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getTestResult() {
        return testResult;
    }

    public void setTestResult(int testResult) {
        this.testResult = testResult;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}

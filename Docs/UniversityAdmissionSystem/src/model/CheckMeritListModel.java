
package model;

public class CheckMeritListModel {
    private int studentID;
    private String studentName;
    private String rank;

    public CheckMeritListModel(int studentID, String studentName, String rank) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.rank = rank;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getRank() {
       
        return rank;
    }
}


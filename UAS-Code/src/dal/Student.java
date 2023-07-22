/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

/**
 *
 * @author DELL
 */
public class Student {
    private int admissionID;
    private String studentName;
    private String Merit;
    private String Fee;
    private String Admission;
    private boolean feeStatus;
    

    public Student(int admissionID, String studentName, String Merit, String Fee, String Admission) {
        this.admissionID = admissionID;
        this.studentName = studentName;
        this.Merit = Merit;
        this.Fee = Fee;
        this.Admission = Admission;
    }

    public Student(int admissionID, String studentName, boolean feeStatus) {
        this.admissionID = admissionID;
        this.studentName = studentName;
        this.feeStatus = feeStatus;
    }

    public int getAdmissionID() {
        return admissionID;
    }

    public String getStudentName() {
        return studentName;
    }
    
    public String getMerit() {
        return Merit;
    }

    public void setMerit(String Merit) {
        this.Merit = Merit;
    }

    public String getFee() {
        return Fee;
    }

    public void setFee(String Fee) {
        this.Fee = Fee;
    }

    public String getAdmission() {
        return Admission;
    }

    public void setAdmission(String Admission) {
        this.Admission = Admission;
    }

    public boolean isFeePaid() {
        return feeStatus;
    }

    public boolean isFeeStatus() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


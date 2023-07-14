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
    private boolean feeStatus;

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

    public boolean isFeePaid() {
        return feeStatus;
    }

    public boolean isFeeStatus() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


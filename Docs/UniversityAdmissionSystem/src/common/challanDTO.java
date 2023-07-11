/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

/**
 *
 * @author Abdul aziz
 */
import java.util.Date;

public class challanDTO {
    private String studentName;
    private double feeAmount;
    private Date submissionDate;
    private String challanNumber;
    private Date challanExpirationDate;

    // Getters and setters for the fields

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(double feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getChallanNumber() {
        return challanNumber;
    }

    public void setChallanNumber(String challanNumber) {
        this.challanNumber = challanNumber;
    }

    public Date getChallanExpirationDate() {
        return challanExpirationDate;
    }

    public void setChallanExpirationDate(Date challanExpirationDate) {
        this.challanExpirationDate = challanExpirationDate;
    }
}


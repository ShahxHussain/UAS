/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */

public class StudentModel {
    
    private int admissionID;
    private boolean feeStatus;
    private String std_name;
    private String Merit;
    private String Fee;
    private String Admission;

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

    public int getAdmissionID() {
        return admissionID;
    }

    public void setAdmissionID(int admissionID) {
        this.admissionID = admissionID;
    }

   public String getStd_name() {
    return std_name;
}

public void setStd_name(String std_name) {
    this.std_name = std_name;
}


    public boolean isFeeStatus() {
        return feeStatus;
    }

    public void setFeeStatus(boolean feeStatus) {
        this.feeStatus = feeStatus;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import UI.ui.compnents.DALManager;
import common.testDTO;
import java.util.ArrayList;
import model.SQLConnection;

/**
 *
 * @author S K
 */

public class UASController {
    public DALManager objTest;
    
    public UASController()
    { 
        objTest  = new DALManager(connectionProvider);
    }
//    
////Mahad Wajid (Fa21-bse-057 ) Use Case: Enter Personal Info 
//    public void Enterpersonalinfo( ){
//              
//        
//    }
    
//    public static Announcement createAnnouncement(String title , String content, String author ,Date date){
//        Announcment announcement=new Announcement(title ,content , author , date);
//        
//        return Announcement;
//    }
//    
//    public static Schedule scheduletest(String testname, Date date, Time time ,String location){
//        Schedule schedule=new Schedule(testname,date ,time,location);
//        return Schedule ;
//    }
    
////    ====================================================================
//    
//    
//    //SYED SHAH HUSSAIN BADSHAH (FA21-BSE-172)
//    public void admissionConfirmation(int AdmissionID){
//        
//        Admission admission =new Admission(admissionID);
//        System.out.println("USE CASE: CONFRIM ADMISSION");
//    }
//     
//    
//    public void notificationController( String notificationType, int admissionID String message ){
//        
//        System.out.println("USE CASE: NOTIFY STUDENTS");
//    }
//    //=====================================================================
//    
//        //ABDUL AZIZ (FA21-BSE-058) 
//    //Use Case: Take Test
//    
public ArrayList<testDTO> getTest() {
    return objTest.getTestQuestions();
}
//    
//    //Use Case: Print Challan
//    
//    public void PrintChallan(int studentId, String challanNO)
//    {
//        PrintChallan challan = new PrintChallan(studentId, challanNo);
//    }
//    
//    //Use Case: Make Payment
//    
//    public void MakePayment(int studentId, String accountNo, String branchNo, String paymentType, double ammount, String challanNo, File challanImage)
//    {
//        MakePayement payment = new MakePayment(studentId,accountNo,branchNo,PaymentType,ammount,challanNo,ChallanImage);
//    }
//}
//
//
// //soman ahmad (FA21-BSE-150) 
//    //Use Case: logout
//    
//    public void logout()
//    {
//        logout log = new Logout(); 
//    }
//    
//    //Use Case: enter academic info
//    
//    public void EnterAcademicInfo(String institutionname, int totalmarks, int obtainmarks, double percentage, int session)
//    {
//        EnterAcademicInfo academicinfo = new EnterAcademicInfo(institutionname,totalmarks, obtainmarks,percentage,session);
//    }
//
// //Use Case: verify document
//
//public void VerifyDocument()
//    {
//        VerifyDocument verify = new VerifyDocument(); 
//    }
//
//########################################################################333
////use csae:publish merit list by (hamza badar fa21-bse-055)
//
//    public void addStudentToMeritList(Student student) {
//        meritList.add(student);
//    }
//
//    public void removeStudentFromMeritList(Student student) {
//        meritList.remove(student);
//    }
//
//    public List<Student> getMeritList() {
//        return meritList;
//    }
//   public void addStudentToWaitingList(Student student) {
//        waitingList.add(student);
//    }
//
//    public void removeStudentFromWaitingList(Student student) {
//        waitingList.remove(student);
//    }
//
//    public List<Student> getWaitingList() {
//        return waitingList;
//    }
//
//
//    ##################################################################
////use csae:check merit list by (hamza badar fa21-bse-055)
//
//    public void addStudentToMeritList(String studentName) {
//        meritList.add(studentName);
//    }
//
//    public boolean isStudentInMeritList(String studentName) {
//        return meritList.contains(studentName);
//    }
//
//    public int getRankInMeritList(String studentName) {
//        return meritList.indexOf(studentName) + 1;
    }
//###################################################################

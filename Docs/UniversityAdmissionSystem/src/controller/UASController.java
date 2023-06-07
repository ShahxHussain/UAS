/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author S K
 */
import java.io.File;
import java.util.Date;
import java.sql.Time;
import java.time.Duration;
public class UASController {
    
//Mahad Wajid (Fa21-bse-057 ) Use Case: Enter Personal Info 
    public static Student enterpersonalinfo(String firstname , String lastname , String email, String phoneno , String Address ){
        Student student=new Student(firstname,lastname,email,phoneno,Address);        
        
        return Student;
    }
    
    public static Announcement createAnnouncement(String title , String content, String author ,Date date){
        Announcment announcement=new Announcement(title ,content , author , date);
        
        return Announcement;
    }
    
    public static Schedule scheduletest(String testname, Date date, Time time ,String location){
        Schedule schedule=new Schedule(testname,date ,time,location);
        return Schedule ;
    }
    
//    ====================================================================
    
    
    //SYED SHAH HUSSAIN BADSHAH (FA21-BSE-172)
    public void admissionConfirmation(int AdmissionID){
        
        Admission admission =new Admission(admissionID);
        System.out.println("USE CASE: CONFRIM ADMISSION");
    }
     
    
    public void notificationController( String notificationType, int admissionID String message ){
        
        System.out.println("USE CASE: NOTIFY STUDENTS");
    }
    //=====================================================================
    
        //ABDUL AZIZ (FA21-BSE-058) 
    //Use Case: Take Test
    
    public void TakeTest(int studentId, Duration testDuration, int testId, Time testTime)
    {
        TakeTest test = new TakeTest(studentId,Duration,testId,testTime); 
    }
    
    //Use Case: Print Challan
    
    public void PrintChallan(int studentId, String challanNO)
    {
        PrintChallan challan = new PrintChallan(studentId, challanNo);
    }
    
    //Use Case: Make Payment
    
    public void MakePayment(int studentId, String accountNo, String branchNo, String paymentType, double ammount, String challanNo, File challanImage)
    {
        MakePayement payment = new MakePayment(studentId,accountNo,branchNo,PaymentType,ammount,challanNo,ChallanImage);
    }
}


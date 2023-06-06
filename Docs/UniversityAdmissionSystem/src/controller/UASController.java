/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author S K
 */
import java.util.Date;
import java.sql.Time;
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
}

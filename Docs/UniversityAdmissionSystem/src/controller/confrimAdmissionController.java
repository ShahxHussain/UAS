/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author DELL
 */

import dal.Student;
import dal.DALManager;
import java.util.List;
import model.StudentModel;

public class confrimAdmissionController {
    private DALManager dalManager;
    private final StudentModel model;

    

    public confrimAdmissionController(DALManager dalManager, StudentModel model) {
        this.dalManager = dalManager;
        this.model = model;
    }



    public List<Student> getStudents() {
        return dalManager.getStudents();
    }

    public void notifyStudents() {
        // Implement the logic to notify students
        List<Student> students = getStudents();

        for (Student student : students) {
            // Notify each student based on their fee status or other criteria
            if (student.isFeeStatus()) {
                System.out.println("Notifying student " + student.getStudentName() + " about merit list announcement.");
                // Perform the notification action for merit list announcement
            } else {
                System.out.println("Notifying student " + student.getStudentName() + " about fee submission.");
                // Perform the notification action for fee submission
            }
        }
    }
}


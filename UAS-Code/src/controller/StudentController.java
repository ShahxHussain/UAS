
package controller;

import dal.Student;
import dal.DALManager;
import java.util.List;

public class StudentController {
    private DALManager dalManager;

    public StudentController(DALManager dalManager) {
        this.dalManager = dalManager;
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


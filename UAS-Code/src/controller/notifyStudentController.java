package controller;

import dal.Student;
import dal.DALManager;
import java.util.List;
import model.StudentModel;

public class notifyStudentController {
    private DALManager dalManager;
    private StudentModel model;

    public notifyStudentController(DALManager dalManager, StudentModel model) {
        this.dalManager = dalManager;
        this.model = model;
    }

    public List<Student> getStudents() {
        return dalManager.getStudents();
    }

    public List<Student> getUnpaidStudents() {
        return dalManager.getUnpaidStudents();
    }

    public List<Student> getPaidStudents() {
        return dalManager.getPaidStudents();
    }
     public List<Student> getNotifiedStudents() {
        return dalManager.getNotifiedStudents();
    }
}

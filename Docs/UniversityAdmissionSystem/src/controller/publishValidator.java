package controller;

import common.PublishDTO;

public class publishValidator {
  public boolean validateStudent(PublishDTO student) {
    // Add your validation logic here
    // For example, check if the student name is not empty and percentage is between 0 and 100
    if (student.getStudentName() == null || student.getStudentName().isEmpty() || student.getPercentage() < 0 || student.getPercentage() > 100) {
        return false;
    }
    return true;
}

}

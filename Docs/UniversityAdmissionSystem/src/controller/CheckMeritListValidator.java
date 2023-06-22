package controller;

import common.CheckMeritListDTO;

public class CheckMeritListValidator {
    public static boolean validateCheckMeritListDTO(CheckMeritListDTO common) {
        // Validate the CheckMeritListDto fields
        if (common.getStudentID() <= 0 || common.getStudentName() == null || common.getStudentName().isEmpty()
                || common.getCourse() == null || common.getCourse().isEmpty() || common.getRank() == null
                || common.getRank().isEmpty()) {
            return false;
        }

        // Additional validation rules if needed

        return true;
    }
}

package controller;

import common.CheckMeritListDTO;

public class CheckMeritListValidator {
    public static boolean validateCheckMeritListDTO(CheckMeritListDTO common) {
        // Validate the CheckMeritListDto fields
        if (common.getStudentID() <= 0 || common.getStudentName() == null || common.getStudentName().isEmpty()
                || common.getTestMarks() < 0 || common.getPercentage() < 0) {
            return false;
        }

        // Additional validation rules if needed

        return true;
    }
}

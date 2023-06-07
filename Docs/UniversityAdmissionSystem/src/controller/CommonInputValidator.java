/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.File;

/**
 *
 * @author HP 840 G3
 */
public class CommonInputValidator {
    
//BY Mahad wajid (fa21-bse-057)   
    
    public static ValidationResult validatePersonalEmail(String email) {
        ValidationResult validationResult = new ValidationResult();

        if (email == null || email.isEmpty()) {
            validationResult.setValid(false);
            validationResult.setMessage("Email cannot be empty.");
        } else if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            validationResult.setValid(false);
            validationResult.setMessage("Invalid email format.");
        } else {
            validationResult.setValid(true);
        }

        return validationResult;
    }
    
        public static ValidationResult validateFirstName(String firstName) {
        ValidationResult validationResult = new ValidationResult();

        if (firstName == null || firstName.isEmpty()) {
            validationResult.setValid(false);
            validationResult.setMessage("First name cannot be empty.");
        } else {
            validationResult.setValid(true);
        }

        return validationResult;
    }

    public static ValidationResult validateLastName(String lastName) {
        ValidationResult validationResult = new ValidationResult();

        if (lastName == null || lastName.isEmpty()) {
            validationResult.setValid(false);
            validationResult.setMessage("Last name cannot be empty.");
        } else {
            validationResult.setValid(true);
        }

        return validationResult;
    }

    public static ValidationResult validateAddress(String address) {
        ValidationResult validationResult = new ValidationResult();

        if (address == null || address.isEmpty()) {
            validationResult.setValid(false);
            validationResult.setMessage("Address cannot be empty.");
        } else {
            validationResult.setValid(true);
        }

        return validationResult;
    }
//================================================================================================
    
     //ABDUL AZIZ (FA21-BSE-058)
    //Use Case: Take Test
    
    public static boolean isValidAnswer(String input) {
        // Assuming valid answers are single alphanumeric characters
        return input != null && input.matches("^[a-zA-Z0-9]$");
    }
    
     public static boolean isValidTimeLimit(String input) {
        try {
            int timeLimit = Integer.parseInt(input);
            return timeLimit > 0; // Assuming time limit should be a positive integer
        } catch (NumberFormatException e) {
            return false;
        }
    }
     
     //Use Case: Print Challan
      public static boolean isValidStudentId(int input) {
        // Assuming valid student IDs are positive integers
        return input > 0;
    }

    public static boolean isValidChallanNo(String input) {
        // Assuming valid challan numbers are non-null and non-empty strings
        return input != null && !input.trim().isEmpty();
    }
    
    //Use Case: Make Payment
    
     public static boolean isValidAccountNo(String input) {
        // Assuming valid account numbers are non-null and non-empty strings
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isValidBranchNo(String input) {
        // Assuming valid branch numbers are non-null and non-empty strings
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isValidPaymentType(String input) {
        // Assuming valid payment types are non-null and non-empty strings
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isValidAmount(double input) {
        // Assuming valid amounts are positive or zero
        return input >= 0;
    }

    public static boolean isValidChallanImage(File input) {
        // Assuming valid challan images are non-null and exist
        return input != null && input.exists();
    }
    
    //===========================================================================================
}


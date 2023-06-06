/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

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
    
}


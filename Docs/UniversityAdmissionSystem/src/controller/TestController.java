/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import UI.ui.compnents.DALManager;
import common.testDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abdul aziz
 */
public class TestController {
    private List<testDTO> questions;
    private int currentQuestionIndex;
    public DALManager objTest;
    
    public TestController() {
        objTest  = new DALManager();
        this.questions = new ArrayList<>();
        loadTestData();
    }
    public ArrayList<testDTO> getTest() {
    return objTest.getTestQuestions();
}
    private void loadTestData() {
        // Use UASController to get the test data
        List<testDTO> testData = getTest();
        for (testDTO data : testData) {
            // Convert testDTO to Question and add to questions list
            String[] options = {data.getOption1(), data.getOption2(), data.getOption3(), data.getOption4()};
            questions.add(new testDTO(data.getDescription(), options, data.getAnswer()));
        }
    }

    public testDTO getCurrentQuestion() {
        return questions.get(currentQuestionIndex);
    }

    public boolean moveToNextQuestion() {
        if (currentQuestionIndex < questions.size() - 1) {
            currentQuestionIndex++;
            return true;
        } else {
            return false;
        }
    }

    public int calculateCorrectAnswers() {
        int correctAnswers = 0;
        // Calculate correct answers here
        for (testDTO question : questions) {
            String selectedAnswer = question.getSelectedAnswer(); // Get the selected answer for this question
            if (selectedAnswer != null && question.isCorrectAnswer(selectedAnswer)) {
                correctAnswers++;
            }
        }
        return correctAnswers;
    }
}

package common;

import java.util.ArrayList;

public class testDTO {
    private String id;
    private String description;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
    private String selectedAnswer;

    public testDTO(String description, String[] options, String answer) {
    if (options == null || options.length != 4) {
        throw new IllegalArgumentException("Must provide exactly 4 options.");
    }

    this.description = description;
    this.option1 = options[0];
    this.option2 = options[1];
    this.option3 = options[2];
    this.option4 = options[3];
    this.answer = answer;
}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public boolean isCorrectAnswer(String selectedAnswer) {
        return this.answer.equals(selectedAnswer);
    }
    

}

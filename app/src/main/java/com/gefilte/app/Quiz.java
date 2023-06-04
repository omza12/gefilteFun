package com.gefilte.app;

public class Quiz {

    String[] questions, correctAnswers;
    String[][] choices;

    public Quiz(){

    }
    public void setQuestions(String[] questions)
    {
        this.questions = questions;
    }

    public String[] getQuestions()
    {
        return questions;
    }

    public void setChoices (String[][] choices){
        this.choices = choices;
    }
    public String[][] getChoices()
    {
        return choices;
    }

    public void setCorrectAnswers(String[] correctAnswers){
        this.correctAnswers = correctAnswers;
    }

    public String[] getCorrectAnswers()
    {
        return correctAnswers;
    }
}

package com.modo.assignment1.mockups;

public class TnFQuestion {
    private String question;
    private boolean answer ;
    public TnFQuestion(){
    }

    public TnFQuestion(String question, boolean answer){
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public boolean getAnswer() {
        return answer;
    }
}

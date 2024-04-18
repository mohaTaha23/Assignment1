package com.modo.assignment1.mockups;

import java.util.ArrayList;
import java.util.List;

public class MCQuestion {
    private String question;
    private String answer;
    private List<String> options = new ArrayList<String>();

    public MCQuestion() {
    }
    public MCQuestion(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
    public MCQuestion(String question, String answer, String op1,String op2,String op3) {
        this.question = question;
        this.answer = answer;
        options.add(op1);
        options.add(op2);
        options.add(op3);
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public List getOptions() {
        return options;
    }

    public void setOptions(List options) {
        this.options = options;
    }
}

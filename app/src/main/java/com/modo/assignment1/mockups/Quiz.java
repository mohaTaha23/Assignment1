package com.modo.assignment1.mockups;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private String title;
    private List questions = new ArrayList<Object>();

    public Quiz(){
    }
    public Quiz(boolean done,String title){
        this.title = title;
        fillQuiz();
    }

    private void fillQuiz() {
        MCQuestion question = new MCQuestion("What is milk color","white","color","water","red");
        MCQuestion question2 = new MCQuestion("Choose the correct answer","the correct answer","false answer","not an answer","answer");
        TnFQuestion tnFQuestion = new TnFQuestion("click true",true);
        TnFQuestion tnFQuestion1 = new TnFQuestion("opposite of false is: ",true);
        questions.add(question);
        questions.add(question2);
        questions.add(tnFQuestion);
        questions.add(tnFQuestion1);
    }

    public List getQuestion() {
        return questions;
    }
    public String toString(){
        return title;
    }
}

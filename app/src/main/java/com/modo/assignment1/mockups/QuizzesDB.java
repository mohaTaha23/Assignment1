package com.modo.assignment1.mockups;

import java.util.ArrayList;
import java.util.List;

public class QuizzesDB {
    List<Quiz> list = new ArrayList<>();
    public QuizzesDB(){

    }
    public QuizzesDB(boolean fill){
        Quiz quiz = new Quiz(true,"default");
        Quiz quiz1 = new Quiz(true,"default hard");

        list.add(quiz);
        list.add(quiz1);
    }

    public List<Quiz> getList() {
        return list;
    }
}

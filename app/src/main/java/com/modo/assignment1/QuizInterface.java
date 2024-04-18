package com.modo.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.modo.assignment1.mockups.MCQuestion;
import com.modo.assignment1.mockups.Quiz;
import com.modo.assignment1.mockups.TnFQuestion;

public class QuizInterface extends AppCompatActivity {

    Quiz quiz;
    int counter =0;

    int score =0;

    Object question1;
    Object question2;

    TextView question1Number;
    TextView question1Text;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;

    TextView question2Number;
    TextView question2Text;
    RadioButton radioButton5;
    RadioButton radioButton6;
    RadioButton radioButton7;
    RadioButton radioButton8;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        quiz = new Quiz(true,"template");

        question1Number = findViewById(R.id.questionNumber);
        question1Text = findViewById(R.id.questionText);
        question2Number = findViewById(R.id.questionNumber2);
        question2Text = findViewById(R.id.questionText2);

        radioButton1 = findViewById(R.id.trueOP);
        radioButton2 = findViewById(R.id.falseOP);
        radioButton3 = findViewById(R.id.OPEX1);
        radioButton4 = findViewById(R.id.OPEX2);
        radioButton5 = findViewById(R.id.trueOP2);
        radioButton6 = findViewById(R.id.falseOP2);
        radioButton7 = findViewById(R.id.OPEX1_2);
        radioButton8 = findViewById(R.id.OPEX2_2);

        button = findViewById(R.id.button);

        startQuiz();
    }

    private void startQuiz() {
        if (counter+1==quiz.getQuestion().size()){
            fillQuestion(quiz.getQuestion().get(counter));
            button.setText("submit");
            button.setOnClickListener(e->{
                checkAnswer();
                System.out.println("score is:"+score);
                Intent intent = new Intent(QuizInterface.this, ResultInterface.class);
                intent.putExtra("result", score);
                startActivity(intent);
//                finish();
            });
        }
        else if (counter+2==quiz.getQuestion().size()) {
            fillQuestion(quiz.getQuestion().get(counter),quiz.getQuestion().get(counter+1));
            button.setText("submit");
            button.setOnClickListener(e->{
                checkAnswer();
                System.out.println("score is:"+score);
                Intent intent = new Intent(QuizInterface.this, ResultInterface.class);
                intent.putExtra("result", score);
                startActivity(intent);
//                finish();
            });
        }
        else {
            fillQuestion(quiz.getQuestion().get(counter),quiz.getQuestion().get(counter+1));
            counter+=2;
            button.setOnClickListener(e->{
                checkAnswer();
                startQuiz();
            });
        }
    }

    private void fillQuestion(Object o) {
        question1 =o;
        if (o instanceof MCQuestion){
            MCQuestion mcQuestion = (MCQuestion) o;
          question1Number.setText("Question"+(counter+1));
          question1Text.setText(mcQuestion.getQuestion());
          radioButton1.setText(mcQuestion.getOptions().get(0).toString());
          radioButton2.setText(mcQuestion.getOptions().get(1).toString());
          radioButton3.setText(mcQuestion.getOptions().get(2).toString());
          radioButton4.setText(mcQuestion.getAnswer());
            radioButton3.setVisibility(View.VISIBLE);radioButton4.setVisibility(View.VISIBLE);
        }
        else {
            TnFQuestion tnFQuestion = (TnFQuestion) o;
            question1Number.setText("Question"+(counter+1));
            question1Text.setText(tnFQuestion.getQuestion());
            radioButton1.setText("true");
            radioButton2.setText("false");
            radioButton3.setVisibility(View.GONE);
            radioButton4.setVisibility(View.GONE);
        }
    }
    private void fillQuestion(Object o,Object o2){
        fillQuestion(o);
        question2 = o2;
        if (o2 instanceof MCQuestion){
            MCQuestion mcQuestion = (MCQuestion) o2;
            question2Number.setText("Question"+(counter+2));
            question2Text.setText(mcQuestion.getQuestion());
            radioButton5.setText(mcQuestion.getOptions().get(0).toString());
            radioButton6.setText(mcQuestion.getOptions().get(1).toString());
            radioButton7.setText(mcQuestion.getOptions().get(2).toString());
            radioButton8.setText(mcQuestion.getAnswer());
            radioButton3.setVisibility(View.VISIBLE);radioButton4.setVisibility(View.VISIBLE);
        }
        else {
            TnFQuestion tnFQuestion = (TnFQuestion) o2;
            question2Number.setText("Question"+(counter+2));
            question2Text.setText(tnFQuestion.getQuestion());
            radioButton5.setText("true");
            radioButton6.setText("false");
            radioButton7.setVisibility(View.GONE);
            radioButton8.setVisibility(View.GONE);
        }
    }
    private void checkAnswer(){
        RadioGroup radioGroup = findViewById(R.id.GroupUp);
        int selectedId = radioGroup.getCheckedRadioButtonId();


        if (selectedId != -1) { // Check if any radio button is selected
            RadioButton selectedRadioButton = findViewById(selectedId);
            if (question1 instanceof MCQuestion){
                MCQuestion mcQuestion = (MCQuestion) question1;
                if (selectedRadioButton.getText().equals(mcQuestion.getAnswer())) score++;
            }
            else {
                TnFQuestion tnFQuestion = (TnFQuestion) question1;
                if (selectedRadioButton.getText().equals(tnFQuestion.getAnswer()+"")) score++;
            }
        }

        RadioGroup radioGroup2 = findViewById(R.id.GroupDown);
        int selectedId2 = radioGroup.getCheckedRadioButtonId();


        if (selectedId2 != -1) { // Check if any radio button is selected
            RadioButton selectedRadioButton = findViewById(selectedId2);
            if (question2 instanceof MCQuestion){
                MCQuestion mcQuestion = (MCQuestion) question2;
                if ((selectedRadioButton.getText()).toString().trim().equals(mcQuestion.getAnswer())) score++;
            }
            else {
                TnFQuestion tnFQuestion = (TnFQuestion) question2;
                if (selectedRadioButton.getText().equals(tnFQuestion.getAnswer()+"")) score++;
            }
        }
    }
}
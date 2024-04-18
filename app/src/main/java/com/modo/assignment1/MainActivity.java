package com.modo.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.modo.assignment1.mockups.Quiz;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView ;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main); // Set content view first
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listView = findViewById(R.id.QuizesList);
        fillList();
    }
    private void fillList(){
        listView = findViewById(R.id.QuizesList);
        TextView textView = findViewById(R.id.textView);
        Quiz quiz = new Quiz(true,"Easy quiz");
        Quiz quiz1 = new Quiz(true,"default hard");
        List arrayList = new ArrayList<>();
        arrayList.add(quiz);
        arrayList.add(quiz1);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Retrieve the selected quiz from the adapter
                System.out.println("hi");
                Quiz selectedQuiz = (Quiz) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, QuizInterface.class);
                intent.putExtra("quiz", selectedQuiz.toString());
                startActivity(intent);
            }
        });

    }
}
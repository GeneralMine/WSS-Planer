package ml.metalogie.generalmine.wss_planner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class grades extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);

        String test = "test";
        List subjects = Collections.synchronizedList(new ArrayList());
        subjects.add(0, test);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_grades_subject);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, subjects);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


    }

    @Override
    protected void onResume() {
        super.onResume();
        LoadSubjects();
    }


    private void LoadSubjects() {           //Subjects die in grades_settings festgelegt werden in den Spinner laden



    }

    public void Settings(View view) {
        Intent intent = new Intent(this, grades_settings.class);     //  Startet bei Knopfdruck "grades_settings" activity
        startActivity(intent);
    }

}

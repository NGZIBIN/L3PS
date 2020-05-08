package com.example.l3ps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AddGrade extends AppCompatActivity {
Button btnSubmit;
RadioGroup rg;
TextView tvWeek;
int week = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grade);

        btnSubmit = findViewById(R.id.btnSubmit);
        tvWeek = findViewById(R.id.tvWeek);
        rg = findViewById(R.id.rgGrade);

        Intent i = getIntent();
        week = i.getIntExtra("week",0);
        week += 1;
        tvWeek.setText("week " + week);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String grade = "";
                int selectedButtonID = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) rg.getChildAt(rg.indexOfChild(rg.findViewById(rg.getCheckedRadioButtonId())));

                Add newMG = new Add("C347", rb.getText().toString(), week);
                Intent i = new Intent();
                i.putExtra("MG", newMG);
                // Set result to RESULT_OK to indicate normal			// response and pass in the intent containing the 		// like
                setResult(RESULT_OK, i);
                finish();

            }
        });


    }
}

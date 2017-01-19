package com.example.assessment_1221;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected  void onResume(){
        super.onResume();
       getFragmentManager().beginTransaction().replace(R.id.activity_main, new AnimalFragment()).commit();
    }
}

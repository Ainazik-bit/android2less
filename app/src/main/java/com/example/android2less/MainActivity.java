package com.example.android2less;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String KLUCH =  "kluch";
    EditText number1, number2, number3;
    TextView rezultat;
    Button knopcake;

    int firstValue, secondValue, thirdValue, result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1= findViewById(R.id.firstEdit);
        number2= findViewById(R.id.secondEdit);
        number3= findViewById(R.id.thirdEdit);
        rezultat= findViewById(R.id.result);
        knopcake= findViewById(R.id.knopka);



        getValue();
        action();
    }

    private void getValue() {

    }

    private void action() {
        knopcake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstValue = Integer.parseInt(number1.getText().toString());
                secondValue = Integer.parseInt(number2.getText().toString());
                thirdValue = Integer.parseInt(number3.getText().toString());
                result=(firstValue+secondValue)/thirdValue;
                rezultat.setText("Результат "+result);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KLUCH,result);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        rezultat.setText("Результат "+savedInstanceState.getInt(KLUCH));
    }
}
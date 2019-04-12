package com.sanjay.numbertofigure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity{

    EditText Number;
    TextView Figure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Number = findViewById(R.id.txtNumber);
        Figure = findViewById(R.id.numberInFigure);

        TextWatcher fieldValidatorTextWatcher = new TextWatcher()
        {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if( filterLongEnough() ){
                    int number = Integer.parseInt(Number.getText().toString());
                    Figure.setText(ToWorld.convert(number));
                }else{
                    Figure.setText("");
                }
            }

            private boolean filterLongEnough() {
                return Number.getText().toString().trim().length() > 0;
            }
        };
        Number.addTextChangedListener(fieldValidatorTextWatcher);
    }

}
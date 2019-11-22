package com.example.myapplication2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button b1;
    EditText ed1, ed2;
    Boolean bool1;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b1 = (Button) findViewById(R.id.convert);
        ed1 = (EditText) findViewById(R.id.fromCurrencyEt);
        ed2 = (EditText) findViewById(R.id.toCurrencyEt);

        ed1.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ed1.hasFocus()) {
                    bool1 = true;
                    convert();
                }
            }

            //...
        });

        ed2.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ed2.hasFocus()) {
                    bool1 = false;
                    convert();
                }
            }

            //...
        });



    }


    public void calculate(View v) {

        convert();
    }

    private void convert() {
        if (bool1 == true) {
            if (!ed1.getText().equals("") && ed1.getText() != null) {
                Double value1 = Double.parseDouble(ed1.getText().toString());
                Double calculatedValue = (0.75 * value1);
                ed2.setText(calculatedValue.toString());
            }

        } else {
            if (!ed1.getText().equals("") && ed1.getText() != null) {
                Double value2 = Double.parseDouble(ed2.getText().toString());
                Double calculatedValue2 = (1.75 * value2);
                ed1.setText(calculatedValue2.toString());
            }

        }
    }


    public void alert(String msg) {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage(msg);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();

    }
}

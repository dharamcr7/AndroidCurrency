package com.example.myapplication2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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

public class Main2Activity extends AppCompatActivity {

    Button b1;
    EditText ed1, ed2;

    private TextWatcher textWatcher = null;

    boolean chk = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        b1 = (Button) findViewById(R.id.convert);

        ed1 = (EditText) findViewById(R.id.fromCurrencyEt);
        ed2 = (EditText) findViewById(R.id.toCurrencyEt);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculate();


            }
        });

        ed1.setOnTouchListener(new View.OnTouchListener()
        {
            public boolean onTouch(View arg0, MotionEvent arg1)
            {
                chk = true;
                ed1.addTextChangedListener(textWatcher);

                return false;
            }
        });

        ed2.setOnTouchListener(new View.OnTouchListener()
        {
            public boolean onTouch(View arg0, MotionEvent arg1)
            {
                chk = false;
                ed2.addTextChangedListener(textWatcher);
                return false;
            }
        });


        textWatcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //calculate();
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculate();
            }

            @Override
            public void afterTextChanged(Editable s) {

                // calculate();
            }
        };

        ed1.addTextChangedListener(textWatcher);
        ed2.addTextChangedListener(textWatcher);



    }


    public void calculate() {
        try {
            if(chk){
                if (!ed1.getText().toString().equals("") && ed1.getText() != null) {
                    Double value1 = Double.parseDouble(ed1.getText().toString());

                    Double calculatedValue = (0.75 * value1);
                    ed2.removeTextChangedListener(textWatcher);
                    ed2.setText(calculatedValue.toString());

                }
            } else if(!chk){
                if (!ed2.getText().toString().equals("") && ed2.getText() != null) {
                    Double value2 = Double.parseDouble(ed2.getText().toString());


                    Double calculatedValue2 = (1.75 * value2);
                    ed1.removeTextChangedListener(textWatcher);
                    ed1.setText(calculatedValue2.toString());

                }
            }

        }catch (Exception e){
            alert(e.toString());
        }
    }




    public void but(View v) {
        Toast.makeText(this, "jatt", Toast.LENGTH_SHORT).show();
        alert("");
    }


    public void alert(String  messah) {
        AlertDialog alertDialog = new AlertDialog.Builder(Main2Activity.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage(messah);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();

    }
}

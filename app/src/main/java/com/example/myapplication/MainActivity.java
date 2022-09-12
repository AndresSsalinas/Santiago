package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btn_FAc;
    private Button btn_FI;

    private TextView text_respuesta;
    private TextView text_respuesta2;

    private EditText edit_numero_uno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_respuesta = findViewById(R.id.Fibonacci);
        text_respuesta2 = findViewById(R.id.Factorial);

        edit_numero_uno = findViewById(R.id.Dato);

        btn_FI = findViewById(R.id.buttonFib);
        btn_FI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_respuesta.setText( fibo( Integer.parseInt(edit_numero_uno.getText().toString()))+"");
            }
        });

        btn_FAc = findViewById(R.id.buttonFac);
        btn_FAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_respuesta2.setText( Fac( Integer.parseInt(edit_numero_uno.getText().toString()))+"");

            }
        });

    }

    public String fibo (int a){
        String text ="";
        ArrayList<BigInteger> fib = new ArrayList<>();
        BigInteger first = new BigInteger("0");
        BigInteger second = new BigInteger("1");
        fib.add(first);
        fib.add(second);
        for(int i = 1;i<a;i++){
            fib.add(fib.get(i).add(fib.get(i-1)));
        }

        for(int i = 1;i<=a;i++){
           text = text + i + ". " + fib.get(i) + "\n";
        }
        return text;
    }

    public String Fac (int a){
        int factorial = 1;
        String text ="";

        for (int i=a;i>0;i--) {
            factorial=factorial*i;
        }
        text= ""+ factorial;
        return text;
    }
}

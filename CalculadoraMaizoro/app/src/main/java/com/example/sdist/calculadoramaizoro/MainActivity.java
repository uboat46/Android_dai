package com.example.sdist.calculadoramaizoro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText op1,op2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        op1 = (EditText)findViewById(R.id.editText);
        op2 = (EditText)findViewById(R.id.editText2);
    }

    public void suma(View view) {
        double res;
        if( !op1.getText().toString().equalsIgnoreCase("") && !op2.getText().toString().equalsIgnoreCase("") )
        {
            double a = Double.parseDouble(op1.getText().toString());
            double b = Double.parseDouble(op2.getText().toString());

            res = a + b;
        }
        else
        {
            res = 0;
        }

        mostrar(res);
    }

    public void resta(View view) {
        double res;
        if( !op1.getText().toString().equalsIgnoreCase("") && !op2.getText().toString().equalsIgnoreCase("") )
        {
            double a = Double.parseDouble(op1.getText().toString());
            double b = Double.parseDouble(op2.getText().toString());

            res = a - b;
        }
        else
        {
            res = 0;
        }

        mostrar(res);
    }

    public void multiplica(View view) {
        double res;
        if( !op1.getText().toString().equalsIgnoreCase("") && !op2.getText().toString().equalsIgnoreCase("") )
        {
            double a = Double.parseDouble(op1.getText().toString());
            double b = Double.parseDouble(op2.getText().toString());

            res = a * b;
        }
        else
        {
            res = 0;
        }

        mostrar(res);
    }

    public void divide(View view) {
        double res;
        if( !op1.getText().toString().equalsIgnoreCase("") && !op2.getText().toString().equalsIgnoreCase("") )
        {
            double a = Double.parseDouble(op1.getText().toString());
            double b = Double.parseDouble(op2.getText().toString());

            if ( b != 0)
                res = a / b;
            else
                res = 0;
        }
        else
        {
            res = 0;
        }

        mostrar(res);
    }

    public void potencia(View view) {
        double res;
        if( !op1.getText().toString().equalsIgnoreCase("") && !op2.getText().toString().equalsIgnoreCase("") )
        {
            double a = Double.parseDouble(op1.getText().toString());
            double b = Double.parseDouble(op2.getText().toString());

            if ( b != 0)
                res = Math.pow(a,b);
            else
                res = 0;
        }
        else
        {
            res = 0;
        }

        mostrar(res);
    }

    private void mostrar(double res){
        Toast.makeText(this,"El resultado es: " + res, Toast.LENGTH_SHORT).show();
    }

    public void clear(View view) {
        op1.setText("");
        op2.setText("");
    }


}

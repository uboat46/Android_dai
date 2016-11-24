package com.example.sdist.hellopersona;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView saludo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        saludo = (TextView)findViewById(R.id.textView2);
        Bundle bundle = this.getIntent().getExtras();
        saludo.setText("Hola" + bundle.getString("nombre"));
    }
}

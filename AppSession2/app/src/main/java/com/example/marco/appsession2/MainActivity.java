package com.example.marco.appsession2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    private EditText edt_usuario, edt_contraseña;
    private Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_usuario = (EditText)findViewById(R.id.edt_usuario);
        edt_contraseña = (EditText)findViewById(R.id.edt_contraseña);
        btn1 = (Button)findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn1= new Intent(MainActivity.this, Main2Activity.class);
                startActivity(btn1);
            }
        });



    }


}

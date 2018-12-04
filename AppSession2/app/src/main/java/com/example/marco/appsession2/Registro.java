package com.example.marco.appsession2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.AccessToken;

public class Registro extends AppCompatActivity {

    private EditText user, pass;
    private Button btnGuardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        user = (EditText) findViewById(R.id.txtUserReg);
        pass = (EditText) findViewById(R.id.txtPassReg);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);


    }

    public void GuardarNuevoUsuario(View view){
        DbHelper admin = new DbHelper(this, "comercio", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

         String usuario = user.getText().toString();
         String contrasena = pass.getText().toString();
         db.execSQL("INSERT INTO usuarios (usuario,contrasena)  VALUES (usuario,contrasena)");
            Toast.makeText(getApplicationContext(),"Insert Correctamente: ",Toast.LENGTH_SHORT).show();
    }


}

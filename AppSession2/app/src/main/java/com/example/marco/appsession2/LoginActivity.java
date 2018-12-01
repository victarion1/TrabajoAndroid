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

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class LoginActivity extends AppCompatActivity {

    //--------.Creacion de Variables-----------------//
    private EditText edt_usuario, edt_contraseña;
    private Button btn1, btn_registro;
    private LoginButton login_button;
    private Cursor fila;
    private CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

    //-----------Emparejamiento variables locales con XML--//
        callbackManager = CallbackManager.Factory.create();
        edt_usuario = (EditText) findViewById(R.id.edt_usuario);
        edt_contraseña = (EditText) findViewById(R.id.edt_contraseña);
        btn1 = (Button) findViewById(R.id.btn1);
        login_button = (LoginButton) findViewById(R.id.login_button);
        btn_registro = (Button) findViewById(R.id.btn_registrar);
    //-----------------------------------------------------//

    //----------Inicio con Facebook------------------------//
    login_button.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            goMainScreen();
        }

        @Override
        public void onCancel() {
            Toast.makeText(getApplicationContext(), R.string.cancel_login, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(FacebookException error) {
            Toast.makeText(getApplicationContext(), R.string.error_login, Toast.LENGTH_SHORT).show();
        }
    });
           }//----------------------------------------------------//

    //-----------Metodo Ingreso---------------------------//
    public void Ingreso(View view) {
        DbHelper admin = new DbHelper(this, "comercio", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String usuario = edt_usuario.getText().toString();
        String contrasena = edt_contraseña.getText().toString();
        fila = db.rawQuery("SELECT usuario,contrasena FROM usuarios WHERE  usuario='" + usuario + "' and contrasena='" + contrasena + "'", null);

        //----Si el cursor esa vacio-----------------//
        if (fila.moveToFirst() == true) {

            //----Se capturan los valores  del cursor y se almacenan en variables---//
            String user = fila.getString(0);
            String pass = fila.getString(1);

            //----Se preguntan si los datos ingresados son iguales---//
            if (usuario.equals(user) && contrasena.equals(pass)) {

                //----Si son iguales se pasa a otra ventana---/
                Toast.makeText(getApplicationContext(),"Bienvenido: "+user,Toast.LENGTH_SHORT).show();
                Intent v = new Intent(this, MainActivity.class);
                startActivity(v);
                edt_usuario.setText("");
                edt_contraseña.setText("");
            }
        }else{
            Toast.makeText(getApplicationContext(),"Usuario o Contraseña incorrectos",Toast.LENGTH_SHORT).show();
        }

    }
    //-----------------Metodo para redirigir a Main------------//
    public void goMainScreen(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }//--------------------------------------------------------//

    //----------------Metodo Resultado-------------------------//
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }



}
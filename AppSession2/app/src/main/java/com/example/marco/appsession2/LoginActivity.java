package com.example.marco.appsession2;

import android.content.Intent;
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


    private EditText edt_usuario, edt_contraseña;
    private Button btn1;
    private LoginButton login_button;
    private CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        callbackManager = CallbackManager.Factory.create();
//----------------------------------------------//
        edt_usuario = (EditText) findViewById(R.id.edt_usuario);
        edt_contraseña = (EditText) findViewById(R.id.edt_contraseña);
        btn1 = (Button) findViewById(R.id.btn1);
        login_button = (LoginButton) findViewById(R.id.login_button);
//---------------------------------------------//

        login_button.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {//En caso de login exitoso
                goMainScreen();

            }

            @Override
            public void onCancel() {//En caso de cancelar el login
                Toast.makeText(getApplicationContext(),R.string.cancel_login,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {//En caso de error de login
                Toast.makeText(getApplicationContext(),R.string.error_login,Toast.LENGTH_SHORT).show();
            }
        });
//---------------------------------------------//
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn1 = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(btn1);
            }


        });


    }

    private void goMainScreen() {
        Intent intent =new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    //---------------------------------------------//
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
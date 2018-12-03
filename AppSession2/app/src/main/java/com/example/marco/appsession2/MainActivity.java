package com.example.marco.appsession2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    private void goLoginScreen() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }


    public void logout(View view) {
        LoginManager.getInstance().logOut();
        Toast.makeText(getApplicationContext(),R.string.login_out,Toast.LENGTH_SHORT).show();
        goLoginScreen();
    }

    public void salir(View view){
        finish();
    }
}

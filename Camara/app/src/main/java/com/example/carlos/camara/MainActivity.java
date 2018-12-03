package com.example.carlos.camara;

import android.app.Activity;
import android.graphics.Bitmap;
import android.hardware.camera2.CameraManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  {

    Button btn;
    ImageView imagen;
    Intent i;
    final static int cons =0;
    Bitmap bmp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btnFoto);
        imagen = (ImageView) findViewById(R.id.imageView);

        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Prueba", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,cons);
            }
        });
    }

//    @Override
//    public void onClick(View v) {
//
//        int id= v.getId();
//        switch (id)
//        {
//            case R.id.btnFoto:
//                i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(i,cons);
//                break;
//        }
//
//    }

//    public void init()
//    {
//        btn = (Button)findViewById(R.id.btnFoto);
//        btn.setOnClickListener(this);
//        imagen = (ImageView)findViewById(R.id.imageView);
//
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode== Activity.RESULT_OK) {
            Bundle ext = data.getExtras();
            bmp =(Bitmap)ext.get("data");
            imagen.setImageBitmap(bmp);
        }
    }
}

package com.example.marco.appsession2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

public class Camara {
    Button btn;
    ImageView imagen;
    Intent i;

    Bitmap bmp;



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

}

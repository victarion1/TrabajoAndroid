package com.example.marco.app_baseproyecto;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp1=(Spinner)findViewById(R.id.spinner);
        cargarSpinner();
    }

    public void Insertar(View view){
        dbHelper baseHelper= new dbHelper(this,"gastos",null,1);
        SQLiteDatabase db = baseHelper.getWritableDatabase();

        if(db !=null){
            Toast.makeText(this,"Base de datos creada",Toast.LENGTH_SHORT).show();
            //insertar..

            int indice = sp1.getSelectedItemPosition()+1;
            String item = sp1.getSelectedItem().toString();
            //captura el monto, descripcion, fecha...
            //hacer el insert
            Toast.makeText(this,"Indice item"+indice+"Nombre item"+item,Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Error en la base de datos...",Toast.LENGTH_SHORT).show();
        }
    }

    public void cargarSpinner(){
        dbHelper baseHelper =  new dbHelper(this,"gastos", null,1);
        SQLiteDatabase db = baseHelper.getReadableDatabase();
        String query = "SELECT * FROM tblItem";
        Cursor c =  db.rawQuery(query, null);
        int nfilas = c.getCount();
        int indice = 0;
        String[] arreglo = new String[nfilas];
        if(c.moveToFirst())
        {
            do{
                String item = c.getString(0)+" "+c.getString(1);
                arreglo[indice] = item;
                indice++;
            }while(c.moveToNext());
        }

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arreglo);
        sp1.setAdapter(adaptador);
    }

    public void btnListar(View view)
    {
        Intent intent = new Intent( this, Listar.class);
        startActivity(intent);
    }



}

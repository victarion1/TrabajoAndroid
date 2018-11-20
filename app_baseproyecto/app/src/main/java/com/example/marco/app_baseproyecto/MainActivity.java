package com.example.marco.app_baseproyecto;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner sp1;
    private EditText edt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp1 = (Spinner) findViewById(R.id.spinner);
        edt1 = (EditText) findViewById(R.id.editText3);
        cargarSpinner();
    }

    public void Insertar(View view) {
        if (edt1.getText().toString().trim().equalsIgnoreCase("")) {
            edt1.setError("Debe ingresar al menos un registro de gasto");

        } else {
            String var1 = sp1.getSelectedItem().toString();
            int var2 = Integer.parseInt(edt1.getText().toString());

            //insercion de datos en la base de datos.
            dbHelper baseHelper = new dbHelper(this, "gastos", null, 1);
            SQLiteDatabase db = baseHelper.getWritableDatabase();

            if(db !=null){
                ContentValues objCV = new ContentValues();
                objCV.put("columna1",var1);
                objCV.put("columna2",var2);

                //numero de filas insertadas.

                long finsertadas = db.insert("tbl_dato",null,objCV);
                if (finsertadas >0){
                    Toast.makeText(this,"Registro exitoso",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this,"Error al insertar",Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this,"Error en la base de datos.",Toast.LENGTH_SHORT).show();
            }


        }
    }

    public void EnviarListar(View view){
        Intent intent = new Intent(this,Listar.class);
        startActivity(intent);
    }

    public void cargarSpinner() {
        dbHelper baseHelper = new dbHelper(this, "gastos", null, 1);
        SQLiteDatabase db = baseHelper.getReadableDatabase();
        String query = "SELECT * FROM tblItem";
        Cursor c = db.rawQuery(query, null);
        int nfilas = c.getCount();
        int indice = 0;
        String[] arreglo = new String[nfilas];
        if (c.moveToFirst()) {
            do {
                String item = c.getString(0) + " " + c.getString(1);
                arreglo[indice] = item;
                indice++;
            } while (c.moveToNext());
        }

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arreglo);
        sp1.setAdapter(adaptador);
    }

    public void btnListar(View view) {
        Intent intent = new Intent(this, Listar.class);
        startActivity(intent);
    }


}

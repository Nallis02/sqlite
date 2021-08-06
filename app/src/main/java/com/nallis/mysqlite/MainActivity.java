package com.nallis.mysqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /*
    public void registrar (View view){
        this.abrirBD();

        String id = et_id.getText().toString();
        String nombre = et_nombre.getText().toString();
        String telefono = et_telefono.getText().toString();

        if(!id.isEmpty() && !nombre.isEmpty() && !telefono.isEmpty()){
            ContentValues cv = new ContentValues();
            cv.put(Utilidades.CAMPO_ID, id);
            cv.put(Utilidades.CAMPO_NOMBRE, nombre);
            cv.put(Utilidades.CAMPO_TELEFONO, telefono);

            base_datos.insert(Utilidades.TABLA_USUARIO, null, cv);
            base_datos.close();

            this.limpiarCampos();
            Toast.makeText(this, "El usuario ha sido resgistrado", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Llena todos los campos ", Toast.LENGTH_SHORT).show();
        }
    }
    public  void consultar (View view){
        this.abrirBD();
        String id = et_id.getText().toString();

        if (!id.isEmpty()){
            Cursor cursor = base_datos.rawQuery("SELECT * FROM " +
                    Utilidades.TABLA_USUARIO + " WHERE " +
                    Utilidades.CAMPO_ID + " = " + id, null);

            if (cursor.moveToFirst()){
                et_nombre.setText(cursor.getString(1));
                et_telefono.setText(cursor.getString(2));

                base_datos.close();
            }else {
                Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "Escribe el id del usuario ", Toast.LENGTH_SHORT).show();
        }
    }

    //metodo para eliminar usuario
    public void eliminar(View view) {
        this.abrirBD();

        String id = et_id.getText().toString();

        if (!id.isEmpty()) {
            int cantidad =base_datos.delete(Utilidades.TABLA_USUARIO,
                    Utilidades.CAMPO_ID +  " = " + id, null);
                if (cantidad == 1){
                    this.limpiarCampos();
                    Toast.makeText(this, "Usuario fue eliminado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
                }
                base_datos.close();
        }else{
            Toast.makeText(this, "Escribe el id del usuario", Toast.LENGTH_SHORT).show();
        }
    }*/


    public void goToRegistro(View view){
        Intent intent = new Intent(this, RegistroUsuario.class);
        startActivity(intent);
    }
    public void goToConsulta(View view){
        Intent intent = new Intent(this, ConsultarUsuario.class);
        startActivity(intent);
    }
    public void goToEliminar(View view){
        Intent intent = new Intent(this, EliminarUsuario.class);
        startActivity(intent);
    }
}
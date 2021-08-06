package com.nallis.mysqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroUsuario extends AppCompatActivity {

    private EditText et_id, et_nombre, et_telefono;
    MySQLiteOpenHelper conexion;
    SQLiteDatabase base_datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        et_id = (EditText)findViewById(R.id.text_id);
        et_nombre = (EditText)findViewById(R.id.txt_nombre);
        et_telefono = (EditText)findViewById(R.id.txt_telefono);
    }
    private void abrirBD() {
        conexion = new MySQLiteOpenHelper(this, "bd_usuarios", null, 1);
        base_datos = conexion.getWritableDatabase();
    }
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
    private void limpiarCampos() {
        et_id.setText("");
        et_nombre.setText("");
        et_telefono.setText("");
    }
    public void goToInicio(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
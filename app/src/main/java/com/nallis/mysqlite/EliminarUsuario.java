package com.nallis.mysqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EliminarUsuario extends AppCompatActivity {

    private EditText et_id, et_nombre, et_telefono;
    MySQLiteOpenHelper conexion;
    SQLiteDatabase base_datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_usuario);

        et_id = (EditText)findViewById(R.id.text_id);
        et_nombre = (EditText)findViewById(R.id.txt_nombre);
        et_telefono = (EditText)findViewById(R.id.txt_telefono);
    }
    private void abrirBD() {
        conexion = new MySQLiteOpenHelper(this, "bd_usuarios", null, 1);
        base_datos = conexion.getWritableDatabase();
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
package com.nallis.mysqlite;

public class Utilidades  {
    public static final String TABLA_USUARIO = "Usuario";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE= "Nombre";
    public static final String CAMPO_TELEFONO= "Telefono";
    public static final String CREAR_TABLA_USUARIO=
            "CREATE TABLE " + TABLA_USUARIO + "(" + CAMPO_ID + " INTEGER PRIMARY KEY, " +
                    CAMPO_NOMBRE + " TEXT, " + CAMPO_TELEFONO + " TEXT) ";

}

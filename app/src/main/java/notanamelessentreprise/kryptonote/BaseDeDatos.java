package notanamelessentreprise.kryptonote;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Valeria on 23/03/2017.
 */

public class BaseDeDatos extends SQLiteOpenHelper {

    public static final String NOMBREBD = "base_de_datos.db";

    //Versión de la base de datos
    //   public static final int VERSION = 1;

    public BaseDeDatos(Context context, int VERSION) {
        super(context, NOMBREBD, null, VERSION);
    }

    //Método utilizado cuando se crea la base de datos.
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + NotaContract.NotaEntry.TABLE_NAME + " ("
                + NotaContract.NotaEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NotaContract.NotaEntry.TITLE + " TEXT NOT NULL,"
                + NotaContract.NotaEntry.NOTE + " TEXT NOT NULL,"
                + NotaContract.NotaEntry.ENCRYPTITLE + " TEXT NOT NULL,"
                + NotaContract.NotaEntry.ENCRYPNOTE + " TEXT NOT NULL,"
                + NotaContract.NotaEntry.PASSWORD + " TEXT NOT NULL)");


        // Contenedor de valores
        ContentValues values = new ContentValues();

        // Pares clave-valor
        values.put(NotaContract.NotaEntry.TITLE, "Prueba");
        values.put(NotaContract.NotaEntry.NOTE, "Esta nota es una prueba");
        values.put(NotaContract.NotaEntry.ENCRYPTITLE, "abeurp");
        values.put(NotaContract.NotaEntry.ENCRYPNOTE, "abeurp anu se aton atse");
        values.put(NotaContract.NotaEntry.PASSWORD, "111");


        // Insertar...
        db.insert(NotaContract.NotaEntry.TABLE_NAME, null, values);

/*

        //TODO agregar tabla productos Vale
        db.execSQL("CREATE TABLE " + IngredienteContract.IngredienteEntry.TABLE_NAME + " ("
                + IngredienteContract.IngredienteEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + IngredienteContract.IngredienteEntry.NAME + " TEXT NOT NULL,"
                + IngredienteContract.IngredienteEntry.PRECIO + " TEXT NOT NULL,"
                + IngredienteContract.IngredienteEntry.IMAGEN + " TEXT)");


        //TODO agregar productos al menos 5 Todos
        ContentValues panTradSup=new ContentValues();
        panTradSup.put("nombre","Tradicional");
        panTradSup.put("precio",0.5);
        panTradSup.put("imagen", R.drawable.pan_tradicional_superior);
        db.insert("ingredientes",null,panTradSup);

        ContentValues panSinSemSup=new ContentValues();
        panSinSemSup.put("nombre","Sin Semillas");
        panSinSemSup.put("precio",1);
        panSinSemSup.put("imagen", R.drawable.pan_sinsemilla_superior);
        db.insert("ingredientes",null,panSinSemSup);

        ContentValues panCroSup=new ContentValues();
        panCroSup.put("nombre","Croissant");
        panCroSup.put("precio",1);
        panCroSup.put("imagen", R.drawable.pan_croissant_superior);
        db.insert("ingredientes",null,panCroSup);

        ContentValues panIntSup=new ContentValues();
        panIntSup.put("nombre","Integral");
        panIntSup.put("precio",1);
        panIntSup.put("imagen", R.drawable.pan_integral_superior);
        db.insert("ingredientes",null,panIntSup);

        ContentValues panTostSup=new ContentValues();
        panTostSup.put("nombre","Tostado");
        panTostSup.put("precio",1);
        panTostSup.put("imagen", R.drawable.pan_tostadas_superior);
        db.insert("ingredientes",null,panTostSup);

        ContentValues panMarrSup=new ContentValues();
        panMarrSup.put("nombre","Marraqueta");
        panMarrSup.put("precio",0.5);
        panMarrSup.put("imagen", R.drawable.pan_marraqueta_superior);
        db.insert("ingredientes",null,panMarrSup);
*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long guardarNota(Nota nota) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                NotaContract.NotaEntry.TABLE_NAME,
                null,
                nota.toContentValues());

    }

/*
    public long agregarIngrediente(Ingrediente usuario) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                UsuariosContract.UsuarioEntry.TABLE_NAME,
                null,
                ingrediente.toContentValues());

    }*/
}


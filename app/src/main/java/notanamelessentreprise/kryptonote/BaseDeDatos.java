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
                + NotaContract.NotaEntry._ID + " INTEGER PRIMARY KEY,"
                + NotaContract.NotaEntry.TITLE + " TEXT NOT NULL,"
                + NotaContract.NotaEntry.NOTE + " TEXT NOT NULL,"
                + NotaContract.NotaEntry.ENCRYPTITLE + " TEXT NOT NULL,"
                + NotaContract.NotaEntry.ENCRYPNOTE + " TEXT NOT NULL,"
                + NotaContract.NotaEntry.PASSWORD + " TEXT NOT NULL)");


        // Contenedor de valores
        ContentValues values = new ContentValues();

        // Pares clave-valor
        values.put(NotaContract.NotaEntry._ID, 0);
        values.put(NotaContract.NotaEntry.TITLE, "Prueba");
        values.put(NotaContract.NotaEntry.NOTE, "Esta nota es una prueba");
        values.put(NotaContract.NotaEntry.ENCRYPTITLE, "abeurp");
        values.put(NotaContract.NotaEntry.ENCRYPNOTE, "abeurp anu se aton atse");
        values.put(NotaContract.NotaEntry.PASSWORD, "111");


        // Insertar...
        db.insert(NotaContract.NotaEntry.TABLE_NAME, null, values);

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

    public long actualizarNota(Nota nota) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.update(
                NotaContract.NotaEntry.TABLE_NAME,
                nota.toContentValuesSinId(), "id="+nota.getId(), null);

    }

    public long actualizarId(int idAnt, int idNuevo) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NotaContract.NotaEntry._ID,idNuevo);

        return sqLiteDatabase.update(
                NotaContract.NotaEntry.TABLE_NAME, values
                , "id="+idAnt, null);

    }

    public long eliminarNota(int idNota) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.delete(
                NotaContract.NotaEntry.TABLE_NAME, "id="+idNota, null);

    }

}


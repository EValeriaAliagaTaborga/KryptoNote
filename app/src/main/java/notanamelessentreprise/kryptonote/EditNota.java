package notanamelessentreprise.kryptonote;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class EditNota extends AppCompatActivity {

    private Context context;

    private EditText txtTitulo;
    private EditText txtNota;
    private EditText txtContrasenia;

    private SQLiteDatabase db;
    public static final int VERSION = 1;
    private BaseDeDatos baseDeDatos;

    String[] datosNota = new String[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_nota);

        context = this;

        baseDeDatos = new BaseDeDatos(context,VERSION);
        db = baseDeDatos.getWritableDatabase();

        txtTitulo = (EditText) findViewById(R.id.txtTitulo);
        txtNota = (EditText) findViewById(R.id.txtCuerpo);
        txtContrasenia = (EditText) findViewById(R.id.txtPassword);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    //        menu.add(Menu.NONE, 1, Menu.NONE, "Guardar");
        getMenuInflater().inflate(R.menu.toolbar_editnote_guardar, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        //Toast.makeText(context,"Presiono guardar",Toast.LENGTH_SHORT).show();
        /*AlertDialog.Builder Dialogo = new AlertDialog.Builder(context);

        Dialogo.setTitle("Atención!");
        Dialogo.setMessage("¿Seguro que desea cerrar sesión?");
        Dialogo.show(); */

        datosNota[0] = txtTitulo.getText().toString();
        datosNota[1] = txtNota.getText().toString();
        datosNota[2] = txtTitulo.getText().toString();
        datosNota[3] = txtNota.getText().toString();
        datosNota[4] = txtContrasenia.getText().toString();

        Nota nota = new Nota(datosNota);
        baseDeDatos.guardarNota(nota);
        db.close();

        Toast.makeText(context,"guardado exitoso",Toast.LENGTH_SHORT).show();


        return super.onOptionsItemSelected(item);
//        return false;
    }

}


    /* Algo guardado creo .-.
    hola
    prueba nota
    111
     */

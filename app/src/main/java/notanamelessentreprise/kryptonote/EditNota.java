package notanamelessentreprise.kryptonote;

import android.app.Dialog;
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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditNota extends AppCompatActivity {

    private Context context;

    private EditText txtTitulo;
    private EditText txtNota;

    private SQLiteDatabase db;
    public static final int VERSION = 1;
    private BaseDeDatos baseDeDatos;

    private String[] datosNota = new String[5];
    private boolean existe = false;
    private String[] datosExistentes = new String[5];
    private int contID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_nota);

        context = this;

        baseDeDatos = new BaseDeDatos(context,VERSION);
        db = baseDeDatos.getWritableDatabase();

        txtTitulo = (EditText) findViewById(R.id.txtTitulo);
        txtNota = (EditText) findViewById(R.id.txtCuerpo);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent recibe = getIntent();
        existe = recibe.getBooleanExtra("existe",false);
        if(existe) {
            datosExistentes = recibe.getStringArrayExtra("datos_nota");
            txtTitulo.setText(datosExistentes[0]);
            txtNota.setText(datosExistentes[1]);
            contID = recibe.getIntExtra("contador_id",0);
        } else {
            contID = recibe.getIntExtra("contador_id",0);
            //Toast.makeText(context,contID+"",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    //        menu.add(MenuActivity.NONE, 1, MenuActivity.NONE, "Guardar");
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

        switch (item.getItemId()) {
            case android.R.id.home:
                //onBackPressed();
                Intent a=new Intent(context, MenuActivity.class);
                finish();
                startActivity(a);
            break;
            case R.id.btnllave:


                final Dialog dialogo = new Dialog(context);

                dialogo.setContentView(R.layout.guardar_nota);

                final EditText txtContrasenia = (EditText) dialogo.findViewById(R.id.txtPasswordInd);

                dialogo.setTitle("Clave individual");

                dialogo.setCancelable(false);
                dialogo.show();


                Button btnGuardar= (Button) dialogo.findViewById(R.id.btnGuardarContInd);
                btnGuardar.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialogo.dismiss();

                        datosNota[0] = txtTitulo.getText().toString();
                        datosNota[1] = txtNota.getText().toString();
                        datosNota[2] = txtTitulo.getText().toString();
                        datosNota[3] = txtNota.getText().toString();
                        datosNota[4] = txtContrasenia.getText().toString();

                        Nota nota = new Nota(datosNota, contID);
                        if(!existe) {
                            baseDeDatos.guardarNota(nota);
                        } else {
                            baseDeDatos.actualizarNota(nota);

                        }
                        db.close();

                        Toast.makeText(context,"guardado exitoso",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(context, MenuActivity.class);
                        finish();
                        startActivity(intent);

                    }
                });

                Button btnCancelar= (Button) dialogo.findViewById(R.id.btnCancel);
                btnCancelar.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialogo.dismiss();
                        Toast.makeText(context, "Aún no tienes clave y la nota no fue guardada",
                                Toast.LENGTH_SHORT).show();

                    }

                });

                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return false;
    }

}

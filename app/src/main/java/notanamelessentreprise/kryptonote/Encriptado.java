package notanamelessentreprise.kryptonote;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class Encriptado extends AppCompatActivity {

    private Context context;

    private TextView lblTitulo;
    private TextView lblNota;

    private boolean mostratEncriptado = true;
    private String contasenia;
    private String[] datos = new String[5];
    private String[] datosAux = new String[5];

    private static final int opcion1= 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;
    private static final int opcion4 = 4;

    private int contId = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encriptado);

        context = this;

        lblTitulo = (TextView) findViewById(R.id.lblMostrarTitulo);
        lblNota = (TextView) findViewById(R.id.lblMostrarNota);

        Intent recibe = getIntent();
        datos = recibe.getStringArrayExtra("datos_nota");
        datosAux = datos;
        mostratEncriptado = recibe.getBooleanExtra("estado",true);
        contId = recibe.getIntExtra("contador_id", 0);
        codificar(datos[2]);

        contasenia = datos[4];
        if(!mostratEncriptado) {
            lblTitulo.setText(datos[0]);
            lblNota.setText(datos[1]);
        } else {
            lblTitulo.setText(datos[2]);
            lblNota.setText(datos[3]);
        }

    }

    private void codificar(String dato) {
        //48-57, 65-90, 97-122
        String s = dato.replace(" ", "");
   //         String s1 = s.replace("[58|64]", "");
        char[] array = s.toCharArray();
        Arrays.sort(array);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(mostratEncriptado) {
            getMenuInflater().inflate(R.menu.toolbar_editnote_guardar, menu);
        } else {
            menu.add(android.view.Menu.NONE, opcion1, android.view.Menu.NONE, "Cerrar y codificar");
            menu.add(android.view.Menu.NONE, opcion2, android.view.Menu.NONE, "Editar");
            menu.add(android.view.Menu.NONE, opcion3, android.view.Menu.NONE, "Cambiar Clave");
            menu.add(android.view.Menu.NONE, opcion4, android.view.Menu.NONE, "Eliminar");
        }
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.btnllave:

                final Dialog dialogo = new Dialog(context);

                dialogo.setContentView(R.layout.desencriptar_nota);

                final EditText txtContrasenia = (EditText) dialogo.findViewById(R.id.txtClave);

                dialogo.setTitle("Decodificar la nota");

                dialogo.setCancelable(false);
                dialogo.show();


                Button btnHecho = (Button) dialogo.findViewById(R.id.btnHecho);
                btnHecho.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialogo.dismiss();

                        if(txtContrasenia.getText().toString().compareTo(contasenia) == 0) {
                            mostratEncriptado = false;
                            Intent intent = new Intent(context, Encriptado.class);
                            finish();
                            intent.putExtra("estado",mostratEncriptado);
                            intent.putExtra("datos_nota",datosAux);
                            intent.putExtra("contador_id", contId);
                            startActivity(intent);
                        } else {
                            mostratEncriptado = true;
                            Toast.makeText(context,"Clave incorrecta, por favor intente de nuevo.",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                Button btnCancelar= (Button) dialogo.findViewById(R.id.btnCancelar);
                btnCancelar.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialogo.dismiss();
                        Toast.makeText(context, "No ha seleccionado ninguna accion.",
                                Toast.LENGTH_SHORT).show();
                    }

                });

                break;
            case opcion1:
                mostratEncriptado = true;
                Intent i = new Intent(context, MenuActivity.class);
                finish();
                startActivity(i);
                break;
            case opcion2:
                Intent ed = new Intent(context, EditNota.class);
                finish();
                ed.putExtra("datos_nota",datos);
                ed.putExtra("existe",true);
                ed.putExtra("contador_id",contId);
                startActivity(ed);
                break;
            case opcion3:
                break;
            case opcion4:
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return false;
    }


}

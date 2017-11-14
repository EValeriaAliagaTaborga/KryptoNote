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
        String tituloCod = codificar(datos[2]);
        String notaCod = codificar(datos[3]);

        contasenia = datos[4];
        if(!mostratEncriptado) {
            lblTitulo.setText(datos[0]);
            lblNota.setText(datos[1]);
        } else {
            lblTitulo.setText(tituloCod);
            lblNota.setText(notaCod);
        }

    }

    private String codificar(String dato) {
        //48-57, 65-90, 97-122
        String s = dato.replace(" ", "");
   //         String s1 = s.replace("[58|64]", "");
        char[] array = s.toCharArray();
        Arrays.sort(array);
        String res = "";
        for(char c : array) {
            switch (c) {
                case 'A':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'B':
                    res += (char)37 + (char)240 + (char)211;
                    break;
                case 'C':
                    res += (char)125 + (char)164 + (char)222;
                    break;
                case 'D':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'E':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'F':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'G':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'H':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'I':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'J':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'K':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'L':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'M':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'N':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'O':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'P':
                    res += (char)167;
                    res += (char)96;
                    res += (char)183;
                    break;
                case 'Q':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'R':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'S':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'T':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'U':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'V':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'W':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'X':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'Y':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'Z':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'a':
                    res += (char)246 + (char)27 + (char)122;
                    break;
                case 'b':
                    res += (char)204 + (char)64 + (char)42;
                    break;
                case 'c':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'd':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'e':
                    res += (char)223 + (char)45 + (char)77;
                    break;
                case 'f':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'g':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'h':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'i':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'j':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'k':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'l':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'm':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'n':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'o':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'p':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'q':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'r':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 's':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 't':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'u':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'v':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'w':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'x':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'y':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case 'z':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case '0':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case '1':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case '2':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case '3':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case '4':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case '5':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case '6':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case '7':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case '8':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                case '9':
                    res += (char)48 + (char)200 + (char)183;
                    break;
                default:
                    res += c;
            }
        }
        return res;

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

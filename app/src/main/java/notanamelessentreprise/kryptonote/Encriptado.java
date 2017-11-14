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
                    res += (char)48;
                    res += (char)200;
                    res += (char)183;
                    break;
                case 'B':
                    res += (char)37;
                    res += (char)240;
                    res += (char)211;
                    break;
                case 'C':
                    res += (char)125;
                    res += (char)164;
                    res += (char)222;
                    break;
                case 'D':
                    res += (char)62;
                    res += (char)167;
                    res += (char)161;
                    break;
                case 'E':
                    res += (char)146;
                    res += (char)98;
                    res += (char)175;
                    break;
                case 'F':
                    res += (char)204;
                    res += (char)40;
                    res += (char)174;
                    break;
                case 'G':
                    res += (char)54;
                    res += (char)251;
                    res += (char)234;
                    break;
                case 'H':
                    res += (char)109;
                    res += (char)57;
                    res += (char)94;
                    break;
                case 'I':
                    res += (char)95;
                    res += (char)126;
                    res += (char)148;
                    break;
                case 'J':
                    res += (char)254;
                    res += (char)33;
                    res += (char)213;
                    break;
                case 'K':
                    res += (char)70;
                    res += (char)106;
                    res += (char)101;
                    break;
                case 'L':
                    res += (char)191;
                    res += (char)43;
                    res += (char)158;
                    break;
                case 'M':
                    res += (char)155;
                    res += (char)57;
                    res += (char)135;
                    break;
                case 'N':
                    res += (char)171;
                    res += (char)83;
                    res += (char)176;
                    break;
                case 'O':
                    res += (char)98;
                    res += (char)124;
                    res += (char)143;
                    break;
                case 'P':
                    res += (char)167;
                    res += (char)96;
                    res += (char)183;
                    break;
                case 'Q':
                    res += (char)39;
                    res += (char)202;
                    res += (char)160;
                    break;
                case 'R':
                    res += (char)34;
                    res += (char)180;
                    res += (char)132;
                    break;
                case 'S':
                    res += (char)47;
                    res += (char)95;
                    res += (char)59;
                    break;
                case 'T':
                    res += (char)75;
                    res += (char)128;
                    res += (char)119;
                    break;
                case 'U':
                    res += (char)209;
                    res += (char)50;
                    res += (char)174;
                    break;
                case 'V':
                    res += (char)55;
                    res += (char)190;
                    res += (char)159;
                    break;
                case 'W':
                    res += (char)178;
                    res += (char)38;
                    res += (char)129;
                    break;
                case 'X':
                    res += (char)241;
                    res += (char)32;
                    res += (char)185;
                    break;
                case 'Y':
                    res += (char)283;
                    res += (char)40;
                    res += (char)189;
                    break;
                case 'Z':
                    res += (char)111;
                    res += (char)39;
                    res += (char)60;
                    break;
                case 'a':
                    res += (char)246;
                    res += (char)27;
                    res += (char)122;
                    break;
                case 'b':
                    res += (char)204;
                    res += (char)64;
                    res += (char)42;
                    break;
                case 'c':
                    res += (char)232;
                    res += (char)58;
                    res += (char)75;
                    break;
                case 'd':
                    res += (char)207;
                    res += (char)74;
                    res += (char)33;
                    break;
                case 'e':
                    res += (char)223;
                    res += (char)45;
                    res += (char)77;
                    break;
                case 'f':
                    res += (char)178;
                    res += (char)32;
                    res += (char)44;
                    break;
                case 'g':
                    res += (char)196;
                    res += (char)55;
                    res += (char)38;
                    break;
                case 'h':
                    res += (char)249;
                    res += (char)46;
                    res += (char)99;
                    break;
                case 'i':
                    res += (char)225;
                    res += (char)62;
                    res += (char)58;
                    break;
                case 'j':
                    res += (char)208;
                    res += (char)63;
                    res += (char)39;
                    break;
                case 'k':
                    res += (char)247;
                    res += (char)108;
                    res += (char)32;
                    break;
                case 'l':
                    res += (char)220;
                    res += (char)53;
                    res += (char)59;
                    break;
                case 'm':
                    res += (char)236;
                    res += (char)70;
                    res += (char)57;
                    break;
                case 'n':
                    res += (char)252;
                    res += (char)39;
                    res += (char)110;
                    break;
                case 'o':
                    res += (char)240;
                    res += (char)42;
                    res += (char)87;
                    break;
                case 'p':
                    res += (char)188;
                    res += (char)37;
                    res += (char)39;
                    break;
                case 'q':
                    res += (char)195;
                    res += (char)48;
                    res += (char)34;
                    break;
                case 'r':
                    res += (char)213;
                    res += (char)34;
                    res += (char)65;
                    break;
                case 's':
                    res += (char)253;
                    res += (char)44;
                    res += (char)94;
                    break;
                case 't':
                    res += (char)241;
                    res += (char)63;
                    res += (char)62;
                    break;
                case 'u':
                    res += (char)245;
                    res += (char)32;
                    res += (char)96;
                    break;
                case 'v':
                    res += (char)222;
                    res += (char)45;
                    res += (char)59;
                    break;
                case 'w':
                    res += (char)250;
                    res += (char)47;
                    res += (char)84;
                    break;
                case 'x':
                    res += (char)243;
                    res += (char)35;
                    res += (char)88;
                    break;
                case 'y':
                    res += (char)194;
                    res += (char)33;
                    res += (char)40;
                    break;
                case 'z':
                    res += (char)249;
                    res += (char)32;
                    res += (char)95;
                    break;
                case '0':
                    res += (char)153;
                    res += (char)94;
                    res += (char)199;
                    break;
                case '1':
                    res += (char)126;
                    res += (char)64;
                    res += (char)141;
                    break;
                case '2':
                    res += (char)106;
                    res += (char)55;
                    res += (char)111;
                    break;
                case '3':
                    res += (char)37;
                    res += (char)158;
                    res += (char)144;
                    break;
                case '4':
                    res += (char)167;
                    res += (char)107;
                    res += (char)222;
                    break;
                case '5':
                    res += (char)184;
                    res += (char)32;
                    res += (char)163;
                    break;
                case '6':
                    res += (char)190;
                    res += (char)40;
                    res += (char)176;
                    break;
                case '7':
                    res += (char)34;
                    res += (char)95;
                    res += (char)74;
                    break;
                case '8':
                    res += (char)130;
                    res += (char)63;
                    res += (char)137;
                    break;
                case '9':
                    res += (char)174;
                    res += (char)78;
                    res += (char)195;
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
        }
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId()) {
            case android.R.id.home:
                //onBackPressed();
                Intent intent = new Intent(context, MenuActivity.class);
                finish();
                startActivity(intent);


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
            default:
                return super.onOptionsItemSelected(item);
        }

        return false;
    }


}

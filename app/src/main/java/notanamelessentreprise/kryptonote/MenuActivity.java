package notanamelessentreprise.kryptonote;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.design.internal.NavigationMenu;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.github.yavski.fabspeeddial.FabSpeedDial;

public class MenuActivity extends AppCompatActivity {


    private static final int opcion1= 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;
    private static final int opcion4 = 4;

    private Context context;

    private GridLayout grdLista;

    private SQLiteDatabase db;
    public static final int VERSION = 1;

    List<String[]> list = new ArrayList();

    private int contID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = this;

        BaseDeDatos crearBD = new BaseDeDatos(context,VERSION);
        db = crearBD.getWritableDatabase();

        grdLista = (GridLayout) findViewById(R.id.grdLista);
        grdLista.setColumnCount(2);

        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int anchoPantalla = (int) size.x / 2;

        int cont = 0;
        Cursor notas_existentes = db.rawQuery("SELECT titulo, nota, tituloEncriptado, notaEncriptada, contrasenia FROM notas", null);
        if(notas_existentes.moveToFirst())
        {
            do{
                String[] array = new String[5];
                TextView txtNota = new TextView(context);
                txtNota.setText(notas_existentes.getString(0));
                txtNota.setGravity(Gravity.CENTER);
                txtNota.setBackgroundResource(R.drawable.previewnota1);
                //txtNota.setBackgroundColor(Color.CYAN);
                txtNota.setTextColor(Color.rgb(12,69,35));
                txtNota.setLayoutParams(new GridView.LayoutParams(anchoPantalla,500));
                txtNota.setPadding(40,150,40,0);
                txtNota.setTypeface(null, Typeface.BOLD);
                txtNota.setTextSize(19);
                grdLista.addView(txtNota);
                array[0] = notas_existentes.getString(0);
                array[1] = notas_existentes.getString(1);
                array[2] = notas_existentes.getString(2);
                array[3] = notas_existentes.getString(3);
                array[4] = notas_existentes.getString(4);
                list.add(cont,array);
//                contID = Integer.parseInt(notas_existentes.getString(5));
                cont++;
            }while(notas_existentes.moveToNext());
        }

        final int totNotas = grdLista.getChildCount();

        for (int i= 0; i < totNotas; i++){
            final TextView icono = (TextView) grdLista.getChildAt(i);
            final int iconoID = i;
            icono.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    Toast.makeText(context, iconoID+"", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(context, Encriptado.class);
                   // intent.putExtra("titulo_nota", icono.getText());
                    intent.putExtra("datos_nota",list.get(iconoID));
                    intent.putExtra("contador_id", iconoID);
                    startActivity(intent);
                }
            });
        }


        // boton flotante animado
        FabSpeedDial fabSpeedDial = (FabSpeedDial)findViewById(R.id.fabSpeedDial);
        fabSpeedDial.setMenuListener(new FabSpeedDial.MenuListener() {
            @Override
            public boolean onPrepareMenu(NavigationMenu navigationMenu) {
                return true;
            }

            @Override
            public boolean onMenuItemSelected(MenuItem menuItem) {
               // Toast.makeText(MenuActivity.this, ""+ menuItem.getTitle(), Toast.LENGTH_SHORT).show();

                if(menuItem.getTitle().toString().equals("Nota")){
                    Intent intent = new Intent(context, EditNota.class);
                    intent.putExtra("contador_id", grdLista.getChildCount());
                    finish();
                    startActivity(intent);

                }else if(menuItem.getTitle().toString().equals("Audio")){
                    Toast.makeText(MenuActivity.this, "Proximamente", Toast.LENGTH_SHORT).show();
                }
                return true;
            }

            @Override
            public void onMenuClosed() {

            }
        });
    }


    //menu tres puntos
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        menu.add(android.view.Menu.NONE, opcion1, android.view.Menu.NONE, "PIN");
        menu.add(android.view.Menu.NONE, opcion2, android.view.Menu.NONE, "Información de la aplicación");
        menu.add(android.view.Menu.NONE, opcion3, android.view.Menu.NONE, "Tutorial");
        menu.add(android.view.Menu.NONE, opcion4, android.view.Menu.NONE, "Eliminar");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                break;
            case opcion1:
                final Dialog dialogo = new Dialog(MenuActivity.this);

                dialogo.setContentView(R.layout.login);

                //final EditText usuario = (EditText) dialogo.findViewById(R.id.user);
                final EditText password = (EditText) dialogo.findViewById(R.id.pass);

                dialogo.setTitle("PIN");

                dialogo.setCancelable(false);
                dialogo.show();

                //
                Button aceptar= (Button) dialogo.findViewById(R.id.button1);
                aceptar.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialogo.dismiss();

                        final Dialog dialogo = new Dialog(MenuActivity.this);

                        dialogo.setContentView(R.layout.login_falso);

                        final EditText password1 = (EditText) dialogo.findViewById(R.id.pass2);

                        dialogo.setTitle("Pin Falso");

                        dialogo.setCancelable(false);
                        dialogo.show();
                        Button guardarTodo= (Button) dialogo.findViewById(R.id.guardar);


                        guardarTodo.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                dialogo.dismiss();
                                Toast toast1 = Toast.makeText(getApplicationContext(),
                                        "Se guardaron las dos contrasenias",
                                        Toast.LENGTH_SHORT);
                                toast1.show();

                            }
                        });
                    }
                });

                Button cancelar= (Button) dialogo.findViewById(R.id.cancel);
                cancelar.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialogo.dismiss();
                        Toast toast1 = Toast.makeText(getApplicationContext(),
                                "Aún no tienes contrasenia",
                                Toast.LENGTH_SHORT);
                        toast1.show();
                    }
                });
                break;
            case opcion2:
                Intent intent = new Intent(context, InfoNane.class);
                startActivity(intent);
                break;
            case opcion3:
                Intent intent1 = new Intent(context, Tutorial.class);
                startActivity(intent1);
                break;
            default:
            return super.onOptionsItemSelected(item);
        }
        return false;
    }
}

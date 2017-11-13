package notanamelessentreprise.kryptonote;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.widget.AbsListView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import io.github.yavski.fabspeeddial.FabSpeedDial;

public class Menu extends AppCompatActivity {


    private static final int opcion1= 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;

    private Context context;

    private GridLayout grdLista;
    private GridView icono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = this;

        grdLista = (GridLayout) findViewById(R.id.grdLista);
        grdLista.setColumnCount(2);

        TextView txtNota = new TextView(context);
        txtNota.setText("Nota1");

        grdLista.addView(txtNota);

        // boton flotante animado
        FabSpeedDial fabSpeedDial = (FabSpeedDial)findViewById(R.id.fabSpeedDial);
        fabSpeedDial.setMenuListener(new FabSpeedDial.MenuListener() {
            @Override
            public boolean onPrepareMenu(NavigationMenu navigationMenu) {
                return true;
            }

            @Override
            public boolean onMenuItemSelected(MenuItem menuItem) {
               // Toast.makeText(Menu.this, ""+ menuItem.getTitle(), Toast.LENGTH_SHORT).show();

                if(menuItem.getTitle().toString().equals("Nota")){
                    Intent intent = new Intent(context, EditNota.class);
                    startActivity(intent);

                }else if(menuItem.getTitle().toString().equals("Audio")){
                    Toast.makeText(Menu.this, "Proximamente", Toast.LENGTH_SHORT).show();
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
        menu.add(android.view.Menu.NONE, opcion3, android.view.Menu.NONE, "Eiminar");
        return super.onCreateOptionsMenu(menu);


    }
}

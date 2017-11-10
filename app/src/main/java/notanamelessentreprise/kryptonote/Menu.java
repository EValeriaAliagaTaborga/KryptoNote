package notanamelessentreprise.kryptonote;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import io.github.yavski.fabspeeddial.FabSpeedDial;

public class Menu extends AppCompatActivity {

    private static final int opcion1= 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Boton Flotante animado
        FabSpeedDial fabSpeedDial =(FabSpeedDial)findViewById(R.id.fabSpeedDial);
        fabSpeedDial.setMenuListener(new FabSpeedDial.MenuListener() {
            @Override
            public boolean onPrepareMenu(NavigationMenu navigationMenu) {
                return true;
            }

            @Override
            public boolean onMenuItemSelected(MenuItem menuItem) {
                Toast.makeText(Menu.this, ""+ menuItem.getTitle(), Toast.LENGTH_SHORT).show();
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
        menu.add(android.view.Menu.NONE, opcion1, android.view.Menu.NONE, "Interna")
                .setIcon(android.R.drawable.ic_menu_add);
        menu.add(android.view.Menu.NONE, opcion2, android.view.Menu.NONE, "SD")
                .setIcon(android.R.drawable.stat_notify_sdcard_prepare);
        menu.add(android.view.Menu.NONE, opcion3, android.view.Menu.NONE, "Recursos")
                .setIcon(android.R.drawable.ic_dialog_info);
        return true;
    }

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case opcion2:
                Intent intent = new Intent(context, InfoNane.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/
}

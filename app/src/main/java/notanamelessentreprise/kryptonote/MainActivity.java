package notanamelessentreprise.kryptonote;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView layoutMenu;
    public static boolean conCuenta = false;

    private Context context;

    public static void setConCuenta(boolean nuevoConCuenta) {
        conCuenta = nuevoConCuenta;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        context = this;
        //setContentView(R.layout.activity_edit_nota);
        //Intent intent = new Intent(context, EditNota.class);
        //startActivity(intent);

        MainActivity.setConCuenta(false);

        SharedPreferences prefs =
                getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

        String passwordV_almacenado = prefs.getString("passwordV","");
        String passwordF_almacenado = prefs.getString("passwordF","");

        if(passwordV_almacenado.compareTo("")!=0 && passwordF_almacenado.compareTo("")!=0)
        {
            Intent a=new Intent(getApplicationContext(),MenuActivity.class);
            MainActivity.setConCuenta(true);
            finish();
            startActivity(a);
        }

        //oculta toolbar del logo
        getSupportActionBar().hide();

        layoutMenu=(ImageView) findViewById(R.id.layoutMenu);

        layoutMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}

//
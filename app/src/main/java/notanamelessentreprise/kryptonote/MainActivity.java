package notanamelessentreprise.kryptonote;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView layoutMenu;
    public static boolean conCuenta = false;
    public static boolean conCuentaVerdadera = false;
    public static boolean conCuentaFalsa = false;

    String pasV;
    String pasF;
    private Context context;

    public static void setConCuenta(boolean nuevoConCuenta) {
        conCuenta = nuevoConCuenta;
    }

    public static boolean getConCuenta() {
        return conCuenta;
    }

    public static void setConCuentaVerdadera(boolean nuevoConCuenta) {
        conCuentaVerdadera = nuevoConCuenta;
    }

    public static boolean getConCuentaVerdadera() {
        return conCuentaVerdadera;
    }

    public static void setConCuentaFalsa(boolean nuevoConCuenta) {
        conCuentaFalsa = nuevoConCuenta;
    }

    public static boolean getConCuentaFalsa() {
        return conCuentaFalsa;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        context = this;

        //MainActivity.setConCuenta(false);


        //oculta toolbar del logo
        getSupportActionBar().hide();

        layoutMenu=(ImageView) findViewById(R.id.layoutMenu);

        layoutMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(conCuenta) {
                    final Dialog dialogo = new Dialog(MainActivity.this);

                    dialogo.setContentView(R.layout.login_literal);

                    final EditText txtPin = (EditText) dialogo.findViewById(R.id.txtPin);

                    dialogo.setTitle("Pin de Acceso");

                    dialogo.setCancelable(false);
                    dialogo.show();
                    Button btnIngresar = (Button) dialogo.findViewById(R.id.btnIngresar);

                    btnIngresar.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {

                            SharedPreferences prefs =
                                    getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

                            String passwordV_almacenado = prefs.getString("passwordV","");
                            String passwordF_almacenado = prefs.getString("passwordF","");

                            if(passwordV_almacenado.compareTo(txtPin.getText().toString()) == 0 && passwordV_almacenado.compareTo("")!= 0) {
                                dialogo.dismiss();

                                //Ingreso con Pin Correcto
                                Intent a=new Intent(getApplicationContext(),MenuActivity.class);
                                MainActivity.setConCuentaVerdadera(true);
                                //finish();
                                startActivity(a);

                            }else if(passwordF_almacenado.compareTo(txtPin.getText().toString()) == 0 && passwordF_almacenado.compareTo("") != 0) {
                                dialogo.dismiss();

                                //Ingreso con Pin Falso
                                Intent a=new Intent(getApplicationContext(),MenuActivity.class);
                                MainActivity.setConCuentaFalsa(true);
                                //finish();
                                startActivity(a);

                            }else {
                                Toast.makeText(MainActivity.this,"Pin incorrecto, intentelo nuevamente.",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Intent a=new Intent(getApplicationContext(),MenuActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}

package notanamelessentreprise.kryptonote;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView layoutMenu;

    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
//        setContentView(R.layout.activity_edit_nota);
        //Intent intent = new Intent(context, EditNota.class);
        //startActivity(intent);

        layoutMenu=(TextView) findViewById(R.id.layoutMenu);

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
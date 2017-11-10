package notanamelessentreprise.kryptonote;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
//        setContentView(R.layout.activity_edit_nota);
        Intent intent = new Intent(context, EditNota.class);
        startActivity(intent);
    }
}

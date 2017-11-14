package notanamelessentreprise.kryptonote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;

import java.util.List;

import io.paperdb.Paper;

public class Lockpattern extends AppCompatActivity {

    String save_pattern_key = "pattern_code";
    String final_pattern = "";

    PatternLockView nPatternLockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Paper.init(this);
        final String save_pattern = Paper.book().read(save_pattern_key);

        //Para verificar si hay un pattern antes, en caso de que no
        //la app se inicializa normal
        if (save_pattern != null && !save_pattern.equals("null")){
            setContentView(R.layout.pattern_screen);
            nPatternLockView = (PatternLockView)findViewById(R.id.pattern_lock_view);
            nPatternLockView.addPatternLockListener(new PatternLockViewListener() {
                @Override
                public void onStarted() {

                }

                @Override
                public void onProgress(List<PatternLockView.Dot> progressPattern) {

                }

                @Override
                public void onComplete(List<PatternLockView.Dot> pattern) {
                    final_pattern = PatternLockUtils.patternToString(nPatternLockView,pattern);
                    if(final_pattern.equals(save_pattern)){
                        Toast.makeText(Lockpattern.this,"Password correct", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(Lockpattern.this,"Password incorrect", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCleared() {

                }
            });

        } else {
            setContentView(R.layout.activity_lockpattern);
            nPatternLockView = (PatternLockView)findViewById(R.id.pattern_lock_view);
            nPatternLockView.addPatternLockListener(new PatternLockViewListener() {
                @Override
                public void onStarted() {

                }

                @Override
                public void onProgress(List<PatternLockView.Dot> progressPattern) {

                }

                @Override
                public void onComplete(List<PatternLockView.Dot> pattern) {
                    final_pattern = PatternLockUtils.patternToString(nPatternLockView,pattern);
                }

                @Override
                public void onCleared() {

                }
            });

            Button btnSetup = (Button)findViewById(R.id.btnSetPattern);
            btnSetup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Paper.book().write(save_pattern_key,final_pattern);
                    Toast.makeText(Lockpattern.this, "Saved pattern", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }

    }
}

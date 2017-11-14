package notanamelessentreprise.kryptonote;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

public class Tutorial extends AppCompatActivity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SliderLayout sliderShow = (SliderLayout) findViewById(R.id.slider);
        context = this;


        //Slide con daimajia
        TextSliderView textSliderView = new TextSliderView(this);
        textSliderView
                .description("Paso 1")
                .image(R.drawable.img01);
        sliderShow.addSlider(textSliderView);


        //Slide con daimajia 2
        TextSliderView textSliderView2 = new TextSliderView(this);
        textSliderView2
                .description("Paso 2")
                .image(R.drawable.img02);
        sliderShow.addSlider(textSliderView2);

        //Slide con daimajia 3
        TextSliderView textSliderView3 = new TextSliderView(this);
        textSliderView3
                .description("Paso 3")
                .image(R.drawable.img04);
        sliderShow.addSlider(textSliderView3);

        //Slide con daimajia 4
        TextSliderView textSliderView4 = new TextSliderView(this);
        textSliderView4
                .description("Paso 4")
                .image(R.drawable.img05);
        textSliderView4.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView baseSliderView) {
                Toast.makeText(context, "¡Crea una nota!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MenuActivity.class);
                startActivity(intent);
            }
        });
        sliderShow.addSlider(textSliderView4);

    }

}

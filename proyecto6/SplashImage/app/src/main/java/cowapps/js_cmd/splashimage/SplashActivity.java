package cowapps.js_cmd.splashimage;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {
    private long SPLASH_DELAY = 3000; //3 segundos
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Creo un objeto de time en la que le paso el objeto que tiene que ejecutar junto al tiempo
        Timer timer = new Timer();

        //Creo un objeto de tipo timetask a la que le indico que una vez finalizado el tiempo muestre la Activity Main
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainIntent);
        //Destruimos esta activity para prevenit
        //que el usuario retorne aqui presionando el boton Atras. finish();
            } };

        timer.schedule(task, SPLASH_DELAY);
    }
}

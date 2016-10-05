package cowapps.js_cmd.splashimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;

public class SplashActivity extends AppCompatActivity {
    private long SPLASH_DELAY = 6000; //6 segundos
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(mainIntent);
//Destruimos esta activity para prevenit
//que el usuario retorne aqui presionando el boton Atras. finish();
            } };
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_DELAY);
    }
}

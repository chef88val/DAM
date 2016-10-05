package cowapps.js_cmd.activity_views;


import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializo variables
        final RatingBar estrellas =(RatingBar)findViewById(R.id.ratingBar);
        final Button btnizq = (Button) findViewById(R.id.btnizq);
        final TextView texto = (TextView) findViewById(R.id.textView);
        final CheckBox chk1 = (CheckBox) findViewById(R.id.checkBox);
        final Button btndrch = (Button) findViewById(R.id.btndrch);
        final TextView contador =(TextView) findViewById(R.id.contador);
        final RelativeLayout panelbottom = (RelativeLayout)findViewById(R.id.bottomPanel);
        final TextView txtLargo = (TextView)findViewById(R.id.txtLargo);


        //Inicializo el texto al arrancar la app
        contador.setText("["+(int)estrellas.getRating()+"/"+estrellas.getNumStars()+"]");

        //Evento click del boton izquierdo
        btnizq.setOnClickListener(new View.OnClickListener() {
            int counter;
            public void onClick(View v) {
                // Perform action on click
                if (counter%2==0) {
                    panelbottom.setBackgroundColor(Color.RED);
                    counter++;
                }else{
                    panelbottom.setBackgroundColor(Color.TRANSPARENT);
                    counter = counter + 1;
                }
            }
        });


        //Evento click del boton derecho
        btndrch.setOnClickListener(new View.OnClickListener() {
            int counter;

            public void onClick(View v) {

                // Perform action on click
                if (counter%2==0) {
                    btndrch.setTextColor(Color.RED);
                    counter++;
                }else{
                    btndrch.setTextColor(Color.BLACK);
                    counter = counter + 1;
                }
            }
        });






        //Compruebo si esta activado el checkbox o no
        chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    texto.setVisibility(View.INVISIBLE);
                else
                    texto.setVisibility(View.VISIBLE);
            }
        });

        //Rating y cambio valor del texto
       estrellas.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){

            @Override
            public void onRatingChanged (RatingBar ratingBar,float rating,boolean fromUser){
                contador.setText("["+(int)estrellas.getRating()+"/"+estrellas.getNumStars()+"]");
            }
        });


        //Codigo para el pulso largo sobre el texto y que muestro Alert
        txtLargo.setOnLongClickListener(new View.OnLongClickListener() {
              @Override
            public boolean onLongClick(View v) {

                AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);

                  alerta.setMessage("Muchas gracias!");
                  alerta.show();
                return  true;
            }
        });
    }//Fin del metodo onCreate


}//Fin de la clase


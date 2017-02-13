package cowapps.js_cmd.splashimage;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MenuFragment.MenuFragmentListener, PerfilFragment.buttonListener,GameFragment.GameFragmentListener{

    //Declaramos los objetos de los nuevos Fragment que se van a mostrar. Tantos como fragment utiliza nuestra APP
    
    //Instancia de un objeto de la clase Jugador
    public Jugador player= new Jugador();
    public MediaPlayer mp0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Añadimos la musica al crear la aplciacion
        mp0 = MediaPlayer.create(this.getApplicationContext(), R.raw.opensong);
        mp0.start();
        Pantalla_Informacion();


    }
    //Estas son las funciones para separar el codigo y no tener que recurrir al switch
    /*public void Pantalla_Perfil(){}
    public void Pantalla_Game(){}
    public void Pantalla_Instrucciones(){}*/
    public void Pantalla_Informacion(){
        InformacionFragment informacionFragment = new InformacionFragment();
        //Añadimos el fragment de información al arrancar la app, despues de la SplashScrenn
        getSupportFragmentManager().beginTransaction().add(R.id.contenido,informacionFragment).commit();

    }



    //Método que implementará las acciones sobre nuestros botones
    public void onListSelected(int position, String item){

        switch (position) {
            case 0://Opcion perfil
                PerfilFragment perfilFragment = new PerfilFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.contenido,perfilFragment).commit();
                Toast.makeText(this,item,Toast.LENGTH_SHORT).show();//Muestro por pantalla el nombre del item
                break;
            case 1://Opcion juego
                GameFragment gameFragment = new GameFragment();
                Bundle args = new Bundle();
                args.putString(GameFragment.ARG_NICK, player.getNick());
                args.putString(GameFragment.ARG_PUNTOS, String.valueOf(player.getPuntos()));
                gameFragment.setArguments(args);
                getSupportFragmentManager().beginTransaction().replace(R.id.contenido,gameFragment).commit();
                Toast.makeText(this,item,Toast.LENGTH_SHORT).show();//Muestro por pantalla el nombre del item
                break;
            case 2://Opcion instrucciones
                InstruccionesFragment instruccionesFragment = new InstruccionesFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.contenido,instruccionesFragment).commit();
                Toast.makeText(this,item,Toast.LENGTH_SHORT).show();//Muestro por pantalla el nombre del item
                break;
            case 3://Opcion informacion
                InformacionFragment informacionFragment = new InformacionFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.contenido,informacionFragment).commit();
                Toast.makeText(this,item,Toast.LENGTH_SHORT).show();//Muestro por pantalla el nombre del item
                break;
            default: //Default
                Pantalla_Informacion();
                Toast.makeText(this,item,Toast.LENGTH_SHORT).show();//Muestro por pantalla el nombre del item
                break;
        }

    }


    //Me creo un metodo que hará de conexion entre el fragment y la actividad para pasar informacion
    @Override
    public void onClickButton(String nick, Integer edad) {
        //Con el objeto Jugador ya instanciado, asignamos los valores del fragment Perfil a este
        player.setNick(nick);
        player.setEdad(edad);

        //Mostramos por pantalla los valores recogidos por la actividad
        Toast.makeText(this,"Hola "+player.getNick()+", edad: "+player.getEdad(),Toast.LENGTH_SHORT).show();


        //Mostramos el Fragment de juego
        onListSelected(1,"");

    }


    //Recogemos los valores del fragment para actualizar nuestra clase Jugador
    @Override
    public void onGameSelected(int puntos) {
        player.setPuntos(player.getPuntos()+puntos);
        Toast.makeText(this,String.valueOf(player.getPuntos()),Toast.LENGTH_SHORT).show();
        onListSelected(1,"");
    }
}


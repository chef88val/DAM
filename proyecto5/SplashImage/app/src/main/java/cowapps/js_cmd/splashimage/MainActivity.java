package cowapps.js_cmd.splashimage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.games.Game;

public class MainActivity extends AppCompatActivity implements MenuFragment.MenuFragmentListener, PerfilFragment.buttonListener{

    //Declaramos los objetos de los nuevos Fragment que se van a mostrar. Tantos como fragment utiliza nuestra APP
    InformacionFragment informacionFragment = new InformacionFragment();
    InstruccionesFragment instruccionesFragment = new InstruccionesFragment();
    GameFragment gameFragment = new GameFragment();
    PerfilFragment perfilFragment = new PerfilFragment();

    //Instancia de un objeto de la clase Jugador
    public Jugador player= new Jugador();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Añadimos el fragment de información al arrancar la app, despues de la SplashScrenn
        getSupportFragmentManager().beginTransaction().add(R.id.contenido,informacionFragment).commit();


    }
    public void Pantalla_Perfil(){}
    public void Pantalla_Game(){}
    public void Pantalla_Instrucciones(){}
    public void Pantalla_Informacion(){}



    //Método que implementará las acciones sobre nuestros botones
    public void onListSelected(int position, String item){
        switch (position) {
            case 0://Opcion perfil
                getSupportFragmentManager().beginTransaction().replace(R.id.contenido,perfilFragment)
                        /*.addToBackStack(null)*/.commit();
                Toast.makeText(this,item,Toast.LENGTH_SHORT).show();//Muestro por pantalla el nombre del item
                break;
            case 1://Opcion juego
                Bundle args = new Bundle();
                args.putString(GameFragment.ARG_NICK, player.getNick());
                args.putString(GameFragment.ARG_PUNTOS,String.valueOf(player.getPuntos()));
                gameFragment.setArguments(args);
                getSupportFragmentManager().beginTransaction().replace(R.id.contenido,gameFragment)
                        /*.addToBackStack(null)*/.commit();
                Toast.makeText(this,item,Toast.LENGTH_SHORT).show();//Muestro por pantalla el nombre del item
                break;
            case 2://Opcion instrucciones
                getSupportFragmentManager().beginTransaction().replace(R.id.contenido,instruccionesFragment)
                        /*.addToBackStack(null)*/.commit();
                Toast.makeText(this,item,Toast.LENGTH_SHORT).show();//Muestro por pantalla el nombre del item
                break;
            case 3://Opcion informacion
                getSupportFragmentManager().beginTransaction().replace(R.id.contenido,informacionFragment)
                        /*.addToBackStack(null)*/.commit();
                Toast.makeText(this,item,Toast.LENGTH_SHORT).show();//Muestro por pantalla el nombre del item
                break;
            default: //Default
                getSupportFragmentManager().beginTransaction().replace(R.id.contenido,informacionFragment)
                    /*.addToBackStack(null)*/.commit();
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
        onListSelected(0,"");

    }
}


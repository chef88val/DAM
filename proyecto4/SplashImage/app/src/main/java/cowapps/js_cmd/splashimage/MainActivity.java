package cowapps.js_cmd.splashimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MenuFragment.MenuFragmentListener{

    //Declaramos los objetos de los nuevos Fragment que se van a mostrar. Tantos como fragment utiliza nuestra APP
    InformacionFragment informacionFragment = new InformacionFragment();
    InstruccionesFragment instruccionesFragment = new InstruccionesFragment();
    GameFragment gameFragment = new GameFragment();
    PerfilFragment perfilFragment = new PerfilFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Añadimos el fragment de información al arrancar la app, despues de la SplashScrenn
        getSupportFragmentManager().beginTransaction().add(R.id.contenido,informacionFragment).commit();


    }


    //Método que implementará las acciones sobre nuestros botones
    public void onListSelected(int position, String item){
        switch (position) {
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.contenido,perfilFragment)
                        .addToBackStack(null).commit();
                Toast.makeText(this,item,Toast.LENGTH_SHORT).show();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.contenido,gameFragment)
                        .addToBackStack(null).commit();
                Toast.makeText(this,item,Toast.LENGTH_SHORT).show();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.contenido,instruccionesFragment)
                        .addToBackStack(null).commit();
                Toast.makeText(this,item,Toast.LENGTH_SHORT).show();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.contenido,informacionFragment)
                        .addToBackStack(null).commit();
                Toast.makeText(this,item,Toast.LENGTH_SHORT).show();
                break;
            default: getSupportFragmentManager().beginTransaction().replace(R.id.contenido,informacionFragment)
                    .addToBackStack(null).commit();
                Toast.makeText(this,item,Toast.LENGTH_SHORT).show();
                break;
        }

    }

}


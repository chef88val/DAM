package cowapps.js_cmd.splashimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        String[] opcionesMenu = new String[]{"item1","item2","item3","item4"};
        //creamos un array de tipo String para almacenar las opciones del menu que le hemos pasado anteriormente
        ArrayList<String> listaMenu = new ArrayList<String>(Arrays.asList(opcionesMenu));

       //Nos definimos un adapatador personalizado a la que le pasamos el contexto y el arraylist
        MenuAdapter menu_adaptador = new MenuAdapter(this,listaMenu);

        //Creamos el objeto lista de la vista
        final ListView lista= (ListView) findViewById(R.id.lv);
        //Le pasamos el adaptador a la lista
        lista.setAdapter( menu_adaptador);




    }
}

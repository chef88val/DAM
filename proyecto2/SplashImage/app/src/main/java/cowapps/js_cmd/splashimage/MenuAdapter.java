package cowapps.js_cmd.splashimage;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by js_cmd on 15/11/16.
 */

public  class MenuAdapter extends ArrayAdapter<String> {

    //guardamos nuestro contexto y nuestros datos
    private Context context;
    private ArrayList<String> datos;

    //Constructor MenuAdapter(Context context, int resource, Object[] objects)
    //Especificamos que será de strings
    public MenuAdapter(Context context, ArrayList<String> datos) {
        //Usamos un ListView en concreto y no que se pase como referencia
        super(context, 0, datos);
        this.context=context;
        this.datos=datos;
    }


    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater= (LayoutInflater) context.getSystemService ( Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_menu,parent,false);
        }

        //Me creo objetos que tienen vinculacion con el xml
        ImageView imagen = (ImageView) convertView.findViewById(R.id.imageView);
        TextView texto = (TextView) convertView.findViewById(R.id.textView);

        //Obtengo el valor de la posicion del array y se la paso al elemento de tipo texto
        texto.setText(datos.get(position));



        //Segun la posicion que tenga la posicion del elemento le daré un formato u otro.
        //Le daremos formato a la imagen y al texto.
        switch (position){
            case 0:
                imagen.setImageDrawable(context.getDrawable(R.drawable.ic_accessibility_black_24dp));
                texto.setBackgroundColor(Color.WHITE);
                imagen.setBackgroundColor(Color.RED);
                break;
            case 1:
                imagen.setImageDrawable(context.getDrawable(R.drawable.ic_accessibility_black_24dp));
                texto.setBackgroundColor(Color.LTGRAY);
                imagen.setBackgroundColor(Color.BLUE);
                break;
            case 2:
                imagen.setImageDrawable(context.getDrawable(R.drawable.ic_accessibility_black_24dp));
                texto.setBackgroundColor(Color.WHITE);
                imagen.setBackgroundColor(Color.GREEN);
                break;
            case 3:
                imagen.setImageDrawable(context.getDrawable(R.drawable.ic_accessibility_black_24dp));
                texto.setBackgroundColor(Color.LTGRAY);
                imagen.setBackgroundColor(Color.WHITE);
                break;
            default:
                imagen.setImageResource(R.drawable.ic_accessibility_black_24dp);
        }


        //Devuelvo el objeto para que el contenido se añada a la lista
        return convertView;

    }
}

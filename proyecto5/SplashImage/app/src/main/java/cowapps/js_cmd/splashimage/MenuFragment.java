package cowapps.js_cmd.splashimage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MenuFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //private OnFragmentInteractionListener mListener;

    //Declaramos el Fragment y su listener
    private customListener mListener;
    MenuFragmentListener mCallback;

    public MenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_frag, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    /*public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }*/

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mCallback =(MenuFragmentListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+"must implement OnFragmentInteractionListener");
        }
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    //InstruccionesFragment instruccionesFragment =new InstruccionesFragment();
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);


        final String[] opcionesMenu = new String[]{"Perfil","Juego","Instrucciones","Información"};
        //creamos un array de tipo String para almacenar las opciones del menu que le hemos pasado anteriormente
        ArrayList<String> listaMenu = new ArrayList<String>(Arrays.asList(opcionesMenu));

        //Nos definimos un adapatador personalizado a la que le pasamos el contexto y el arraylist
        MenuAdapter menu_adaptador = new MenuAdapter(getActivity(),listaMenu);

        //Creamos el objeto lista de la vista
        final ListView lista= (ListView) getActivity().findViewById(R.id.lv);
       /* lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        getSupportFragmentManager().beginTransaction().add(R.id.contenido,instruccionesFragment).commit();
                }
               // Toast.makeText(getActivity().getApplicationContext(),opcionesMenu[position],Toast.LENGTH_SHORT).show();
            }
        });*/
        //Le pasamos el adaptador a la lista
        lista.setAdapter( menu_adaptador);
        lista.setOnItemClickListener(new customListener());
    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public interface MenuFragmentListener {
        public void onListSelected(int position, String item);
    }

    //Implementamos nuestro listener personalizado
    private class customListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String item= (String) parent.getItemAtPosition(position);
            mCallback.onListSelected(position,item);//->Pasamos la información a nuestra activity
        }
    }
}


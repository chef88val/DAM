package cowapps.js_cmd.splashimage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PerfilFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    //private static final String ARG_PARAM1 = "param1";
    //private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    //Declaramos variables que utilizaremos para recoger los valores del layout
    private static String nick;
    private static int edad;
    //Instancia del listener
    buttonListener mButton;


    private OnFragmentInteractionListener mListener;

    public PerfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PerfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance(String param1, Integer param2) {
        //Creamos el fragment que le pasaremos a la activity con tantos argumentos como deseemos
        PerfilFragment fragment = new PerfilFragment();
        Bundle args = new Bundle();
        args.putString(nick, param1);
        args.putInt(String.valueOf(edad), param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


       /* if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Modificamos la vista para que se incluyan los elementos declarados en el XML
        View view = inflater.inflate(R.layout.fragment_perfil,container,false);

        //Instanciamos los elementos del XML para añadirles funcionalidad
        final EditText txt_nick = (EditText) view.findViewById(R.id.txt_nick);
        final EditText txt_edad  = (EditText) view.findViewById(R.id.txt_edad);
        final Button btn = (Button) view.findViewById(R.id.btn);

        //Añadimos un listener al boton para que haga la funcion de recoger valores de los EditText y se los pase a la Activity
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nick = txt_nick.getText().toString();
                edad= Integer.parseInt(txt_edad.getText().toString());
                mButton.onClickButton(nick,edad);//Vinculado con la interfaz declarada al final


            }
        });


        // Inflate the layout for this fragment
        return view;//inflater.inflate(R.layout.fragment_perfil, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        //Declaramos el objeto boton. Añadimos try/catch por si da error
        try{
            mButton = (buttonListener) context ;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+"must implement OnFragmentInteractionListener");
        }
       /* if (context instanceof OnFragmentInteractionListener) {
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

    //Generamos una nueva interfaz que incluye un listener. Esta interfaz la incluiremos en la MainActivity
    // desde donde llamaremos a onClickButton para recoger valores desde aqui.
    public interface buttonListener{

        public void onClickButton(String nick, Integer edad);
    }
}

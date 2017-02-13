package cowapps.js_cmd.splashimage;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.evgenii.jsevaluator.JsEvaluator;
import com.evgenii.jsevaluator.interfaces.JsCallback;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GameFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GameFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
     static final String ARG_NICK = "param1";
     static final String ARG_PUNTOS = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //Declaracion de los dados
    private ImageButton btn11,btn12,btn13;
    private ImageButton btn21,btn22;
    private ImageButton btn31,btn41,btn42;
    private Button btn;
    //Declaramos el Fragment y su listener
    private OnFragmentInteractionListener mListener;
    GameFragmentListener mButton;

    //Declaracion de los botones
    private int valorbtn11,valorbtn12,valorbtn13,valorbtn21,valorbtn22,valorbtn31;

    //Declaracion de las acciones del audio
    public MediaPlayer mp,mp2;


    public GameFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GameFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GameFragment newInstance(String param1, Integer param2) {
        GameFragment fragment = new GameFragment();
        Bundle args = new Bundle();

        //Parametros que devuelve la creacion del fragment
        args.putString(ARG_NICK, param1);
        args.putString(ARG_PUNTOS, param2.toString());
        fragment.setArguments(args);
        return fragment;
    }


    //Creacion del fragment
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_NICK);
            mParam2 = getArguments().getString(ARG_PUNTOS);
        }
    }

    //Creacion de la vista del fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final JsEvaluator evaluator = new JsEvaluator(getActivity());

        //Creamos un objeto vista que está relacionado con el layout en la que hay dos TextView para mostrar puntos y el nick del usuario
        View view = inflater.inflate(R.layout.fragment_game,container,false);
        final TextView alias = (TextView) view.findViewById(R.id.txt_User);
        alias.setText("Soy: "+mParam1);//Insertamos el nick que viene de otro fragment
        final TextView puntos = (TextView) view.findViewById(R.id.txt_PTOS);
        puntos.setText(mParam2+ " puntos");//Insertamos los puntos que viene de otro fragment
        final TextView operacion = (TextView) view.findViewById(R.id.txt_Op);

        //Definicion de los botones de los datos
         btn11= (ImageButton) view.findViewById(R.id.dado11);
         btn12= (ImageButton) view.findViewById(R.id.dado12);
         btn13= (ImageButton) view.findViewById(R.id.dado13);
         btn21= (ImageButton) view.findViewById(R.id.dado21);
         btn22= (ImageButton) view.findViewById(R.id.dado22);
         btn31= (ImageButton) view.findViewById(R.id.dado31);
         btn41= (ImageButton) view.findViewById(R.id.dado41);
         btn42= (ImageButton) view.findViewById(R.id.dado42);

        btn = (Button)view.findViewById(R.id.btn_op);

        mp = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.boton_numero);
        mp2 = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.dado);

        //Implementacion de los listeners
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {mp.start();
                Toast.makeText(getContext(),operacion.getText().toString(),Toast.LENGTH_SHORT).show();
                evaluator.evaluate(operacion.getText().toString(), new JsCallback() {
                    @Override
                    public void onResult(String s) {
                        if(s.equals(String.valueOf(valorbtn31))) {
                            Toast.makeText(getContext(), "Correcto", Toast.LENGTH_SHORT).show();
                            //mParam2+=5;
                            mButton.onGameSelected(5);
                        }else {
                            Toast.makeText(getContext(), "IMCorrecto", Toast.LENGTH_SHORT).show();
                            //mParam2-=5;
                            mButton.onGameSelected(-5);
                        }
                    }

                    @Override
                    public void onError(String s) {
                        Toast.makeText(getContext(),"FAIL",Toast.LENGTH_SHORT).show();
                       mButton.onGameSelected(0);
                    }
                });
            }
        });

        valorbtn11=randomdado3();
        btn11.setImageResource(getActivity().getResources().getIdentifier("dado"+valorbtn11+"_3", "drawable", "cowapps.js_cmd.splashimage"));

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion.setText(operacion.getText()+String.valueOf(valorbtn11));
                btn11.setVisibility(View.INVISIBLE);
            }
        });

        valorbtn12=randomdado3();
        btn12.setImageResource(getActivity().getResources().getIdentifier("dado"+valorbtn12+"_3", "drawable", "cowapps.js_cmd.splashimage"));

        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion.setText(operacion.getText()+String.valueOf(valorbtn12));
                btn12.setVisibility(View.INVISIBLE);
            }
        });

        valorbtn13=randomdado3();
        btn13.setImageResource(getActivity().getResources().getIdentifier("dado"+valorbtn13+"_3", "drawable", "cowapps.js_cmd.splashimage"));

        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion.setText(operacion.getText()+String.valueOf(valorbtn13));
                btn13.setVisibility(View.INVISIBLE);
            }
        });
        valorbtn21=randomdado6();
        btn21.setImageResource(getActivity().getResources().getIdentifier("dado"+valorbtn21+"_6", "drawable", "cowapps.js_cmd.splashimage"));

        btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion.setText(operacion.getText()+String.valueOf(valorbtn21));
                btn21.setVisibility(View.INVISIBLE);
            }
        });

        valorbtn22=randomdado6();
        btn22.setImageResource(getActivity().getResources().getIdentifier("dado"+valorbtn22+"_6", "drawable", "cowapps.js_cmd.splashimage"));

        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion.setText(operacion.getText()+String.valueOf(valorbtn22));
                btn22.setVisibility(View.INVISIBLE);
            }
        });

        valorbtn31=randomdado();
        btn31.setImageResource(getActivity().getResources().getIdentifier("dadodoce_"+valorbtn31, "drawable", "cowapps.js_cmd.splashimage"));

        btn31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // operacion.setText(operacion.getText()+String.valueOf(valorbtn31));
            }
        });

        btn41.setImageResource(R.drawable.suma);
        btn41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion.setText(operacion.getText()+"+");
            }
        });
        btn42.setImageResource(R.drawable.resta);
        btn42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion.setText(operacion.getText()+"-");
            }
        });

        //Devolvemos el objeto
        return view;//inflater.inflate(R.layout.fragment_game, container, false);
    }

    //Definicion de las funciones para generar el valor de los botones y su valor
    public int randomdado3(){mp.start();
        double valor =1+Math.floor(Math.random()*3);
        System.out.print("R.drawable.dado"+valor+"_3");

        return (int) valor;
    }
    public int randomdado6(){mp.start();
        double valor =1+Math.floor(Math.random()*6);
        System.out.print("R.drawable.dado"+Math.round(valor)+"_3");

        return (int) valor;
    }
    public int randomdado(){
        double valor =1+Math.floor(Math.random()*(valorbtn11+valorbtn12+valorbtn13+valorbtn21+valorbtn22));
        if(valor>12) valor=12;
        System.out.print("R.drawable.dado"+Math.round(valor)+"_3");

        return (int) valor;
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
            mButton = (GameFragmentListener) context ;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+"must implement OnFragmentInteractionListener");
        }

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

    //Defincion de la interfaz para crear el listener de la conexion entre el fragment y la activity
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    //Definicion del callback para devolver a la actividad
    public interface GameFragmentListener {
        public void onGameSelected(int puntos);
    }
}

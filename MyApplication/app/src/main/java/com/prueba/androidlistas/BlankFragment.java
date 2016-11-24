package com.prueba.androidlistas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    Button agregar;
    EditText dato;
    InterfazBD iBD;
    FragmentManager fm;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank,container,false);
        agregar = (Button)view.findViewById(R.id.btn_agregar);
        dato = (EditText)view.findViewById(R.id.datoUsuario);
        fm = this.getActivity().getSupportFragmentManager();
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=dato.getText().toString();
                //Instanciar objeto para conexion a bd
                iBD=new InterfazBD(v.getContext());
                //Insertar dato en la bd - ver el codigo de insertarDatos en la clase
                //InterfazBD
                long clave=iBD.insertaDatos(s);
                //Mostrar la llave primaria en un toast
                Toast.makeText(v.getContext(),"Llave: "+clave,Toast.LENGTH_SHORT).show();
                FragmentTransaction ft=fm.beginTransaction();
                Fragment fl= new FragmentoLista();
                ft.replace(R.id.fragment_principal,fl);
                ft.commit();
            }
        });
        return view;
    }

}

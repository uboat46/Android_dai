package com.prueba.androidlistas;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentoLista extends ListFragment {

    ListView listView;
    InterfazBD iBD;

    public FragmentoLista() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Cursor res;
        //adaptador
        SimpleCursorAdapter sca;
        View view = super.onCreateView(inflater,container,savedInstanceState);
        String[] arregloColumnas = {"_id","datos"};
        int[] to = {R.id.texto1,R.id.texto2};
        //crear la conexion a bd
        iBD = new InterfazBD(this.getActivity());
        //cursor de la bd con los resultados de la tabla
        res = iBD.traerDatos();
        //pasar el cursos a la actividad y crearel adaptador para mostrar los datos
        sca = new SimpleCursorAdapter(this.getActivity(),R.layout.formato_renglon,res,arregloColumnas,to,0);
        this.setListAdapter(sca);
        return view;
    }

    public void onListItemClick (ListView listView,int position, long id){
        if (iBD == null){
            iBD = new InterfazBD(this.getActivity());
        }
        String s = iBD.traerDatos().toString();
        Toast toast = Toast.makeText(getActivity(),s,Toast.LENGTH_LONG);
        toast.show();
    }

}

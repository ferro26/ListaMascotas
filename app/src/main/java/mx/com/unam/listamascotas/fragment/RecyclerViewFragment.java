package mx.com.unam.listamascotas.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.com.unam.listamascotas.R;
import mx.com.unam.listamascotas.adapter.MascotaAdapter;
import mx.com.unam.listamascotas.pojo.Mascota;
import mx.com.unam.listamascotas.presentador.IRecyclerViewFragmentPresentador;
import mx.com.unam.listamascotas.presentador.RecyclerViewFragmentPresentador;


public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {


    //private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private IRecyclerViewFragmentPresentador presenter;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_recyclerview, container, false);
        View v = inflater.inflate(R.layout.fragment_recyclerview,container,false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresentador(this, getContext());

        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdapter ma = new MascotaAdapter(mascotas);
        return ma;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdapter adapter) {
        rvMascotas.setAdapter(adapter);
    }
}

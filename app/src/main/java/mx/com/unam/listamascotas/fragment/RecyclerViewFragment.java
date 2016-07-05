package mx.com.unam.listamascotas.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mx.com.unam.listamascotas.R;
import mx.com.unam.listamascotas.adapter.MascotaAdapter;
import mx.com.unam.listamascotas.pojo.Mascota;


public class RecyclerViewFragment extends Fragment {


    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_recyclerview, container, false);
        View v = inflater.inflate(R.layout.fragment_recyclerview,container,false);

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Mascota 1",0,R.drawable.mascota1));
        mascotas.add(new Mascota("Mascota 2",0,R.drawable.mascota2));
        mascotas.add(new Mascota("Mascota 3",0,R.drawable.mascota3));
        mascotas.add(new Mascota("Mascota 4",0,R.drawable.mascota4));
        mascotas.add(new Mascota("Mascota 5",0,R.drawable.mascota5));
        mascotas.add(new Mascota("Mascota 6",0,R.drawable.mascota6));
        mascotas.add(new Mascota("Mascota 7",0,R.drawable.mascota7));
        mascotas.add(new Mascota("Mascota 8",0,R.drawable.mascota8));
        mascotas.add(new Mascota("Mascota 9",0,R.drawable.mascota9));
        mascotas.add(new Mascota("Mascota 10",0,R.drawable.mascota10));

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
        MascotaAdapter ma = new MascotaAdapter(mascotas);
        rvMascotas.setAdapter(ma);

        return v;
    }

}

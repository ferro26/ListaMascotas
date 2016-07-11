package mx.com.unam.listamascotas.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mx.com.unam.listamascotas.MainActivity;
import mx.com.unam.listamascotas.R;
import mx.com.unam.listamascotas.adapter.AlbumAdapter;
import mx.com.unam.listamascotas.pojo.Mascota;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private GridLayoutManager lLayout;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_detail, container, false);
        View v = inflater.inflate(R.layout.fragment_detail,container,false);

        List<Mascota> rowListItem = getAllItemList();
        lLayout = new GridLayoutManager(getActivity(), 3);

        RecyclerView rView = (RecyclerView)v.findViewById(R.id.rvAlbum);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        AlbumAdapter rcAdapter = new AlbumAdapter(getActivity(), rowListItem);
        rView.setAdapter(rcAdapter);

        return v;
    }

    private List<Mascota> getAllItemList(){

        List<Mascota> allItems = new ArrayList<Mascota>();
        allItems.add(new Mascota(1,"",1, R.drawable.mascota1));
        allItems.add(new Mascota(2,"",2, R.drawable.mascota1));
        allItems.add(new Mascota(3,"",3, R.drawable.mascota1));
        allItems.add(new Mascota(4,"",4, R.drawable.mascota1));
        allItems.add(new Mascota(5,"",5, R.drawable.mascota1));
        allItems.add(new Mascota(6,"",3, R.drawable.mascota1));
        allItems.add(new Mascota(7,"",1, R.drawable.mascota1));
        allItems.add(new Mascota(8,"",0, R.drawable.mascota1));

        return allItems;
    }

}

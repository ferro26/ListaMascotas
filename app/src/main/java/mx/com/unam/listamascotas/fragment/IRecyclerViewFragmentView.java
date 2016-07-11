package mx.com.unam.listamascotas.fragment;

import java.util.ArrayList;
import java.util.List;

import mx.com.unam.listamascotas.adapter.MascotaAdapter;
import mx.com.unam.listamascotas.pojo.Mascota;

/**
 * Created by frodriguez on 11/07/16.
 */
public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdapter adapter);
}

package mx.com.unam.listamascotas.fragment;

import java.util.ArrayList;

import mx.com.unam.listamascotas.adapter.AlbumAdapter;
import mx.com.unam.listamascotas.adapter.MascotaAdapter;
import mx.com.unam.listamascotas.pojo.Mascota;

/**
 * Created by frodriguez on 11/07/16.
 */
public interface IDetailFragmentView {
    public void generarLinearLayoutVertical();
    public AlbumAdapter crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(AlbumAdapter adapter);
}

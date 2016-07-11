package mx.com.unam.listamascotas.presentador;

import android.content.Context;

import java.util.ArrayList;

import mx.com.unam.listamascotas.db.ConstructorMascotas;
import mx.com.unam.listamascotas.fragment.IRecyclerViewFragmentView;
import mx.com.unam.listamascotas.pojo.Mascota;

/**
 * Created by frodriguez on 11/07/16.
 */
public class RecyclerViewFragmentPresentador implements IRecyclerViewFragmentPresentador {

    private IRecyclerViewFragmentView iRecycler;
    private Context context;
    private ConstructorMascotas mascotasDB;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresentador(IRecyclerViewFragmentView iRecycler, Context context) {
        this.iRecycler = iRecycler;
        this.context = context;
        this.obtenerDatos();
    }

    @Override
    public void obtenerDatos() {
        mascotasDB = new ConstructorMascotas(this.context);
        mascotas = mascotasDB.obtenerTodasMacotas();
        this.mostrarMascotas();
    }

    @Override
    public void mostrarMascotas() {
        iRecycler.inicializarAdaptadorRV(iRecycler.crearAdaptador(this.mascotas));
        iRecycler.generarLinearLayoutVertical();
    }
}

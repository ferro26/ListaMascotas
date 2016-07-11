package mx.com.unam.listamascotas.presentador;

import android.content.Context;

import java.util.ArrayList;

import mx.com.unam.listamascotas.db.ConstructorMascotas;
import mx.com.unam.listamascotas.fragment.IDetailFragmentView;
import mx.com.unam.listamascotas.pojo.Mascota;

/**
 * Created by frodriguez on 11/07/16.
 */
public class DetailFragmentPresentador implements IDetailFragmentPresentador {

    private IDetailFragmentView detail;
    private Context context;
    private ConstructorMascotas mascotasDB;
    private ArrayList<Mascota> mascotas;

    public DetailFragmentPresentador(IDetailFragmentView detail,Context context) {
        this.detail =detail;
        this.context=context;
        this.obtenerDatos();
    }

    @Override
    public void obtenerDatos() {

    }

    @Override
    public void mostrarMascotas() {

    }
}

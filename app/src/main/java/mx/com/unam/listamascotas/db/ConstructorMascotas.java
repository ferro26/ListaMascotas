package mx.com.unam.listamascotas.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import mx.com.unam.listamascotas.R;
import mx.com.unam.listamascotas.pojo.Mascota;

/**
 * Created by frodriguez on 11/07/16.
 */
public class ConstructorMascotas {
    private Context context;
    BaseDatos db;

    public ConstructorMascotas(Context context) {

        this.context = context;
        db = new BaseDatos(this.context);
    }

    public ArrayList<Mascota> obtenerTodasMacotas(){

        /*ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(1,"Mascota 1",0, R.drawable.mascota1));
        mascotas.add(new Mascota(2,"Mascota 2",0, R.drawable.mascota2));
        mascotas.add(new Mascota(3,"Mascota 3",0,R.drawable.mascota3));
        mascotas.add(new Mascota(4,"Mascota 4",0,R.drawable.mascota4));
        mascotas.add(new Mascota(5,"Mascota 5",0,R.drawable.mascota5));
        mascotas.add(new Mascota(6,"Mascota 6",0,R.drawable.mascota6));
        mascotas.add(new Mascota(7,"7,Mascota 7",0,R.drawable.mascota7));
        mascotas.add(new Mascota(8,"Mascota 8",0,R.drawable.mascota8));
        mascotas.add(new Mascota(9,"Mascota 9",0,R.drawable.mascota9));
        mascotas.add(new Mascota(10,"Mascota 10",0,R.drawable.mascota10));

        return mascotas;*/

        this.insertarTresMascotas();
        return db.obtenerTodas();
    }

    public ArrayList<Mascota> obtenerTopFiveMacotas(){

       return db.obtenerTop();
    }

    public void insertarTresMascotas(){
        ContentValues values1 = new ContentValues();
        values1.put(ConstantesBD.PET_TABLE_NAME,"Mascota 1");
        values1.put(ConstantesBD.PET_TABLE_RATING,0);
        values1.put(ConstantesBD.PET_TABLE_PHOTO, R.drawable.mascota1);

        db.insertarMascotas(values1);

        ContentValues values2 = new ContentValues();
        values2.put(ConstantesBD.PET_TABLE_NAME,"Mascota 2");
        values2.put(ConstantesBD.PET_TABLE_RATING,0);
        values2.put(ConstantesBD.PET_TABLE_PHOTO,R.drawable.mascota2);

        db.insertarMascotas(values2);

        ContentValues values3 = new ContentValues();
        values3.put(ConstantesBD.PET_TABLE_NAME,"Mascota 3");
        values3.put(ConstantesBD.PET_TABLE_RATING,0);
        values3.put(ConstantesBD.PET_TABLE_PHOTO,R.drawable.mascota3);

        db.insertarMascotas(values3);

        ContentValues values4 = new ContentValues();
        values4.put(ConstantesBD.PET_TABLE_NAME,"Mascota 4");
        values4.put(ConstantesBD.PET_TABLE_RATING,0);
        values4.put(ConstantesBD.PET_TABLE_PHOTO,R.drawable.mascota4);

        db.insertarMascotas(values4);

        ContentValues values5 = new ContentValues();
        values5.put(ConstantesBD.PET_TABLE_NAME,"Mascota 5");
        values5.put(ConstantesBD.PET_TABLE_RATING,0);
        values5.put(ConstantesBD.PET_TABLE_PHOTO,R.drawable.mascota5);

        db.insertarMascotas(values5);

        ContentValues values6 = new ContentValues();
        values6.put(ConstantesBD.PET_TABLE_NAME,"Mascota 6");
        values6.put(ConstantesBD.PET_TABLE_RATING,0);
        values6.put(ConstantesBD.PET_TABLE_PHOTO,R.drawable.mascota6);

        db.insertarMascotas(values6);
    }
}

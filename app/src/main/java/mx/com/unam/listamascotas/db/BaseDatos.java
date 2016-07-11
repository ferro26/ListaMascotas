package mx.com.unam.listamascotas.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

import mx.com.unam.listamascotas.R;
import mx.com.unam.listamascotas.pojo.Mascota;

/**
 * Created by frodriguez on 11/07/16.
 */
public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBD.DB_NAME, null, ConstantesBD.DB_VERSION);

        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String creationQuery = "CREATE TABLE " + ConstantesBD.PET_TABLE +
                "("+
                ConstantesBD.PET_TABLE_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                ConstantesBD.PET_TABLE_NAME+" TEXT,"+
                ConstantesBD.PET_TABLE_RATING+" INTEGER,"+
                ConstantesBD.PET_TABLE_PHOTO+" INTEGER"+
                ")";


        db.execSQL(creationQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+ ConstantesBD.PET_TABLE);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodas(){
        ArrayList<Mascota> mascotas= new ArrayList<Mascota>();

        String query = "SELECT  * FROM "+ConstantesBD.PET_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while(registros.moveToNext()){
            Mascota current = new Mascota();

            current.setId(registros.getInt(0));
            current.setName(registros.getString(1));
            current.setRating(registros.getInt(2));
            current.setFoto(registros.getInt(3));

            mascotas.add(current);
        }

        db.close();
        return mascotas;
    }

    public ArrayList<Mascota> obtenerTop(){
        ArrayList<Mascota> mascotas= new ArrayList<Mascota>();

        String query = "SELECT * FROM "+ConstantesBD.PET_TABLE+" order by "+ConstantesBD.PET_TABLE_RATING+" desc limit 5";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while(registros.moveToNext()){
            Mascota current = new Mascota();

            current.setId(registros.getInt(0));
            current.setName(registros.getString(1));
            current.setRating(registros.getInt(2));
            current.setFoto(registros.getInt(3));

            mascotas.add(current);
        }

        db.close();
        return mascotas;
    }

    public void insertarMascotas(ContentValues values){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.PET_TABLE,null,values);

        db.close();
    }

    public void addLike(String id,int like){
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "UPDATE "+ConstantesBD.PET_TABLE+" SET "+ConstantesBD.PET_TABLE_RATING+"="+(++like)+" WHERE id="+id;
        Toast.makeText(this.context, query, Toast.LENGTH_SHORT).show();
        db.execSQL(query);

        db.close();
    }

}

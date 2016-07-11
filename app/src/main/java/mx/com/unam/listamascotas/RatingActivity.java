package mx.com.unam.listamascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import android.support.v7.widget.Toolbar;

import mx.com.unam.listamascotas.adapter.MascotaAdapter;
import mx.com.unam.listamascotas.db.ConstructorMascotas;
import mx.com.unam.listamascotas.pojo.Mascota;

public class RatingActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        ConstructorMascotas DB = new ConstructorMascotas(getBaseContext());
        mascotas = DB.obtenerTopFiveMacotas();

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas2);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);

        MascotaAdapter ma = new MascotaAdapter(mascotas);

        rvMascotas.setAdapter(ma);

        Toolbar toolbar = (Toolbar) findViewById(R.id.primaryActionBar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch(item.getItemId()){
            case R.id.mcontact:
                intent = new Intent(this,Contacto.class);
                startActivity(intent);
                break;
            case R.id.macerca:
                intent = new Intent(this,Acerca.class);
                startActivity(intent);
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }
}

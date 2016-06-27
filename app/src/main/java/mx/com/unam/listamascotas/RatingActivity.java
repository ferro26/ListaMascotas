package mx.com.unam.listamascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import android.support.v7.widget.Toolbar;

public class RatingActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Mascota 1", 0,R.drawable.mascota1));
        mascotas.add(new Mascota("Mascota 2", 0,R.drawable.mascota2));
        mascotas.add(new Mascota("Mascota 5", 0,R.drawable.mascota5));
        mascotas.add(new Mascota("Mascota 6", 0,R.drawable.mascota6));
        mascotas.add(new Mascota("Mascota 8", 0,R.drawable.mascota8));


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
}

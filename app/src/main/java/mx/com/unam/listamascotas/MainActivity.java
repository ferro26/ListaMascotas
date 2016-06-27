package mx.com.unam.listamascotas;

import android.content.Intent;
import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Mascota 1", 0,R.drawable.mascota1));
        mascotas.add(new Mascota("Mascota 2", 0,R.drawable.mascota2));
        mascotas.add(new Mascota("Mascota 3", 0,R.drawable.mascota3));
        mascotas.add(new Mascota("Mascota 4", 0,R.drawable.mascota4));
        mascotas.add(new Mascota("Mascota 5", 0,R.drawable.mascota5));
        mascotas.add(new Mascota("Mascota 6", 0,R.drawable.mascota6));
        mascotas.add(new Mascota("Mascota 7", 0,R.drawable.mascota7));
        mascotas.add(new Mascota("Mascota 8", 0,R.drawable.mascota8));
        mascotas.add(new Mascota("Mascota 9", 0,R.drawable.mascota9));
        mascotas.add(new Mascota("Mascota 10", 0,R.drawable.mascota10));

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);

        MascotaAdapter ma = new MascotaAdapter(mascotas);

        rvMascotas.setAdapter(ma);

        TextView starAction = (TextView) findViewById(R.id.starAction);

        starAction.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                siguiente();
            }
        });


    }

    public void siguiente(){
        Intent i = new Intent(MainActivity.this,RatingActivity.class);
        startActivity(i);
        //finish();
    }
}

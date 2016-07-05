package mx.com.unam.listamascotas.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mx.com.unam.listamascotas.pojo.Mascota;
import mx.com.unam.listamascotas.R;


public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {


    ArrayList<Mascota> mascotas;

    public MascotaAdapter(ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {


        Mascota mascota = mascotas.get(position);
        System.out.println(mascota.getFoto());
        System.out.println(mascota.getName());
        System.out.println(mascota.getRating());

        holder.img.setImageResource(mascota.getFoto());
        holder.name.setText(mascota.getName());
        holder.rating.setText(mascota.getRating()+"");
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        public ImageView img;
        public TextView name;
        public TextView rating;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.photo);
            name = (TextView) itemView.findViewById(R.id.nameView);
            rating = (TextView) itemView.findViewById(R.id.ratingView);
        }
    }
}

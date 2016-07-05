package mx.com.unam.listamascotas.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import mx.com.unam.listamascotas.R;
import mx.com.unam.listamascotas.pojo.Mascota;


public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.MascotaViewHolder>{

    private List<Mascota> itemList;
    private Context context;

    public AlbumAdapter(Context context, List<Mascota> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridcard, null);
        MascotaViewHolder rcv = new MascotaViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        holder.rating.setText(itemList.get(position).getRating()+"");
        holder.img.setImageResource(itemList.get(position).getFoto());
    }


    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView img;
        public TextView rating;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.pet_photo);
            rating = (TextView) itemView.findViewById(R.id.pet_rating);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "Clicked Pet", Toast.LENGTH_SHORT).show();
        }
    }
}

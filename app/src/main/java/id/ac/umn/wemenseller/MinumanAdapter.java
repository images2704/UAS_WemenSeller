package id.ac.umn.wemenseller;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import id.ac.umn.wemenseller.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;


public class MinumanAdapter extends RecyclerView.Adapter<MinumanAdapter.ViewHolder> {

    ViewHolder holder;

    public MinumanAdapter(ArrayList<Minuman> listMinuman) {
        this.listMinuman = listMinuman;
    }

    private final ArrayList<Minuman> listMinuman;

    @NonNull
    @Override
    public MinumanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        return new ViewHolder(inflater.inflate(R.layout.item_menu, parent, false));
    }

    public String rp(int txt){
        Locale locale = new Locale("in", "ID");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        format.setMaximumFractionDigits(0);
        return format.format(txt); // Integer.toString(total);
    }

    @Override
    public void onBindViewHolder(@NonNull MinumanAdapter.ViewHolder holder, int position) {
        Minuman Minuman = listMinuman.get(position);
        holder.txtNamaMinuman.setText(Minuman.getNamaMinuman());
        holder.txtHargaMinuman.setText(rp(Integer.parseInt(Minuman.getHargaMinuman())));
        holder.imgMinuman.setImageResource(Minuman.getImgMinuman());

        holder.itemView.setOnClickListener(view -> {
                if (listMinuman.get(position).getNamaMinuman().equals("Susu Segar Cimory")) {
                    Intent intent = new Intent(holder.itemView.getContext(), MenuDetailActivity.class);
                    intent.putExtra("GAMBAR_DEFAULT", R.drawable.susu_cimory);
                    intent.putExtra("NAMA_DEFAULT", "Susu Segar Cimory");
                    intent.putExtra("DESKRIPSI_DEFAULT", "Susu Cimory berbagai rasa, bisa dipilih saat checkout");
                    intent.putExtra("HARGA_DEFAULT", "9000");
                    holder.itemView.getContext().startActivity(intent);
                }
                if (listMinuman.get(position).getNamaMinuman().equals("Jus Buavita 225ml")) {
                    Intent intent = new Intent(holder.itemView.getContext(), MenuDetailActivity.class);
                    intent.putExtra("GAMBAR_DEFAULT", R.drawable.jus_buavita);
                    intent.putExtra("NAMA_DEFAULT", "Jus Buavita 225ml");
                    intent.putExtra("DESKRIPSI_DEFAULT", "Jus buah dari Buavita, ada kandungan vitamin");
                    intent.putExtra("HARGA_DEFAULT", "8500");
                    holder.itemView.getContext().startActivity(intent);
                }
                if (listMinuman.get(position).getNamaMinuman().equals("Sprite 250ml")) {
                    Intent intent = new Intent(holder.itemView.getContext(), MenuDetailActivity.class);
                    intent.putExtra("GAMBAR_DEFAULT", R.drawable.sprite_250ml);
                    intent.putExtra("NAMA_DEFAULT", "Sprite 250ml");
                    intent.putExtra("DESKRIPSI_DEFAULT", "Udah tahu kan ini minuman berkarbonasi rasa lemon?");
                    intent.putExtra("HARGA_DEFAULT", "5000");
                    holder.itemView.getContext().startActivity(intent);
                }
                if (listMinuman.get(position).getNamaMinuman().equals("Coca-Cola 250ml")) {
                    Intent intent = new Intent(holder.itemView.getContext(), MenuDetailActivity.class);
                    intent.putExtra("GAMBAR_DEFAULT", R.drawable.coca_cola);
                    intent.putExtra("NAMA_DEFAULT", "Coca-Cola 250ml");
                    intent.putExtra("DESKRIPSI_DEFAULT", "Seenak-enaknya ini bikin gas besar di perut");
                    intent.putExtra("HARGA_DEFAULT", "5000");
                    holder.itemView.getContext().startActivity(intent);
                }
                if (listMinuman.get(position).getNamaMinuman().equals("Air Prima 500ml")) {
                    Intent intent = new Intent(holder.itemView.getContext(), MenuDetailActivity.class);
                    intent.putExtra("GAMBAR_DEFAULT", R.drawable.air_prima);
                    intent.putExtra("NAMA_DEFAULT", "Air Prima 500ml");
                    intent.putExtra("DESKRIPSI_DEFAULT", "Haus? Minum air aja!");
                    intent.putExtra("HARGA_DEFAULT", "6000");
                    holder.itemView.getContext().startActivity(intent);
                }
                if (listMinuman.get(position).getNamaMinuman().equals("S-tee")) {
                    Intent intent = new Intent(holder.itemView.getContext(), MenuDetailActivity.class);
                    intent.putExtra("GAMBAR_DEFAULT", R.drawable.es_tee);
                    intent.putExtra("NAMA_DEFAULT", "S-tee");
                    intent.putExtra("DESKRIPSI_DEFAULT", "Minuman teh menyegarkan");
                    intent.putExtra("HARGA_DEFAULT", "8000");
                    holder.itemView.getContext().startActivity(intent);
                }
            });
        }

    @Override
    public int getItemCount() {
        return listMinuman.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtNamaMinuman, txtHargaMinuman;
        public ImageView imgMinuman;
        public ConstraintLayout itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNamaMinuman = itemView.findViewById(R.id.txtNamaItem);
            txtHargaMinuman = itemView.findViewById(R.id.txtHargaItem);
            imgMinuman = itemView.findViewById(R.id.imgItem);
            this.itemView = itemView.findViewById(R.id.itemLayout);
        }
    }
}

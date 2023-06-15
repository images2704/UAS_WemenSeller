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


public class MakananAdapter extends RecyclerView.Adapter<MakananAdapter.ViewHolder> {

    ViewHolder holder;

    public MakananAdapter(ArrayList<id.ac.umn.wemenseller.Makanan> listMakanan) {
        this.listMakanan = listMakanan;
    }

    private final ArrayList<id.ac.umn.wemenseller.Makanan> listMakanan;

    @NonNull
    @Override
    public MakananAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.item_menu, parent, false));

        return holder;
    }

    public String rp(int txt){
        Locale locale = new Locale("in", "ID");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        format.setMaximumFractionDigits(0);
        return format.format(txt); // Integer.toString(total);
    }

    @Override
    public void onBindViewHolder(@NonNull MakananAdapter.ViewHolder holder, int position) {
        id.ac.umn.wemenseller.Makanan Makanan = listMakanan.get(position);
        holder.txtNamaMakanan.setText(Makanan.getNamaMakanan());
        holder.txtHargaMakanan.setText(rp(Integer.parseInt(Makanan.getHargaMakanan())));
        holder.imgMakanan.setImageResource(Makanan.getImgMakanan());

        holder.itemView.setOnClickListener(view -> {
            if (listMakanan.get(position).getNamaMakanan().equals("Nasi Mentai")) {
                Intent intent = new Intent(holder.itemView.getContext(), id.ac.umn.wemenseller.MenuDetailActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.nasi_mentai);
                intent.putExtra("NAMA_DEFAULT", "Nasi Mentai");
                intent.putExtra("DESKRIPSI_DEFAULT", "Nasi daging ayam/tuna/kepiting dengan saus mentai diatasnya");
                intent.putExtra("HARGA_DEFAULT", "23000");
                holder.itemView.getContext().startActivity(intent);
            }
            if (listMakanan.get(position).getNamaMakanan().equals("Nasi Karaage")) {
                Intent intent = new Intent(holder.itemView.getContext(), id.ac.umn.wemenseller.MenuDetailActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.nasi_karaage);
                intent.putExtra("NAMA_DEFAULT", "Nasi Karaage");
                intent.putExtra("DESKRIPSI_DEFAULT", "Nasi dengan Karaage (ayam goreng potong)");
                intent.putExtra("HARGA_DEFAULT", "25000");
                holder.itemView.getContext().startActivity(intent);
            }
            if (listMakanan.get(position).getNamaMakanan().equals("Nasi Padang")) {
                Intent intent = new Intent(holder.itemView.getContext(), id.ac.umn.wemenseller.MenuDetailActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.sushi_sepuluh);
                intent.putExtra("NAMA_DEFAULT", "Nasi Padang");
                intent.putExtra("DESKRIPSI_DEFAULT", "Sepedes-pedesnya bikin perut penuh!");
                intent.putExtra("HARGA_DEFAULT", "30000");
                holder.itemView.getContext().startActivity(intent);
            }
            if (listMakanan.get(position).getNamaMakanan().equals("Nasi Ayam Saus Telur Asin")) {
                Intent intent = new Intent(holder.itemView.getContext(), id.ac.umn.wemenseller.MenuDetailActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.nasi_ayam_telur_asin);
                intent.putExtra("NAMA_DEFAULT", "Nasi Ayam Saus Telur Asin");
                intent.putExtra("DESKRIPSI_DEFAULT", "Nasi dengan ayam kecil-kecil pakai saus telur asin");
                intent.putExtra("HARGA_DEFAULT", "25000");
                holder.itemView.getContext().startActivity(intent);
            }
            if (listMakanan.get(position).getNamaMakanan().equals("Crepe Es Krim")) {
                Intent intent = new Intent(holder.itemView.getContext(), id.ac.umn.wemenseller.MenuDetailActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.crepe_eskrim);
                intent.putExtra("NAMA_DEFAULT", "Crepe Es Krim");
                intent.putExtra("DESKRIPSI_DEFAULT", "Crepe dengan Es Krim, rasa es krim bisa random");
                intent.putExtra("HARGA_DEFAULT", "25000");
                holder.itemView.getContext().startActivity(intent);
            }
            if (listMakanan.get(position).getNamaMakanan().equals("Nasi Goreng")) {
                Intent intent = new Intent(holder.itemView.getContext(), id.ac.umn.wemenseller.MenuDetailActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.nasi_goreng);
                intent.putExtra("NAMA_DEFAULT", "Nasi Goreng");
                intent.putExtra("DESKRIPSI_DEFAULT", "Dibuat dari sisa nasi yang tidak dipakai. Tinggal pakai kecap dan daging ayam, udah!");
                intent.putExtra("HARGA_DEFAULT", "20000");
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMakanan.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtNamaMakanan, txtHargaMakanan;
        public ImageView imgMakanan;
        public ConstraintLayout itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNamaMakanan = itemView.findViewById(R.id.txtNamaItem);
            txtHargaMakanan = itemView.findViewById(R.id.txtHargaItem);
            imgMakanan = itemView.findViewById(R.id.imgItem);
            this.itemView = itemView.findViewById(R.id.itemLayout);
        }
    }
}

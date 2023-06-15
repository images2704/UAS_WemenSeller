package id.ac.umn.wemenseller;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import id.ac.umn.wemenseller.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.text.NumberFormat;
import java.util.Locale;


public class PesananAdapter extends FirestoreRecyclerAdapter<id.ac.umn.wemenseller.Pesanan, PesananAdapter.ViewHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public PesananAdapter(@NonNull FirestoreRecyclerOptions<id.ac.umn.wemenseller.Pesanan> options) {
        super(options);
    }

    public String rp(int txt){
        Locale locale = new Locale("in", "ID");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        format.setMaximumFractionDigits(0);
        return format.format(txt); // Integer.toString(total);
    }

    @Override
    protected void onBindViewHolder(@NonNull PesananAdapter.ViewHolder holder, int position, @NonNull id.ac.umn.wemenseller.Pesanan model) {
        holder.txtPesanan.setText(model.namaPesanan + " (" + String.valueOf(model.jumlahPesanan) +
                " x " + rp(Integer.parseInt(String.valueOf(model.hargaPesanan))) + ')');
        holder.txtJmlHarga.setText(rp(Integer.parseInt(String.valueOf(model.hargaPesanan * model.jumlahPesanan))));

        holder.itemLayout.setOnClickListener(view -> {
            Context context = holder.itemLayout.getContext();
            Intent it = new Intent(context, id.ac.umn.wemenseller.DetailCartActivity.class);
            it.putExtra("pesanan", model);
            context.startActivity(it);
        });
    }

    @NonNull
    @Override
    public PesananAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.item_records, parent, false));
        return holder;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView txtPesanan, txtJmlHarga;
        public ConstraintLayout itemLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtPesanan = itemView.findViewById(R.id.txt_pesanan);
            txtJmlHarga = itemView.findViewById(R.id.txt_jmlharga);
            itemLayout = itemView.findViewById(R.id.item_layout);

        }
    }
}

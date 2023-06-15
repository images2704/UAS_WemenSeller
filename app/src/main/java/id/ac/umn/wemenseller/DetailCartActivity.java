package id.ac.umn.wemenseller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import id.ac.umn.wemenseller.R;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.NumberFormat;
import java.util.Locale;

import id.ac.umn.wemenseller.MenuActivity;
import id.ac.umn.wemenseller.Pesanan;


public class DetailCartActivity extends AppCompatActivity {

    TextView txtPesanan, txtJmlHarga;

    FirebaseFirestore fireDb;
    Pesanan pesanan;

    String del;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cart);
        txtPesanan = findViewById(R.id.txt_pesanan_detail);
        txtJmlHarga = findViewById(R.id.txt_jmlharga_detail);

        Intent it = getIntent();
        Pesanan pesanan = (Pesanan) it.getSerializableExtra("pesanan");
        txtPesanan.setText(pesanan.namaPesanan + " (" + String.valueOf(pesanan.jumlahPesanan) +
                " x " + rp(Integer.parseInt(String.valueOf(pesanan.hargaPesanan))) + ')');
        txtJmlHarga.setText(rp(Integer.parseInt(String.valueOf(pesanan.hargaPesanan * pesanan.jumlahPesanan))));

        fireDb = FirebaseFirestore.getInstance();

        del = pesanan.namaPesanan;
    }

    public String rp(int txt){
        Locale locale = new Locale("in", "ID");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        format.setMaximumFractionDigits(0);
        return format.format(txt); // Integer.toString(total);
    }

    public void close(View v){
        finish();
    }


    public void delete(View v){
        fireDb.collection("pesanan").whereEqualTo("namaPesanan",del)
                .get().addOnCompleteListener(task -> {
                    if(task.isSuccessful() && !task.getResult().isEmpty()){
                        DocumentSnapshot documentSnapshot = task.getResult().getDocuments().get(0);
                        String documentID = documentSnapshot.getId();
                        fireDb.collection("pesanan")
                                .document(documentID)
                                .delete();
                    }
                });
        startActivity(new Intent(this, MenuActivity.class));
    }
}
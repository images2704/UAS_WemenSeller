package id.ac.umn.wemenseller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import id.ac.umn.wemenseller.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

import id.ac.umn.wemenseller.Minuman;
import id.ac.umn.wemenseller.MinumanAdapter;

public class MenuActivity extends AppCompatActivity {

    String namaUser;
    TextView txtNama;

    FirebaseUser user;
    FirebaseAuth mAuth;

    FirebaseFirestore fireDb;

    private ArrayList<id.ac.umn.wemenseller.Makanan> listMakanan;
    private ArrayList<Minuman> listMinuman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initFab();

        fireDb = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        namaUser = user.getEmail();

        RecyclerView recMakanan = findViewById(R.id.rec_makanan);
        RecyclerView recMinuman = findViewById((R.id.rec_minuman));
        initDataMakanan();
        initDataMinuman();

        recMakanan.setAdapter(new id.ac.umn.wemenseller.MakananAdapter(listMakanan));
        recMakanan.setLayoutManager(new LinearLayoutManager(this));

        recMinuman.setAdapter(new MinumanAdapter(listMinuman));
        recMinuman.setLayoutManager(new LinearLayoutManager(this));

        txtNama = findViewById(R.id.txtNama);
        txtNama.setText("Hi, " + namaUser);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initFab(){
        FloatingActionButton fabCart = findViewById(R.id.fabCart);
        fabCart.setOnClickListener(view -> startActivity(new Intent(getBaseContext(), id.ac.umn.wemenseller.CartActivity.class)));

        FloatingActionButton fabLogout = findViewById(R.id.fabLogout);
        fabLogout.setOnClickListener(view -> {
            mAuth.signOut();
            startActivity(new Intent(getBaseContext(), id.ac.umn.wemenseller.MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
        });
    }

    private void initDataMakanan(){
        this.listMakanan =  new ArrayList<>();
        listMakanan.add(new id.ac.umn.wemenseller.Makanan("Nasi Mentai (dengan daging ayam, kepiting, atau tuna)", "25000", R.drawable.nasi_mentai));
        listMakanan.add(new id.ac.umn.wemenseller.Makanan("Nasi Karaage", "20000", R.drawable.nasi_karaage));
        listMakanan.add(new id.ac.umn.wemenseller.Makanan("Sushi 10 Potong", "25000", R.drawable.sushi_sepuluh));
        listMakanan.add(new id.ac.umn.wemenseller.Makanan("Nasi Ayam Saus Telur Asin", "25000", R.drawable.nasi_ayam_telur_asin));
        listMakanan.add(new id.ac.umn.wemenseller.Makanan("Crepe Es Krim Vanila", "30000", R.drawable.crepe_eskrim));
        listMakanan.add(new id.ac.umn.wemenseller.Makanan("Nasi Goreng", "20000", R.drawable.nasi_goreng));
        listMakanan.add(new id.ac.umn.wemenseller.Makanan("Es Krim (rasa random)", "10000", R.drawable.es_krim));
        listMakanan.add(new id.ac.umn.wemenseller.Makanan("Nasi Padang", "30000", R.drawable.nasi_padang));
        listMakanan.add(new id.ac.umn.wemenseller.Makanan("Wrap Ayam dengan Sayur", "25000", R.drawable.chicken_wrap));
        listMakanan.add(new id.ac.umn.wemenseller.Makanan("Salad Sayur", "20000", R.drawable.salad_sayur));
    }

    private void initDataMinuman(){
        this.listMinuman = new ArrayList<>();
        listMinuman.add(new Minuman("Susu Segar Cimory (rasa random)", "9000", R.drawable.susu_cimory));
        listMinuman.add(new Minuman("Jus Buavita 225ml (rasa random)", "8500", R.drawable.jus_buavita));
        listMinuman.add(new Minuman("Sprite 250ml", "5000", R.drawable.sprite_250ml));
        listMinuman.add(new Minuman("Coca-Cola 250ml", "5000", R.drawable.coca_cola));
        listMinuman.add(new Minuman("Air Prima 500ml", "6000", R.drawable.air_prima));
        listMinuman.add(new Minuman("S-tee", "8000", R.drawable.es_tee));
        listMinuman.add(new Minuman("Teh Pucuk Harum", "5500", R.drawable.teh_pucuk));
    }
}
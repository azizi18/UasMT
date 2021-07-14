package me.azizi.daftarbelanja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private DaftarViewModel daftarViewModel;
    public static final int NEW_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rv_belanja);
        final AdapterDaftarBelanja adapter = new AdapterDaftarBelanja();
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        daftarViewModel = new ViewModelProvider(this).get(DaftarViewModel.class);
        daftarViewModel.getAllBelanja().observe(this, adapter::setDaftarBelanjas);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, InputBelanjaActivity.class);
            startActivityForResult(intent, NEW_ACTIVITY_REQUEST_CODE);
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NEW_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            DaftarBelanja daftarBelanja=null;

            if (data !=null){
                daftarBelanja = new DaftarBelanja(data.getStringExtra(InputBelanjaActivity.EXTRA_NAME_BELANJA),data.getIntExtra(InputBelanjaActivity.EXTRA_BANYAK_BELANJA,0));
            }
            Toast.makeText(getApplicationContext(), R.string.saved, Toast.LENGTH_LONG).show();
            daftarViewModel.insert(daftarBelanja);
        } else {
            Toast.makeText(getApplicationContext(), R.string.empty_not_saved, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
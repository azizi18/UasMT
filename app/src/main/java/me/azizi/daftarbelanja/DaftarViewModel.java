package me.azizi.daftarbelanja;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class DaftarViewModel extends AndroidViewModel {
    private DaftarBelanjaRepository daftarBelanjaRepository;
    private LiveData<List<DaftarBelanja>> liastDaftarBelanja;

    public DaftarViewModel(@NonNull Application application) {
        super(application);
        daftarBelanjaRepository = new DaftarBelanjaRepository(application);
        liastDaftarBelanja = daftarBelanjaRepository.getAllDaftarBelanja();

    }
    LiveData<List<DaftarBelanja>> getAllBelanja() {
        return liastDaftarBelanja;
    }

    void insert(DaftarBelanja daftarBelanja) {
        daftarBelanjaRepository.insert(daftarBelanja);
    }
}

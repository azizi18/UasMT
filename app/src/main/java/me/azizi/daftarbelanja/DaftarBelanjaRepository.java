package me.azizi.daftarbelanja;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class DaftarBelanjaRepository {
    private DaptarBelanjaDAO daptarBelanjaDAO;
    private LiveData<List<DaftarBelanja>> listDaftarBelanja;

    DaftarBelanjaRepository(Application application) {
        DaftarBelanjaDatabase db = DaftarBelanjaDatabase.getDatabase(application);
        daptarBelanjaDAO = db.dao();
        listDaftarBelanja = daptarBelanjaDAO.getAllBelanja();
    }
    LiveData<List<DaftarBelanja>> getAllDaftarBelanja() {
        return listDaftarBelanja;
    }
    void insert(DaftarBelanja daftarBelanja) {
      DaftarBelanjaDatabase.databaseWriteExecutor.execute(() -> daptarBelanjaDAO.insert(daftarBelanja));
    }
}



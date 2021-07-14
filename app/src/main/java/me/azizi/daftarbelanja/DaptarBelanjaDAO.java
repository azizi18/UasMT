 package me.azizi.daftarbelanja;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaptarBelanjaDAO {

    @Query("SELECT * FROM tabel_belanja ORDER BY nama ASC")
    LiveData<List<DaftarBelanja>> getAllBelanja();

    @Insert
    void insert(DaftarBelanja daftarBelanja);

    @Query("DELETE FROM tabel_belanja")
    void deleteAll();
}

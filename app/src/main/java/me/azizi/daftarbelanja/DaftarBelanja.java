package me.azizi.daftarbelanja;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tabel_belanja")
public class DaftarBelanja {
    @PrimaryKey
    @NonNull @ColumnInfo(name = "nama") private String nama;
    @ColumnInfo(name = "banyak") private int banyak;

    public DaftarBelanja(@NonNull String nama, int banyak) {
        this.nama = nama;
        this.banyak = banyak;
    }

    @NonNull
    public String getNama() {
        return nama;
    }

    public void setNama(@NonNull String nama) {
        this.nama = nama;
    }

    public int getBanyak() {
        return banyak;
    }

    public void setBanyak(int banyak) {
        this.banyak = banyak;
    }
}

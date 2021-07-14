package me.azizi.daftarbelanja;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {DaftarBelanja.class}, version = 1, exportSchema = false)
abstract class DaftarBelanjaDatabase extends RoomDatabase {
    abstract DaptarBelanjaDAO dao();

    private static volatile DaftarBelanjaDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static DaftarBelanjaDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (DaftarBelanjaDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DaftarBelanjaDatabase.class, "belanja_database")
                            .addCallback(Callback)
                            .build();

                }
            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback Callback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };
}
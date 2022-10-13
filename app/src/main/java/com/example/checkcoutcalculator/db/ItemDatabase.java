package com.example.checkcoutcalculator.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

@Database(entities = {CartItem.class, MenuItem.class}, version = 1)
public abstract class ItemDatabase extends RoomDatabase {

    public abstract ItemDao itemDao();

    // Singleton pattern
    public static ItemDatabase INSTANCE;
    public static ItemDatabase getDbInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ItemDatabase.class,
                    "ItemDB")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .addCallback(new RoomDatabase.Callback() { // prepopulate database
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            for(MenuItem menuItem : prepopData){
                                getDbInstance(context).itemDao().insertMenuItem(menuItem);
                            }
                        }
                    })
                    .build();
        }
        return INSTANCE;
    }

    // prepopulate db data
    private static final List<MenuItem> prepopData = Arrays.asList(
            new MenuItem("LV", 20000.0, true),
            new MenuItem("iPhone 14 Pro Max", 3000.0, true),
            new MenuItem("Apple (1lb)", 1.99, false),
            new MenuItem("White potato (1lb)", 2.99, false)
    );
}

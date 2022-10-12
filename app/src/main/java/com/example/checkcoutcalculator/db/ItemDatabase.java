package com.example.checkcoutcalculator.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

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
//                    .addCallback()
                    .build();
        }
        return INSTANCE;
    }

}

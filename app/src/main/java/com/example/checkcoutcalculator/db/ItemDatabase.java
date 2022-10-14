package com.example.checkcoutcalculator.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.Arrays;
import java.util.List;

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
                    .addCallback(callback)
                    .build();
        }
        return INSTANCE;
    }

    /**
     * Pre-populating the menu table using callback function
     */
    private static final RoomDatabase.Callback callback =
            new RoomDatabase.Callback(){
                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final ItemDao Dao;

        // prepopulate db data
        private static final List<MenuItem> prepopData = Arrays.asList(
                new MenuItem(1, "LV", 20000.0, true),
                new MenuItem(2, "iPhone 14 Pro Max", 3000.0, true),
                new MenuItem(3, "Apple (1lb)", 1.99, false),
                new MenuItem(4, "White potato (1lb)", 2.99, false),
                new MenuItem(5, "Tomato (1lb)", 2.32, false),
                new MenuItem(6, "UofT T-shirt", 120.00, true),
                new MenuItem(7, "CS Tuition Fee", 63729.63, false),
                new MenuItem(8, "White potato (1lb)", 2.99, false),
                new MenuItem(9, "Brian's Brain", 0.99, true)
        );

        PopulateDbAsync(ItemDatabase db) {
            Dao = db.itemDao();
        }

        @Override
        protected Void doInBackground(final Void... params) { // reset db whenever app is started.
            Dao.clearMenu();

            for (MenuItem item : prepopData) {
                Dao.insertMenuItem(item);
            }
            return null;
        }
    }
}

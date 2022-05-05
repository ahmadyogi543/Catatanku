package com.joyapps.catatanku.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.joyapps.catatanku.models.GoodModel;
import com.joyapps.catatanku.models.UserModel;

@Database(entities = {UserModel.class, GoodModel.class}, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DB_NAME = "dbcatatanku";
    private static AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context ctx) {
        if (instance == null) {
            instance = Room.databaseBuilder(ctx.getApplicationContext(),
                    AppDatabase.class, DB_NAME).fallbackToDestructiveMigration()
                    .allowMainThreadQueries().build();
        }
        return instance;
    }

    public abstract UserDao userDao();
    public abstract GoodDao goodDao();
}

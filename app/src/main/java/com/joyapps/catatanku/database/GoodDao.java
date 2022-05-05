package com.joyapps.catatanku.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GoodDao {
    @Query("SELECT * FROM good_table")
    List<Good> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertOne(Good good);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(Good... goods);

    @Query("DELETE FROM good_table WHERE good_name = :goodName")
    void deleteByName(String goodName);
}

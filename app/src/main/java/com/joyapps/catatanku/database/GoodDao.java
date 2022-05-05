package com.joyapps.catatanku.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.joyapps.catatanku.models.GoodModel;

import java.util.List;

@Dao
public interface GoodDao {
    @Query("SELECT * FROM good_table")
    List<GoodModel> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertOne(GoodModel goodModel);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(GoodModel... goodModels);

    @Query("DELETE FROM good_table WHERE good_name = :goodName")
    void deleteByName(String goodName);
}

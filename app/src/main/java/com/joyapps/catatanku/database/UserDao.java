package com.joyapps.catatanku.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.joyapps.catatanku.models.UserModel;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user_table")
    List<UserModel> getAll();

    @Query("SELECT * FROM user_table WHERE username = :uname")
    UserModel findUser(String uname);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(UserModel... userModels);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void InsertOne(UserModel userModel);

    @Delete
    void delete(UserModel userModel);
}


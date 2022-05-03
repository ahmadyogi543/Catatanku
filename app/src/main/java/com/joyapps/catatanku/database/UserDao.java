package com.joyapps.catatanku.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user_table")
    List<User> getAll();

    @Query("SELECT * FROM user_table WHERE username LIKE :username LIMIT 1")
    User findUser(String username);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(User... users);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void InsertOne(User user);

    @Delete
    void delete(User user);
}


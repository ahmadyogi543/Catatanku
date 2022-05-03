package com.joyapps.catatanku.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {
    @PrimaryKey
    @NonNull
    private String username;

    @ColumnInfo(name = "full_name")
    private String fullName;

    private String password;

    @ColumnInfo(name = "password_hint")
    private String passwordHint;

    @ColumnInfo(name = "store_name")
    private String storeName;

    public User(@NonNull String username, String fullName, String password, String passwordHint, String storeName) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.passwordHint = passwordHint;
        this.storeName = storeName;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordHint() {
        return passwordHint;
    }

    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}

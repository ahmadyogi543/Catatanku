package com.joyapps.catatanku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.mainActivity_bottomNavView);

        this.setupBottomNavigationView();
    }

    public void setupBottomNavigationView() {
        // menginisialisasi bottom navigation view
        NavController navController = Navigation.findNavController(findViewById(R.id.mainActivity_navFragment));
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}

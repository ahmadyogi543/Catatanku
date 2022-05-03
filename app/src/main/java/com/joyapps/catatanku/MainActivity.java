package com.joyapps.catatanku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setupBottomNavigationView();
    }

    public void setupBottomNavigationView() {
        // menginisialisasi bottom navigation view
        BottomNavigationView bottomNavigationView = findViewById(R.id.mainActivity_bottomNavView);
        NavController navController = Navigation.findNavController(findViewById(R.id.mainActivity_navFragment));
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}

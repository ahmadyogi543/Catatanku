package com.joyapps.catatanku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

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
        NavController navController = Navigation.findNavController(findViewById(R.id.mainActivity_navFragment));
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.loginFragment ||
            destination.getId() == R.id.signUpFragment ||
            destination.getId() == R.id.addGoodsFragment ||
            destination.getId() == R.id.splashScreenFragment) {
                bottomNavigationView.setVisibility(View.GONE);
            }
            else {
                bottomNavigationView.setVisibility(View.VISIBLE);
            }
        });
    }
}

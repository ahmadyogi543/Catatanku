package com.joyapps.catatanku.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.joyapps.catatanku.R;
import com.joyapps.catatanku.database.AppDatabase;
import com.joyapps.catatanku.models.UserModel;

public class AccountFragment extends Fragment {

    private AppDatabase appDB;
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;

    TextView txtFullName;
    TextView txtUserName;
    TextView txtStoreName;
    TextView txtPasswordHint;

    Button btnEditInfo;
    Button btnLogout;

    public AccountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        appDB = AppDatabase.getInstance(getContext());
        sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        txtFullName = view.findViewById(R.id.txtFullName);
        txtUserName = view.findViewById(R.id.txtUserName);
        txtStoreName = view.findViewById(R.id.txtStoreName);
        txtPasswordHint = view.findViewById(R.id.txtPasswordHint);

        btnEditInfo = view.findViewById(R.id.btnEditInfo);
        btnLogout = view.findViewById(R.id.btnLogout);

        this.handleUserInfo();
        this.handleBtnLogout();
    }

    private void handleBtnLogout() {
        btnLogout.setOnClickListener(v -> {
            editor.putBoolean("isLogin", false);
            editor.apply();

            Navigation.findNavController(v).navigate(R.id.action_accountFragment_to_loginFragment);
        });
    }

    private void handleUserInfo() {
        String loggedUserName = sharedPref.getString("loggedUsername", "");

        UserModel loggedUserModel = appDB.userDao().findUser(loggedUserName);
        txtFullName.setText(loggedUserModel.getFullName());
        txtUserName.setText(loggedUserModel.getUsername());
        txtStoreName.setText(loggedUserModel.getStoreName());
        txtPasswordHint.setText(loggedUserModel.getPasswordHint());
    }
}

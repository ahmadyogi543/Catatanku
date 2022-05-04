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
import android.widget.EditText;
import android.widget.Toast;

import com.joyapps.catatanku.R;
import com.joyapps.catatanku.database.AppDatabase;
import com.joyapps.catatanku.database.User;
import com.joyapps.catatanku.utils.MyUtils;

import java.util.List;

public class loginFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private AppDatabase appDB;
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;

    private EditText txtUserName;
    private EditText txtPassword;
    private Button btnLogin;
    private Button btnSignUp;

    public loginFragment() {
        // Required empty public constructor
    }

    public static loginFragment newInstance(String param1, String param2) {
        loginFragment fragment = new loginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // setup for database and sharedprefs
        appDB = AppDatabase.getInstance(getContext());
        sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        // get views
        txtUserName = view.findViewById(R.id.txtUserName);
        txtPassword = view.findViewById(R.id.txtPassword);
        btnSignUp = view.findViewById(R.id.btnSignUp);
        btnLogin = view.findViewById(R.id.btnLogin);

        // handle actions
        this.handleBtnLogin();
        this.handleBtnSignUp();
        this.handleCheckLoginStatus(view);
    }

    private void handleCheckLoginStatus(View view) {
        boolean isLogin = sharedPref.getBoolean("isLogin", false);

        if (isLogin) {
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_salesFragment);
        }
    }

    private void handleBtnLogin() {
        btnLogin.setOnClickListener(v -> {
            List<User> users = appDB.userDao().getAll();
            String username = txtUserName.getText().toString();
            String password = MyUtils.getHashedPassword(txtPassword.getText().toString());

            if (!username.isEmpty() && !password.isEmpty()) {
                if (username.equals(users.get(0).getUsername()) && password.equals(users.get(0).getPassword())) {
                    editor.putBoolean("isLogin", true);
                    editor.apply();

                    Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_salesFragment);
                }
                else {
                    Toast.makeText(getContext(),
                            "Nama pengguna atau kata sandi salah!", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(getContext(),
                        "Nama pengguna atau kata sandi kosong!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void handleBtnSignUp() {
        btnSignUp.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_signUpFragment));
    }
}

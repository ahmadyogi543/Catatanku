package com.joyapps.catatanku.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.joyapps.catatanku.R;
import com.joyapps.catatanku.database.AppDatabase;
import com.joyapps.catatanku.models.UserModel;
import com.joyapps.catatanku.utils.MyUtils;

public class SignUpFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private AppDatabase appDB;

    private EditText txtFullName;
    private EditText txtUserName;
    private EditText txtPassword;
    private EditText txtPasswordHint;
    private EditText txtStoreName;
    private CheckBox cbTOSAgree;
    private Button btnSignUp;
    private Button btnAbout;

    public SignUpFragment() {
        // Required empty public constructor
    }

    public static SignUpFragment newInstance(String param1, String param2) {
        SignUpFragment fragment = new SignUpFragment();
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
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        appDB = AppDatabase.getInstance(getContext());

        txtFullName = view.findViewById(R.id.txtFullName);
        txtUserName = view.findViewById(R.id.txtUserName);
        txtPassword = view.findViewById(R.id.txtPassword);
        txtPasswordHint = view.findViewById(R.id.txtPasswordHint);
        txtStoreName = view.findViewById(R.id.txtStoreName);
        cbTOSAgree = view.findViewById(R.id.cbTOSAgree);

        btnSignUp = view.findViewById(R.id.btnSignUp);
        btnAbout = view.findViewById(R.id.btnAbout);

        this.handleBtnSignUp(view);
    }

    private void handleBtnSignUp(View view) {
        btnSignUp.setOnClickListener(v -> {
            String fullName = txtFullName.getText().toString();
            String userName = txtUserName.getText().toString();
            String password = MyUtils.getHashedPassword(txtPassword.getText().toString());
            String passwordHint = txtPasswordHint.getText().toString();
            String storeName = txtStoreName.getText().toString();

            if (!fullName.isEmpty() && !userName.isEmpty() &&
                !password.isEmpty() && !passwordHint.isEmpty() &&
                !storeName.isEmpty()) {
                if (cbTOSAgree.isChecked()) {
                    UserModel userModel = new UserModel(userName, fullName, password, passwordHint, storeName);
                    appDB.userDao().InsertOne(userModel);
                    Toast.makeText(getContext(),
                            "Akun berhasil terdaftar, silahkan login!", Toast.LENGTH_LONG).show();

                    Navigation.findNavController(v).navigate(R.id.action_signUpFragment_to_loginFragment);
                }
                else {
                    Toast.makeText(getContext(),
                            "Anda harus setuju dengan S&K aplikasi!", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(getContext(),
                        "Isikan semua data yang diperlukan!", Toast.LENGTH_SHORT).show();
            }

        });
    }
}

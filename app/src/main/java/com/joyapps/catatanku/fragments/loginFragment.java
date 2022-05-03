package com.joyapps.catatanku.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.joyapps.catatanku.R;

public class loginFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

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
         btnSignUp = view.findViewById(R.id.btnSignUp);
         btnLogin = view.findViewById(R.id.btnLogin);

        this.handleBtnLogin(view);
        this.handleBtnSignUp(view);
    }

    private void handleBtnLogin(View view) {
        btnLogin.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(requireActivity().findViewById(R.id.mainActivity_navFragment));
            navController.navigate(R.id.action_loginFragment_to_salesFragment);
        });
    }

    private void handleBtnSignUp(View view) {
        btnSignUp.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(requireActivity().findViewById(R.id.mainActivity_navFragment));
            navController.navigate(R.id.action_loginFragment_to_signUpFragment);
        });
    }
}

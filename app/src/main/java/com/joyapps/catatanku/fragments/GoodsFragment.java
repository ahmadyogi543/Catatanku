package com.joyapps.catatanku.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.joyapps.catatanku.R;
import com.joyapps.catatanku.adapters.GoodAdapter;
import com.joyapps.catatanku.database.AppDatabase;
import com.joyapps.catatanku.models.GoodModel;

import java.util.ArrayList;

public class GoodsFragment extends Fragment {
    private AppDatabase appDB;
    RecyclerView recyclerView;
    LinearLayout iconNoGoods;
    EditText txtSearchGoods;
    Button btnAddGood;

    public GoodsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_goods, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        appDB = AppDatabase.getInstance(getContext());

        txtSearchGoods = view.findViewById(R.id.txtSearchGoods);
        iconNoGoods = view.findViewById(R.id.iconNoGoods);
        recyclerView = view.findViewById(R.id.rvGoods);
        btnAddGood = view.findViewById(R.id.btnAddGood);

        this.setupGoodsData();
        this.handleBtnAddGood();
        this.handleTxtSearchGoods();
    }

    private void handleTxtSearchGoods() {
        txtSearchGoods.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ArrayList<GoodModel> goodModels = new ArrayList<>(appDB.goodDao().searchByName(charSequence.toString()));

                if (goodModels.size() != 0) {
                    iconNoGoods.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);

                    GoodAdapter goodAdapter = new GoodAdapter(iconNoGoods, recyclerView, goodModels);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(goodAdapter);
                }
                else {
                    recyclerView.setVisibility(View.GONE);
                    iconNoGoods.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void handleBtnAddGood() {
        btnAddGood.setOnClickListener(v -> Navigation.findNavController(v)
                .navigate(R.id.action_goodsFragment_to_addGoodsFragment));
    }

    private void setupGoodsData() {
        ArrayList<GoodModel> goodModels = new ArrayList<>(appDB.goodDao().getAll());

        if (goodModels.size() != 0) {
            iconNoGoods.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

            GoodAdapter goodAdapter = new GoodAdapter(iconNoGoods, recyclerView, goodModels);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(goodAdapter);
        }
    }
}

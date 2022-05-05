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
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.joyapps.catatanku.R;
import com.joyapps.catatanku.database.AppDatabase;
import com.joyapps.catatanku.models.GoodModel;

public class AddGoodsFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    AppDatabase appDB;

    EditText txtGoodName;
    EditText txtGoodPrice;
    EditText txtGoodQty;
    RadioGroup rgQuality;

    Button btnAddGood;
    Button btnCancelAdd;

    public AddGoodsFragment() {
        // Required empty public constructor
    }

    public static AddGoodsFragment newInstance(String param1, String param2) {
        AddGoodsFragment fragment = new AddGoodsFragment();
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
        return inflater.inflate(R.layout.fragment_add_goods, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        appDB = AppDatabase.getInstance(getContext());

        txtGoodName = view.findViewById(R.id.txtGoodName);
        txtGoodPrice = view.findViewById(R.id.txtGoodPrice);
        txtGoodQty = view.findViewById(R.id.txtGoodQty);
        rgQuality = view.findViewById(R.id.rgQuality);

        btnAddGood = view.findViewById(R.id.btnAddGood);
        btnCancelAdd = view.findViewById(R.id.btnCancelAdd);

        this.handleBtnAddGood();
        this.handleBtnCancelAdd();
    }

    private void handleBtnAddGood() {
        btnAddGood.setOnClickListener(v -> {
            String goodName = txtGoodName.getText().toString();
            String goodPrice = txtGoodPrice.getText().toString();
            String goodQty = txtGoodQty.getText().toString();
            String goodQuality;

            if (rgQuality.getCheckedRadioButtonId() == R.id.rbUsed) {
                goodQuality = "Bekas";
            } else {
                goodQuality = "Baru";
            }

            if (!goodName.isEmpty() && !goodPrice.isEmpty() && !goodQty.isEmpty()) {
                GoodModel goodModel = new GoodModel(
                        goodName,
                        Integer.parseInt(goodQty),
                        goodQuality,
                        Integer.parseInt(goodPrice)
                );

                appDB.goodDao().insertOne(goodModel);
                Toast.makeText(getContext(), "Barang berhasil ditambahkan!", Toast.LENGTH_LONG).show();

                Navigation.findNavController(v).navigate(R.id.action_addGoodsFragment_to_goodsFragment);
            }
            else {
                Toast.makeText(getContext(), "Isikan semua data yang diperlukan!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void handleBtnCancelAdd() {
        btnCancelAdd.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_addGoodsFragment_to_goodsFragment));
    }
}

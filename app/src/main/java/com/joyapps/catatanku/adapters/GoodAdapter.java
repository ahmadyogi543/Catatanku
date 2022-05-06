package com.joyapps.catatanku.adapters;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joyapps.catatanku.R;
import com.joyapps.catatanku.models.GoodModel;

import java.util.ArrayList;

public class GoodAdapter extends RecyclerView.Adapter<GoodAdapter.ViewHolder> {
    private final ArrayList<GoodModel> goodModels;

    public GoodAdapter(ArrayList<GoodModel> goodModels) {
        this.goodModels = goodModels;
    }

    @NonNull
    @Override
    public GoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rv_goods_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GoodAdapter.ViewHolder holder, int position) {
        String goodName = goodModels.get(position).getGoodName();
        String goodQty = "Jumlah : " + goodModels.get(position).getGoodQty();
        String goodQuality = "Kualitas : " + goodModels.get(position).getGoodQuality();
        @SuppressLint("DefaultLocale")
        String goodPrice = "Rp. " + String.format("%,d", goodModels.get(position).getGoodPrice());

        holder.txtGoodName.setText(goodName);
        holder.txtGoodQty.setText(goodQty);
        holder.txtGoodQuality.setText(goodQuality);
        holder.txtGoodPrice.setText(goodPrice);

        holder.itemView.setOnLongClickListener(v -> {
            AlertDialog alertDialog = new AlertDialog.Builder(v.getContext())
                    .setTitle("Penghapusan Barang")
                    .setMessage("Hapus barang ini?")
                    .setPositiveButton("HAPUS", ((dialogInterface, i) -> {
                        this.removeItemAt(position);
                        Toast.makeText(v.getContext(), "Barang berhasil dihapus!", Toast.LENGTH_SHORT).show();
                    }))
                    .setNegativeButton("BATAL", ((dialogInterface, i) -> dialogInterface.dismiss())).create();
            alertDialog.setOnShowListener(dialogInterface -> {
                Button button = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
                button.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

                button = alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
                button.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            });
            alertDialog.show();

            return false;
        });
    }

    public void removeItemAt(int position) {
        goodModels.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, goodModels.size());
    }

    @Override
    public int getItemCount() {
        return (goodModels == null) ? 0 : goodModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView txtGoodName;
        private final TextView txtGoodQty;
        private final TextView txtGoodQuality;
        private final TextView txtGoodPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtGoodName = itemView.findViewById(R.id.txtGoodName);
            txtGoodQty = itemView.findViewById(R.id.txtGoodQty);
            txtGoodQuality = itemView.findViewById(R.id.txtGoodQuality);
            txtGoodPrice = itemView.findViewById(R.id.txtGoodPrice);
        }
    }
}

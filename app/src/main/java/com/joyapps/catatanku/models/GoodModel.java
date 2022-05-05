package com.joyapps.catatanku.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "good_table")
public class GoodModel {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "good_id")
    private int goodId;

    @ColumnInfo(name = "good_name")
    private String goodName;

    @ColumnInfo(name = "good_qty")
    private int goodQty;

    @ColumnInfo(name = "good_quality")
    private String goodQuality;

    @ColumnInfo(name = "good_price")
    private int goodPrice;

    public GoodModel(int goodId, String goodName, int goodQty, String goodQuality, int goodPrice) {
        this.goodId = goodId;
        this.goodName = goodName;
        this.goodQty = goodQty;
        this.goodQuality = goodQuality;
        this.goodPrice = goodPrice;
    }

    @Ignore
    public GoodModel(String goodName, int goodQty, String goodQuality, int goodPrice) {
        this.goodName = goodName;
        this.goodQty = goodQty;
        this.goodQuality = goodQuality;
        this.goodPrice = goodPrice;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getGoodQty() {
        return goodQty;
    }

    public void setGoodQty(int goodQty) {
        this.goodQty = goodQty;
    }

    public String getGoodQuality() {
        return goodQuality;
    }

    public void setGoodQuality(String goodQuality) {
        this.goodQuality = goodQuality;
    }

    public int getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(int goodPrice) {
        this.goodPrice = goodPrice;
    }
}

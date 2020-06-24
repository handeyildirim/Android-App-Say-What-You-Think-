package com.yildirim.hande.saywhatyouthinkapp;

/**
 * Created by hande on 6/18/17.
 */

public class YorumModel {
    private String konu;
    private String detay;
    private String time;

    public YorumModel(String konu, String detay, String time) {
        this.konu = konu;
        this.detay = detay;
        this.time = time;
    }

    public String getKonu() {
        return konu;
    }

    public void setKonu(String konu) {
        this.konu = konu;
    }

    public String getDetay() {
        return detay;
    }

    public void setDetay(String detay) {
        this.detay = detay;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

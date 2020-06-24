package com.yildirim.hande.saywhatyouthinkapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hande on 6/18/17.
 */

public class CustomAdaptor extends BaseAdapter {

    ArrayList<YorumModel> yorumlarListe;
    LayoutInflater userInflater;


    public CustomAdaptor(Activity activity, ArrayList<YorumModel> liste){
        yorumlarListe = liste; //liste; YorumlarFragment'dtan gelecek. yorumlarListe, burada oluşturuldu
        userInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return yorumlarListe.size();
    }

    @Override
    public Object getItem(int position) {
        return yorumlarListe.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View satir;
        satir =  userInflater.inflate(R.layout.custom_satir, null);

        TextView tvKonu = (TextView) satir.findViewById(R.id.textViewKonu);
        TextView tvDetay = (TextView) satir.findViewById(R.id.textViewDetay);

        YorumModel yorum = yorumlarListe.get(position);

        tvKonu.setText(yorum.getKonu());
        tvDetay.setText(yorum.getDetay());

        return satir;
    }
}

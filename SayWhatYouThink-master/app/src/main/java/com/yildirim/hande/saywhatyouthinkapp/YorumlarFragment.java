package com.yildirim.hande.saywhatyouthinkapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class YorumlarFragment extends Fragment {

    ListView lvYorumlar;
    ArrayList<YorumModel> yorumlarListe = new ArrayList<>();

    public YorumlarFragment()  {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_yorumlar, container, false);

        lvYorumlar = (ListView) rootView.findViewById(R.id.listViewYorumlar);




        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference yorumRef = database.getReference("yorumlar");

        yorumRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //yorumlarListe.clear();
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    yorumlarListe.add(new YorumModel(ds.child("konu").getValue().toString(),ds.child("detay").getValue().toString(),""));
                }
                CustomAdaptor adaptor = new CustomAdaptor(getActivity(),yorumlarListe);
                lvYorumlar.setAdapter(adaptor);
                adaptor.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return rootView;
    }

}

package com.yildirim.hande.saywhatyouthinkapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class YorumYapFragment extends Fragment {

    EditText etKonu,etDetay;
    Button btnYolla;

    String konu,detay;

    public YorumYapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_yorum_yap, container, false);
        etDetay = (EditText) rootView.findViewById(R.id.editTextDetay);
        etKonu = (EditText) rootView.findViewById(R.id.editTextKonu);
        btnYolla = (Button) rootView.findViewById(R.id.buttonYolla);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference dbRef = database.getReference("yorumlar");

        btnYolla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                konu = etKonu.getText().toString();
                detay = etDetay.getText().toString();

                if(!(konu.equals("") && detay.equals(""))){
                    DatabaseReference databaseReference = dbRef.push();
                    databaseReference.child("konu").setValue(konu);
                    databaseReference.child("detay").setValue(detay);

                    etKonu.setText("");
                    etDetay.setText("");
                }
                else{
                    Toast.makeText(rootView.getContext(),
                            "Konu ve Detay alanını boş geçemezsiniz!",Toast.LENGTH_SHORT).show();
                }
            }
        });



        // Inflate the layout for this fragment
        return rootView;
    }

}

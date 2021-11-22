package com.example.midoctor.ui.Servicios;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.example.midoctor.AMBU;
import com.example.midoctor.COV19;
import com.example.midoctor.LoginActivity;
import com.example.midoctor.R;
import com.example.midoctor.Servicios;
import com.example.midoctor.VACCINE;
import com.example.midoctor.databinding.FragmentServiciosBinding;

public class ServiciosFragment extends Fragment {

    private ImageButton mVacunacion;
    private ImageButton mAmbulancia;
    private ImageButton mCov19;
    public ServiciosFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_servicios, container, false);

        mVacunacion=view.findViewById(R.id.vacunacion);
        mAmbulancia=view.findViewById(R.id.ambulancia);
        mCov19=view.findViewById(R.id.covid);

        mVacunacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent vac=new Intent(getActivity(), VACCINE.class);
                startActivity(vac);
            }
        });

        mAmbulancia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent amb=new Intent(getActivity(), AMBU.class);
                startActivity(amb);
            }
        });

        mCov19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cov=new Intent(getActivity(), COV19.class);
                startActivity(cov);
            }
        });


        return view;

    }

}
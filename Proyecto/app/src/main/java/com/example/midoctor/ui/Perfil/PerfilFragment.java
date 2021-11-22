package com.example.midoctor.ui.Perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.midoctor.DatabaseHelper;
import com.example.midoctor.R;
import com.example.midoctor.databinding.FragmentPerfilBinding;


public class PerfilFragment extends Fragment {

   public PerfilFragment(){

   }

    TextView viewname,viewlastname,viewuser,viewpass;
    Button savechanges ;
    DatabaseHelper db;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_perfil, container, false);



        return view;
    }

}
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

    private PerfilViewModel perfilViewModel;
    private FragmentPerfilBinding binding;
    TextView viewname,viewlastname,viewuser,viewpass;
    Button savechanges ;
    DatabaseHelper db;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        perfilViewModel =
                new ViewModelProvider(this).get(PerfilViewModel.class);


        binding = FragmentPerfilBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textPerfil;
        perfilViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
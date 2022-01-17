package com.example.fragments.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragments.R;

public class FragmentDos extends Fragment {
    private View view;
    private static String texto;
    private TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.from(getContext()).inflate(R.layout.fragment_dos_layout, container,false);
        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        instancias();
        acciones();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (this.getArguments()!=null){
            texto = this.getArguments().getString("Texto");
        }
    }

    public static FragmentDos newInstance(String texto) {
        FragmentDos fragmentDos = new FragmentDos();
        Bundle args = new Bundle();
        args.putString("Texto",texto);
        fragmentDos.setArguments(args);
        return fragmentDos;
    }
    private void instancias(){
        textView = view.findViewById(R.id.textViewFragment2);
    }
    private void acciones(){
        textView.setText(texto);
    }
}

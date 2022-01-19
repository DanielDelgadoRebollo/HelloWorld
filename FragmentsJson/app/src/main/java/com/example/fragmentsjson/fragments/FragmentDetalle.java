package com.example.fragmentsjson.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.fragmentsjson.R;
import com.example.fragmentsjson.utils.Equipo;

public class FragmentDetalle extends Fragment {
    private View view;
    private ImageView imagen;
    private TextView nombre,id,estadio,detalle;
    private Equipo equipoRecuperado;

    public static FragmentDetalle newInstance(Equipo equipo) {

        Bundle args = new Bundle();
        args.putSerializable("equipo",equipo);
        FragmentDetalle fragment = new FragmentDetalle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (this.getArguments()!=null){
            equipoRecuperado = (Equipo) this.getArguments().getSerializable("equipo");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detalle,container,false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        instancias();
        initGUI();
    }

    private void initGUI() {
        nombre.setText(equipoRecuperado.getTextoNombre());
        estadio.setText(equipoRecuperado.getTextoEstadio());
        id.setText(equipoRecuperado.getId());
        Glide.with(getContext()).load(equipoRecuperado.getImagen()).into(imagen);
        detalle.setText(equipoRecuperado.getDetalle());
    }

    private void instancias() {
        imagen = view.findViewById(R.id.fragmentDetalleImagen);
        nombre = view.findViewById(R.id.fragmentDetalleTextView1);
        estadio = view.findViewById(R.id.fragmentDetalleTextView2);
        id = view.findViewById(R.id.fragmentDetalleTextView3);
        detalle = view.findViewById(R.id.fragmentDetalleTextView4);
    }
}

package com.example.fragmentsjson.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentsjson.R;
import com.example.fragmentsjson.adapter.RecyclerAdapter;

import java.util.ArrayList;

public class FragmentActivity extends Fragment {

    private Context context;
    private View view;
    private RecyclerView recyclerView;
    private RecyclerAdapter adaptadorEquipos;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;

    }

    @Override
    public void onStart() {
        super.onStart();
        instancias();
        asociarDatos();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.from(context).inflate(R.layout.fragment_estadio,container,false);
        return view;
    }

    public void instancias(){
        recyclerView = view.findViewById(R.id.recycler_equipos);
        adaptadorEquipos = new RecyclerAdapter(new ArrayList(),getContext());
    }
   public void asociarDatos(){
        recyclerView.setAdapter(adaptadorEquipos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
   }

}

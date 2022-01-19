package com.example.masterdetail.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.masterdetail.R;

import java.util.ArrayList;

public class FragmentMaster extends Fragment {
    private View view;
    private ListView listView;
    private ArrayAdapter adaptador;
    private ArrayList datos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_master,container,false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        listView = view.findViewById(R.id.recyclerView);
        datos = new ArrayList();
        adaptador = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,datos);
        for (int i = 0; i < 100; i++) {
            datos.add("Opcion " + i);
            adaptador.notifyDataSetChanged();
        }
        listView.setAdapter(adaptador);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}

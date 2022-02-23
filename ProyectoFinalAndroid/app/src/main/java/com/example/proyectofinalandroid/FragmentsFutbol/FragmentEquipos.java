package com.example.proyectofinalandroid.FragmentsFutbol;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyectofinalandroid.Adapters.AdaptadorEquipos;
import com.example.proyectofinalandroid.MainActivity;
import com.example.proyectofinalandroid.R;
import com.example.proyectofinalandroid.utils.Equipo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentEquipos extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private AdaptadorEquipos adaptadorEquipos;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_equipo,container,false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        instancias();
        realizarPeticion();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        
    }

    private void instancias() {
        recyclerView = view.findViewById(R.id.recyclerEquipos);
        adaptadorEquipos = new AdaptadorEquipos(getContext());
        recyclerView.setAdapter(adaptadorEquipos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),recyclerView.VERTICAL,false));

    }

    public static FragmentEquipos newInstance(String url) {
        FragmentEquipos fragment = new FragmentEquipos();
        Bundle args = new Bundle();
        args.putString("Url",url);
        fragment.setArguments(args);
        return fragment;
    }

    private void procesarPeticion(JSONObject response){

        try {
            JSONArray arrayResultados = response.getJSONArray("teams");
            Log.v("prueba",arrayResultados.toString());
            for (int i=0;i<arrayResultados.length();i++){
                JSONObject equipo = arrayResultados.getJSONObject(i);
                String imagen = equipo.getString("strTeamBadge");
                String nombre = equipo.getString("strTeam");
                Equipo equipoAgregar = new Equipo(imagen,nombre);
                adaptadorEquipos.agregarEquipo(equipoAgregar);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void realizarPeticion() {

        Bundle bundle = getArguments();
        String url = bundle.getString("Url");
        Log.v("URL",url);
        // petición volley

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                procesarPeticion(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

                RequestQueue request = Volley.newRequestQueue(getContext());
        request.add(jsonObjectRequest);


    }


}

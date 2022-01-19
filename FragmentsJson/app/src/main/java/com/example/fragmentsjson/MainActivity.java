package com.example.fragmentsjson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.fragmentsjson.adapter.RecyclerAdapter;
import com.example.fragmentsjson.fragments.FragmentActivity;
import com.example.fragmentsjson.fragments.FragmentDetalle;
import com.example.fragmentsjson.utils.Equipo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.OnEquipoListener {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.sitioFragments,new FragmentActivity());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

/*
        String url = "https://www.thesportsdb.com/api/v1/json/2/search_all_teams.php?s=Soccer&c=Spain";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(1, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.v("Peticion", String.valueOf(response));
                procesarPeticion(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("Error","Error bro");
            }
        });
        Volley.newRequestQueue(getApplicationContext()).add(jsonObjectRequest);


 */
    }

    private void procesarPeticion(JSONObject response) {
        try {
            JSONArray jsonArray = response.getJSONArray("teams");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject equipo = jsonArray.getJSONObject(i);
                String nombre = equipo.getString("strTeam");
                Log.v("peticion",nombre);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onEquipoSelected(Equipo equipo) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.sitioFragments,FragmentDetalle.newInstance(equipo));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
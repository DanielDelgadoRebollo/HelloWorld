package com.example.fragments.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragments.R;

public class FragmentUno extends Fragment {
    private View view;
    private EditText editText;
    private Button button;
    public static String texto;
    private OnFragmentUno listener;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.from(getContext()).inflate(R.layout.fragment_uno_layout, container,false);
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (OnFragmentUno) context;
    }


    @Override
    public void onStart() {
        super.onStart();
        instancias();
        acciones();
    }

    private void instancias(){
        editText = view.findViewById(R.id.editTextFragment1);
        button = view.findViewById(R.id.btnComunicar);
    }

    private void acciones(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 listener.onDataSelected(editText.getText().toString());
            }
        });
    }

    public interface OnFragmentUno{
         void onDataSelected(String dato);
    }
}

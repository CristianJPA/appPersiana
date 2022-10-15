package com.example.persianaautomatica;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConfiguracionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConfiguracionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RadioGroup rGroup;
    RadioButton rButton1, rButton2;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int selected;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ConfiguracionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConfiguracionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConfiguracionFragment newInstance(String param1, String param2) {
        ConfiguracionFragment fragment = new ConfiguracionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_configuracion, container, false);
        Button btn = v.findViewById(R.id.btnConfig1);
        Button btn2 = v.findViewById(R.id.btnConfig2);
        sharedPreferences = getActivity().getSharedPreferences("pref",0);
        int selected = sharedPreferences.getInt("selected",3);
        editor = sharedPreferences.edit();
        rGroup = v.findViewById(R.id.rGroup);
        rButton1 = v.findViewById(R.id.rButton1);
        rButton2 = v.findViewById(R.id.rButton2);
        if (selected==1){
            rButton1.setChecked(true);
        }else if (selected == 0){
            rButton2.setChecked(true);
        }
        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.rButton1){
                    editor.putInt("selected",1);
                }else if (checkedId == R.id.rButton2){
                    editor.putInt("selected",0);
                }
                editor.commit();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Btn1", Toast.LENGTH_SHORT).show();
                Autom2Fragment secFrag = new Autom2Fragment();
                FragmentTransaction fragTransaction = getFragmentManager().beginTransaction();
                fragTransaction.replace(R.id.contenedor,secFrag );
                fragTransaction.addToBackStack(null);
                fragTransaction.commit();


            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Btn2", Toast.LENGTH_SHORT).show();

                AutomFragment secFrag = new AutomFragment();
                FragmentTransaction fragTransaction = getFragmentManager().beginTransaction();
                fragTransaction.replace(R.id.contenedor,secFrag );
                fragTransaction.addToBackStack(null);
                fragTransaction.commit();
            }
        });
        return v;
    }
}
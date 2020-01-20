package com.sharath.mvvmgooglegitprojects.view.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sharath.mvvmgooglegitprojects.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_project_list, container, false);

        Button btnShowProjectDetails = view.findViewById(R.id.btnShowProjectDetails);
        btnShowProjectDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).showProjectDetails();
            }
        });
        return view;
    }

}

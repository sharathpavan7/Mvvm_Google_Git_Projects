package com.sharath.mvvmgooglegitprojects.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sharath.mvvmgooglegitprojects.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectListFragment extends Fragment {


    public static final String TAG = "ProjectListFragment";

    public ProjectListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_project_list, container, false);
    }

}

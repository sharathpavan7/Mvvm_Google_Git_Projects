package com.sharath.mvvmgooglegitprojects.view.ui;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sharath.mvvmgooglegitprojects.R;
import com.sharath.mvvmgooglegitprojects.databinding.FragmentProjectListBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectListFragment extends Fragment {


    public static final String TAG = "ProjectListFragment";

    private FragmentProjectListBinding binding;

    public ProjectListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_project_list, container, false);
        return binding.getRoot();
    }

}

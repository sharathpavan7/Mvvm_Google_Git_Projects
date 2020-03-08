package com.sharath.mvvmgooglegitprojects.view.ui;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sharath.mvvmgooglegitprojects.R;
import com.sharath.mvvmgooglegitprojects.databinding.FragmentProjectListBinding;
import com.sharath.mvvmgooglegitprojects.services.model.Project;
import com.sharath.mvvmgooglegitprojects.view.adapter.ProjectListAdapter;
import com.sharath.mvvmgooglegitprojects.viewmodel.ProjectListViewmodel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectListFragment extends Fragment {


    public static final String TAG = "ProjectListFragment";

    private FragmentProjectListBinding binding;
    private ProjectListAdapter projectListAdapter;

    public ProjectListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        projectListAdapter = new ProjectListAdapter();

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_project_list, container, false);
        binding.rcyProjectList.setAdapter(projectListAdapter);
        binding.setIsLoading(true);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ProjectListViewmodel projectListViewmodel = ViewModelProviders.of(this).get(ProjectListViewmodel.class);

        observViewModel(projectListViewmodel);
    }

    private void observViewModel(ProjectListViewmodel viewmodel) {
        viewmodel.getProjectListObserver().observe(this, new Observer<List<Project>>() {
            @Override
            public void onChanged(List<Project> projects) {
                binding.setIsLoading(false);
                projectListAdapter.setProjectList(projects);
            }
        });
    }
}

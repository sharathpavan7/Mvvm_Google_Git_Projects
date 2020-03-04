package com.sharath.mvvmgooglegitprojects.view.ui;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sharath.mvvmgooglegitprojects.R;
import com.sharath.mvvmgooglegitprojects.databinding.FragmentProjectListBinding;
import com.sharath.mvvmgooglegitprojects.service.model.Project;
import com.sharath.mvvmgooglegitprojects.view.adapter.ProjectAdapter;
import com.sharath.mvvmgooglegitprojects.view.callback.ProjectClickCallback;
import com.sharath.mvvmgooglegitprojects.viewmodel.ProjectListViewmodel;
import com.sharath.mvvmgooglegitprojects.viewmodel.ProjectViewmodel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectListFragment extends Fragment {

    private FragmentProjectListBinding binding;
    private ProjectAdapter adapter;

    private final ProjectClickCallback clickCallback = new ProjectClickCallback() {
        @Override
        public void onClick() {

        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_project_list, container, false);
        adapter = new ProjectAdapter(clickCallback);
        binding.projectList.setAdapter(adapter);
        binding.setIsLoading(true);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ProjectListViewmodel viewmodel = ViewModelProviders.of(this).get(ProjectListViewmodel.class);
        observeViewModel(viewmodel);
    }

    private void observeViewModel(ProjectListViewmodel viewmodel) {
        viewmodel.getProjectListObservable().observe(this, new Observer<List<Project>>() {
            @Override
            public void onChanged(List<Project> projects) {
                adapter.setProjectList(projects);
                binding.setIsLoading(false);
            }
        });
    }
}

package com.sharath.mvvmgooglegitprojects.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.sharath.mvvmgooglegitprojects.R;
import com.sharath.mvvmgooglegitprojects.databinding.ProjectListItemBinding;
import com.sharath.mvvmgooglegitprojects.services.model.Project;

import java.util.List;

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ProjectListViewHolder>{

    private List<Project> projectList;

    public ProjectListAdapter(Context context, List<Project> projectList) {
        this.projectList = projectList;
    }

    @NonNull
    @Override
    public ProjectListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ProjectListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.project_list_item, parent, false);
        return new ProjectListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ProjectListViewHolder extends RecyclerView.ViewHolder{
        ProjectListItemBinding binding;
        public ProjectListViewHolder(ProjectListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

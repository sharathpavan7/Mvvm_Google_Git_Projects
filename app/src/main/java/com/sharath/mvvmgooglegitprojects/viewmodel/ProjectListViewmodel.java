package com.sharath.mvvmgooglegitprojects.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sharath.mvvmgooglegitprojects.services.model.Project;
import com.sharath.mvvmgooglegitprojects.services.repository.ProjectRrepository;

import java.util.List;

public class ProjectListViewmodel extends AndroidViewModel {

    private MutableLiveData<List<Project>> projectListObserver;

    public ProjectListViewmodel(Application application) {
        super(application);
        projectListObserver = ProjectRrepository.getInstance().getProjectList("Google");
    }

    /*Expose project list observer. So UI can observer it.*/
    public MutableLiveData<List<Project>> getProjectListObserver() {
        return projectListObserver;
    }
}

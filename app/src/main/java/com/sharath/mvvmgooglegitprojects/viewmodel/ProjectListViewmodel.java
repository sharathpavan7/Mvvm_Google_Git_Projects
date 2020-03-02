package com.sharath.mvvmgooglegitprojects.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.sharath.mvvmgooglegitprojects.service.model.Project;
import com.sharath.mvvmgooglegitprojects.service.repository.ProjectRepository;

import java.util.List;

public class ProjectListViewmodel extends AndroidViewModel {

    private MutableLiveData<List<Project>> projectListObservable;

    public ProjectListViewmodel(Application application) {
        super(application);

        projectListObservable = ProjectRepository.getInstance().getProjectList("Google");
    }

    /*Exposing the Livedata project list . so the Ui layer can observ it*/
    public MutableLiveData<List<Project>> getProjectListObservable() {
        return projectListObservable;
    }


}

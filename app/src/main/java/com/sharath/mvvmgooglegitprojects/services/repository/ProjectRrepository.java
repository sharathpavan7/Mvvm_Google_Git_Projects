package com.sharath.mvvmgooglegitprojects.services.repository;

import androidx.lifecycle.MutableLiveData;

import com.sharath.mvvmgooglegitprojects.services.model.Project;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProjectRrepository {

    private static ProjectRrepository projectRrepository;
    private GitHubService gitHubService;

    private ProjectRrepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GitHubService.HTTPS_API_GITHUB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        gitHubService = retrofit.create(GitHubService.class);
    }

    public synchronized static ProjectRrepository getInstance() {
        if (projectRrepository == null) {
            projectRrepository = new ProjectRrepository();
        }
        return projectRrepository;
    }

    public MutableLiveData<List<Project>> getProjectList(String user) {
        final MutableLiveData<List<Project>> projectList = new MutableLiveData<>();

        gitHubService.getProjectList(user).enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {
                projectList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {
                projectList.setValue(null);
            }
        });

        return projectList;
    }

    public MutableLiveData<Project> getProjectDetails(String userId, String projectName) {
        final MutableLiveData<Project> project = new MutableLiveData<>();

        gitHubService.getProjectDetails(userId, projectName).enqueue(new Callback<Project>() {
            @Override
            public void onResponse(Call<Project> call, Response<Project> response) {
                simulateDelay();
                project.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Project> call, Throwable t) {
                project.setValue(null);
            }
        });

        return project;
    }

    private void simulateDelay() {
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

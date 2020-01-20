package com.sharath.mvvmgooglegitprojects.view.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sharath.mvvmgooglegitprojects.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add ProjectListFragment if this is the first creation
        if (savedInstanceState == null){
            ProjectListFragment projectListFragment = new ProjectListFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, projectListFragment, "projectListFragment")
                    .commit();
        }
    }

    public void showProjectDetails() {
        ProjectFragment projectFragment = new ProjectFragment();

        getSupportFragmentManager().beginTransaction()
                .addToBackStack("project")
                .replace(R.id.fragment_container, projectFragment, null)
                .commit();

    }
}

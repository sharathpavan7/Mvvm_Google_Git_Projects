package com.sharath.mvvmgooglegitprojects.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sharath.mvvmgooglegitprojects.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            ProjectListFragment projectListFragment = new ProjectListFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, projectListFragment,
                    ProjectListFragment.TAG).commit();
        }
    }
}

package ui;

import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.wissamsandroidlabs.databinding.ActivityMainBinding;

import data.MainViewModel;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding variableBinding;
private MainViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new ViewModelProvider(this).get(MainViewModel.class);

        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());




    }
}
package ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
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

        variableBinding.textview.setText(model.editString);
        variableBinding.mybutton.setOnClickListener(click ->
                {
                    model.editString.postValue(variableBinding.myEditText.getText().toString());
                    variableBinding.textview.setText("Your edit text has: " + model.editString);
                }
                );

        model.editString.observe(this, s -> {
            variableBinding.textview.setText("Your edit has: " + s);
        });
    }
}
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


        variableBinding.mybutton.setOnClickListener(click ->
                {
                    model.editString.postValue(variableBinding.editText.getText().toString());
                    variableBinding.textview.setText("Your edit text has: " + model.editString);
                }
                );

        model.editString.observe(this, s -> {
            variableBinding.textview.setText("Your edit has: " + s);
        });

        model.getDrinkCoffeeLiveData().observe(this, selected -> {
            variableBinding.checkBox.setChecked(selected);
            variableBinding.radioButton.setChecked(selected);
            variableBinding.switchButton.setChecked(selected);
        });

        variableBinding.checkBox.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            model.getDrinkCoffeeLiveData().postValue(isChecked);
        });

        variableBinding.switchButton.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            model.getDrinkCoffeeLiveData().postValue(isChecked);
        });

        variableBinding.radioButton.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            model.getDrinkCoffeeLiveData().postValue(isChecked);
        });



    }
}
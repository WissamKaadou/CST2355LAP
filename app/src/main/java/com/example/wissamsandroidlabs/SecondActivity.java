package com.example.wissamsandroidlabs;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent fromPrevious = getIntent();
        String emailAddress = fromPrevious.getStringExtra("EmailAddress");
        TextView textView = findViewById(R.id.textView3);
        textView.setText("Welcome Back: " + emailAddress);
        Button changePicture = findViewById(R.id.button4);
        Button callNumber = findViewById(R.id.button);
        Intent call = new Intent(Intent.ACTION_DIAL);
        EditText phoneNumber = findViewById(R.id.editTextPhone);
        ImageView profileImage = findViewById(R.id.imageButton);

        ActivityResultLauncher<Intent> cameraResult = registerForActivityResult(
        new ActivityResultContracts.StartActivityForResult(),
        new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    Bitmap thumbnail = data.getParcelableExtra("data");
                    profileImage.setImageBitmap(thumbnail);
                }
            }

        });


        callNumber.setOnClickListener(clk -> {
            call.setData(Uri.parse("tel:" + phoneNumber.getText().toString()));
            startActivity(call);
        });
        changePicture.setOnClickListener(clk ->{
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            cameraResult.launch(cameraIntent);
        });
    }
}







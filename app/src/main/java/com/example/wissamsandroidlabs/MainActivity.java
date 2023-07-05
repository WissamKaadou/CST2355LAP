package com.example.wissamsandroidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author wissa
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    /**
     * This holds the text at the top of the screen
     **/
    private TextView tv = null;
    /**
     * This hold the password line
     **/
    private EditText et = null;
    /**
     * This holds the Button at the bottom
     **/
    private Button btn = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.textView2);
        EditText et = findViewById(R.id.editTextTextPassword);
        Button btn = findViewById(R.id.TheButton);

        btn.setOnClickListener(v -> {
            String password = et.getText().toString();

            if (checkPasswordComplexity(password)) {
                tv.setText("Your password meets the requirements");
            } else {
                tv.setText("You shall not pass!");
            }
        });

    }


    /**
     * Checks if a password meets the complexity requirements.
     *
     * @param pw the password to check
     * @return true if the password meets the complexity requirements, false otherwise
     */
    boolean checkPasswordComplexity(String pw) {
        boolean foundUpperCase, foundLowerCase, foundNumber, foundSpecial;
        foundUpperCase = foundLowerCase = foundNumber = foundSpecial = false;

        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);

            if (Character.isUpperCase(c)) {
                foundUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                foundLowerCase = true;
            } else if (Character.isDigit(c)) {
                foundNumber = true;
            } else if (isSpecialCharacter(c)) {
                foundSpecial = true;
            }
        }

        if (!foundUpperCase) {
            Toast.makeText(getApplicationContext(), "Your password is missing an uppercase letter", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundLowerCase) {
            Toast.makeText(getApplicationContext(), "Your password is missing a lowercase letter", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundNumber) {
            Toast.makeText(getApplicationContext(), "Your password is missing a number", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundSpecial) {
            Toast.makeText(getApplicationContext(), "Your password is missing a special character", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    /**
     * Checks if a character is a special character.
     *
     * @param c the character to check
     * @return true if the character is a special character, false otherwise
     */
    boolean isSpecialCharacter(char c) {
        switch (c) {
            case '#':
            case '$':
            case '%':
            case '^':
            case '&':
            case '*':
            case '!':
            case '@':
            case '?':
                return true;
            default:
                return false;
        }
    }
}
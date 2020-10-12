package com.degel.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.degel.helloworld.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    String phoneNumber;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        getSupportActionBar().hide();


        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumber = binding.inputPhoneNumber.getEditText().getText().toString();
                password = binding.inputPassword.getEditText().getText().toString();
                if (phoneNumber != null) {
                    if (phoneNumber.length() == 11) {
                        if (password.length() > 8) {
                            showBarHideBtn(binding.progressLoading, binding.btnLogin);


                        } else {
                            Toast.makeText(getApplicationContext(), R.string.invalidPassword, Toast.LENGTH_SHORT).show();

                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "" + getString(R.string.invalidPhone), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "" + getString(R.string.invalidPhone), Toast.LENGTH_SHORT).show();

                }


            }
        });
    }

    private void showBarHideBtn(View viewToShow, View viewToHide) {
        ((Button) viewToHide).setText("");
        viewToShow.setVisibility(View.VISIBLE);
    }


}

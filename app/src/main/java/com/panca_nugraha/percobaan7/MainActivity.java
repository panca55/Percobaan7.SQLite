package com.panca_nugraha.percobaan7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.panca_nugraha.percobaan7.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        binding.btnLogin.setOnClickListener(view ->{
            String username = binding.editUsername.getText().toString().trim();
            String password = binding.editPassword.getText().toString().trim();
            boolean res = databaseHelper.checkUser(username, password);
            if (res){
                Toast.makeText(MainActivity.this,"Succesfully Logged In", Toast.LENGTH_SHORT).show();
                Intent contentIntent = new Intent(MainActivity.this,ContentActivity.class);
                startActivity(contentIntent);
            }else {
                Toast.makeText(MainActivity.this,"Username atau Password",Toast.LENGTH_SHORT).show();
            }
        });
        binding.btnRegister.setOnClickListener(view ->{
            Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(registerIntent);
        });
    }
}
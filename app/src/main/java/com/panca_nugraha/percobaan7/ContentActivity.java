package com.panca_nugraha.percobaan7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.panca_nugraha.percobaan7.databinding.ActivityContentBinding;

public class ContentActivity extends AppCompatActivity {
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment;
                    if (item.getItemId() == R.id.navigation_home) {
                        fragment = new HomeFragment();
                        switchFragment(fragment);
                        return true;
                    } else if (item.getItemId() == R.id.navigation_dashboard) {
                        fragment = new DashboardFragment();
                        switchFragment(fragment);
                        return true;
                    } else if (item.getItemId() == R.id.navigation_account) {
                        fragment = new AccountFragment();
                        switchFragment(fragment);
                        return true;
                    }
                    return false;
                }
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.panca_nugraha.percobaan7.databinding.ActivityContentBinding binding = ActivityContentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        if (savedInstanceState == null) {
            binding.navigation.setSelectedItemId(R.id.navigation_home);
        }
    }
    private void switchFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerLayout, fragment, fragment.getClass().getSimpleName())
                .commit();
    }
}
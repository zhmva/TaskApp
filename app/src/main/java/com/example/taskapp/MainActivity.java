package com.example.taskapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.taskapp.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private BottomNavigationView navigationView;
    private AppBarConfiguration appBarConfiguration;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initViews();
        initNavController();
        initAppBar();

        mImageView = findViewById(R.id.ImgProfile);
    }

    private void initNavController() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavController navController1;
        navController1 = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        navController1.navigate(R.id.boardFragment);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller,
                                             @NonNull NavDestination destination,
                                             @Nullable Bundle arguments) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(R.id.navigation_home);
                list.add(R.id.navigation_dashboard);
                list.add(R.id.navigation_notifications);
                list.add(R.id.profileFragment);

                if (list.contains(destination.getId())){
                    binding.navView.setVisibility(View.VISIBLE);
                    binding.txtBar.setVisibility(View.VISIBLE);
                }else{
                    binding.navView.setVisibility(View.GONE);
                    binding.txtBar.setVisibility(View.GONE);
                }

            }
        });
    }

    private void initAppBar() {
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
    }

    private void initViews() {
        navigationView = findViewById(R.id.nav_view);
    }
    public void pickImage(View view){
        Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhoto, 3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent ReturningImageIntent) {
        super.onActivityResult(requestCode, resultCode, ReturningImageIntent);
            switch (requestCode) {
                case 3:
                    if (resultCode == RESULT_OK) {
                        Uri selectedImage = ReturningImageIntent.getData();
                        mImageView.setImageURI(selectedImage);
                    }
                    break;
                default:
                    break;
            }
        }
    }

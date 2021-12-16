package com.example.taskapp.ui.profile;

import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.taskapp.R;
import com.example.taskapp.databinding.FragmentProfileBinding;
import com.example.taskapp.ui.home.HomeViewModel;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    ActivityResultLauncher<String> mGetContent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        binding = FragmentProfileBinding.inflate(inflater, container,false);
        View view1 = binding.getRoot();
        mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri uri) {
                        binding.ImgProfile.setImageURI(uri);
                    }
                });
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        handleClick();
    }

    private void handleClick() {
        binding.ImgProfile.setOnClickListener(v -> {
            mGetContent.launch("image/*");
        });
    }
}
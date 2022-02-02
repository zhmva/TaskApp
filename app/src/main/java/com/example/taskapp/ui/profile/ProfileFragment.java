package com.example.taskapp.ui.profile;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.taskapp.MainActivity;
import com.example.taskapp.R;
import com.example.taskapp.databinding.FragmentProfileBinding;

import java.util.Calendar;

public class ProfileFragment extends Fragment {

    ActivityResultLauncher<String> mGetContent;
    private FragmentProfileBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //     handleClick();
//    }
//
//    private void handleClick() {
//        binding.ImgPicker.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                usesPermission();
//            }
//
//            private void usesPermission() {
//                int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
//                        Manifest.permission.READ_EXTERNAL_STORAGE);
//
//                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
//                    openGallery();
//                } else {
//                    ActivityCompat.requestPermissions(getActivity(),
//                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 200);
//                }
//            }
//
//            private void openGallery() {
//                Intent cameraIntent = new Intent(Intent.ACTION_GET_CONTENT);
//                cameraIntent.setType("image/*");
//                if (cameraIntent.resolveActivity(getActivity().getPackageManager()) != null) {
//                    ActivityResultLauncher<String[]> galleryActivityLauncher =
//                            registerForActivityResult(new
//                                            ActivityResultContracts.OpenDocument(),
//                                    new ActivityResultCallback<Uri>() {
//                                        @Override
//                                        public void onActivityResult(Uri result) {
//                                            if (result != null) {
//                                            } else {
//                                                Log.d("tag", "onActivityResult: the result is null for some reason");
//                                            }
//                                        }
//                                    });
//                }
//            }
//        });
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_profile, container, false);
//        binding = FragmentProfileBinding.inflate(inflater, container, false);
//        View view1 = binding.getRoot();
//        mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
//                new ActivityResultCallback<Uri>() {
//                    @Override
//                    public void onActivityResult(Uri uri) {
//                        binding.ImgProfile.setImageURI(uri);
//                    }
//                });
//        return view;
//    }
    }
}


package com.example.taskapp.ui.form;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.taskapp.R;
import com.example.taskapp.databinding.FragmentFormBinding;
import com.example.taskapp.models.User;

public class FormFragment extends Fragment {

    private FragmentFormBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFormBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListeners();
    }

    private void initListeners() {
        binding.saveBtn.setOnClickListener(view -> {
            save();
            saveInList();
            close();
        });
    }

    private void saveInList() {
        String name = binding.nameEt.getText().toString();
        String surname = binding.surnameEt.getText().toString();
        User user = new User(name, surname);
        Bundle bundle = new Bundle();
        bundle.putString("key", String.valueOf(user));
        getParentFragmentManager().setFragmentResult("key", bundle);


    }

    private void close() {
        NavController navController = Navigation.findNavController(requireActivity(),
                R.id.nav_host_fragment_activity_main);
        navController.navigateUp();
    }

    private void save() {
        String name = binding.nameEt.getText().toString();
        String surname = binding.surnameEt.getText().toString();
        User user = new User(name, surname);
        Bundle bundle = new Bundle();
        bundle.putSerializable("user", user);
        getParentFragmentManager().setFragmentResult("user", bundle);

    }
}
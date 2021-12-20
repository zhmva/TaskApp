package com.example.taskapp.ui.onBoardScreen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taskapp.Utils.Prefs;
import com.example.taskapp.databinding.FragmentOnBoardBinding;

public class OnBoardFragment extends Fragment {

    private FragmentOnBoardBinding binding;
    private PagerAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Prefs prefs = new Prefs(requireContext());
        if (!prefs.isBoardShown()) {
            initViewPager();
        }
    }
        private void initViewPager () {
            adapter = new PagerAdapter();
            binding.BoardViewPager2.setAdapter(adapter);

        }
    }
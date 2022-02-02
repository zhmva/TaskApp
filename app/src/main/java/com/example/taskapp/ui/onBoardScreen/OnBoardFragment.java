package com.example.taskapp.ui.onBoardScreen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taskapp.R;
import com.example.taskapp.Utils.Prefs;
import com.example.taskapp.databinding.FragmentOnBoardBinding;

public class OnBoardFragment extends Fragment {

    private FragmentOnBoardBinding binding;
    private PagerAdapter adapter;
    ViewPager2 pager2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
            initViewPager();

        }
        private void initViewPager () {
            adapter = new PagerAdapter();
            binding.BoardViewPager2.setAdapter(adapter);
            initListeners();
        }
    private void initListeners() {
        binding.btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment();
            }

        });
    }
    private void openFragment() {
        NavController navController = Navigation.findNavController(requireActivity(),
                R.id.nav_host_fragment_activity_main);
        navController.navigate(R.id.authFragment);
    }
}

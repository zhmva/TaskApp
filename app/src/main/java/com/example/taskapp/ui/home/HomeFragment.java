package com.example.taskapp.ui.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.taskapp.App;
import com.example.taskapp.R;
import com.example.taskapp.databinding.FragmentHomeBinding;
import com.example.taskapp.models.User;
import com.example.taskapp.ui.form.FormFragment;

import java.util.List;

public class HomeFragment extends Fragment implements TaskAdapter.OnItemClick {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private TaskAdapter adapter = new TaskAdapter();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListeners();
        setFragmentListener();
        App.dataBase.userDao().getALlUsers().observe(getViewLifecycleOwner(),
                new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                adapter.setList(users);
            }
        });
        initRv();
    }

    private void initRv() {
        adapter.setListener(this);
        binding.taskRv.setAdapter(adapter);
    }

    private void setFragmentListener() {
        getParentFragmentManager().setFragmentResultListener("user",
                getViewLifecycleOwner(), new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                User user = (User) result.getSerializable("user");
                App.dataBase.userDao().addUser(user);
            }
        });
    }


    private void initListeners() {
        binding.ActionBtn.setOnClickListener(v -> {
            openFragment();
        });
    }

    private void openFragment() {
        NavController navController = Navigation.findNavController(requireActivity(),
                R.id.nav_host_fragment_activity_main);
        navController.navigate(R.id.formFragment);
        openActivityForResult();
    }

    private void openActivityForResult() {
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    @Override
    public void onClick(String txt) {
        Toast.makeText(requireContext(),txt,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onLongClick(int position) {
        Log.e("TAG", "position: "+ position );
        new AlertDialog.Builder(requireContext())
                .setMessage("Внимание")
                .setIcon(R.drawable.ic_launcher_foreground)
                .setTitle("Удалить запись ?")
                .setNegativeButton("Нет", null)
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        adapter.removeItem(position);
                        binding.taskRv.setAdapter(adapter);
                    }
                }).show();
    }
}
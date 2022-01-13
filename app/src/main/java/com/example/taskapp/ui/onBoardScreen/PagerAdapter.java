package com.example.taskapp.ui.onBoardScreen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskapp.R;
import com.example.taskapp.databinding.ItemOnBoardBinding;

public class PagerAdapter extends RecyclerView.Adapter<PagerAdapter.ViewHolder>{

    private ItemOnBoardBinding binding;
    private String [] list = {"Stay organized!","Plan events","Be effective" };
    private Integer[] imageList = {R.raw.on_board3, R.raw.on_board2,
            R.raw.on_board4};
    private String [] listD = {"Organize your tasks", "Comfortable interface",
            "Keep your To-Do List!"};

    @NonNull
    @Override
    public PagerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemOnBoardBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new ViewHolder(binding.getRoot()) ;
    }

    @Override
    public void onBindViewHolder(@NonNull PagerAdapter.ViewHolder holder, int position) {
        holder.onBind(position);
    }

    public String[] getList() {
        return list;
    }

    public Integer[] getImageList() {
        return imageList;
    }


    @Override
    public int getItemCount() {
        return list.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void onBind(int position) {
            binding.boardTv.setText(list[position]);
            //binding.boardImgView.setImageResource(imageList[position]);
            binding.boardTv2.setText(listD[position]);
            binding.boardImgView.setAnimation(imageList[position]);
        }
        }
    }


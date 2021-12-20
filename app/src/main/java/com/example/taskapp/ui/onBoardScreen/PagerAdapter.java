package com.example.taskapp.ui.onBoardScreen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskapp.R;
import com.example.taskapp.databinding.ItemOnBoardBinding;
import com.example.taskapp.databinding.ItemTaskBinding;

import java.util.List;

public class PagerAdapter extends RecyclerView.Adapter<PagerAdapter.ViewHolder>{

    ItemOnBoardBinding binding;

    @NonNull
    @Override
    public PagerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_on_board, parent,
                false);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull PagerAdapter.ViewHolder holder, int position) {
        holder.onBind(position);

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title, description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.boardImgView);
            title = itemView.findViewById(R.id.boardTv);
            description = itemView.findViewById(R.id.boardTv2);
        }

        public void onBind(int position) {
            switch (position){
                case 0:
                    title.setText("Stay organized!");
                    break;
                case 1:
                    title.setText("Plan events");
                    break;
                case 2:
                    title.setText("Be effective");
                    break;
            }
        }
    }
}

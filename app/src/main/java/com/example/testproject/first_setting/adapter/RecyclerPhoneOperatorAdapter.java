package com.example.testproject.first_setting.adapter;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testproject.R;

import java.util.List;

public class RecyclerPhoneOperatorAdapter extends RecyclerView.Adapter<RecyclerPhoneOperatorAdapter.ViewHolder> {

    private OnOperatorClickListener listener;
    private List<String> operatorList;
    private ViewHolder lastSelected;

    public RecyclerPhoneOperatorAdapter(List<String> operatorList) {
        this.operatorList = operatorList;
        this.operatorList.add("");
        this.operatorList.add("");
        this.operatorList.add("");
        this.operatorList.add("");
        this.operatorList.add("");
        this.operatorList.add("");
        this.operatorList.add("");
        this.operatorList.add("");
        this.operatorList.add("");
        this.operatorList.add("");
        this.operatorList.add("");
        this.operatorList.add("");
    }

    public void setListener(OnOperatorClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_mobile_operator, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(v -> {
            if (lastSelected != null) {
                lastSelected.itemView.setBackgroundColor(Color.WHITE);
                lastSelected.imgSelected.setImageResource(R.mipmap.ic_not_selected);
            }
            holder.itemView.setBackgroundColor(Color.parseColor("#F5F4FF"));
            holder.imgSelected.setImageResource(R.mipmap.ic_selected);
            lastSelected = holder;
            listener.onClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return operatorList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgIcon;
        TextView tvTitle;
        ImageView imgSelected;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgIcon = itemView.findViewById(R.id.img_icon);
            tvTitle = itemView.findViewById(R.id.tv_title);
            imgSelected = itemView.findViewById(R.id.img_selected);
        }
    }

    public interface OnOperatorClickListener {
        void onClick(int position);
    }
}

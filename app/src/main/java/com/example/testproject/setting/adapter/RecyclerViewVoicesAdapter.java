package com.example.testproject.setting.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testproject.R;
import com.example.testproject.utils.objects.VoiceItem;

import java.util.List;

public class RecyclerViewVoicesAdapter extends RecyclerView.Adapter<RecyclerViewVoicesAdapter.ViewHolder> {

    private OnVoiceClickListener listener;
    private List<VoiceItem> voiceList;
    private ViewHolder lastSelected;

    public RecyclerViewVoicesAdapter(List<VoiceItem> voiceList) {
        this.voiceList = voiceList;
    }

    public void setListener(OnVoiceClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_for_select, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VoiceItem item = voiceList.get(position);
        holder.imgIcon.setImageResource(item.getIcon());
        holder.tvTitle.setText(item.getTitle());

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
        return voiceList.size();
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

    public interface OnVoiceClickListener {
        void onClick(int position);
    }
}

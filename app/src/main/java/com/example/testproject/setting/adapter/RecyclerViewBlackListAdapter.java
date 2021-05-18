package com.example.testproject.setting.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;
import com.example.testproject.R;

import java.util.List;

public class RecyclerViewBlackListAdapter extends RecyclerView.Adapter<RecyclerViewBlackListAdapter.MyViewHolder> {

    private List<String> phoneNumberList;
    private final ViewBinderHelper viewBinderHelper = new ViewBinderHelper();
    private OnItemClickListener listener;

    public RecyclerViewBlackListAdapter(List<String> phoneNumberList) {
        viewBinderHelper.setOpenOnlyOne(true);
        this.phoneNumberList = phoneNumberList;
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_black_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        viewBinderHelper.bind(holder.swipeLayout, phoneNumberList.get(position));
        holder.tvTitle.setText(phoneNumberList.get(position));

        holder.itemLayout.setOnClickListener(view -> listener.onClickItem(phoneNumberList.get(position)));

        holder.imgMinus.setOnClickListener(view -> {
            listener.onClickMinus(position);
            if (!holder.swipeLayout.isClosed()) {
                holder.swipeLayout.close(true);
            }
        });
        holder.imgDelete.setOnClickListener(view -> {
            listener.onClickDelete(position);
            if (!holder.swipeLayout.isClosed()) {
                holder.swipeLayout.close(true);
            }
        });
    }

    @Override
    public int getItemCount() {
        return phoneNumberList.size();
    }

    public void setPhoneNumberList(List<String> phoneNumberList) {
        this.phoneNumberList = phoneNumberList;
        notifyDataSetChanged();
    }

    public void saveStates(Bundle outState) {
        viewBinderHelper.saveStates(outState);
    }

    public void restoreStates(Bundle inState) {
        viewBinderHelper.restoreStates(inState);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        SwipeRevealLayout swipeLayout;
        LinearLayout itemLayout;
        TextView tvTitle;
        ImageView imgMinus;
        ImageView imgDelete;

        private MyViewHolder(@NonNull View itemView) {
            super(itemView);

            swipeLayout = itemView.findViewById(R.id.swipe_layout);
            itemLayout = itemView.findViewById(R.id.content_layout);
            tvTitle = itemView.findViewById(R.id.tv_title);
            imgMinus = itemView.findViewById(R.id.img_minus);
            imgDelete = itemView.findViewById(R.id.img_delete);

//            btnMore.setOnClickListener(v -> {
//                if (swipeLayout.isClosed()) {
//                    swipeLayout.open(true);
//                } else {
//                    swipeLayout.close(true);
//                }
//            });
        }
    }

    public interface OnItemClickListener {
        void onClickItem(String phone);

        void onClickMinus(int phone);

        void onClickDelete(int phone);
    }
}

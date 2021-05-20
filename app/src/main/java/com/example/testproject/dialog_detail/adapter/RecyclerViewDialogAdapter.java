package com.example.testproject.dialog_detail.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testproject.R;
import com.example.testproject.utils.objects.MainDialogItem;

import java.util.List;

public class RecyclerViewDialogAdapter extends RecyclerView.Adapter<RecyclerViewDialogAdapter.ViewHolder> {

    private OnOperatorClickListener listener;
    private List<MainDialogItem> dialogList;

    public RecyclerViewDialogAdapter(List<MainDialogItem> dialogList) {
        this.dialogList = dialogList;
    }

    public void setListener(OnOperatorClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_main_dialog, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MainDialogItem item = dialogList.get(position);
        if (item.isAutoAnswer()) {
            holder.rightMessageLayout.setVisibility(View.VISIBLE);
            holder.leftMessageLayout.setVisibility(View.GONE);
            holder.tvMessageRight.setText(item.getMessage());
        } else {
            holder.rightMessageLayout.setVisibility(View.GONE);
            holder.leftMessageLayout.setVisibility(View.VISIBLE);
            holder.tvMessageLeft.setText(item.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return dialogList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        FrameLayout rightMessageLayout;
        TextView tvMessageRight;

        FrameLayout leftMessageLayout;
        TextView tvMessageLeft;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rightMessageLayout = itemView.findViewById(R.id.right_message_layout);
            tvMessageRight = itemView.findViewById(R.id.tv_message_right);

            leftMessageLayout = itemView.findViewById(R.id.left_message_layout);
            tvMessageLeft = itemView.findViewById(R.id.tv_message_left);
        }
    }

    public interface OnOperatorClickListener {
        void onClick(MainDialogItem item);
    }
}

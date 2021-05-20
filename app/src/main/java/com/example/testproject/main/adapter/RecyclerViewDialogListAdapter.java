package com.example.testproject.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;
import com.example.testproject.R;
import com.example.testproject.utils.objects.MainDialogListItem;

import java.util.List;

public class RecyclerViewDialogListAdapter extends RecyclerView.Adapter<RecyclerViewDialogListAdapter.ViewHolder> {

    private List<MainDialogListItem> itemDialog;
    private OnItemClickListener listener;
    private final ViewBinderHelper viewBinderHelper = new ViewBinderHelper();

    public RecyclerViewDialogListAdapter(List<MainDialogListItem> itemDialog) {
        viewBinderHelper.setOpenOnlyOne(true);
        this.itemDialog = itemDialog;
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_main_dialog_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MainDialogListItem itemMenu = itemDialog.get(position);
        viewBinderHelper.bind(holder.swipeRevealLayout, itemMenu.getTitle());
        if (itemMenu.isHeader()) {
            holder.headerLayout.setVisibility(View.VISIBLE);
            holder.swipeRevealLayout.setVisibility(View.GONE);

            holder.tvHeader.setText(itemMenu.getTitle());
        } else {
            holder.headerLayout.setVisibility(View.GONE);
            holder.swipeRevealLayout.setVisibility(View.VISIBLE);

            holder.tvTitle.setText(itemMenu.getTitle());
            holder.tvDescription.setText(itemMenu.getDescription());
            holder.imgIcon.setImageResource(itemMenu.getIcon());
            holder.tvTime.setText(itemMenu.getTime());

            holder.itemLayout.setOnClickListener(v -> {
                listener.onClickItem(itemMenu);
                if (!holder.swipeRevealLayout.isClosed()) {
                    holder.swipeRevealLayout.close(true);
                }
            });
            holder.imgMinus.setOnClickListener(v -> {
                listener.onClickMinus(itemMenu);
                if (!holder.swipeRevealLayout.isClosed()) {
                    holder.swipeRevealLayout.close(true);
                }
            });
            holder.imgDelete.setOnClickListener(v -> {
                listener.onClickDelete(itemMenu);
                if (!holder.swipeRevealLayout.isClosed()) {
                    holder.swipeRevealLayout.close(true);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return itemDialog.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout headerLayout;
        TextView tvHeader;

        SwipeRevealLayout swipeRevealLayout;
        RelativeLayout itemLayout;
        TextView tvTitle;
        ImageView imgIcon;
        TextView tvDescription;
        TextView tvTime;

        ImageView imgMinus;
        ImageView imgDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            headerLayout = itemView.findViewById(R.id.header_layout);
            tvHeader = itemView.findViewById(R.id.tv_header);
            swipeRevealLayout = itemView.findViewById(R.id.swipe_layout);
            itemLayout = itemView.findViewById(R.id.item_layout);
            tvTitle = itemView.findViewById(R.id.tv_title);
            imgIcon = itemView.findViewById(R.id.img_icon);
            tvDescription = itemView.findViewById(R.id.tv_description);
            tvTime = itemView.findViewById(R.id.tv_time);
            imgMinus = itemView.findViewById(R.id.img_minus);
            imgDelete = itemView.findViewById(R.id.img_delete);
        }
    }

    public interface OnItemClickListener {
        void onClickItem(MainDialogListItem itemMenu);

        void onClickMinus(MainDialogListItem itemMenu);

        void onClickDelete(MainDialogListItem itemMenu);
    }
}

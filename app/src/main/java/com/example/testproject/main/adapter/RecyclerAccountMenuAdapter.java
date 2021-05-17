package com.example.testproject.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testproject.R;
import com.example.testproject.utils.objects.AccountItemMenu;

import java.util.List;

public class RecyclerAccountMenuAdapter extends RecyclerView.Adapter<RecyclerAccountMenuAdapter.ViewHolder> {

    private List<AccountItemMenu> itemMenuList;
    private OnItemClickListener listener;

    public RecyclerAccountMenuAdapter(List<AccountItemMenu> itemMenuList) {
        this.itemMenuList = itemMenuList;
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_account_menu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AccountItemMenu itemMenu = itemMenuList.get(position);
        if (itemMenu.isHeader()) {
            holder.tvHeader.setText(itemMenu.getTitle());
            holder.tvHeader.setVisibility(View.VISIBLE);
            holder.line.setVisibility(View.GONE);
            holder.itemLayout.setVisibility(View.GONE);
        } else {
            holder.tvHeader.setVisibility(View.GONE);
            holder.line.setVisibility(View.VISIBLE);
            holder.itemLayout.setVisibility(View.VISIBLE);
            holder.imgIcon.setImageResource(itemMenu.getIcon());
            holder.tvTitle.setText(itemMenu.getTitle());

            if (itemMenu.getIcon() == 0) {
                holder.imgIcon.setVisibility(View.GONE);
            } else {
                holder.imgIcon.setVisibility(View.VISIBLE);
            }


            holder.tvDescription.setText(itemMenu.getDescription());
            if (itemMenu.getDescription().isEmpty()) {
                holder.tvDescription.setVisibility(View.GONE);
            } else {
                holder.tvDescription.setVisibility(View.VISIBLE);
            }

            holder.itemLayout.setOnClickListener(v -> listener.onClick(itemMenu));
        }
    }

    @Override
    public int getItemCount() {
        return itemMenuList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvHeader;
        private View line;
        private LinearLayout itemLayout;
        private ImageView imgIcon;
        private TextView tvTitle;
        private TextView tvDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvHeader = itemView.findViewById(R.id.tv_header);
            line = itemView.findViewById(R.id.view_line);
            itemLayout = itemView.findViewById(R.id.item_layout);
            imgIcon = itemView.findViewById(R.id.img_icon);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);
        }
    }

    public interface OnItemClickListener {
        void onClick(AccountItemMenu item);
    }
}

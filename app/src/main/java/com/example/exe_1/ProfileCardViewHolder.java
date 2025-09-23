package com.example.exe_1;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;

public class ProfileCardViewHolder extends RecyclerView.ViewHolder {
    public final MaterialCardView cardRoot;
    public final ImageView imgAvatar;
    public final TextView tvName;
    public final TextView tvRole;
    public final Chip chipExp;
    public final Chip chipRole;
    public final TextView tvSummary;
    public final TextView tvPrice;
    public final TextView tvExperience;
    public final TextView tvRate;
    public final ImageButton btnBookmark;

    public ProfileCardViewHolder(@NonNull View itemView) {
        super(itemView);
        cardRoot = itemView.findViewById(R.id.cardRoot);
        imgAvatar = itemView.findViewById(R.id.imgAvatar);
        tvName = itemView.findViewById(R.id.tvName);
        tvRole = itemView.findViewById(R.id.tvRole);
        chipExp = itemView.findViewById(R.id.chipExp);
        chipRole = itemView.findViewById(R.id.chipRole);
        tvSummary = itemView.findViewById(R.id.tvSummary);
        tvPrice = itemView.findViewById(R.id.tvPrice);
        tvExperience = itemView.findViewById(R.id.tvExperience);
        tvRate = itemView.findViewById(R.id.tvRate);
        btnBookmark = itemView.findViewById(R.id.btnBookmark);
    }
}



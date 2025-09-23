package com.example.exe_1;

import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class ProfilesAdapter extends RecyclerView.Adapter<ProfileCardViewHolder> {

    public interface ProfileCallbacks {
        void onCardClick(@NonNull String id);
        void onBookmarkToggle(@NonNull String id, boolean state);
    }

    private final List<Profile> items;
    private final ProfileCallbacks callbacks;

    public ProfilesAdapter(List<Profile> items, ProfileCallbacks callbacks) {
        this.items = items;
        this.callbacks = callbacks;
    }

    @NonNull
    @Override
    public ProfileCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profile_card, parent, false);
        return new ProfileCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileCardViewHolder holder, int position) {
        Profile p = items.get(position);

        holder.tvName.setText(p.name);
        holder.tvRole.setText(p.role);
        holder.chipExp.setText(holder.itemView.getContext().getString(R.string.fmt_years_exp, p.yearsExp));
        holder.chipRole.setText(p.tagPrimary);
        holder.tvSummary.setText(p.summary);
        holder.tvExperience.setText(holder.itemView.getContext().getString(R.string.fmt_years_exp, p.yearsExp));
        holder.tvRate.setText(holder.itemView.getContext().getString(R.string.fmt_rate_range, p.rateMin, p.rateMax));
        holder.tvPrice.setText(holder.itemView.getContext().getString(R.string.fmt_price_day, p.rateMin, p.rateMax));

        // Placeholder: simple avatar fallback (no image loader requirement specified)
        holder.imgAvatar.setImageResource(R.drawable.ic_profile_placeholder);

        // Force single theme: black card only
        int black = 0xFF0B0B0B;
        holder.cardRoot.setCardBackgroundColor(black);

        // Hide extra trailing info to match design
        holder.tvExperience.setVisibility(View.GONE);
        holder.tvRate.setVisibility(View.GONE);

        // Bookmark icon should be light on dark background
        holder.btnBookmark.setColorFilter(0xFFFFFFFF);

        holder.btnBookmark.setImageResource(p.isSaved ? R.drawable.action_bookmark_filled : R.drawable.action_bookmark);

        holder.cardRoot.setOnClickListener(v -> callbacks.onCardClick(p.id));
        holder.btnBookmark.setOnClickListener(v -> {
            p.isSaved = !p.isSaved;
            notifyItemChanged(holder.getBindingAdapterPosition());
            callbacks.onBookmarkToggle(p.id, p.isSaved);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}



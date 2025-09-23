package com.example.exe_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WorkExperienceAdapter extends RecyclerView.Adapter<WorkExperienceAdapter.WorkExperienceViewHolder> {

    private List<WorkExperience> workExperiences;

    public WorkExperienceAdapter(List<WorkExperience> workExperiences) {
        this.workExperiences = workExperiences;
    }

    @NonNull
    @Override
    public WorkExperienceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_work_experience, parent, false);
        return new WorkExperienceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkExperienceViewHolder holder, int position) {
        WorkExperience workExperience = workExperiences.get(position);
        holder.bind(workExperience);
    }

    @Override
    public int getItemCount() {
        return workExperiences.size();
    }

    static class WorkExperienceViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgCompanyLogo;
        private TextView tvPosition;
        private TextView tvCompanyName;
        private TextView tvDuration;

        public WorkExperienceViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCompanyLogo = itemView.findViewById(R.id.imgCompanyLogo);
            tvPosition = itemView.findViewById(R.id.tvPosition);
            tvCompanyName = itemView.findViewById(R.id.tvCompanyName);
            tvDuration = itemView.findViewById(R.id.tvDuration);
        }

        public void bind(WorkExperience workExperience) {
            imgCompanyLogo.setImageResource(workExperience.getLogoResource());
            tvPosition.setText(workExperience.getPosition());
            tvCompanyName.setText(workExperience.getCompany());
            tvDuration.setText(workExperience.getDuration());
        }
    }
}
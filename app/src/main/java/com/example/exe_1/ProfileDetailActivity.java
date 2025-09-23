package com.example.exe_1;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.imageview.ShapeableImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class ProfileDetailActivity extends AppCompatActivity {

    private MaterialToolbar toolbar;
    private RecyclerView recyclerWorkExperience;
    private WorkExperienceAdapter workExperienceAdapter;
    private ShapeableImageView imgProfileAvatar;
    private ImageView imgPortfolioMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_detail);

        setupSystemUI();
        initViews();
        setupToolbar();
        setupWorkExperience();
    }

    private void setupSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        Window window = getWindow();

        // Set status bar color based on theme
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
        window.setStatusBarColor(typedValue.data);

        // Set navigation bar color
        window.setNavigationBarColor(typedValue.data);
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        recyclerWorkExperience = findViewById(R.id.recyclerWorkExperience);
        imgProfileAvatar = findViewById(R.id.imgProfileAvatar);
        imgPortfolioMain = findViewById(R.id.imgPortfolioMain);

        // Load avatar image from URL
        Glide.with(this)
                .load("https://static.vecteezy.com/system/resources/previews/052/523/062/non_2x/3d-icon-avatar-cartoon-man-with-glasses-is-smiling-and-wearing-on-transparent-background-png.png")
                .placeholder(R.drawable.gerald_avatar)
                .error(R.drawable.gerald_avatar)
                .into(imgProfileAvatar);

        // Load portfolio image from URL
        Glide.with(this)
                .load("https://image.isu.pub/240206120058-048d13aa65c9e325e49e8de97b453d0e/jpg/page_1_thumb_large.jpg")
                .placeholder(R.drawable.portfolio_placeholder)
                .error(R.drawable.portfolio_placeholder)
                .into(imgPortfolioMain);

        // Setup safe area for app bar
        View appBarContainer = findViewById(R.id.appBarContainer);
        androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(appBarContainer, (v, insets) -> {
            int top = insets.getInsets(androidx.core.view.WindowInsetsCompat.Type.statusBars()).top;
            v.setPadding(v.getPaddingLeft(), top, v.getPaddingRight(), v.getPaddingBottom());
            return insets;
        });
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(v -> {
            finish();
        });
    }

    private void setupWorkExperience() {
        // Setup horizontal RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerWorkExperience.setLayoutManager(layoutManager);

        // Create sample work experience data
        List<WorkExperience> workExperiences = new ArrayList<>();
        workExperiences.add(new WorkExperience("Lead Product Designer", "X", "2023-2024", R.drawable.logo_x));
        workExperiences.add(new WorkExperience("Senior Product Designer", "Spotify", "2020-2023", R.drawable.logo_spotify));
        workExperiences.add(new WorkExperience("Product Designer", "Google", "2018-2020", R.drawable.logo_google));

        workExperienceAdapter = new WorkExperienceAdapter(workExperiences);
        recyclerWorkExperience.setAdapter(workExperienceAdapter);
    }
}
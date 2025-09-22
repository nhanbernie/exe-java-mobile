package com.example.exe_1;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.WindowCompat;
import androidx.core.view.ViewCompat;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

public class OnboardingActivity extends AppCompatActivity {

    private LinearLayout stepsContainer;
    private ViewPager2 pager;
    private static final int TOTAL_STEPS = 3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        setContentView(R.layout.activity_onboarding);

        View root = findViewById(R.id.root);

        ViewCompat.setOnApplyWindowInsetsListener(root, (v, insets) -> {
            int top = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top;
            v.setPadding(v.getPaddingLeft(), top, v.getPaddingRight(), v.getPaddingBottom());
            return insets;
        });

        stepsContainer = findViewById(R.id.stepsContainer);
        pager = findViewById(R.id.pager);

        pager.setAdapter(new OnboardingAdapter(this));

        createSteps(TOTAL_STEPS);

        pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                updateIndicator(position);
            }
        });

        updateIndicator(0);
    }

    private void createSteps(int total) {
        stepsContainer.removeAllViews();
        int heightPx = dp(6);
        int gapPx = dp(6);

        for (int i = 0; i < total; i++) {
            View bar = new View(this);
            LinearLayout.LayoutParams lp =
                    new LinearLayout.LayoutParams(0, heightPx, 1f);
            if (i < total - 1) lp.setMarginEnd(gapPx);
            bar.setLayoutParams(lp);
            bar.setBackgroundResource(R.drawable.step_inactive);
            stepsContainer.addView(bar);
        }
    }

    private void updateIndicator(int current) {
        for (int i = 0; i < stepsContainer.getChildCount(); i++) {
            View bar = stepsContainer.getChildAt(i);
            bar.setBackgroundResource(i == current
                    ? R.drawable.step_active
                    : R.drawable.step_inactive);
        }
        stepsContainer.setContentDescription("Step " + (current + 1) + " of " + TOTAL_STEPS);
    }

    private int dp(int v){
        float d = getResources().getDisplayMetrics().density;
        return Math.round(d * v);
    }
}

package com.example.exe_1;

import android.animation.ObjectAnimator;
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
                updateIndicatorWithAnimation(position);
            }
        });

        updateIndicatorWithAnimation(0);
    }

    private void createSteps(int total) {
        stepsContainer.removeAllViews();
        int heightPx = dp(8);
        int gapPx = dp(8);

        for (int i = 0; i < total; i++) {
            View bar = new View(this);
            LinearLayout.LayoutParams lp =
                    new LinearLayout.LayoutParams(0, heightPx, 1f);
            if (i < total - 1) lp.setMarginEnd(gapPx);
            bar.setLayoutParams(lp);
            bar.setBackgroundResource(R.drawable.step_inactive);
            bar.setAlpha(0.6f);
            stepsContainer.addView(bar);
        }
    }

    private void updateIndicatorWithAnimation(int current) {
        for (int i = 0; i < stepsContainer.getChildCount(); i++) {
            View bar = stepsContainer.getChildAt(i);

            if (i == current) {
                // Animate to active state
                bar.setBackgroundResource(R.drawable.step_active);
                ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(bar, "alpha", bar.getAlpha(), 1.0f);
                alphaAnimator.setDuration(300);
                alphaAnimator.start();

                ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(bar, "scaleX", 0.8f, 1.0f);
                scaleXAnimator.setDuration(300);
                scaleXAnimator.start();

                ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(bar, "scaleY", 0.8f, 1.0f);
                scaleYAnimator.setDuration(300);
                scaleYAnimator.start();
            } else {
                // Animate to inactive state
                bar.setBackgroundResource(R.drawable.step_inactive);
                ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(bar, "alpha", bar.getAlpha(), 0.6f);
                alphaAnimator.setDuration(300);
                alphaAnimator.start();

                ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(bar, "scaleX", bar.getScaleX(), 1.0f);
                scaleXAnimator.setDuration(300);
                scaleXAnimator.start();

                ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(bar, "scaleY", bar.getScaleY(), 1.0f);
                scaleYAnimator.setDuration(300);
                scaleYAnimator.start();
            }
        }
        stepsContainer.setContentDescription("Step " + (current + 1) + " of " + TOTAL_STEPS);
    }

    private int dp(int v){
        float d = getResources().getDisplayMetrics().density;
        return Math.round(d * v);
    }
}

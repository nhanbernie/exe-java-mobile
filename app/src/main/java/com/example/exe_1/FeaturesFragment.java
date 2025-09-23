package com.example.exe_1;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FeaturesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_features, container, false);

        // Setup feature items animation
        setupFeatureAnimation(view.findViewById(R.id.feature1));
        setupFeatureAnimation(view.findViewById(R.id.feature2));
        setupFeatureAnimation(view.findViewById(R.id.feature3));

        return view;
    }

    private void setupFeatureAnimation(LinearLayout featureItem) {
        featureItem.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Scale down animation
                        AnimatorSet pressAnimator = (AnimatorSet) AnimatorInflater.loadAnimator(
                                getContext(), R.animator.button_press_scale);
                        pressAnimator.setTarget(featureItem);
                        pressAnimator.start();
                        break;

                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        // Scale up animation
                        AnimatorSet releaseAnimator = (AnimatorSet) AnimatorInflater.loadAnimator(
                                getContext(), R.animator.button_release_scale);
                        releaseAnimator.setTarget(featureItem);
                        releaseAnimator.start();
                        break;
                }
                return true; // Consume the touch event
            }
        });
    }
}

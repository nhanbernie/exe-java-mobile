package com.example.exe_1;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

public class GetStartedFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Trỏ tới res/layout/fragment_get_started.xml
        View view = inflater.inflate(R.layout.fragment_get_started, container, false);

        // Setup button animation & navigation
        MaterialButton btnGetStarted = view.findViewById(R.id.btnGetStarted);
        setupButtonAnimation(btnGetStarted);
        btnGetStarted.setOnClickListener(v -> {
            if (getActivity() != null) {
                startActivity(new Intent(getActivity(), ExploreActivity.class));
            }
        });

        return view;
    }

    private void setupButtonAnimation(MaterialButton button) {
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Scale down animation
                        AnimatorSet pressAnimator = (AnimatorSet) AnimatorInflater.loadAnimator(
                                getContext(), R.animator.button_press_scale);
                        pressAnimator.setTarget(button);
                        pressAnimator.start();
                        break;

                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        // Scale up animation
                        AnimatorSet releaseAnimator = (AnimatorSet) AnimatorInflater.loadAnimator(
                                getContext(), R.animator.button_release_scale);
                        releaseAnimator.setTarget(button);
                        releaseAnimator.start();
                        break;
                }
                return false; // Let the button handle the click normally
            }
        });
    }
}

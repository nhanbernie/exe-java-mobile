package com.example.exe_1;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class ProfilesRepository {

    public List<Profile> getProfiles() {
        List<Profile> items = new ArrayList<>();
        items.add(new Profile(
                "p1",
                "https://i.pravatar.cc/150?img=1",
                "Ava Johnson",
                "UI/UX Designer",
                5,
                "Figma",
                20,
                35,
                "Human-centered designer focused on mobile experiences.",
                false,
                Color.parseColor("#FFB300")));

        items.add(new Profile(
                "p2",
                "https://i.pravatar.cc/150?img=2",
                "Ethan Lee",
                "Product Designer",
                7,
                "Prototyping",
                30,
                50,
                "Rapid prototyping and design systems expert.",
                true,
                null));

        items.add(new Profile(
                "p3",
                "https://i.pravatar.cc/150?img=3",
                "Mia Chen",
                "Visual Designer",
                3,
                "Branding",
                18,
                28,
                "Clean visuals with accessibility baked in.",
                false,
                Color.parseColor("#29B6F6")));

        return items;
    }
}



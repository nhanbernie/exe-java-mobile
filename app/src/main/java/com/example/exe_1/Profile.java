package com.example.exe_1;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;

public class Profile {
    public final String id;
    public final String avatarUrl;
    public final String name;
    public final String role;
    public final int yearsExp;
    public final String tagPrimary;
    public final int rateMin;
    public final int rateMax;
    public final String summary;
    public boolean isSaved;
    @Nullable @ColorInt public final Integer accentColor;

    public Profile(String id,
                   String avatarUrl,
                   String name,
                   String role,
                   int yearsExp,
                   String tagPrimary,
                   int rateMin,
                   int rateMax,
                   String summary,
                   boolean isSaved,
                   @Nullable Integer accentColor) {
        this.id = id;
        this.avatarUrl = avatarUrl;
        this.name = name;
        this.role = role;
        this.yearsExp = yearsExp;
        this.tagPrimary = tagPrimary;
        this.rateMin = rateMin;
        this.rateMax = rateMax;
        this.summary = summary;
        this.isSaved = isSaved;
        this.accentColor = accentColor;
    }
}



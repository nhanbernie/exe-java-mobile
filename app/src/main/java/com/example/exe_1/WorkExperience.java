package com.example.exe_1;

public class WorkExperience {
    private String position;
    private String company;
    private String duration;
    private int logoResource;

    public WorkExperience(String position, String company, String duration, int logoResource) {
        this.position = position;
        this.company = company;
        this.duration = duration;
        this.logoResource = logoResource;
    }

    // Getters
    public String getPosition() {
        return position;
    }

    public String getCompany() {
        return company;
    }

    public String getDuration() {
        return duration;
    }

    public int getLogoResource() {
        return logoResource;
    }

    // Setters
    public void setPosition(String position) {
        this.position = position;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setLogoResource(int logoResource) {
        this.logoResource = logoResource;
    }
}
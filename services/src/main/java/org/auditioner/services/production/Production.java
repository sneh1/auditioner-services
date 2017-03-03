package org.auditioner.services.production;

public class Production{
    private String name;
    private String auditionDate;
    private String season;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuditionDate() {
        return auditionDate;
    }

    public void setAuditionDate(String auditionDate) {
        this.auditionDate = auditionDate;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getSeason() {
        return season;
    }
}
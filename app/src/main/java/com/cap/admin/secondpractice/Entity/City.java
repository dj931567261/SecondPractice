package com.cap.admin.secondpractice.Entity;

/**
 * Created by admin on 2017/1/11.
 */
public class City {
    /**
     * cityName : 鞍山
     * firstLetter : A
     */

    private String cityName;
    private String firstLetter;

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public String getCityName() {
        return cityName;
    }

    public String getFirstLetter() {
        return firstLetter;
    }
}

package org.myorg.xls.entities;


public class XlsEntity {

    private String brand;
    private String fullName;
    private String width;
    private String hight;
    private String diameter;
    private String season;
    private String country;
    private String balance;
    private String grossPrice;
    private String date;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHight() {
        return hight;
    }

    public void setHight(String hight) {
        this.hight = hight;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(String grossPrice) {
        this.grossPrice = grossPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "XlsEntity{" +
                "brand='" + brand + '\'' +
                ", fullName='" + fullName + '\'' +
                ", width='" + width + '\'' +
                ", hight='" + hight + '\'' +
                ", diameter='" + diameter + '\'' +
                ", season='" + season + '\'' +
                ", country='" + country + '\'' +
                ", balance='" + balance + '\'' +
                ", grossPrice='" + grossPrice + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

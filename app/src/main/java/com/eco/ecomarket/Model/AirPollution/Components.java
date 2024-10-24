package com.eco.ecomarket.Model.AirPollution;

public class Components {
    private double co;
    private double nh3;
    private double no;
    private double no2;
    private double o3;
    private double pm10;
    private double pm2_5;
    private double so2;

    public Components(double co, double nh3, double no, double no2, double o3, double pm10, double pm2_5, double so2) {
        this.co = co;
        this.nh3 = nh3;
        this.no = no;
        this.no2 = no2;
        this.o3 = o3;
        this.pm10 = pm10;
        this.pm2_5 = pm2_5;
        this.so2 = so2;
    }

    public double getCo() {
        return co;
    }

    public void setCo(double co) {
        this.co = co;
    }

    public double getNh3() {
        return nh3;
    }

    public void setNh3(double nh3) {
        this.nh3 = nh3;
    }

    public double getNo() {
        return no;
    }

    public void setNo(double no) {
        this.no = no;
    }

    public double getNo2() {
        return no2;
    }

    public void setNo2(double no2) {
        this.no2 = no2;
    }

    public double getO3() {
        return o3;
    }

    public void setO3(double o3) {
        this.o3 = o3;
    }

    public double getPm10() {
        return pm10;
    }

    public void setPm10(double pm10) {
        this.pm10 = pm10;
    }

    public double getPm2_5() {
        return pm2_5;
    }

    public void setPm2_5(double pm2_5) {
        this.pm2_5 = pm2_5;
    }

    public double getSo2() {
        return so2;
    }

    public void setSo2(double so2) {
        this.so2 = so2;
    }
}

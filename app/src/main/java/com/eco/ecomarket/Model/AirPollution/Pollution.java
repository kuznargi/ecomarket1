package com.eco.ecomarket.Model.AirPollution;

public class Pollution {
    private Components components;
    private int dt;
    private Main main;

    public Pollution(Components components, int dt, Main main) {
        this.components = components;
        this.dt = dt;
        this.main = main;
    }

    public Components getComponents() {
        return components;
    }

    public void setComponents(Components components) {
        this.components = components;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}

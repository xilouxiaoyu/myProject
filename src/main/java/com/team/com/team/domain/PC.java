package com.team.com.team.domain;

public class PC implements Equipment {
    private String model;
    private String display;

    public PC() {
    }

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    public PC(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public String getDisplay() {
        return display;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getDescription(){
        return model + "(" + display + ")";
    }
}

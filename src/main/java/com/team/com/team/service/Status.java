package com.team.com.team.service;

public class Status {
    private final String NAME;
    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    public String getNAME() {
        return NAME;
    }

    private Status(String name){
        this.NAME = name;

    }

    @Override
    public String toString() {
        return NAME;
    }
}

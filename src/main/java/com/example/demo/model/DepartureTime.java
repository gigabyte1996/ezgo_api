package com.example.demo.model;

public class DepartureTime {
    private int fiveToElevenAM;
    private int elevenToFivePM;
    private int fiveToElevenPM;
    private int elevenToFiveAM;

    public DepartureTime() {
        super();
    }

    public DepartureTime(int fiveToElevenAM, int elevenToFivePM, int fiveToElevenPM, int elevenToFiveAM) {
        this.fiveToElevenAM = fiveToElevenAM;
        this.elevenToFivePM = elevenToFivePM;
        this.fiveToElevenPM = fiveToElevenPM;
        this.elevenToFiveAM = elevenToFiveAM;
    }

    public int getFiveToElevenAM() {
        return fiveToElevenAM;
    }

    public void setFiveToElevenAM(int fiveToElevenAM) {
        this.fiveToElevenAM = fiveToElevenAM;
    }

    public int getElevenToFivePM() {
        return elevenToFivePM;
    }

    public void setElevenToFivePM(int elevenToFivePM) {
        this.elevenToFivePM = elevenToFivePM;
    }

    public int getFiveToElevenPM() {
        return fiveToElevenPM;
    }

    public void setFiveToElevenPM(int fiveToElevenPM) {
        this.fiveToElevenPM = fiveToElevenPM;
    }

    public int getElevenToFiveAM() {
        return elevenToFiveAM;
    }

    public void setElevenToFiveAM(int elevenToFiveAM) {
        this.elevenToFiveAM = elevenToFiveAM;
    }
}

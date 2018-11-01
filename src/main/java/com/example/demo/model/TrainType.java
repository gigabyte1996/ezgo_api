package com.example.demo.model;

public class TrainType {
    private int slowTrain;
    private int slowestTrain;
    private int fastTrain;
    private int superFastTrain;

    public TrainType() {
        super();
    }

    public TrainType(int slowTrain, int slowestTrain, int fastTrain, int superFastTrain) {
        this.slowTrain = slowTrain;
        this.slowestTrain = slowestTrain;
        this.fastTrain = fastTrain;
        this.superFastTrain = superFastTrain;
    }

    public int getSlowTrain() {
        return slowTrain;
    }

    public void setSlowTrain(int slowTrain) {
        this.slowTrain = slowTrain;
    }

    public int getSlowestTrain() {
        return slowestTrain;
    }

    public void setSlowestTrain(int slowestTrain) {
        this.slowestTrain = slowestTrain;
    }

    public int getFastTrain() {
        return fastTrain;
    }

    public void setFastTrain(int fastTrain) {
        this.fastTrain = fastTrain;
    }

    public int getSuperFastTrain() {
        return superFastTrain;
    }

    public void setSuperFastTrain(int superFastTrain) {
        this.superFastTrain = superFastTrain;
    }
}

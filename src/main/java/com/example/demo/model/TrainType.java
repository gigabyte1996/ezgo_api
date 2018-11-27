package com.example.demo.model;

public class TrainType {
    private Integer slowTrain;
    private Integer slowestTrain;
    private Integer fastTrain;
    private Integer superFastTrain;

    public TrainType() {
        super();
    }

    public TrainType(Integer slowTrain, Integer slowestTrain, Integer fastTrain, Integer superFastTrain) {
        this.slowTrain = slowTrain;
        this.slowestTrain = slowestTrain;
        this.fastTrain = fastTrain;
        this.superFastTrain = superFastTrain;
    }

    public Integer getSlowTrain() {
        return slowTrain;
    }

    public void setSlowTrain(Integer slowTrain) {
        this.slowTrain = slowTrain;
    }

    public Integer getSlowestTrain() {
        return slowestTrain;
    }

    public void setSlowestTrain(Integer slowestTrain) {
        this.slowestTrain = slowestTrain;
    }

    public Integer getFastTrain() {
        return fastTrain;
    }

    public void setFastTrain(Integer fastTrain) {
        this.fastTrain = fastTrain;
    }

    public Integer getSuperFastTrain() {
        return superFastTrain;
    }

    public void setSuperFastTrain(Integer superFastTrain) {
        this.superFastTrain = superFastTrain;
    }
}

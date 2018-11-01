package com.example.demo.model;

public class SeatType {
    private int hardSeat;
    private int softSeat;
    private int extraSeat;
    private int hardBedFirstFloor;
    private int hardBedSecondFloor;
    private int hardBedThirdFloor;
    private int softBedFirstFloor;
    private int softBedSecondFloor;

    public SeatType(int hardSeat, int softSeat, int extraSeat, int hardBedFirstFloor, int hardBedSecondFloor, int hardBedThirdFloor, int softBedFirstFloor, int softBedSecondFloor) {
        this.hardSeat = hardSeat;
        this.softSeat = softSeat;
        this.extraSeat = extraSeat;
        this.hardBedFirstFloor = hardBedFirstFloor;
        this.hardBedSecondFloor = hardBedSecondFloor;
        this.hardBedThirdFloor = hardBedThirdFloor;
        this.softBedFirstFloor = softBedFirstFloor;
        this.softBedSecondFloor = softBedSecondFloor;
    }

    public SeatType() {
        super();
    }

    public int getHardSeat() {
        return hardSeat;
    }

    public void setHardSeat(int hardSeat) {
        this.hardSeat = hardSeat;
    }

    public int getSoftSeat() {
        return softSeat;
    }

    public void setSoftSeat(int softSeat) {
        this.softSeat = softSeat;
    }

    public int getExtraSeat() {
        return extraSeat;
    }

    public void setExtraSeat(int extraSeat) {
        this.extraSeat = extraSeat;
    }

    public int getHardBedFirstFloor() {
        return hardBedFirstFloor;
    }

    public void setHardBedFirstFloor(int hardBedFirstFloor) {
        this.hardBedFirstFloor = hardBedFirstFloor;
    }

    public int getHardBedSecondFloor() {
        return hardBedSecondFloor;
    }

    public void setHardBedSecondFloor(int hardBedSecondFloor) {
        this.hardBedSecondFloor = hardBedSecondFloor;
    }

    public int getHardBedThirdFloor() {
        return hardBedThirdFloor;
    }

    public void setHardBedThirdFloor(int hardBedThirdFloor) {
        this.hardBedThirdFloor = hardBedThirdFloor;
    }

    public int getSoftBedFirstFloor() {
        return softBedFirstFloor;
    }

    public void setSoftBedFirstFloor(int softBedFirstFloor) {
        this.softBedFirstFloor = softBedFirstFloor;
    }

    public int getSoftBedSecondFloor() {
        return softBedSecondFloor;
    }

    public void setSoftBedSecondFloor(int softBedSecondFloor) {
        this.softBedSecondFloor = softBedSecondFloor;
    }
}

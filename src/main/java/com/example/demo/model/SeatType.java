package com.example.demo.model;

public class SeatType {
    private Integer hardSeat;
    private Integer softSeat;
    private Integer extraSeat;
    private Integer hardBedFirstFloor;
    private Integer hardBedSecondFloor;
    private Integer hardBedThirdFloor;
    private Integer softBedFirstFloor;
    private Integer softBedSecondFloor;

    public SeatType(Integer hardSeat, Integer softSeat, Integer extraSeat, Integer hardBedFirstFloor, Integer hardBedSecondFloor, Integer hardBedThirdFloor, Integer softBedFirstFloor, Integer softBedSecondFloor) {
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

    public Integer getHardSeat() {
        return hardSeat;
    }

    public void setHardSeat(Integer hardSeat) {
        this.hardSeat = hardSeat;
    }

    public Integer getSoftSeat() {
        return softSeat;
    }

    public void setSoftSeat(Integer softSeat) {
        this.softSeat = softSeat;
    }

    public Integer getExtraSeat() {
        return extraSeat;
    }

    public void setExtraSeat(Integer extraSeat) {
        this.extraSeat = extraSeat;
    }

    public Integer getHardBedFirstFloor() {
        return hardBedFirstFloor;
    }

    public void setHardBedFirstFloor(Integer hardBedFirstFloor) {
        this.hardBedFirstFloor = hardBedFirstFloor;
    }

    public Integer getHardBedSecondFloor() {
        return hardBedSecondFloor;
    }

    public void setHardBedSecondFloor(Integer hardBedSecondFloor) {
        this.hardBedSecondFloor = hardBedSecondFloor;
    }

    public Integer getHardBedThirdFloor() {
        return hardBedThirdFloor;
    }

    public void setHardBedThirdFloor(Integer hardBedThirdFloor) {
        this.hardBedThirdFloor = hardBedThirdFloor;
    }

    public Integer getSoftBedFirstFloor() {
        return softBedFirstFloor;
    }

    public void setSoftBedFirstFloor(Integer softBedFirstFloor) {
        this.softBedFirstFloor = softBedFirstFloor;
    }

    public Integer getSoftBedSecondFloor() {
        return softBedSecondFloor;
    }

    public void setSoftBedSecondFloor(Integer softBedSecondFloor) {
        this.softBedSecondFloor = softBedSecondFloor;
    }
}

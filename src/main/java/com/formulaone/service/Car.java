package com.formulaone.service;

/**
 * Created by vjose on 21/05/16.
 */
public class Car {
    private Double topSpeed;
    private Double handlingFactor = 0.8;
    private Double acceleration;
    private Double startingSpeed = 0.0;

    public Car(Integer teamId) {
        setTopSpeed(teamId);
        setAcceleration(teamId);
    }

    private void setAcceleration(Integer teamId){
        this.acceleration = 2.0*teamId;
    }

    public Double getStartingSpeed() {
        return startingSpeed;
    }

    public Double getAcceleration() {
        return acceleration;
    }

    public Double getHandlingFactor() {
        return handlingFactor;
    }

    public Double applyNitro(Double currentSpeed){
        return null;
    }

    private void setTopSpeed(Integer teamId){
        this.topSpeed = ((150.0 +(10*teamId))*5)/18;
    }

    public Double getTopSpeed() {
        return this.topSpeed;
    }
}

package com.formulaone.service;

/**
 * Created by vjose on 21/05/16.
 */
public class Team {
    private Integer id;
    private Double distanceToCover;
    private Car car;

    public Integer getId() {
        return id;
    }

    public Double getDistanceToCover() {
        return distanceToCover;
    }

    public Car getCar() {
        return car;
    }

    public Team(Integer id, Double totalDistance) {
        this.id = id;
        findDistanceToCover (totalDistance);
        this.car = new Car(id);
    }

    private void findDistanceToCover(Double totalDistance){
        Integer extra = 0;
        for(int i=1;i<id;i++)
            extra = extra + 200*i;
        this.distanceToCover = totalDistance*1000 + extra;

    }
}

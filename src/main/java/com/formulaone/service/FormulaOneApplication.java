package com.formulaone.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.naming.NamingException;
import java.util.Map;

/**
 * Created by vjose on 21/05/16.
 */
@SpringBootApplication
public class FormulaOneApplication {
    private Race race;

    void racing(Integer totalTeams,Double totalDistance){

        setupReace( totalTeams, totalDistance);


        runRace(race.getTeams(),totalTeams,totalDistance);

    }

    void setupReace(Integer totalTeams,Double totalDistance){

        race = new Race(totalDistance,totalTeams);
    }

    void startRace(Team team){
        Double distanceToCover = team.getDistanceToCover();

        Double timeTaken;
        Double acceleration = team.getCar().getAcceleration();
        Double maxSpeed = team.getCar().getTopSpeed();
        Integer teamId = team.getId();
        System.out.println("distanceToCover  for Team"+teamId+" is "+distanceToCover/1000 +" km");
        Double timeTakenToReachMaxSpeed = maxSpeed/acceleration;
        System.out.println("timeTakenToReachMaxSpeed"+teamId+" is "+timeTakenToReachMaxSpeed +" secs");
        Double distanceCoveredToReachMaxSpeed = (acceleration*timeTakenToReachMaxSpeed*(timeTakenToReachMaxSpeed+1))/2;
        System.out.println("distanceCoveredToReachMaxSpeed"+teamId+" is "+distanceCoveredToReachMaxSpeed/1000 +" km");
        Double remainingDistance = distanceToCover - distanceCoveredToReachMaxSpeed;
        Double remainingTimeTaken = remainingDistance/maxSpeed;
        timeTaken = remainingTimeTaken + timeTakenToReachMaxSpeed;
        System.out.println("Time taken for Team"+teamId+" is "+timeTaken/60 +" mins");

        Double distanceCovered = 0.0;

        for (int t = 2; distanceCovered < distanceToCover; t=t+2) {
            distanceCovered = (acceleration*t*(t+1))/2;
            System.out.println("distanceCovered by Team"+teamId+" in "+t+" secs is "+distanceCovered/1000 +" km");
        }

    }

    void runRace( Map<Integer,Team> teams,Integer totalTeams,Double totalDistance){


        Double distanceCovered = 0.0;
        for (int t = 2; distanceCovered < totalDistance*1000; t=t+2) {
            for (int j = 1; j < totalTeams+1; j++) {
                Team team = teams.get(j);
                distanceCovered = (team.getCar().getAcceleration() * t * (t + 1)) / 2;
                System.out.println("distanceCovered by Team" + j + " in " + t + " secs is " + distanceCovered  + " meters");
            }
        }

    }
    public static void main(String[] args) throws NamingException {

        SpringApplication.run(FormulaOneApplication.class, args);
        FormulaOneApplication app = new FormulaOneApplication();
        app.racing(5,100.0);

    }

}

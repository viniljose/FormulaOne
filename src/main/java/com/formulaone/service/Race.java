package com.formulaone.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vjose on 21/05/16.
 */
public class Race {

    private Double totalDistance;
    private Map<Integer,Team> teams;
    private Integer totalTeams;

    public Integer getTotalTeams() {
        return totalTeams;
    }

    public void setTotalTeams(Integer totalTeams) {
        this.totalTeams = totalTeams;
    }

    public Map<Integer,Team> getTeams() {
        return teams;
    }

    public Race(Double totalDistance, Integer totalTeams) {
        this.totalDistance = totalDistance;
        this.totalTeams = totalTeams;
        loadTeams(totalDistance,totalTeams);
    }

    private void loadTeams(Double totalDistance, Integer totalTeams){
        teams = new HashMap<Integer, Team>();
        for(int i=0;i<totalTeams;i++){
            teams.put(i+1,new Team(i+1,totalDistance));

        }
    }


}

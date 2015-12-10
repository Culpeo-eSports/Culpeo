package com.culpeo.android.models;

import java.util.Date;

/**
 * Created by Ross on 12/10/2015.
 */
public class Match {

    private String team1;
    private String team2;
    private int team1Icon;
    private int team2Icon;
    private Date time;

    public Match(String team1,String team2, int team1Icon, int team2Icon, Date time) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1Icon = team1Icon;
        team2Icon = team2Icon;
        this.time = time;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public int getTeam1Icon() {
        return team1Icon;
    }

    public int getTeam2Icon() {
        return team2Icon;
    }

    public Date getTime() {
        return time;
    }
}

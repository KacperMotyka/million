package com.company;

import com.company.Ball;

import java.util.ArrayList;
import java.util.Date;

public class Game {
    private Date launchDate;
    private int totalNumberOfBalls;
    private int numberOfSelectedBalls;
    private ArrayList<Draw> history;
    private ArrayList<Ball> ballStatistics;

    public Game(Date launchDate, int totalNumberOfBalls, int numberOfSelectedBalls, ArrayList<Draw> history) {
        this.launchDate = launchDate;
        this.totalNumberOfBalls = totalNumberOfBalls;
        this.numberOfSelectedBalls = numberOfSelectedBalls;
        this.history = history;
        this.ballStatistics = new ArrayList<Ball>(this.totalNumberOfBalls);
    }

    // GETTERS
    public Date getLaunchDate() {
        return launchDate;
    }
    public int getTotalNumberOfBalls() {
        return totalNumberOfBalls;
    }
    public int getNumberOfSelectedBalls() {
        return numberOfSelectedBalls;
    }
    public ArrayList<Draw> getHistory() {
        return history;
    }
    public ArrayList<Ball> getBallStatistics() { return ballStatistics; }

    // SETTERS
    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }
    public void setTotalNumberOfBalls(int totalNumberOfBalls) {
        this.totalNumberOfBalls = totalNumberOfBalls;
    }
    public void setNumberOfSelectedBalls(int numberOfSelectedBalls) { this.numberOfSelectedBalls = numberOfSelectedBalls; }
    public void setHistory(ArrayList<Draw> history) {
        this.history = history;
    }

}

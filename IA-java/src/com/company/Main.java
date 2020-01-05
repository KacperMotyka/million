package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {


    String filename = "lotto_values_l.json";
    DataReader reader = new DataReader(filename);
    ArrayList<Draw> history = reader.readJsonData();
    Game lotto = new Game ("lotto", "1957-03-07", 49, 6, history);
        
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Based on the historical data program will determine:
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Entire History Winning Frequency for a number
    public static double EHWinningFrequency (Game game, String number){
        int index = Integer.parseInt(number) - 1;
        return game.getBallStatistics().get(index).getTotalNumberOfWinning();
    }
    //  Entire History Winning Percent for a number = Number of draws in which the number won /  Number of all draws
    public static double EHWinningPercent (Game game, String number){
        int index = Integer.parseInt(number) - 1;
        return game.getBallStatistics().get(index).getTotalPercentOfWinning();
    }

    // Winning Frequency for the last 5, 10 and 15 draws for a number
    public static int[] WinningFrequencyForLastDraws(Game game, String number) {
        int index = Integer.parseInt(number) - 1;
        Ball ball =  game.getBallStatistics().get(index);
        int[] result = new int[3];
        result[0] = ball.getLast5drawsWinning();
        result[0] = ball.getLast10drawsWinning();
        result[0] = ball.getLast15drawsWinning();
        return result;
    }
    // Winning Percent for the last 5, 10 and 15 draws for a number
    public static int[] WinningPercentForLastDraws(Game game, String number) {
        int index = Integer.parseInt(number) - 1;
        Ball ball =  game.getBallStatistics().get(index);
        int[] result = new int[3];
        result[0] = ball.getLast5drawsWinning()/5;
        result[0] = ball.getLast10drawsWinning()/10;
        result[0] = ball.getLast15drawsWinning()/15;
        return result;
    }

    // Entire History Winning Frequency for each number
    public static int[] EHWinningFrequency (Game game){
        int n = game.getTotalNumberOfBalls();
        int[] array = new int[n+1];
        for (int index = 1; index <= n; index++){
            array[index] = game.getBallStatistics().get(index).getTotalNumberOfWinning();
        }
        return array;
    }
    //  Entire History Winning Percent for each number = Number of draws in which the number won /  Number of all draws
    public static double[] EHWinningPercent (Game game){
        int n = game.getTotalNumberOfBalls();
        double[] array = new double[n+1];
        for (int i = 1; i <= n; i++){
            array[i] = game.getBallStatistics().get(i).getTotalPercentOfWinning();
        }
        return array;
    }
    // 20 most frequently winning numbers in the entire history
    public static ArrayList<Ball> twentyMostFrequentlyWinning(Game game) {
        ArrayList<Ball> array = game.getBallStatistics();
        array.sort(game.comparatorByPercentWinningDescending);
        return (ArrayList<Ball>) array.subList(0, 20);
    }

    // 20 least frequently winning numbers in the entire history
    public static ArrayList<Ball>  twentyLeastFrequentlyWinning(Game game) {
        ArrayList<Ball> array = game.getBallStatistics();
        array.sort(game.comparatorByPercentWinningAscending);
        return (ArrayList<Ball>) array.subList(0, 20);
    }



}

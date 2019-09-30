package org.fasttrackit;

import javax.swing.plaf.basic.BasicSliderUI;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

    private Vehicle competitor1;
    private Vehicle competitor2;
    private Track[] tracks = new Track[3];
    private List<Vehicle> competitors = new ArrayList<>();

    public void start() throws Exception {
        initializeTracks();
        displayTracks();

        Track selectedTrak = getSelectedTrackFromUser();

        initializeCompetitors();
        boolean winnerNotKnown = true;
        int competitorsWithoutFuel = 0;

        while( winnerNotKnown && competitorsWithoutFuel < competitors.size()) {

            // for-each or enhanced for loop
            for (Vehicle vehicle : competitors) {
                double speed = getAccelerateSpeedFromUser();
                vehicle.accelerate(speed, 1);

                if (selectedTrak.getLenght() <= vehicle.getTraveledDistance()){
                    winnerNotKnown = false;
                    System.out.println("The winner is " + vehicle.getName());
                    break;
                }
                if (vehicle.getFuelLevel() <= 0) {
                    competitorsWithoutFuel++;
                }
            }
        }
    }
    private double getAccelerateSpeedFromUser(){
        System.out.println("Please enter acceleration speed");
        Scanner scanner = new Scanner(System.in);
        try{
        return scanner.nextDouble();
    }catch (InputMismatchException e){
            System.out.println("you have entered an invalid number.");
       return getAccelerateSpeedFromUser();}
    }

    private Track getSelectedTrackFromUser() {
        System.out.println("Please select a track.");
        Scanner scanner = new Scanner(System.in);

        try {
            int userChoice = scanner.nextInt();
            return tracks[userChoice - 1];
        } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
            System.out.println("You have entered an invalid number.");
            //recursion - a method calling itself1
            return getSelectedTrackFromUser();
        }
    }

    private void initializeCompetitors() throws Exception {
        int competitorCount = getCompetitorCountFromUser();

        System.out.println("Today competitors are: ");
        for (int i = 0; i < competitorCount; i++) {
            Vehicle competitor = new Vehicle();
            competitor.setName("Competitor: " + i);
            competitor.setMaxSpeed(300);
            competitor.setMileage(ThreadLocalRandom.current().nextDouble(6, 12));
            competitor.setFuelLevel(80);
            System.out.println(competitor);

            competitors.add(competitor);
        }
    }

    private int getCompetitorCountFromUser() throws Exception {
        System.out.println("Please enter number of players.");
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new Exception(" You have enter an invalid number.");
        } finally {
            System.out.println("Finally block is always executed.");
        }
    }

    private void initializeTracks() {
        Track track1 = new Track();
        track1.setName("Monte Carlo");
        track1.setLenght(300);

        tracks[0] = track1;

        Track track2 = new Track();
        track2.setName("Monza");
        track2.setLenght(400);

        tracks[1] = track2;
    }

    private void displayTracks() {
        System.out.println("Available tracks: ");

        for (int i = 0; i < tracks.length; i++) {
            if (tracks[i] != null) {
                System.out.println(tracks[i].getName() + " - Length: " + tracks[i].getLenght() + " km.");

            }
        }
    }
}

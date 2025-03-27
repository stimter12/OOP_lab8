package main.logic;

import java.io.Serializable;

public class Train implements Serializable {
    private int id;
    private String pointOfDestination;
    private long trainNumber;
    private String departureTime;
    private int numberOfSeats;
    private String travelTime;
    private int numberOfIntermediateStops;
    public Train(int id, String pointOfDestination, long trainNumber,
                 String departureTime, int numberOfSeats, String travelTime, int numberOfIntermediateStops){
        this.id=id;
        this.pointOfDestination=pointOfDestination;
        this.trainNumber=trainNumber;
        this.departureTime=departureTime;
        this.numberOfSeats=numberOfSeats;
        this.travelTime=travelTime;
        this.numberOfIntermediateStops=numberOfIntermediateStops;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPointOfDestination() {
        return pointOfDestination;
    }

    public void setPointOfDestination(String pointOfDestination) {
        this.pointOfDestination = pointOfDestination;
    }

    public long getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(long trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getTravelTime() {return travelTime;}

    public void setTravelTime(String travelTime) {this.travelTime = travelTime;}

    public int getNumberOfIntermediateStops() {
        return numberOfIntermediateStops;
    }

    public void setNumberOfIntermediateStops(int numberOfIntermediateStops) {
        this.numberOfIntermediateStops = numberOfIntermediateStops;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", pointOfDestination='" + pointOfDestination + '\'' +
                ", trainNumber=" + trainNumber +
                ", departureTime='" + departureTime + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", travelTime='" + travelTime + '\'' +
                ", numberOfIntermediateStops=" + numberOfIntermediateStops +
                '}';
    }

    public String ShowToString() {
        return id + " ".repeat(4 - Integer.toString(id).length()) +
                pointOfDestination + " ".repeat(22 - pointOfDestination.length()) +
                trainNumber + " ".repeat(14 - Integer.toString((int) trainNumber).length()) +
                departureTime+" ".repeat(16-departureTime.length()) +
                numberOfSeats+" ".repeat(17-Integer.toString(numberOfSeats).length())+
                travelTime+" ".repeat(13-travelTime.length()) +
                numberOfIntermediateStops+
                " ".repeat(29 - Integer.toString(numberOfIntermediateStops).length())+"\n";
    }

    public String toStringFile() {
        return  id +
                "," + pointOfDestination +
                "," + trainNumber +
                "," + departureTime +
                "," + numberOfSeats +
                "," + travelTime+
                "," + numberOfIntermediateStops;
    }
}

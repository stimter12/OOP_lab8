package main.servise;

import main.logic.Train;

import java.util.*;
import java.util.stream.Collectors;

public class TrainServise {
    public List<Train> findTrainByPointOfDestination(List<Train> trains,String pointOfDestination){
        return trains.stream().filter(train -> train.getPointOfDestination().equals(pointOfDestination)).collect(Collectors.toList());
    }
    public List<Train> findTrainByDepartureTime(List<Train> trains,String departureTime){
        return trains.stream().filter(train -> compareDepartureTime(train, departureTime)).collect(Collectors.toList());
    }
    private boolean compareDepartureTime(Train train,String departureTime){
        double trainDepartureTime;
        if(train.getDepartureTime().length()==5){
            trainDepartureTime=Double.parseDouble(train.getDepartureTime().substring(0,2))+
                    (double) Integer.parseInt(train.getDepartureTime().substring(3, 5)) /60;
        }else {
            trainDepartureTime=Double.parseDouble(train.getDepartureTime().substring(0,1))+
                    (double) Integer.parseInt(train.getDepartureTime().substring(2, 4)) /60;
        }
        double userDepartureTime;
        if(departureTime.length()==5){
            userDepartureTime=Double.parseDouble(departureTime.substring(0,2))+
                    (double) Integer.parseInt(departureTime.substring(3, 5)) /60;
        }else {
            userDepartureTime=Double.parseDouble(departureTime.substring(0,1))+
                    (double) Integer.parseInt(departureTime.substring(2, 4)) /60;
        }
        return trainDepartureTime>userDepartureTime;
    }
    public List<Train> findTrainByPointOfDestinationAndNumberOfSeats
            (List<Train> trains,String pointOfDestination,int n){
        return trains.stream().filter(train -> train.getPointOfDestination().equals(pointOfDestination)
                && train.getNumberOfSeats() >= n).collect(Collectors.toList());
    }

    public List<Train> sortTrainsByNumberOfIntermediateStopsAndTrainNumber(List<Train> trains) {
        trains.sort(Comparator.comparing(Train::getNumberOfIntermediateStops)
                .thenComparing(Train::getTrainNumber));
        return trains;
    }

    public Train findTrainByTrainNumberAndNumberOfIntermediateStops(List<Train> trains, int id, int numberOfIntermediateStops) {
        return trains.stream().filter(train -> train.getId() == id).filter(train -> train.getNumberOfIntermediateStops() == numberOfIntermediateStops).findFirst().orElse(null);
    }
    public Map<String, List<Train>>
    createMapWithKeyPointOfDestinationAndValueListOfTrainsSortedByTrainNumber(List<Train> trains) {
        Map<String, List<Train>> map = new HashMap<>();
        trains.forEach(train -> {
            String pointOfDestination = train.getPointOfDestination();
            if (!map.containsKey(pointOfDestination)) {
                map.put(pointOfDestination, new ArrayList<>());
            }
            List<Train> list = map.get(pointOfDestination);
            list.add(train);
            list.sort(Comparator.comparing(Train::getTrainNumber));
            map.replace(pointOfDestination, list);
        });
        return map;
    }
    public List<Train>
    findTrainsWithLessNumberOfIntermediateStopsByPointOfDestination(List<Train> trains) {
        List<Train> resultTrains;
        Map<String, List<Train>> map =
                createMapWithKeyPointOfDestinationAndValueListOfTrainsSortedByTrainNumber(trains);
        map.forEach((key, value) -> value.sort(Comparator.comparing(Train::getNumberOfIntermediateStops)));
        resultTrains = map.values().stream().map(List::getFirst).collect(Collectors.toList());
        return resultTrains;
    }

    public List<Train> findTrainsById(List<Train> trains, int id){
        return trains.stream().filter(train -> train.getId() == id).collect(Collectors.toList());
    }

    public List<Train> findTrainsByPointOfDestination
            (List<Train> trains, String PointOfDestination) {
        return trains.stream().filter(train -> train.getPointOfDestination().equals(PointOfDestination)).collect(Collectors.toList());
    }
    public  List<Train> findTrainsByTrainNumber(List<Train> trains, long trainNumber){
        return trains.stream().filter(train -> train.getTrainNumber() == trainNumber).collect(Collectors.toList());
    }
    public  List<Train> findTrainsByDepartureTime(List<Train> trains,String departureTime){
        return trains.stream().filter(train -> train.getDepartureTime().equals(departureTime)).collect(Collectors.toList());
    }
    public List<Train> findTrainsByNumberOfSeats(List<Train> trains, int numberOfSeats){
        return trains.stream().filter(train -> train.getNumberOfSeats() == numberOfSeats).collect(Collectors.toList());
    }
    public List<Train> findTrainsByTrainsTravelTime(List<Train> trains,String trainsTravelTime){
        return trains.stream().filter(train -> train.getTravelTime().equals(trainsTravelTime)).collect(Collectors.toList());
    }
    public List<Train> findTrainsByNumberOfIntermediateStops
            (List<Train> trains, int numberOfIntermediateStops) {
        return trains.stream().filter(train -> train.getNumberOfIntermediateStops() == numberOfIntermediateStops).collect(Collectors.toList());
    }

    public String showTrains(List<Train>  trains) {
        return trains.stream().map(Train::ShowToString).collect(Collectors.joining());
    }

    public String showTrainsFields() {
        return "id  point of destination  train number  departure time" +
                "  number of seats  travel time  number of intermediate stops";
    }

    public boolean deleteTrainById(List<Train> trains, int id) {
        return trains.removeIf(train -> train.getId() == id);
    }
}

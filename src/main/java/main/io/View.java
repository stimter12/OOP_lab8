package main.io;

import main.TrainRepositoryBinaryImpl;
import main.TrainRepositoryTextImpl;
import main.logic.Train;
import main.servise.TrainServise;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class View {
    private final TrainServise trainService =  new TrainServise();
    public void menu(List<Train> trains){
        int option=1;
        Scanner read=new Scanner(System.in);
        TrainRepositoryBinaryImpl trainRepositoryBinaryImpl=new TrainRepositoryBinaryImpl();
        TrainRepositoryTextImpl trainRepositoryTextImpl=new TrainRepositoryTextImpl();
        int id;
        String pointOfDestination;
        long trainNumber;
        String departureTime;
        int numberOfSeats;
        String travelTime;
        int numberOfIntermediateStops;
        while (option != 0) {
            System.out.println(
                    """
                            1. Find trains by point of destination
                            2. Find trains by departure time
                            3. Find trains by point of destination and number of seats
                            4. Sort trains by number of intermediate stops and when matched by train number
                            5. Find train by id and write intermediate stops
                            6. For each point of destination sort trains by train number
                            7. For each point of destination train with less number of intermediate stops
                            8. Show trains
                            9. Add train
                            10.Find trains by
                            11.Delete train by id
                            12. Read file text
                            13. Read file binary
                            14. Write in file text
                            15. Write in file binary
                            0. Exit"""
            );
            option=Integer.parseInt(read.nextLine());
            switch (option) {
                case 1:
                    System.out.println("Enter point of destination:");
                    pointOfDestination=read.nextLine();
                    List<Train> task1 = trainService.findTrainByPointOfDestination(trains, pointOfDestination);
                    System.out.println(trainService.showTrainsFields());
                    System.out.println(trainService.showTrains(task1));
                    break;
                case 2:
                    System.out.println("Enter departure time:");
                    departureTime=read.nextLine();
                    List<Train> task2 = trainService.findTrainByDepartureTime(trains, departureTime);
                    System.out.println(trainService.showTrainsFields());
                    System.out.println(trainService.showTrains(task2));
                    break;
                case 3:
                    System.out.println("Enter point of destination:");
                    String pointOfDestination1=read.nextLine();
                    System.out.println("Enter number of seats:");
                    int nos=Integer.parseInt(read.nextLine());
                    List<Train> task3 = trainService.findTrainByPointOfDestinationAndNumberOfSeats(trains, pointOfDestination1, nos);System.out.println(trainService.showTrainsFields());
                    System.out.println(trainService.showTrains(task3));
                    break;
                case 4:
                    List<Train> task4 = trainService.sortTrainsByNumberOfIntermediateStopsAndTrainNumber(trains);
                    System.out.println(trainService.showTrainsFields());
                    System.out.println(trainService.showTrains(task4));
                    break;
                case 5:
                    System.out.println("Enter id:");
                    id=Integer.parseInt(read.nextLine());
                    System.out.println("Enter number of intermediate stops:");
                    numberOfIntermediateStops=Integer.parseInt(read.nextLine());
                    Train task5 = trainService
                            .findTrainByTrainNumberAndNumberOfIntermediateStops(trains,id,numberOfIntermediateStops);
                        if(task5!=null) {
                            System.out.println(trainService.showTrainsFields());
                            task5.ShowToString();
                        }
                        else System.out.println("Train not found");
                    break;
                case 6:
                    Map<String, List<Train>> trainsMap = trainService.createMapWithKeyPointOfDestinationAndValueListOfTrainsSortedByTrainNumber(trains);
                    trainsMap.forEach((key, value) -> {
                        System.out.println(trainService.showTrainsFields());
                        System.out.println(trainService.showTrains(value));
                        System.out.println();
                    });
                    break;
                case 7:
                    List<Train> result = trainService.findTrainsWithLessNumberOfIntermediateStopsByPointOfDestination(trains);
                    System.out.println(trainService.showTrainsFields());
                    result.stream().map(Train::ShowToString).forEach(System.out::print);
                    break;
                case 8:
                    System.out.println(trainService.showTrainsFields());
                    System.out.println(trainService.showTrains(trains));
                    break;
                case 9:
                    System.out.println("Enter id:");
                    id=Integer.parseInt(read.nextLine());
                    System.out.println("Enter point of destination:");
                    pointOfDestination=read.nextLine();
                    System.out.println("Enter train number:");
                    trainNumber= Integer.parseInt((read.nextLine()));
                    System.out.println("Enter departure time:");
                    departureTime=read.nextLine();
                    System.out.println("Enter number of seats:");
                    numberOfSeats=Integer.parseInt(read.nextLine());
                    System.out.println("Enter travel time:");
                    travelTime=read.nextLine();
                    System.out.println("Enter number of intermediate stops:");
                    numberOfIntermediateStops=Integer.parseInt(read.nextLine());
                    trains.add(new Train(id,pointOfDestination,trainNumber,departureTime,
                            numberOfSeats,travelTime,numberOfIntermediateStops));
                    System.out.println("Train added successfully");
                    break;
                case 10:
                    System.out.println("""
                            1.Find trains by id
                            2.Find trains by point of destination
                            3.Find trains by train number
                            4.Find trains by departure time
                            5.Find trains by number of seats
                            6.Find trains by travel time
                            7.Find trains by number of intermediate stops
                            """);
                    option=Integer.parseInt(read.nextLine());
                    List<Train> list;
                    switch (option) {
                        case 1:
                            System.out.println("Enter id:");
                            id=Integer.parseInt(read.nextLine());
                            list=trainService.findTrainsById(trains,id);
                            System.out.println(trainService.showTrainsFields());
                            System.out.println(trainService.showTrains(list));
                            break;
                        case 2:
                            System.out.println("Enter point of destination:");
                            pointOfDestination=read.nextLine();
                            list=trainService.findTrainsByPointOfDestination(trains, pointOfDestination);
                            System.out.println(trainService.showTrainsFields());
                            System.out.println(trainService.showTrains(list));
                            break;
                        case 3:
                            System.out.println("Enter train number:");
                            trainNumber= Long.parseLong((read.nextLine()));
                            list=trainService.findTrainsByTrainNumber(trains,trainNumber);
                            System.out.println(trainService.showTrainsFields());
                            System.out.println(trainService.showTrains(list));
                            break;
                        case 4:
                            System.out.println("Enter departure time:");
                            departureTime=read.nextLine();
                            list=trainService.findTrainsByDepartureTime(trains, departureTime);
                            System.out.println(trainService.showTrainsFields());
                            System.out.println(trainService.showTrains(list));
                            break;
                        case 5:
                            System.out.println("Enter number of seats:");
                            numberOfSeats=Integer.parseInt(read.nextLine());
                            list=trainService.findTrainsByNumberOfSeats(trains, numberOfSeats);
                            System.out.println(trainService.showTrainsFields());
                            System.out.println(trainService.showTrains(list));
                            break;
                        case 6:
                            System.out.println("Enter travel time:");
                            travelTime=read.nextLine();
                            list=trainService.findTrainsByTrainsTravelTime(trains, travelTime);
                            System.out.println(trainService.showTrainsFields());
                            System.out.println(trainService.showTrains(list));
                            break;
                        case 7:
                            System.out.println("Enter number of intermediate stops:");
                            numberOfIntermediateStops=Integer.parseInt(read.nextLine());
                            list=trainService.findTrainsByNumberOfIntermediateStops(trains, numberOfIntermediateStops);
                            System.out.println(trainService.showTrainsFields());
                            System.out.println(trainService.showTrains(list));
                            break;
                    }
                    break;
                case 11:
                    System.out.println("Enter id:");
                    id=Integer.parseInt(read.nextLine());
                    if(trainService.deleteTrainById(trains,id))System.out.println("Train delete successfully");
                    else System.out.println("Train not found");
                    break;
                case 12:
                    System.out.println("Enter filename to read:");
                    String readFileText=read.nextLine()+".txt";
                    List<Train> trains1Text = trainRepositoryTextImpl.readArray(readFileText);
                    trains.addAll(trains1Text);
                    break;
                case 13:
                    System.out.println("Enter filename to read:");
                    String readFile=read.nextLine()+".txt";
                    List<Train> trains1Binary = trainRepositoryBinaryImpl.readArray(readFile);
                    trains.addAll(trains1Binary);
                    break;
                case 14:
                    System.out.println("Enter filename to write:");
                    String writeFileText=read.nextLine()+".txt";
                    trainRepositoryTextImpl.outputArray(trains, writeFileText);
                    break;
                case 15:
                    System.out.println("Enter filename to write:");
                    String writeFileBinary=read.nextLine()+".txt";
                    trainRepositoryBinaryImpl.outputArray(trains, writeFileBinary);
                    break;
            }
        }
    }
}
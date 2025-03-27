package main.factory;

import main.logic.Train;

import java.util.ArrayList;
import java.util.List;

public class TrainFactory {
    public static Train createTrain(int id, String pointOfDestination, long trainNumber,
                                    String departureTime, int numberOfSeats,
                                    String travelTime, int numberOfIntermediateStops){
        return new Train(id,pointOfDestination,trainNumber,departureTime,numberOfSeats,
                travelTime, numberOfIntermediateStops);
    }
    public static List<Train> createTrains(){
         List<Train> trains = new ArrayList<>();
         trains.add(new Train(1,"Kuiv",4301,
                 "10:00",400,"2:00",2));
        trains.add(new Train(2,"Kherson",4625,
                        "1:30",500,"1:30",6));

        trains.add(new Train(3,"Mykolaiv",4260,
                        "18:30",350,"1:40",3));

        trains.add(new Train(4,"Mykolaiv",5032,
                        "23:00",800,"0:50",1));

        trains.add(new Train(5,"Kherson",4188,
                        "11:30",300,"2:25",4 ));

        trains.add(new Train(6,"Lviv",4368,
                        "14:20",400,"7:40",8));

        trains.add(new Train(7,"Kharkiv",5143,
                        "4:30",950,"5:10",4));

        trains.add(new Train(8,"Mykolaiv",5042,
                        "21:15",800,"0:50",2));

        trains.add(new Train(9,"Kherson",4788,
                        "13:20",600,"2:40",3));

        trains.add(new Train(10,"Lviv",4374,
                        "15:20",400,"5:20",11));

        trains.add(new Train(11,"Kharkiv",5443,
                        "7:30",1100,"6:30",5));
        return  trains;
    }
}

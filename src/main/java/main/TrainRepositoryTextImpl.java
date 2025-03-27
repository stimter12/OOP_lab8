package main;

import main.factory.TrainFactory;
import main.logic.Train;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TrainRepositoryTextImpl implements TrainRepository {
    @Override
    public void outputArray(List<Train> t, File file) {
        try(PrintWriter outputStream = new PrintWriter(file)) {
            t.stream().map(Train::toStringFile).forEach(outputStream::println);
        } catch (IOException e) {
            System.err.println("File not found");
        }
    }

    @Override
    public void outputArray(List<Train> t, String fileName) {
        File file = new File(fileName);
        outputArray(t, file);
    }

    @Override
    public List<Train> readArray(File file) {
        try (BufferedReader inputStream = new BufferedReader(new FileReader(file))) {
            List<Train> trains = new ArrayList<>();
            //replace with stream
            while (inputStream.ready()) {
                String stringTrain = inputStream.readLine();
                String[] stringTrainArray = stringTrain.split(",");
                trains.add(TrainFactory.createTrain(
                        Integer.parseInt(stringTrainArray[0]), stringTrainArray[1],
                        Integer.parseInt(stringTrainArray[2]), stringTrainArray[3],
                        Integer.parseInt(stringTrainArray[4]),stringTrainArray[5],
                        Integer.parseInt(stringTrainArray[6])));
            }
            return trains;
        } catch (IOException e) {
            System.err.println("File not found");
        }
        return null;
    }


    @Override
    public List<Train> readArray(String fileName) {
        File file = new File(fileName);
        return readArray(file);
    }
}

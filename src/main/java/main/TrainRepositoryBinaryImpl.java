package main;

import main.logic.Train;

import java.io.*;
import java.util.List;

public class TrainRepositoryBinaryImpl implements TrainRepository {
    @Override
    public void outputArray(List<Train> t, File file) {
        try(FileOutputStream outputFile = new FileOutputStream(file);
            ObjectOutputStream outputStream = new ObjectOutputStream(outputFile)) {
                outputStream.writeObject(t);
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
        try {
            FileInputStream inputFile = new FileInputStream(file);
            ObjectInputStream inputStream = new ObjectInputStream(inputFile);
            Object trains = inputStream.readObject();
            return (List<Train>) trains;
        } catch (IOException | ClassNotFoundException e) {
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
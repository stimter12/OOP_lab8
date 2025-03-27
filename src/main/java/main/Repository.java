package main;

import main.logic.Train;

import java.io.File;
import java.util.List;

public interface Repository<T> {
    void outputArray(List<T> t, File file);
    void outputArray(List<T> t, String fileName);
    List<Train> readArray(File file);
    List<Train> readArray(String fileName);
}

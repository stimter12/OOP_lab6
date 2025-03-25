package main;

import main.logic.Train;

import java.io.File;
import java.util.ArrayList;

public interface Repository<T> {
    void outputArray(ArrayList<T> t, File file);
    void outputArray(ArrayList<T> t, String fileName);
    ArrayList<Train> readArray(File file);
    ArrayList<Train> readArray(String fileName);
}

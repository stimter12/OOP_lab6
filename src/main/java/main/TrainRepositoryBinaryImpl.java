package main;

import main.logic.Train;

import java.io.*;
import java.util.ArrayList;

public class TrainRepositoryBinaryImpl implements TrainRepository {
    @Override
    public void outputArray(ArrayList<Train> t, File file) {
        try(FileOutputStream outputFile = new FileOutputStream(file);
            ObjectOutputStream outputStream = new ObjectOutputStream(outputFile)) {
                outputStream.writeObject(t);
        } catch (IOException e) {
            System.err.println("File not found");
        }
    }

    @Override
    public void outputArray(ArrayList<Train> t, String fileName) {
        File file = new File(fileName);
        outputArray(t, file);
    }

    @Override
    public ArrayList<Train> readArray(File file) {
        try {
            FileInputStream inputFile = new FileInputStream(file);
            ObjectInputStream inputStream = new ObjectInputStream(inputFile);
            Object trains = inputStream.readObject();
            return (ArrayList<Train>) trains;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("File not found");
        }
       return null;
    }

    @Override
    public ArrayList<Train> readArray(String fileName) {
        File file = new File(fileName);
        return readArray(file);
    }
}

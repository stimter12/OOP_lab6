package main.servise;

import main.logic.Train;

import java.util.*;

public class TrainServise {
    public ArrayList<Train> findTrainByPointOfDestination(ArrayList<Train> trains,String pointOfDestination){
        ArrayList<Train> result = new ArrayList<>();
        for (Train train : trains) {
            if (train.getPointOfDestination().equals(pointOfDestination)) {
                result.add(train);
            }
        }
        return result;
    }
    public ArrayList<Train> findTrainByDepartureTime(ArrayList<Train> trains,String departureTime){
        ArrayList<Train> result = new ArrayList<>();
        for (Train train : trains) {
            double temp1;
            if(train.getDepartureTime().length()==5){
                temp1=Double.parseDouble(train.getDepartureTime().substring(0,2))+
                        (double) Integer.parseInt(train.getDepartureTime().substring(3, 5)) /60;
            }else {
                temp1=Double.parseDouble(train.getDepartureTime().substring(0,1))+
                        (double) Integer.parseInt(train.getDepartureTime().substring(2, 4)) /60;
            }
            double temp2;
            if(departureTime.length()==5){
                temp2=Double.parseDouble(departureTime.substring(0,2))+
                        (double) Integer.parseInt(departureTime.substring(3, 5)) /60;
            }else {
                temp2=Double.parseDouble(departureTime.substring(0,1))+
                        (double) Integer.parseInt(departureTime.substring(2, 4)) /60;
            }
            if (temp1>temp2) {
                result.add(train);
            }
        }
        return result;
    }
    public ArrayList<Train> findTrainByPointOfDestinationAndNumberOfSeats
            (ArrayList<Train> trains,String pointOfDestination,int n){
        ArrayList<Train> result = new ArrayList<>();
        for (Train train : trains) {
            if (train.getPointOfDestination().equals(pointOfDestination)
                    && train.getNumberOfSeats()>=n) {
                result.add(train);
            }
        }
        return result;
    }

    public ArrayList<Train> sortTrainsByNumberOfInitialStopsAndTrainNumber(ArrayList<Train> trains) {
        trains.sort(Comparator.comparing(Train::getNumberOfIntermediateStops)
                .thenComparing(Train::getTrainNumber));
        return trains;
    }

    public Train findTrainByTrainNumberAndNumberOfIntermediateStops(ArrayList<Train> trains, long trainNumber, int numberOfIntermediateStops) {
        for (Train train : trains) {
            if (train.getTrainNumber()==trainNumber) {
                if (train.getNumberOfIntermediateStops()==numberOfIntermediateStops) {
                    return train;
                }
            }
        }
        return null;
    }
}

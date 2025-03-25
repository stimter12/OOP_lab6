package main.servise;

import main.logic.Train;

import java.util.*;

public class TrainServise {
    public List<Train> findTrainByPointOfDestination(List<Train> trains,String pointOfDestination){
        List<Train> result = new ArrayList<>();
        for (Train train : trains) {
            if (train.getPointOfDestination().equals(pointOfDestination)) {
                result.add(train);
            }
        }
        return result;
    }
    public List<Train> findTrainByDepartureTime(List<Train> trains,String departureTime){
        List<Train> result = new ArrayList<>();
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
    public List<Train> findTrainByPointOfDestinationAndNumberOfSeats
            (List<Train> trains,String pointOfDestination,int n){
        List<Train> result = new ArrayList<>();
        for (Train train : trains) {
            if (train.getPointOfDestination().equals(pointOfDestination)
                    && train.getNumberOfSeats()>=n) {
                result.add(train);
            }
        }
        return result;
    }

    public List<Train> sortTrainsByNumberOfInitialStopsAndTrainNumber(List<Train> trains) {
        trains.sort(Comparator.comparing(Train::getNumberOfIntermediateStops)
                .thenComparing(Train::getTrainNumber));
        return trains;
    }

    public Train findTrainByTrainNumberAndNumberOfIntermediateStops(List<Train> trains, long trainNumber, int numberOfIntermediateStops) {
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

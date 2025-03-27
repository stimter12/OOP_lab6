package main.io;

import main.TrainRepositoryBinaryImpl;
import main.TrainRepositoryTextImpl;
import main.logic.Train;
import main.servise.TrainServise;

import java.util.*;
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
        String departureTime;
        int numberOfIntermediateStops;
        while (option != 0) {
            System.out.println(
                    """
                            1. Find trains by point of destination
                            2. Find trains by departure time
                            3. Find trains by point of destination and number of seats
                            4. Sort trains by number of intermediate stops and when matched by train number
                            5. Find train by id and  number of intermediate stops
                            6. Read file text
                            7. Read file binary
                            8. Write in file text
                            9. Write in file binary
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
                            .findTrainByIdAndNumberOfIntermediateStops(trains,id,numberOfIntermediateStops);
                    if(task5!=null) {
                        System.out.println(trainService.showTrainsFields());
                        System.out.println(task5.ShowToString());
                    }
                    else System.out.println("Train not found");
                    break;
                case 6:
                    System.out.println("Enter filename to read:");
                    String readFileText=read.nextLine()+".txt";
                    trains = trainRepositoryTextImpl.readArray(readFileText);
                    break;
                case 7:
                    System.out.println("Enter filename to read:");
                    String readFile=read.nextLine()+".txt";
                    trains = trainRepositoryBinaryImpl.readArray(readFile);
                    break;
                case 8:
                    System.out.println("Enter filename to write:");
                    String writeFileText=read.nextLine()+".txt";
                    trainRepositoryTextImpl.outputArray(trains, writeFileText);
                    break;
                case 9:
                    System.out.println("Enter filename to write:");
                    String writeFileBinary=read.nextLine()+".txt";
                    trainRepositoryBinaryImpl.outputArray(trains, writeFileBinary);
                    break;

            }
        }
    }
}
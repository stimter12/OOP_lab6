package main.io;

import main.TrainRepositoryBinaryImpl;
import main.TrainRepositoryTextImpl;
import main.logic.Train;
import main.servise.TrainServise;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    private final TrainServise trainService =  new TrainServise();
    public void menu(ArrayList<Train> trains){
        int option=1;
        Scanner read=new Scanner(System.in);
        TrainRepositoryBinaryImpl trainRepositoryBinaryImpl=new TrainRepositoryBinaryImpl();
        TrainRepositoryTextImpl trainRepositoryTextImpl=new TrainRepositoryTextImpl();
        while (option != 0) {
            System.out.println(
                    """
                            1. Find trains by point of destination
                            2. Find trains by departure time
                            3. Find trains by point of destination and number of seats
                            4. Sort trains by number of initial stops and when matched by train number
                            5. Find train by train number and  number of intermediate stops
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
                    String pod=read.nextLine();
                    ArrayList<Train> task1 = trainService.findTrainByPointOfDestination(trains, pod);
                    for(Train train : task1){
                        System.out.println(train);
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Enter departure time:");
                    String dt=read.nextLine();
                    ArrayList<Train> task2 = trainService.findTrainByDepartureTime(trains, dt);
                    for(Train train : task2){
                        System.out.println(train);
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Enter point of destination:");
                    String pofd=read.nextLine();
                    System.out.println("Enter number of seats:");
                    int nos=Integer.parseInt(read.nextLine());
                    ArrayList<Train> task3 = trainService.findTrainByPointOfDestinationAndNumberOfSeats(trains, pofd, nos);
                    for(Train train : task3){
                        System.out.println(train);
                    }
                    break;
                case 4:
                    ArrayList<Train> task4 = trainService.sortTrainsByNumberOfInitialStopsAndTrainNumber(trains);
                    for(Train train : task4){
                        System.out.println(train);
                    }
                    break;
                case 5:
                    System.out.println("Enter train number:");
                    long trainNumber=Long.parseLong(read.nextLine());
                    System.out.println("Enter number of intermediate stops:");
                    int numberOfIntermediateStops=Integer.parseInt(read.nextLine());
                    Train task5 = trainService
                            .findTrainByTrainNumberAndNumberOfIntermediateStops(trains,trainNumber,numberOfIntermediateStops);
                        if(task5!=null)System.out.println(task5);
                        else System.out.println("Train not found");
                    break;
                case 6:
                    System.out.println("Enter filename to read:");
                    String readFileText=read.nextLine()+".txt";
                    ArrayList<Train> trains1Text = trainRepositoryTextImpl.readArray(readFileText);
                    trains.addAll(trains1Text);
                    break;
                case 7:
                    System.out.println("Enter filename to read:");
                    String readFile=read.nextLine()+".txt";
                    ArrayList<Train> trains1Binary = trainRepositoryBinaryImpl.readArray(readFile);
                    trains.addAll(trains1Binary);
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
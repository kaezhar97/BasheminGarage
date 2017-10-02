
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Octavio
 */
public class BasheminTest
{

    public static void main(String args[]) throws IOException
    {
        String licensePlate = "";
        String action = "";
        Scanner fileIn = new Scanner(new File("garage.txt"));
        PrintWriter fileOut = new PrintWriter("output.txt") ;
        Garage garage = new Garage();
        Car car;
       
        /*
        int i=0;
        int numberOfCars=0;
        int numberOfInstructions=0;
        //Check how may cars and instructions there are in the file
        do
        {
            i++;
            numberOfCars=i/2;
            numberOfInstructions=numberOfCars;
            fileIn.next();
        }while(fileIn.hasNext());
        
        Car[] allCarsInFile= new Car[numberOfCars];
        String[] licensePlates = new String [numberOfCars];
        String[] instructions = new String [numberOfInstructions];
        fileIn = new Scanner(new File("garage.txt"));
        
        int m=0;
        do
        {
            licensePlates[m]=fileIn.next();
            instructions[m]=fileIn.next();
            allCarsInFile[m]=new Car(licensePlates[m]);
            m++;
        }while(fileIn.hasNext());
        
        for (int n=0;n<allCarsInFile.length;n++)
        {
            if (instructions[n].equals("ARRIVE"))
            {
                fileOut.println(garage.arrive(allCarsInFile[n]));
            }
            else
            {
                fileOut.println(garage.depart(allCarsInFile[n]));
            }
        }
        */
        
        
        do
        {
            licensePlate = fileIn.next();
            action = fileIn.next();

            car = new Car(licensePlate);

            if (action.equals("ARRIVE"))
            {
                fileOut.println(garage.arrive(car));
            }
            else
            {
                fileOut.println(garage.depart(car));
            }
        }while (fileIn.hasNext());
        
        fileOut.close();
    }
}

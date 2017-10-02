
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
File: BasheminTest.java
Purpose:
    This class tests the garage operations. 
 */

/**
 *  This test class reads from an input file all of the license plates and operations and outputs the state of each 
 * operation (arriving and departing) to an external output.txt file
 * 
 * @author Octavio
 */
public class BasheminTest
{

    public static void main(String args[]) throws IOException
    {
        String licensePlate = ""; //stores the license plates
        String action = ""; //stores the instructions (arrive or depart)
        Scanner fileIn = new Scanner(new File("garage.txt")); //input file
        PrintWriter fileOut = new PrintWriter("output.txt") ; //output file
        Garage garage = new Garage(); //creates a garage object where all the operations take place
        Car car; // each car that is going to be parked or going to depart the garage

        /*
            A loop that checks each word in the input file and stores it in the proper variable
        */
        do
        {
            licensePlate = fileIn.next();
            action = fileIn.next();

            car = new Car(licensePlate); // creates a new car with the license plate taken from the input file

            /*
                Parks the car in the garage if the instruction is ARRIVE. Otherwise, takes the car out of the garage
            */
            if (action.equals("ARRIVE"))
            {
                fileOut.println(garage.arrive(car));
            }
            else
            {
                fileOut.println(garage.depart(car));
            }
        }while (fileIn.hasNext());
        
        /*
            Closes the file once the program stops using it
        */
        fileOut.close();
    }
}

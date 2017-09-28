
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

        do
        {
            licensePlate = fileIn.next();
            action = fileIn.next();

            Car car = new Car(licensePlate);

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

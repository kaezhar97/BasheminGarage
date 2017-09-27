
import java.io.File;
import java.io.IOException;
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
    public static void main (String args[]) throws IOException
    {
        String licensePlate="";
        String action="";
        Scanner fileIn=new Scanner(new File("garage.txt"));
        Garage garage = new Garage();
        
        do
        {
                licensePlate=fileIn.next();
                action=fileIn.next();
                
                Car car = new Car(licensePlate);
                
                
                if (action.equals("ARRIVE"))
                {
                    garage.arrive(car);
                }
                else
                {
                    garage.depart(car);
                }
            
        }while(fileIn.hasNext());
    }
}

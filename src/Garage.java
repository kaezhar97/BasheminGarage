/*
File: Garage.java
Purpose:
    This class simulates a real-world one lane garage. 
*/

import java.util.Arrays;

/**
 * The Bashemin Parking Garage contains a single lane that can hold up to ten cars.  Arriving cars enter the garage at
 * the rear and are parked in the empty space nearest to the front. Departing cars exit only from the front.  
 * If a customer needs to pick up a car that is not nearest to the exit, then all cars blocking its path are moved out temporarily, 
 * the customer's car is driven out, and the other cars are restored in the order they were in originally.  
 * Whenever a car departs, all cars behind it in the garage are moved up one space.
 * 
 * @author Octavio
 */
public class Garage
{

    private static final int MAX_SPACE = 10; //Maximum number of cars that can be parked in the garage

    private Car[] cars; //The list of cars in the garage
 
    private Car[] carsBeingMoved; //Temporarily stores the cars that need to be moved out of the garage to allow another car to leave

    private int garageCarCount = 0; //Keeps track of the number of cars in the garage at all times

    /**
     * Creates a new garage with MAX_SPACE number of empty spaces inside
     */
    public Garage()
    {
        cars = new Car[MAX_SPACE];

    }
    
    /**
     * Parks a car inside the garage if there are empty spaces available
     * 
     * @param hiCar the car that needs to be parked
     * @return the status of the operation
     */
    public String arrive(Car hiCar)
    {

        int spaceWhereCarWasParked = 0; //Keeps track of the where the arriving car has parked

        /*
            Checks if the garage is full
        */
        if (garageCarCount == MAX_SPACE)
        {

            return "Sorry, the garage is full at this moment. Try again later";
        }
        boolean emptyPositionNotFound = true; 

        /*
            Checks each space individually to find one that is empty and closest to the entrance
        */
        for (int i = 0; i < MAX_SPACE && emptyPositionNotFound; i++)
        {

            if (isEmptyAtPosition(i))
            {

                cars[i] = hiCar; //Stores the arriving car in the empty position
                garageCarCount++; //Increases the number of cars in the garage

                emptyPositionNotFound = false; //Car has been found

                spaceWhereCarWasParked = i; //Tracks where the car was parked

            }
        }

        return hiCar.getLicensePlate() + " has arrived at parking space number " + spaceWhereCarWasParked;
    }

    /**
     * Moves a car out of the garage. If it is right next to the entrance, then it can leave easily. Otherwise, all the other cars in front of it 
     * need to be moved out temporarily to allow it to leave.
     * 
     * @param byeCar the car that is departing
     * @return the status of the operation
     */
    public String depart(Car byeCar)
    {

        boolean carNotFound = true;

        carsBeingMoved = new Car[MAX_SPACE]; //Creates a temporary space for the cars that need to be moved out of the garage to allow another car to leave

        boolean garageIsEmpty = cars[0] == null; //Checks if the garage is empty. The garage should be empty if there are no cars at the very front

        if (garageIsEmpty)
        {

            return "The garage is empty";
        }

        /*
            Looks for the departing car inside the garage by checking each parking space individually
        */
        for (int i = 0; i < MAX_SPACE && carNotFound; i++)
        {

            /*
                Checks if the current car is the car that needs to depart
            */
            if ((cars[i] != null) && (byeCar.getLicensePlate().equals(cars[i].getLicensePlate())))
            {
                byeCar = cars[i]; 
                carNotFound = false;

                /*
                    Checks if the departing car is next to the entrance
                */
                if (i != 0)
                {

                    moveOutAllCarsBeforeIndex(i);
                } 
                /*
                    If the car is right next to the entrance then let it leave and move all other cars up one space so that they are all 
                closer to the entrance
                */
                else
                {

                    for (int l = 0; l < garageCarCount; l++)
                    {

                        cars[l] = cars[l + 1];

                    }

                }

                garageCarCount--; //Reduce the number of cars in the garage

                cleanUpGarbage(); //Make sure the spaces where there are no cars parked are truly empty

                return "The car " + byeCar.getLicensePlate() + " has departed. It was moved "
                        + byeCar.getMoveCount() + " times " + "during its stay. Have a nice day!";
            }
        }

        return "Sorry, that car is not on this garage";
    }

    /**
     * Checks if the current parking space is empty
     * 
     * @param index the parking space that is being checked
     * @return whether or not the parking space is empty as true for empty and false for not empty
     */
    public boolean isEmptyAtPosition(int index)
    {

        /*
            If the position being checked has a value of null then we know it to be empty
        */
        if (cars[index] == null)
        {

            return true;
        } else
        {

            return false;
        }
    }

    /**
     * Moves all cars before a specified parking space number
     * 
     * @param i the parking space number. All cars before it must be moved out temporarily
     */
    public void moveOutAllCarsBeforeIndex(int i)
    {

        /*
            Puts all cars from the garage that are parked before the specified parking space number into a temporary space to allow the departing car
        to leave
        */
        for (int j = 0; j < i; j++)
        {

            carsBeingMoved[j] = cars[j];

            cars[j].increaseMoveCount();

        }

        /*
            All cars after the specified parking space are moved up one space closer to the entrance. That way the parking space
        that was being occupied by the departing car is not being occupied by the car that was before it
        
        */
        for (int k = i; k < garageCarCount; k++)
        {

            
            if (cars.length != (k + 1)) // This condition checks we are not trying to move up a car that is beyond the MAX_SPACE of the garage
            {

                cars[k] = cars[k + 1]; //Each car is moved up once space closer to the entrance
            }

        }

        /*
            Puts the cars that were moved out temporarily back in their parking spots
        */
        for (int m = 0; m < i; m++)
        {

            cars[m] = carsBeingMoved[m];

        }
    }

    /**
     * Cleans up the parking spaces that are not being occupied by any cars by making them empty
     */
    public void cleanUpGarbage()
    {
        
        /*
            All parking spaces starting right after the last car that was parked and ending at the end of the garage are cleaned up
        */
        for (int n = garageCarCount; n < MAX_SPACE; n++)
        {
            cars[n] = null;
        }
    }

    /**
     * Shows a literal representation of the garage. Occupied spaces are illustrated by showing the car's license plate and empty spaces are shown as "null"
     * 
     * @return the current state of the garage
     */
    public String toString()
    {
        String garageString = "[";

        for (int i = 0; i < cars.length; i++)
        {
            if (cars[i] != null)
            {

                if (i == (cars.length - 1))
                {
                    garageString += cars[i].getLicensePlate();
                } else
                {
                    garageString += cars[i].getLicensePlate() + ", ";
                }

            } else
            {
                if (i == (cars.length - 1))
                {

                    garageString += "null";
                } else
                {
                    garageString += "null, ";
                }

            }
        }

        garageString += "]";

        return garageString;
    }

}

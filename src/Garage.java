/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays;

/**
 *
 * @author Octavio
 */
public class Garage
{

    private static final int MAX_SPACE = 10;
    private Car[] cars;
    private Car[] carsBeingMoved;
    private int garageCarCount = 0;

    public Garage()
    {
        cars = new Car[MAX_SPACE];
    }

    public String arrive(Car hiCar)
    {
        int spaceWhereCarWasParked=0;
        if (garageCarCount == MAX_SPACE)
        {
            return "Sorry, the garage is full at this moment. Try again later";
        }
        boolean emptyPositionNotFound = true;
        for (int i = 0; i < MAX_SPACE && emptyPositionNotFound; i++)
        {
            if (isEmptyAtPosition(i))
            {
                cars[i] = hiCar;
                garageCarCount++;
                emptyPositionNotFound = false;
                spaceWhereCarWasParked=i;
            }
        }

        return hiCar.getLicensePlate()+" has arrived at parking space number "+spaceWhereCarWasParked;
    }

    public String depart(Car byeCar)
    {
        boolean carNotFound = true;
        carsBeingMoved = new Car[MAX_SPACE];
        boolean garageIsEmpty=cars[0]==null;
        
        if (garageIsEmpty)
        {
            return "The garage is empty";
        }
        
        for (int i = 0; i < MAX_SPACE && carNotFound; i++)
        {  
            if (byeCar.getLicensePlate() == cars[i].getLicensePlate())
            {
                carNotFound = false;
                if (i != 0)
                {
                    moveOutAllCarsBeforeIndex(i);
                }
                else
                {
                    for (int l = 0; l < garageCarCount; l++)
                    {
                        cars[l] = cars[l + 1];
                    }
                }
                garageCarCount--;
                cleanUpGarbage();
                return "The car " + byeCar.getLicensePlate() + " has departed. Have a nice day!";
            }
        }
        return "Sorry, that car is not on this garage";
    }

    public boolean isEmptyAtPosition(int index)
    {
        if (cars[index] == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void moveOutAllCarsBeforeIndex(int i)
    {
        for (int j = 0; j < i; j++)
        {
            carsBeingMoved[j] = cars[j];
            cars[j].increaseMoveCount();
        }

        for (int k = i; k < garageCarCount; k++)
        {
            cars[k] = cars[k + 1];
        }

        for (int m = 0; m < i; m++)
        {
            cars[m] = carsBeingMoved[m];
        }
    }
    
    public void cleanUpGarbage()
    {
        for (int n=garageCarCount;n<MAX_SPACE;n++)
        {
            cars[n]=null;
        }
    }
}

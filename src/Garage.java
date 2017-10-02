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
        System.out.println("[DEBUGGING]: Initializing cars to an array of size "+ MAX_SPACE);
    }

    public String arrive(Car hiCar)
    {
        System.out.println("[DEBUGGING]: We are now inside the arrive method of the Garage class");
        int spaceWhereCarWasParked=0;
        System.out.println("[DEBUGGING]: Initializing variable spaceWHereCasWasParked to "+spaceWhereCarWasParked);
        
        System.out.println("[DEBUGGING]: Checking if the garage is full");
        
        if (garageCarCount == MAX_SPACE)
        {
            System.out.println("[DEBUGGING]: The garage seems to be full");
            return "Sorry, the garage is full at this moment. Try again later";
        }
        boolean emptyPositionNotFound = true;
        System.out.println("[DEBUGGING]: Initializing emptyPositionNotFound to "+ emptyPositionNotFound);
        for (int i = 0; i < MAX_SPACE && emptyPositionNotFound; i++)
        {
            System.out.println("[DEBUGGING]: We are inside the for loop that will look for an available parking spot in the garage");
            System.out.println("[DEBUGGING]: The loop has has run "+(i+1)+" times so far");
            System.out.println("[DEBUGGING]: Checking if there are no cars in position "+i);
            if (isEmptyAtPosition(i))
            {
                System.out.println("[DEBUGGING]: There are no cars in position" +i+" therefore we will park our car here");
                System.out.println("[DEBUGGING]: Placing "+hiCar.getLicensePlate()+" in position "+i+" of the cars array");
                cars[i] = hiCar;
                garageCarCount++;
                System.out.println("[DEBUGGING]: Increasing the garageCarCount by one. The number of cars in the garage is "+garageCarCount);
                System.out.println("[DEBUGGING]: Setting emptyPositionNotFound to false because an empty position was found for the car");
                emptyPositionNotFound = false;
                System.out.println("[DEBUGGING]: Storing the space where the car was parked. The car was parked in position "+i+" of the array cars");
                spaceWhereCarWasParked=i;
                System.out.println("[DEBUGGING]: The present state of the cars garage: "+this.toString());
            }
        }

        return hiCar.getLicensePlate()+" has arrived at parking space number "+spaceWhereCarWasParked;
    }

    public String depart(Car byeCar)
    {
        System.out.println("[DEBUGGING]: We are now inside the depart method of the Garage class");
        boolean carNotFound = true;
        System.out.println("[DEBUGGING]: Initializing carNotFound to "+carNotFound);
        carsBeingMoved = new Car[MAX_SPACE];
        System.out.println("[DEBUGGING]: Creating an empty array of 10 spaces to store the cars that need to be moved");
        boolean garageIsEmpty=cars[0]==null;
        System.out.println("[DEBUGGING]: Initializing garage is empty to whether or not the garage is empty. The value is "+garageIsEmpty);
        
        if (garageIsEmpty)
        {
            System.out.println("[DEBUGGING]: The garage appears to be empty");
            return "The garage is empty";
        }
        
        
        for (int i = 0; i < MAX_SPACE && carNotFound; i++)
        {  
            System.out.println("[DEBUGGING]: We are now inside the loop that will check if the departing car is in the garage at all");
            if ((cars[i]!=null) && (byeCar.getLicensePlate().equals(cars[i].getLicensePlate())))
            {
                byeCar=cars[i];
                carNotFound = false;
                System.out.println("[DEBUGGING]: Initializing carNotFound to "+carNotFound);
                System.out.println("[DEBUGGING]: Checking if i is not equal to zero. If i is 0 then that means the car can just leave "
                        + "the garage without problems. However, if i is not 0 then we need to move out the cars before it");
                if (i != 0)
                {
                    System.out.println("[DEBUGGING]: It appears i is not 0. Therefore, move all cars before position "+i);
                    moveOutAllCarsBeforeIndex(i);
                }
                else
                {
                    System.out.println("[DEBUGGING]: i is 0. Car can leave the garage. All other cars are moved up closer to the entrance");
                    for (int l = 0; l < garageCarCount; l++)
                    {
                        System.out.println("[DEBUGGING]: We are inside the loop that moves all cars closer to the entrance");
                        System.out.println("[DEBUGGING]: The way this happens is that the car in position "+(l+1)+" is moved up to position "+l);
                        cars[l] = cars[l + 1];
                        
                    }
                    System.out.println("[DEBUGGING]: The present state of the cars garage: "+this.toString());
                }
                System.out.print("[DEBUGGING]: The number of cars in the garage has been decreased from "+garageCarCount);
                garageCarCount--;
                System.out.println(" to "+garageCarCount);
                System.out.println("[DEBUGGING]: Cleaning out the garbage values that don't matter");
                cleanUpGarbage();
                System.out.println("[DEBUGGING]: The present state of the cars garage: "+this.toString());
                
                return "The car " + byeCar.getLicensePlate() + " has departed. It was moved " + 
                        byeCar.getMoveCount()+" times "+"during its stay. Have a nice day!";
            }
        }
        System.out.println("[DEBUGGING]: It appears the car is not in this garage");
        return "Sorry, that car is not on this garage";
    }

    public boolean isEmptyAtPosition(int index)
    {
        System.out.println("[DEBUGGING]: We are inside the method that checks if a position is empty or not");
        
        if (cars[index] == null)
        {
            System.out.print("[DEBUGGING]: The value of the car at position is null");
            System.out.println("Therefore, the garage is empty at this position");
            return true;
        }
        else
        {
            System.out.print("[DEBUGGING]: The value of the car at position "+index+" is "+cars[index].getLicensePlate()+". ");
            System.out.println("Therefore, the garage is occupied at this position");
            return false;
        }
    }

    public void moveOutAllCarsBeforeIndex(int i)
    {
        System.out.println("[DEBUGGING]: We are now inside the method that moves out all cars before the index of the departing car");
        for (int j = 0; j < i; j++)
        {
            System.out.println("[DEBUGGING]: We are inside the loop that will put every car before the index of the departing car inside the"
                    + " cars being moved array");
            carsBeingMoved[j] = cars[j];
            System.out.println("[DEBUGGING]: The car "+cars[j].getLicensePlate()+" is being put in position "+j+" of the array"
                    + " carsBeingMoved. The car inside carsBeingMoved[j] is thus "+carsBeingMoved[j].getLicensePlate());
            cars[j].increaseMoveCount();
            System.out.println("[DEBUGGING]: The move count of "+cars[j].getLicensePlate()+" is now"+cars[j].getMoveCount());
        }

        for (int k = i; k < garageCarCount; k++)
        {
            System.out.println("[DEBUGGING]: We are inside the loop that will move all cars in the cars array up to the position of the"
                    + "departing car which will replace the departing car itself");
            System.out.println("[DEBUGGING]: Checking if the length of the cars array is equal to position "+(k+1)+", in which case"
                    + " we cannot move up a nonexistent car");
            if ( cars.length!=(k+1) )
            {
                System.out.println("[DEBUGGING]: All good. We can move up the cars");
                cars[k] = cars[k + 1];
            }
            System.out.println("[DEBUGGING]: This is done by grabbing the car at position "+(k+1)+" and putting it in position "+k);
        }

        for (int m = 0; m < i; m++)
        {
            System.out.println("[DEBUGGING]: We are now inside the loop that will put back the cars that we moved out");
            cars[m] = carsBeingMoved[m];
            
        }
    }
    
    public void cleanUpGarbage()
    {
        System.out.println("[DEBUGGING]: We are now inside of the cleanUpGarbage method of the Garage class");
        for (int n=garageCarCount;n<MAX_SPACE;n++)
        {
            System.out.println("[DEBUGGING]: We are inside the loop that will make every value from the garageCarCount until the max space of the"
                    + " garage equal to null. This has happened "+(n+1)+" times thus far");
            cars[n]=null;
        }
    }
    
    public String toString()
    {
        String garageString="[";
        
        for (int i=0;i<cars.length;i++)
        {
            if (cars[i]!=null)
            {
                
                if(i==(cars.length-1))
                {
                    garageString+=cars[i].getLicensePlate(); 
                }
                else
                {
                    garageString+=cars[i].getLicensePlate()+", ";
                }          
                
            }
            else
            {
                if(i==(cars.length-1))
                {
                   
                    garageString+="null";
                }
                else
                {
                    garageString+="null, ";
                }   
                
            }
        }
        
        garageString+="]";
        
        return garageString;
    }
}

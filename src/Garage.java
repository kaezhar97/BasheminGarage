/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays ;
/**
 *
 * @author Octavio
 */
public class Garage 
{
    private static final int MAX_SPACE=10;
    private Car[] cars;
    private Car[] carsBeingMoved;
    private int garageCarCount=0;
    
    public Garage()
    {
        cars=new Car[MAX_SPACE]; 
    }
    
    public String arrive(Car hiCar)
    {   
        if (garageCarCount==MAX_SPACE)
        {
            return "Sorry, the garage is full at this moment. Try again later";
        }
        boolean emptyPositionFound=false;
        for(int i=0;i<MAX_SPACE&&emptyPositionFound;i++)
        {
           if (isEmptyAtPosition(i))
           {
               cars[i]=hiCar;
               garageCarCount++;
               emptyPositionFound=true;
           }
        }
        
        
        return    "JAV001 has arrived at position 10"
                + "The garage now has 9 available spaces";
    }
    
    public String depart(Car byeCar)
    {
        boolean carNotFound=true;
        carsBeingMoved=new Car[MAX_SPACE];
        for (int i=0; i<MAX_SPACE&&carNotFound;i++)
        {
            if (byeCar.getLicensePlate()==cars[i].getLicensePlate())
            {
                carNotFound=false;
                if (i!=0)
                {
                    for (int j=0;j<i;j++)
                    {
                        carsBeingMoved[j]=cars[j];
                        cars[j].increaseMoveCount();
                    }
                    
                    for (int k=i;k<garageCarCount;k++)
                    {
                        cars[k]=cars[k+1];
                    }
                }
                else
                {
                    
                }
                
            }
        }
        
        if(carNotFound==true)
        {
            return "Sorry, that car is not on this garage";
        }
        return    "JAV001 has departed from position 10"
                + "The garage now has 10 available spaces";
    }
    
    public boolean isEmptyAtPosition(int index)
    {
        if (cars[index]==null)
        {
            return true;
        }
        
        else
        {
            return false;
        }
    }
    
    
}

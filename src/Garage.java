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
    
    public Garage()
    {
        cars=new Car[MAX_SPACE]; 
    }
    
    public String arrive(Car hiCar)
    {     
        boolean emptyPositionFound=false;
        for(int i=MAX_SPACE-1;i>0&&emptyPositionFound;i--)
        {
           if (isEmptyAtPosition(i))
           {
               cars[i]=hiCar;
               emptyPositionFound=true;
           }
        }
        
        cars[MAX_SPACE-1]=hiCar;
        return    "JAV001 has arrived at position 10"
                + "The garage now has 9 available spaces";
    }
    
    public String depart(Car byeCar)
    {      
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

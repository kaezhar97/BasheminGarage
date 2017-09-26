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
        
        cars[MAX_SPACE-1]=hiCar;
        return "";
    }
    
    public String depart(Car byeCar)
    {
        
        return "";
    }
    
    public boolean isEmpty(int index)
    {
        return true;
    }
    
    
}

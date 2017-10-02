/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Octavio
 */
public class Car 
{
    private String licensePlate;
    private int moveCount;
 
    public Car(String licensePlate)
    {
        this.licensePlate=licensePlate;
    }
    
    public String getLicensePlate()
    {
        return this.licensePlate;
    }
    
    public void increaseMoveCount()
    {
        this.moveCount++;
    }
    
    public int getMoveCount()
    {
        return this.moveCount;
    }
 
}

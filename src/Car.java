/*
File: Car.java
Purpose:
    This class simulates a real life car with a license plate number.
*/

/**
 * A car is a license plate number
 * 
 * @author Octavio
 */
public class Car 
{
    private String licensePlate; // Stores the license plate of the car
    private int moveCount; // Keeps track of how many times the car has been moved out of the garage to allow another car to leave
 
    /**
     * Creates a car object with a unique license plate
     * 
     * @param licensePlate the license plate of the car
     */
    public Car(String licensePlate)
    {
        this.licensePlate=licensePlate;
    }
    
    /**
     * Get the car's license plate
     * 
     * @return the license plate of the car
     */
    public String getLicensePlate()
    {
        return this.licensePlate;
    }
    
    /**
     * Increases the number of times the car has been moved out of the garage
     */
    public void increaseMoveCount()
    {
        this.moveCount++;
    }
    
    /**
     * Gets the number of times the car has been moved during its stay at the garage
     * 
     * @return the number of times the car has moved
     */
    public int getMoveCount()
    {
        return this.moveCount;
    }
 
}

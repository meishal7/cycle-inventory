/** 
* TITLE: Motorcycle.java 
* AUTHOR: Elena Mudrakova   
* COURSE: CS 112 Intro to CS II - Java  
* MODULE: 6
* PROJECT: Lab 12_CycleInventory
* LAST MODIFIED: 10/18/2020
* DESCRIPTION: this program defines the class Motorcycle that extends Cycle class
*
* ALGORITHM:
* declare  protected int displacement;
           protected double fuelCapacity;
* 
* declare constructors
* declare setters and getters
* declare equals() method
* declare toString() method
* declare hashCode() method
* 
* PACKAGES INCLUDED
* import java.text.NumberFormat; //fornmatting price
* import java.util.Objects;
* import java.io.Serializable;
* import java.lang.*;
* 
* 
*/   

import java.text.NumberFormat; //fornmatting price
import java.util.Objects;
import java.io.Serializable;
import java.lang.*;

public class Motorcycle extends Cycle implements Serializable {
    /**************************** INSTANCE VARS ***************************/
    protected int displacement;
    protected double fuelCapacity;
    
    /**************************** CONSTRUCTORS ***************************/
    
    /**
     * No arguments constructor
     */
    public Motorcycle(){ }
    /**
     * Four argumrnts constructor
     * @param manufacturer for setting manufacturer
     * @param price for setting price
     * @param displacement for setting displacement
     * @param fuelCapacity for setting fuelCapacity
     */
    public Motorcycle(String manufacturer, double price, int displacement, double fuelCapacity){
        super(manufacturer, price);
        setDisplacement(displacement);
        setFuelCapacity(fuelCapacity);
    }

    /**************************** GETTERS AND SETTERS ***************************/
    
    /**
     * Sets displacement
     * @param displacement for set
     */
    public void setDisplacement(int displacement){
        this.displacement = displacement;
    }
    /**
     * 
     * @return displacement
     */
    public int getDisplacement(){
        return displacement;
    }
    /**
     * Sets fuelCapacity
     * @param displacement for set
     */
    public void setFuelCapacity(double fuelCapacity){
        this.fuelCapacity = fuelCapacity;
    }
    /**
     * @return fuelCapacity
     */
    public double getFuelCapacity(){
        return fuelCapacity;
    }
    
    /************************************ EQUALS() toSTRING() hashCODE() **************************************/
    /**
     * Prints out the object data
     */
    public String toString()
    {
        // Use a class called NumberFormat
        // to format a number (mPrice) as currency
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        
        return ("Motorcycle [ Manufacturer = " + manufacturer + ", Price = " + currency.format(price) 
                + ", Displacement = " + displacement 
                + ", Fuel capacity = " + fuelCapacity
                + " ]");
    }
    /**
     * Tests for equality of two objects. To be equal
     * objects must have the same manufacturer, price, displacement, fuelCapacity
     * @return returns true if the objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Motorcycle that = (Motorcycle) o;
        return displacement == that.displacement &&
               fuelCapacity == that.fuelCapacity;
               
    }

    /**
     * Returns hash code value for the obj
     * 
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), displacement, fuelCapacity);
    }
    
    
}

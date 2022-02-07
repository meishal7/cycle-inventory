/** 
* TITLE: Cycle.java 
* AUTHOR: Elena Mudrakova   
* COURSE: CS 112 Intro to CS II - Java  
* MODULE: 6
* PROJECT: Lab 12_CycleInventory
* LAST MODIFIED: 10/18/2020
* DESCRIPTION: this program defines the abstract class Cycle
*
* ALGORITHM:
* declare  protected String manufacturer;
           protected double price;
* 
* declare constructors
* declare setters and getters
* declare equals() method
* declare toString() method
* declare hashCode() method
* 
* PACKAGES INCLUDED
* 
* import java.util.Objects;
* import java.io.Serializable;
* import java.lang.*;
* 
* 
*/   

import java.util.Objects;
import java.io.Serializable;
import java.lang.*;

public abstract class Cycle implements Serializable {
    /**************************** INSTANCE VARS ***************************/
    protected String manufacturer;
    protected double price;
    

    /**************************** CONSTRUCTORS ***************************/
    
    /**
     * No arguments constructor
     */
    public Cycle(){ }
     /**
      * Two arguments constructor
      * @param manufacturer for setting manufacturer
      * @param price for setting price
      */
    public Cycle(String manufacturer, double price){
        setManufacturer(manufacturer);
        setPrice(price);
    }

    /**************************** GETTERS AND SETTERS ***************************/
    
    /**
     * Sets the factory
     * @param factory for set
     */
    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }
    /**
     * 
     * @return factory
     */
    public String getManufacturer(){
        return manufacturer;
    }
    /**
     * Sets price
     * @param price price for set, double, min = 1.00
     */
    public void setPrice(double price){
        this.price = price;
    }
    /**
     * @return price
     */
    public double getPrice(){
        return price;
    }
    
    /************************************ EQUALS() toSTRING() hashCODE() **************************************/
    /**
     * Prints out the object data
     */
    public String toString()
    {
        return ("Cycle manufacturer: " + manufacturer + " price" + price);
    }
    /**
     * Tests for equality of two objects. To be equal
     * objects must have the same factory and price
     * @return returns true if the objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cycle that = (Cycle) o;
        return Double.compare(that.price, price) == 0 &&
        manufacturer.equals(that.manufacturer);
                
    }

    /**
     * Returns hash code value for the obj
     * 
     */
    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, price);
    }
    
}

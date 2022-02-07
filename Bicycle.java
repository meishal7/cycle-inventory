/** 
* TITLE: Bicycle.java 
* AUTHOR: Elena Mudrakova   
* COURSE: CS 112 Intro to CS II - Java  
* MODULE: 6
* PROJECT: Lab 12_CycleInventory
* LAST MODIFIED: 10/18/2020
* DESCRIPTION: this program defines the class Bicycle that extends Cycle class
*
* ALGORITHM:
* declare protected int frameSize;
          protected int cranks;
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
import java.util.Objects; //for hashCode
import java.io.Serializable;
import java.lang.*;

public class Bicycle extends Cycle implements Serializable {

    /**************************** INSTANCE VARS ***************************/
    protected int frameSize;
    protected int cranks;

    /**************************** CONSTRUCTORS ***************************/

    /**
     * No arguments constructor
     */
    public Bicycle() {
    }
    /**
     * Four arguments constructor
     * @param manufacturer for setting manufacturer
     * @param price for setting the price
     * @param frameSize for setting the
     * @param cranks for setting cranks
     * @throws InvalidFrameSizeException if framesSize not equals to 15 or 17 or 19
     */
    public Bicycle(String manufacturer, double price, int frameSize, int cranks) throws InvalidFrameSizeException {
        super(manufacturer, price);
        setFramesize(frameSize);
        setCranks(cranks);
        if(frameSize != 15 && frameSize != 17 && frameSize != 19)
            throw new InvalidFrameSizeException(); 

    }

    /**************************** GETTERS AND SETTERS ***************************/

    /**
     * Sets framesize
     * 
     * @param framesize for set
     */
    public void setFramesize(int frameSize) {
        this.frameSize = frameSize;
    }

    /**
     * 
     * @return framesize
     */
    public int frameSize() {
        return frameSize;
    }

    /**
     * Sets cranks
     * 
     * @param cranks for set
     */
    public void setCranks(int cranks) {
        this.cranks = cranks;
    }

    /**
     * @return cranks
     */
    public int getCranks() {
        return cranks;
    }

    /************************************
     * EQUALS() toSTRING() hashCODE()
     **************************************/
    /**
     * Prints out the object data
     */
    public String toString() {
        // Use a class called NumberFormat
        // to format a number (mPrice) as currency
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        return ("Bicycle [ Manufacturer = " + manufacturer + ", Price = " + currency.format(price) + ", Framesize = "
                + frameSize + ", Cranks = " + cranks + " ]");
    }

    /**
     * Tests for equality of two objects. To be equal objects must have the same
     * manufacturer, price, framesize, cranks
     * 
     * @return returns true if the objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        Bicycle that = (Bicycle) o;
        return frameSize == that.frameSize && cranks == that.cranks;

    }

    /**
     * Returns hash code value for the obj
     * 
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), frameSize, cranks);
    }

}

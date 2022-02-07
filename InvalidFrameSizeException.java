/** 
* TITLE: InvalidFrameSizeException.java 
* AUTHOR: Elena Mudrakova   
* COURSE: CS 112 Intro to CS II - Java  
* MODULE: 6
* PROJECT: Lab 12_CyclesInventory
* LAST MODIFIED: 10/18/2020
* DESCRIPTION: InvalidFrameSizeException class declaration
* 
* ALGORITHM: 
* declare public class InvalidFrameSizeException extends Exception
* create no argument constr and define super("Invalid frame size: Only 15\" (small), 17\" (medium) or 19\" (large) frame sizes are recognized.");
* create one argument constr and define super(message) constr inside
* 
* PACKAGES INCLUDED: no 
*/ 

public class InvalidFrameSizeException extends Exception {
    /**
     * No arguments constructor
     */
    public InvalidFrameSizeException(){
        super("Invalid frame size: Only 15\" (small), 17\" (medium) or 19\" (large) frame sizes are recognized.");
    }
    /**
     * One argument constructor
     * @param message message to be displayed
     */
    public InvalidFrameSizeException(String message){
        super(message);
    }
    
}

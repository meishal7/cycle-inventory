/** 
* TITLE: CycleInventoryDemo.java 
* AUTHOR: Elena Mudrakova   
* COURSE: CS 112 Intro to CS II - Java  
* MODULE: 6
* PROJECT: Lab 12_CycleInventory
* LAST MODIFIED: 10/18/2020
* DESCRIPTION: this program prints data from binary file on console,
* takes user input, stores it in the object, stores the object into array and prints
* array in binary file. This program finds avg price in all cycles in array and finds the Motocycle 
* with the highest displacement.
*
* ALGORITHM:
* declare public class CycleInventoryDemo
* declare public static double findAvgPrice(Cycle[] cycles)
* --> declare int avgPrice = 0, count = 0;
*              double totalPrice = 0;
* in for loop --> if(cycles[i] != null){
*                 count++;
*                 totalPrice += cycles[i].getPrice(); }
*                 avgPrice = (int)totalPrice / count;
* after for loop --> format price with NumberFormat
* return avgPrice
*
* 
* declare public static Cycle findMaxDisplacement(Cycle[] cycles)
* --> declare int maxDisplacement = 0;
*              int index = 0;
* in for loop -->  if(cycles[i] instanceof Motorcycle) --> convert this elem in Motocycle instance
* if(maxDisplacement < moto.getDisplacement() --> 
* maxDisplacement = moto.getDisplacement();
* index = i; 
* print cycles[index]
* return cycles[index]
* 
* 
* in main method --> declare array of type Cycle 
* declare Scanner sc = new Scanner(System.in);
          int userChoice = 0, 
          frameSize = 0, 
          cranks = 0,
          count = 0,
          displacement = 0;
          double price = 0,
          fuelCapacity = 0;
          String manufacturer;
* 
* for binary file --> declare binary file
* in try-catch block --> create a stream for reading from file
* read data from file in array Cycle[] cycles
* print data from array in console
* catch exceptions
*
*
* for user input --> in while loop create user prompt - menu
* in switch stmt create prompt for every case from menu and grab user input
* case "Enter Bicycle" --> create an object, grab user input and store it in array Cycle[] cycles
* case "Enter Motorcycle" --> create an object, grab user input and store it in array Cycle[] cycles
* case "show inventory" --> print tha data from Cycle[] cycles in console
* case "exit" --> print Cycle[] cycles into binary file in try-catch block
* and call findAvgPrice(), findMaxDisplacement() methods
* catch exceptions
* 
* PACKAGES INCLUDED
* import java.text.NumberFormat; //fornmatting price
* import java.util.Objects;
* import java.io.Serializable;
* import java.lang.*;
* 
* 
*/   

import java.io.*;
import java.util.Scanner;
import java.text.NumberFormat; //fornmatting price
import java.util.ArrayList; // import the ArrayList class
import java.util.List;

public class CycleInventoryDemo {
    /**
     * Calculate avg price of all cycles in cycles array
     * @param cycles array of cycles
     * @return avgPrice
     */
    public static double findAvgPrice(Cycle[] cycles){
        //Declaration
        int avgPrice = 0, count = 0;
        double totalPrice = 0;
        //Compute total price of all cycles in inventory array
        for(int i =0; i < cycles.length; i++){
            if(cycles[i] != null){
                count++;
                totalPrice += cycles[i].getPrice();
            }
            //Compute avg price
            avgPrice = (int)totalPrice / count;
        }
        // Use a class called NumberFormat
        // to format a number (mPrice) as currency
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println("\nAvg price is " + currency.format(avgPrice));
        
        return avgPrice;
    }

    
    /**
     * Finds the Motorcycle with the max displacement
     * @param cycles array of all cycles in the inventory
     * @return Motorcycle instance
     */
    public static Cycle findMaxDisplacement(Cycle[] cycles){
      int maxDisplacement = 0;
      int index = 0;
      for(int i = 0; i<cycles.length; i++){
          //If the object in array is instance of Motorcycle class
         if(cycles[i] instanceof Motorcycle){
           //Convert this obj to Motorcycle instance
           Motorcycle moto = (Motorcycle) cycles[i];
           //If masDisplaycment < motorcycle obj displacement
           if(maxDisplacement < moto.getDisplacement())
           {
            //assign current obj displacemnt to maxDisplacement var
             maxDisplacement = moto.getDisplacement();
             index = i; //grab the index of current obj
            }
          }
      }
      System.out.println("\nThe motorcycle with max displacement:");
      System.out.println(cycles[index].toString());
      
      return cycles[index];
    }


    public static void main(String[] args) throws InvalidFrameSizeException {
    
    /***************************************************************************************
     *                                 VARS DECLARATION                                    *
     ***************************************************************************************/
     Cycle[] cycles = new Cycle[10]; //array for storing all cycles from the inventory
    
    Scanner sc = new Scanner(System.in);
    
    int userChoice = 0, 
        frameSize = 0, 
        cranks = 0,
        count = 0,
        displacement = 0;
    
    double price = 0,
           fuelCapacity = 0;
    
    String manufacturer;
    

    /***************************************************************************************
     *                                 BINARY FILE CODE                                    *
     ***************************************************************************************/
    
    // Declare the binary file
    File binaryFile = new File("CycleInventory.dat");
    try
    {
        if (binaryFile.exists()){
        //Create infile stream
         ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(binaryFile));
        //Read object data from file into array
        cycles = (Cycle[])inputStream.readObject();
        inputStream.close();

        //Print array of cycles
        if (cycles == null) {
            System.out.println("No data.  Please enter cycles into inventory.");
        }
        else{
            System.out.print("Previously saved cycles from the inventory:\n");
            for (Cycle c : cycles){
                if (c != null)
                {
                    System.out.println(c);
                    count++;
                }
                else
                    break;
                }
            }//end of for loop
        }//end of if-else
    }
    catch(IOException e)
    {
        System.err.println(e.getMessage());
    } catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}

  
    /***************************************************************************************
     *                                 USER INPUT                                          *
     ***************************************************************************************/
    
        while(userChoice != 4){
            //User prompt
            System.out.println("\n*********************** Welcome to Inventory Department! ************************");
            System.out.print("\nChoose the option below:\n"  +
                            "1. Enter a Bicycle.\n" +
                            "2. Enter a Motorcycle.\n" +
                            "3. Display all cycles in the Inventory.\n" +
                            "4. Exit ");

            //Another prompt and take user input
            userChoice = sc.nextInt();
            switch(userChoice){
                case 1: 
                        System.out.print("Enter manufacturer name: ");
                        sc.nextLine();
                        manufacturer = sc.nextLine();
                        System.out.print("Enter bicycle price: ");
                        price = sc.nextDouble();
                        System.out.print("Enter frame size: ");
                        frameSize = sc.nextInt();
                        System.out.print("Enter number of cranks: ");
                        cranks = sc.nextInt();
                        
                        //Create a Bicycle obj, put into array
                        cycles[count++] = new Bicycle(manufacturer, price, frameSize, cranks);
                        break;
                
                case 2: 
                        System.out.print("Enter manufacturer name: ");
                        sc.nextLine();
                        manufacturer = sc.nextLine();
                        System.out.print("Enter motorcycle price: ");
                        price = sc.nextDouble();
                        System.out.print("Enter displacement: ");
                        displacement = sc.nextInt();
                        System.out.print("Enter fuel capacity: ");
                        fuelCapacity = sc.nextDouble();
                
                        //Create a Motorcycle obj, put into array
                        cycles[count++] = new Motorcycle(manufacturer, price, displacement, fuelCapacity);
                        break;

                case 3:
                        //Print array of cycles
                        if (cycles == null) {
                            System.out.println("No data.  Please enter cycles into inventory.");
                        }
                        else{
                            System.out.print("Previously saved cycles from the inventory:\n");
                            for (Cycle c : cycles){
                                if (c != null)
                                {
                                    System.out.println(c);
                                    count++; //count items in array
                                }
                                else break;
                            }//end of for loop
                        }//end of if-else
                        break;

                case 4:
                        //Printing array of cycles into file
                        try
                        {
                            //Create outfile stream
                            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(binaryFile));
                            //Write array of dogs in a file 
                            for(int i=0; i < cycles.length; i++){
                                System.out.println(cycles[i]);
                                outputStream.writeObject(cycles);
                            }

                            CycleInventoryDemo.findAvgPrice(cycles);
                            CycleInventoryDemo.findMaxDisplacement(cycles);
                            System.exit(0);
                        }
                        catch(FileNotFoundException e)
                        {
                            System.err.println("Cant find the file.");
                        }
                        catch(IOException e)
                        {
                            System.err.println(e.getMessage());
                            
                        }
                        break;

            }//end of switch
        }//end of while
    }
}

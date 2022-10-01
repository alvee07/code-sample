/**
 * Name: Alvee Hassan Akash
 * Student ID: 3433334
 * Program: 01
 * Course: COMP 308
 * Athabasca University
 */

/**
 * title: PartyTrayOrder.java
 * description: a basic Computer Party tray Order class takes all types of arbitrary objects
 * date: March 25, 2020
 * @author Alvee Hassan Akash
 * @version 1.0
 * @copyright 2020 Alvee Hassan Akash
 */

/**
 * DOCUMENTATION...
 */

/**
 * ComputerPartyOrder
 *
 * Purpose and Description
 *
 * a class called ComputerPartyOrder that is subtype of GenericOrder class, takes
 * ComputerPart objects, Peripheral objects, Cheese objects, Fruit objects and Service objects.
 * It gives each instance of the container a unique identifier from super class
 *
 * This program does not use User input, all inputs are in Main.java file.
 *
 * Sun Java SDK version 1.3 or better.
 *
 * Compiling and running instructions
 * Assuming SDK 1.3 (or later) and the CLASSPATH are set up properly.
 * Change to the directory containing the source code.
 *
 * Compile:    See AnotherClient class file
 * Run:        See AnotherClient class file
 *
 */

/**
 * Classes
 *
 * public class ComputerPartyOrder<T extends Product> extends GenericOrder<T>
 *
 * Methods (Method documentations are with the methods)
 *
 * public void addProduct(T product)
 *
 *
 */

/**
 * CODE...
 */

public class ComputerPartyOrder<T extends Product> extends GenericOrder<T>{

    /**
     * Takes an arbitrary number of different classes of ComputerPart objects, Peripheral objects,
     * Cheese objects, Fruit objects and Service objects through extending Product.
     * @param product - PartyTrayInterface interface - product
     */
    public void addProduct(T product){
        super.addProduct(product);
    }

}///:~
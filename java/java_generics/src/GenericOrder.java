/**
 * Name: Alvee Hassan Akash
 * Student ID: 3433334
 * Program: 01
 * Course: COMP 308
 * Athabasca University
 */

/**
 * title: GenericOrder.java
 * description: a basic Generic Order collection class
 * date: March 25, 2020
 * @author Alvee Hassan Akash
 * @version 1.0
 * @copyright 2020 Alvee Hassan Akash
 */

/**
 * DOCUMENTATION...
 */

/**
 * GenericOrder
 *
 * Purpose and Description
 *
 * a class called GenericOrder that represents a collection of an arbitrary number of objects in Products.java.
 * It gives each instance of the container a unique identifier using Java generics features
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
 * public class GenericOrder<T>
 *
 * Methods (Method documentations are with the methods)
 *
 * Constructors
 * public GenericOrder()
 *
 *
 * Instance Variables
 *
 * private List<T> products;
 * private static long startId = 1;
 * private long Id;
 *
 *
 */

/**
 * CODE...
 */

import java.util.ArrayList;
import java.util.List;

public class GenericOrder<T> {

    /**
     * instance Variables
     * startId - to start the id from 1
     * Id - to store the instance unique identity
     * List<T> - to store products
     */
    private static long startId = 1;
    private final long Id;
    private List<T> products;

    /**
     * Constructor
     */
    public GenericOrder(){
        this.products = new ArrayList<T>();
        Id = startId;
        startId++;
    }

    /**
     * Setting T type of list in Private variable
     * @param product - T type of List
     */
    public void setProduct(List<T> product) {
        this.products = product;
    }

    /**
     * Returns T type of list
     * @return - list
     */
    public List<T> getProducts() {
        return products;
    }

    /**
     * Returns Id number of the instance
     * @return long type
     */
    public long getId() {
        return Id;
    }

    /**
     * Adds product to the list
     * @param product - Product type
     */
    public void addProduct(T product){
        this.products.add(product);
    }

    /**
     * Returns number of elements in the list
     * @return - int type
     */
    public int getHowManyProductsInList(){
        return this.products.size();
    }

}///:~


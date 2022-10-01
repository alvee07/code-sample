/**
 * Name: Alvee Hassan Akash
 * Student ID: 3433334
 * Program: 02
 * Course: COMP 308
 * Athabasca University
 */


/**
 * title: ShippingLabel.java
 * description: a basic ShippingLabel structure of a parcel
 * date: March 05, 2020
 * @author Alvee Hassan Akash
 * @version 1.0
 * @copyright 2020 Alvee Hassan Akash
 */

/**
 * DOCUMENTATION...
 */

/**
 *
 * ShippingLabel
 *
 * Purpose and Description
 *
 * a class called ShippingLabel that consists of ship-from and ship-to MailingAddress objects.
 * Write a single method that prints the label to the console.
 *
 * This program does not use User input, all inputs are in Main.java file.
 *
 * Sun Java SDK version 1.3 or better.
 *
 * Compiling and running instructions
 * Assuming SDK 1.3 (or later) and the CLASSPATH are set up properly.
 * Change to the directory containing the source code.
 *
 * Compile:    See Main file to compile
 * Run:        See Main file to run
 */

/**
 *
 * Classes
 *
 * public class ShippingLabel
 *
 * Methods (Method documentations are with the methods)
 *
 * Constructors
 * public MailingAddress(FullName fullName, String address, String city, String province, String postalCode)
 *
 * public String toString()
 *
 * Instance Variables
 *
 * private FullName fullName;
 * private String address;
 * private String city;
 * private String province;
 * private String postalCode;
 *
 */


/**
 * CODE...
 */
/** Java core packages */

public class ShippingLabel {
    private MailingAddress shipTo;
    private MailingAddress shipFrom;

    public ShippingLabel(MailingAddress to, MailingAddress from){
        shipTo = to;
        shipFrom = from;
    }

    /**
     * Override method to display Shipping label
     * @return - String value - Shipping label representation
     */
    @Override
    public String toString() {
        return "Shipping Label: \n" +
                "To:\n" + shipTo +
                "\nFrom:\n" + shipFrom;
    }
}//:~

/**
 * Name: Alvee Hassan Akash
 * Student ID: 3433334
 * Program: 02
 * Course: COMP 308
 * Athabasca University
 */


/**
 * title: MailingAddress.java
 * description: a basic MailingAddress structure of an address
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
 * MailingAddress
 *
 * Purpose and Description
 *
 * a class called MailingAddress that represents a mailing address. It must have separate fields for
 * a FullName object, street address, city, province and postal code. Other than FullName all other fields are Strings.
 * Override the toString() method to return a nicely formatted address.
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
 * public class MailingAddress
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

public class MailingAddress {
    /**
     * fullName holds a person's name who holds the address
     * other holds as string data type
     */
    private FullName fullName;
    private String address;
    private String city;
    private String province;
    private String postalCode;

    /**
     * Mailing address parameterised constructor
     * @param fullName - FullName instance - person's full name
     * @param address - String value
     * @param city - String value
     * @param province - String value
     * @param postalCode - String value
     */
    public MailingAddress(FullName fullName, String address, String city, String province, String postalCode) {
        this.fullName = fullName;
        this.address = address;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }

    /**
     * Override method to display mailing address
     * @return - String value - Mailing address representation
     */
    @Override
    public String toString() {
        return   fullName + "\n" +
                 address + ", " +
                 city + ", " +
                 province + ", " +
                 postalCode + ".";
    }
}//:~
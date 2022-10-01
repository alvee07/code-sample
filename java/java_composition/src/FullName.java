/**
 * Name: Alvee Hassan Akash
 * Student ID: 3433334
 * Program: 02
 * Course: COMP 308
 * Athabasca University
 */


/**
 * title: FullName.java
 * description: a basic Name structure of a person
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
 * FullName
 *
 * Purpose and Description
 *
 * a class called FullName that represents a person's full name. It must have separate fields for title
 * (e.g., Mr., Mrs., Ms.), first name, middle name, and last name. Override the toString() method to return
 * a nicely formatted name.
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
 * public class FullName
 *
 * Methods (Method documentations are with the methods)
 *
 * Constructors
 * public FullName(String title, String firstName, String middleName, String lastName)
 *
 * public String toString() - Override method - Nicely formatted FullName representation
 *
 * Instance Variables
 *
 * private String title;
 * private String firstName;
 * private String middleName;
 * private String lastName;
 *
 */


/**
 * CODE...
 */
/** Java core packages */


public class FullName {
    /**
     * A person's full name holder in string data type
     */
    private String title;
    private String firstName;
    private String middleName;
    private String lastName;

    /**
     * A person full name set up parameterised constructor
     *
     * @param title - person's title - Mr., Mrs., etc
     * @param firstName - person's first name - John, Jenny, etc
     * @param middleName - person's middle name - anne, M., etc
     * @param lastName - person's first name - McDonald, Fitzpatrick, etc
     */
    public FullName(String title, String firstName, String middleName, String lastName) {
        this.title = title;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    /**
     * Override method to display full name
     * @return - String value - Full name representation
     */
    @Override
    public String toString() {
        return title + " " + firstName + " " + middleName + " " + lastName + "." ;
    }

}//:~

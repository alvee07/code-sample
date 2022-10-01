/**
 * Name: Alvee Hassan Akash
 * Student ID: 3433334
 * Program: 01
 * Course: COMP 308
 * Athabasca University
 */


/**
 * title: Circle.java
 * description: a basic geometry type class called 'circle' which sets its coordinates, radius, and calculates various
 * functionality.
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
 * Circle
 *
 * Purpose and Description
 *
 * a class called Circle which has two constructors. The first constructor (default constructor) does not
 * take any parameter and supplies default values for the coordinates and the radius. The second constructor
 * takes three doubles as parameters corresponding to the X and Y coordinates and the radius.
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
 * public class Circle
 *
 * Methods (Method documentations are with the methods)
 *
 * Constructors
 * Circle()
 * Circle(double x, double y, double rad)
 *
 * public double circumference() - calculate circle's circumference
 * public double area() - calculate circle's area
 * public void setRadius(double r) - set circle's radius, if greater than MAXIMUM_RADIUS, set to MAXIMUM_RADIUS
 * public void printAttributes() - print all the instance variables
 * public boolean isInside(double x, double y) - checks any point inside or outside circle
 * public void move(int x, int y) - move coordinate, new points add to previous points
 *
 * Instance Variables
 *
 * private double xCoordinate;
 * private double yCoordinate;
 * private double radius;
 *
 * Constant Variable
 * private static final double MAXIMUM_RADIUS = 5.0
 *
 */


/**
 * CODE...
 */
/** Java core packages */

public class Circle {
    /**
     * Circle's X and Y coordinates, and radius
     */
    private double xCoordinate;
    private double yCoordinate;
    private double radius;

    /**
     * Maximum radius allows for this circle
     */
    private static final double MAXIMUM_RADIUS = 5.0;

    /**
     * default constructor
     */
    Circle(){
        xCoordinate = 2;
        yCoordinate = 2;
        radius = MAXIMUM_RADIUS;
    }

    /**
     * parameterised constructor
     * @param x - double value - xCoordinate
     * @param y - double value - yCoordinate
     * @param rad - double value - radius
     */
    Circle(double x, double y, double rad){
        xCoordinate = x;
        yCoordinate = y;
        setRadius(rad);
    }

    /**
     * Calculates Circle's circumference
     * @return - double value - circle's circumference
     */
    public double circumference(){
        return 2 * Math.PI * radius;
    }

    /**
     * Calculates Circle's Area
     * @return - double value - circle's area
     */
    public double area(){
        return Math.PI * Math.pow(radius, 2);
    }

    /**
     * sets Circle's radius, if given radius is greater than 5 then set it to 5
     * uses "ternary conditional operator" to set the value
     *
     * @param r - double value - set circle's radius
     */
    public void setRadius(double r){
        radius = (r > MAXIMUM_RADIUS) ? MAXIMUM_RADIUS : r;
    }

    /**
     * Prints Circle's X, Y, Radius, Circumference, and Area on the system console
     */
    public void printAttributes(){
        System.out.println("Circle's Attributes are -\n" +
                "X Coordinate "+ xCoordinate + "\tY Coordinate "+ yCoordinate + "\tRadius "+ radius +
                "\nCircumference "+ circumference() +"\tArea "+ area());
    }

    /**
     * Checks if the given coordinates are inside the circle or not
     *
     * @param x - double value - given X coordinate
     * @param y - double value - given Y coordinate
     * @return - Boolean value - true/false of the given coordinate position
     */
    public boolean isInside(double x, double y){
        double changeInX = Math.pow((x - xCoordinate), 2);
        double changeInY = Math.pow((y - yCoordinate), 2);
        double distanceFromCenter = Math.sqrt(changeInX + changeInY);

        return distanceFromCenter < radius ? true : false;
    }

    /**
     * Moves Circle's X, Y coordinate to new coordinates based on given coordinates.
     *
     * @param x - int value - given X coordinate
     * @param y - int value - given Y coordinate
     */
    public void move(int x, int y){
        xCoordinate = xCoordinate + x;
        yCoordinate = yCoordinate + y;
    }


}//:~
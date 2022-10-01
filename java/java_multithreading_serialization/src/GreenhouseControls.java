/***********************************************************************
 * Adapated for COMP308 Java for Programmer, 
 *		SCIS, Athabasca University
 *
 * Assignment: TME3
 *
 * @date  : Oct 21, 2005
 *
 */
/**
 * Name: Alvee Hassan Akash
 * Student ID: 3433334
 * Program: 01 - Greenhouse Controls by abstract class, inheritance, File I/O
 * Course: COMP 308
 * Athabasca University
 *
 * NOTE: Most of the programing is self-documenting or self-describing.
 * Note: The base file was already coded by creator, I am just adding some features only for assignment.
 */

/**
 * title: GreenhouseControls.java
 * description: A basic GreenhouseControls class controls I/O, inheritance.
 * date: April 12, 2020
 * @author: Steve Leung (main Author)
 * Note: Alvee Hassan Akash added functionality to complete assignment (only this edition)
 * @version 1.0
 * @copyright 2020 Alvee Hassan Akash
 *
 * // innerclasses/GreenhouseControls.java
 * // This produces a specific application of the
 * // control system, all in a single class. Inner
 * // classes allow you to encapsulate different
 * // functionality for each type of event.
 * // From 'Thinking in Java, 4th ed.' (c) Bruce Eckel 2005
 * // www.BruceEckel.com. See copyright notice in CopyRight.txt.
 *
 * I declare that this assignment is my own work which will be differently formatted in the folder
 * and that all material previously written or published in any source
 * by any other person has been duly acknowledged in the assignment. I have not submitted this work, or a significant
 * part thereof, previously as part of any academic program. In submitting this assignment I give permission to copy
 * it for assessment purposes only.
 */

/**
 * DOCUMENTATION...
 */

/**
 * GreenhouseControls
 *
 * Purpose and Description
 *
 * a class to run the complete program. It has many functionality - inner classes, interface, etc
 * Inner classes to run that helps to complete the Events and GreenhouseControls with and without
 * errors according to the assignment requirements.
 *
 * This program does use User input, all inputs are from directory based shown in the RUN-TIME.
 *
 * Sun Java SDK version 1.3 or better.
 *
 * Compiling and running instructions
 * Assuming SDK 1.3 (or later) and the CLASSPATH are set up properly.
 * Change to the directory containing the source code.
 *
 *
 * Compile:    See Application class
 *
 * Run:        See Application class
 *
 */

/**
 * Classes
 *
 * public class GreenhouseControls extends Controller implements Serializable
 *
 * Interface
 *
 * interface Fixable
 *  - help to fix the errors in the GreenhouseControls Events such as Power out and Window Malfunction
 *
 * Methods (Method documentations are with the methods)
 *
 * Constructors
 * public GreenhouseControls(String startCode, String fileName, Screen window)
 *
 *
 * public void shutdown(String problem)
 *
 * public Fixable getFixable (int errorcode)
 *
 * public int getError()
 *
 * public void setVariable(Tuple<String, String> tuple)
 *
 * public void showDB()
 *
 * public List<Tuple<String, String>> getDatabase()
 *
 * public PausableThreadPoolExecutor getPauseThread()
 *
 * public void scheduleToThread(Runnable runnable, long time)
 *
 * protected void addTerminateEvent(Event event)
 *
 *
 * Instance Variables
 *
 * protected transient Screen screen;
 *
 * private volatile int errorCode;
 *
 * protected List<String> events = new ArrayList<>();
 *
 * protected final transient PausableThreadPoolExecutor pauseThread
 *
 * protected List<Tuple<String, String>> database
 *
 */

/**
 * CODE...
 */

/**
 * Important imported packages to run this file
 */

import tme3.Controller;
import tme3.Event;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class GreenhouseControls extends Controller implements Serializable, Runnable {
    // added for some unique id, (I had only One problem at first, so I included)
    private static final long serialVersionUID = 4581425092843353410L;

    protected transient Screen screen;

    private volatile int errorCode;

    protected List<String> events = new ArrayList<>();

    protected final transient PausableThreadPoolExecutor pauseThread = new PausableThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), this);

    protected List<Tuple<String, String>> database = Collections.synchronizedList(new ArrayList<>());



    /**
     * interface fixable type classes to fix the error and start the system again.
     * @param errorcode - int value
     * @return - fixable interface type class - in this case (FixWindow or PowerOn)
     */
    public Fixable getFixable (int errorcode, GreenhouseControls gc){
        //which returns the appropriate Fixable object to correct the error and reset the error code to zero.
        if (errorcode == 1){
            return new FixWindow(0, gc);
        }
        else return new PowerOn(0, gc);
    }















    /**
     * End of Alvee Hassan Akash code
     */

    //-------------------------------------------------------------------------


    public void printUsage() {
        screen.printStream.println("Correct format: ");
        screen.printStream.println("  java GreenhouseControls -f <filename>, or");
        screen.printStream.println("  java GreenhouseControls -d dump.out");
    }

    //---------------------------------------------------------

    public GreenhouseControls(String startCode, String fileName, Screen window){

        if (!(startCode.equals("-f")) && !(startCode.equals("-d")) ){
            printUsage();
        }

        // Creating object based on start code, -f is to make a new GreenhouseControls
        if (startCode.equals("-f")) {
            this.screen = window;
            this.screen.greenHouseStartRunning();
            createDatabase();

            events.add("LightOn");
            events.add("LightOff");

            Thread thread = new Thread(new Restart(0, fileName, this), "green house");
            thread.start();
        } // if

        // Retrieving object based on start code, -d is to retrieve old
        if (startCode.equals("-d")) {
            this.screen = window;
            screen.greenHouseStartRunning();

            Thread thread = new Thread(new Restore(0, fileName, this));
            thread.start();
        } // if
    } // GreenhouseControls


    //-----------------------------------------------------------------------------------
    // Methods are done

    /**
     * Sets GreenhouseControls current state as Key:Value pair in list
     * @param tuple - Tuple value - key:value pair
     */
    public void setVariable(Tuple<String, String> tuple){
        for (Tuple<String, String> originalTuple : database) {
            if (originalTuple.getKey().equals(tuple.getKey())){
                originalTuple.setValue(tuple.getValue());
            }
        }
    }

    /**
     * Shows the database in the console of print stream
     */
    public void showDB(){
        screen.getPrintStream().printf("%-15s %15s %n", "Key", "Value");
        screen.getPrintStream().printf("%-15s %15s %n", "____", "______");
        for (Tuple<String, String> tuple : database) {
            String key = tuple.getKey();
            String value = tuple.getValue();
            String line = String.format("%-15s %15s %n", key, value);

            screen.getPrintStream().print(line);
        }
    }

    /**
     * Returns the list of Tuple as a database
     * @return - List of Tuple value
     */
    public List<Tuple<String, String>> getDatabase() {
        return database;
    }

    /**
     * Returns the Thread Pool Executor from current object class,
     * so that it can be used to schedule
     * @return - PausableThreadPoolExecutor value
     */
    public PausableThreadPoolExecutor getPauseThread() {
        return pauseThread;
    }

    /**
     * it schedules our events in GreenhouseControls System
     * @param runnable - Runnable implemented object value
     * @param time - long value - schedule time to execute
     */
    public void scheduleToThread(Runnable runnable, long time){
        pauseThread.schedule(runnable, time, TimeUnit.MILLISECONDS);
    }

    /**
     * Shutdown the system. showing the reason.
     * @param problem - string value of the problem name
     */
    public void shutdown(String problem){
        this.screen.printStream.println("Emergency Shutdown !! \nReason is- " + problem +"\n");
        try {
            // writing file what causes the shutdown in the system
            WritingFile writingFile = new WritingFile(errorCode, false, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            this.screen.printStream.println("Before shutdown");
            screen.sentBackToSerialize(this);
            this.pauseThread.shutdownNow();
            //serializeObject(gc);
            //gc.screen.printStream.println("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15");
        }
    } // shutdown

    /**
     * adds sudden terminate event to GreenhouseControls system.
     * checks if the scheduling system has already ended or not.
     * @param event - Event value - it receives Terminate event from Screen
     */
    protected void addTerminateEvent(Event event){
        if (this.pauseThread.getQueue().isEmpty()) return;
        this.pauseThread.schedule(event, event.getDelayTime(), TimeUnit.MILLISECONDS);
        //Restart.pauseThread.shutdownNow();
    }




    /**
     * Returns the Screen reference in GreenhouseControls object
     * @return - Screen value
     */
    public Screen getScreen() {
        return screen;
    }

    /**
     * Returns the Error code saved in GreenhouseControls object
     * @return - int value
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the code to GreenhouseControls object
     * @param errorCode - int value
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * initializes the database with empty values
     */
    private void createDatabase() {
        database.add(new Tuple<String, String>("light", ""));
        database.add(new Tuple<String, String>("water", ""));
        database.add(new Tuple<String, String>("fan", ""));
        database.add(new Tuple<String, String>("thermostat", ""));
    }

    /**
     * list of Event's class name left to run
     * @return - String value
     */
    public List<String> getEvents() {
        return events;
    }


    //  public static void main(String[] args) {
//    try {
//      String option = args[0];
//      String filename = args[1];
//
//      if ( !(option.equals("-f")) && !(option.equals("-d")) ) {
//        System.out.println("Invalid option");
//        printUsage();
//      }
//
//      GreenhouseControls gc = new GreenhouseControls();
//
//      if (option.equals("-f")) {
//        //gc.eventsFile = filename;
//        //Screen.greenHouseStartRunning();
//        Thread thread = new Thread(new Restart(0, filename, gc));
//        thread.start();
//        //gc.addEvent(new Restart(0,filename, gc));
//
//        //event.run();
//        System.out.println();
//        //gc.run();
//      }
//
//      // Call the Restore to re-start the system from the dump.out file
//      if (option.equals("-d")) { Restore restore = new Restore(filename); }
//
//////       if any error codes sees, it will serialize the object
////      if (errorCode == 1 || errorCode == 2){
////        serializeObject(gc);
////        System.out.println("\nSystem is exiting");
////        System.exit(0);
////      } // if
//
//
//    }
//    catch (ArrayIndexOutOfBoundsException e) {
//      System.out.println("Invalid number of parameters");
//      printUsage();
//    }
//  } // main method


} ///:~
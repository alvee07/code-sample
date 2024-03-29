/**
 * Name: Alvee Hassan Akash
 * Student ID: 3433334
 * Program: 01
 * Course: COMP 308
 * Athabasca University
 */

/**
 * title: Bell.java
 * description: a basic Bell class
 * date: April 25, 2020
 * @author Alvee Hassan Akash
 * @version 1.0
 * @copyright 2020 Alvee Hassan Akash
 */

/**
 * DOCUMENTATION...
 */

/**
 * Bell
 *
 * Purpose and Description
 *
 * A class to ring a bell at a given time.
 *
 * This program does not use User input, all inputs are from directory based.
 *
 * Sun Java SDK version 1.3 or better.
 *
 * Compiling and running instructions
 * Assuming SDK 1.3 (or later) and the CLASSPATH are set up properly.
 * Change to the directory containing the source code.
 *
 * Compile:    See Application class file
 * Run:        See Application class file
 *
 */

/**
 * Classes
 *
 * public class Bell extends Event implements Runnable, Serializable
 *
 * Methods (Method documentations are with the methods)
 *
 * Constructors
 * public Bell(long delayTime, GreenhouseControls gc)
 *
 * public void action()
 *  - Override from Event class
 *
 * public String toString()
 *  - Show the Bing on screen
 *
 * public long getDelayTime()
 *  - Override from Event class
 *
 * public void run()
 *  - Override from Event
 *  - Implemented from Runnable
 *
 */

/**
 * CODE...
 */

import tme3.Event;

import java.io.Serializable;


public class Bell extends Event implements Runnable, Serializable {
    /**
     * Instance variables
     *  - ringsForBell - int value
     *  - timeInterval - long - 2000 (msec) from the start then increment by 2000
     */
    private int ringsForBell;
    private long timeInterval = 2000;
    protected GreenhouseControls gc;

    /**
     * Bell only rings for once
     * @param delayTime - long value
     */
    public Bell(long delayTime, GreenhouseControls gc) {
        super(delayTime);
        this.gc = gc;
    }

    /**
     * Bell rings for multiple times.
     * @param delayTime - long value
     * @param rings - int value - how many times Bells need to be called.
     */
    public Bell(long delayTime, int rings) {
        super(delayTime);
        ringsForBell = rings-1;
        for (int i = 0; i < ringsForBell; i ++){
            //addEvent(new Bell(delayTime+ timeInterval));
            timeInterval +=2000;
        }
    } // Bell constructor

    @Override
    public void action() {
        gc.screen.printStream.println("Yes its here");
    } // action

    @Override
    public long getDelayTime() {
        return super.delayTime;
    }
    @Override
    public String toString() { return "Bing!"; }

    @Override
    public void run() {
        gc.getScreen().changeImage("bing");

        gc.screen.printStream.println("Bing!");
    }

} // end of Bell class

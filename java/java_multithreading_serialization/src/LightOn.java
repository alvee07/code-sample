/**
 * Name: Alvee Hassan Akash
 * Student ID: 3433334
 * Program: 01
 * Course: COMP 308
 * Athabasca University
 */

/**
 * title: LightOn.java
 * description: a basic LightOn class
 * date: April 25, 2020
 * @author Alvee Hassan Akash
 * @version 1.0
 * @copyright 2020 Alvee Hassan Akash
 */

/**
 * DOCUMENTATION...
 */

/**
 * LightOn
 *
 * Purpose and Description
 *
 * A class to run LightOn at a given time.
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
 * public class LightOn extends Event implements Runnable, Serializable
 *
 * Methods (Method documentations are with the methods)
 *
 * Constructors
 * public LightOn(long delayTime, GreenhouseControls gc)
 *
 * public void action()
 *  - Override from Event class
 *
 * public String toString()
 *  - Show the light on on the screen
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

/**
 *  class LightOn
 */


public class LightOn extends Event implements Runnable, Serializable {
    protected GreenhouseControls gc;

    /**
     * Parameterised constructor
     * @param delayTime - long value
     * @param gc - GreenhouseControls value
     */
    public LightOn(long delayTime, GreenhouseControls gc) {
        super(delayTime);
        this.gc = gc;
    }

    @Override
    public void action() {
        // Put hardware control code here to
        // physically turn on the light.
        /**
         * Assignment requirements done
         */
//        light = true;
        System.out.println("Light is on from lightOn class");
    }


    public String toString() { return "Light is on"; }

    @Override
    public void run() {
        gc.setVariable(new Tuple<String, String>("light", "On"));

        gc.getScreen().changeImage("lighton");

        gc.screen.printStream.println("Light is on");

    }

    @Override
    public long getDelayTime() {
        return super.delayTime;
    }



}
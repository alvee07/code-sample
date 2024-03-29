/**
 * Name: Alvee Hassan Akash
 * Student ID: 3433334
 * Program: 01
 * Course: COMP 308
 * Athabasca University
 */

/**
 * title: WindowMalfunction.java
 * description: a basic WindowMalfunction class
 * date: April 25, 2020
 * @author Alvee Hassan Akash
 * @version 1.0
 * @copyright 2020 Alvee Hassan Akash
 */

/**
 * DOCUMENTATION...
 */

/**
 * WindowMalfunction
 *
 * Purpose and Description
 *
 * A class to run WindowMalfunction at a given time. it shutdowns and serialize it.
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
 * public class WindowMalfunction extends Event implements Runnable, Serializable
 *
 * Methods (Method documentations are with the methods)
 *
 * Constructors
 * public WindowMalfunction(long delayTime, GreenhouseControls gc)
 *
 * public void action()
 *  - Override from Event class
 *
 * public String toString()
 *  - Show the Window Malfunction on the screen
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
 *  class WindowMalfunction
 *  - sets the windowok variable
 *
 * action()
 *  - if windowok is false and set errorCode, throws exception, shutdown the system
 */
public class WindowMalfunction extends Event implements Runnable, Serializable {
    protected GreenhouseControls gc;

    /**
     * Parameterised Constructor
     * @param delayTime - long value
     * @param gc - GreenhouseControls value
     */
    public WindowMalfunction(long delayTime, GreenhouseControls gc) {
        super(delayTime);
        this.gc = gc;
        //windowok = false;
    }

    @Override
    public void action() {

          // windowok = false then goes here to set error code and throws ControllerException
            try {
                gc.setErrorCode(1);
                throw new ControllerException("Window Malfunction");
            } catch (ControllerException e) {
                gc.screen.printStream.println(e.toString());
            } finally {
                gc.getScreen().setThreadRunning(false);
                gc.getScreen().greenHouseEndRunning();
                //Restart.pauseThread.shutdownNow();
                gc.shutdown("Window Malfunction");
            }


    }// action

    public String toString() {
        return "Window Malfunction";
    }

    @Override
    public void run() {
        //gc.getScreen().changeImage("windowmalfunction");
        gc.screen.printStream.println("Window Malfunction");
        action();
    }
    @Override
    public long getDelayTime() {
        return super.delayTime;
    }


} // WindowMalfunction
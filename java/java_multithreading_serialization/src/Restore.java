/**
 * Name: Alvee Hassan Akash
 * Student ID: 3433334
 * Program: 01
 * Course: COMP 308
 * Athabasca University
 */

/**
 * title: Restore.java
 * description: a basic Restore class to retrieve the serializable object
 * date: April 25, 2020
 * @author Alvee Hassan Akash
 * @version 1.0
 * @copyright 2020 Alvee Hassan Akash
 */

/**
 * DOCUMENTATION...
 */

/**
 * Restore
 *
 * Purpose and Description
 *
 * A class to run Restore at a given time to deserialize the GreenhouseControls object and
 * run it from where it left before, and fix the error.
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
 * public class Restore extends Event implements Runnable, Serializable
 *
 * Methods (Method documentations are with the methods)
 *
 * Constructors
 * public Restore(long delayTime, GreenhouseControls gc)
 *
 * public void action()
 *  - Override from Event class
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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


/**
 *  class Restore.java
 *  - restore the system from console given file (dump.out)
 *  - writes the fix.log file
 *
 * Note: idea taken from see {@link} https://www.geeksforgeeks.org/object-serialization-inheritance-java/
 */
public class Restore extends Event implements Runnable, Serializable {
    protected  GreenhouseControls gc;
    protected String filename;

    /**
     * Parameterised constructor
     * @param delayTime - long value
     * @param filename - string value
     * @param gc - GreenhouseControls value
     */
    public Restore(long delayTime, String filename, GreenhouseControls gc){
        super(delayTime);
        this.gc = gc;
        this.filename = filename;

    } // public Restore(String filename)

    @Override
    public void action() {
        try {
            GreenhouseControls newGC;
            
            FileInputStream dumpFileName = new FileInputStream(filename);
            ObjectInputStream dumpFileIn = new ObjectInputStream(dumpFileName);

            // Method for deserialization of object
            // Reading the object from file
            newGC = (GreenhouseControls) dumpFileIn.readObject();

            dumpFileIn.close();
            dumpFileName.close();

            // Event that fixes the problem
            //Event event = (Event) newGC.getFixable(newGC.getError());

            //this.gc.reStart();
            gc.screen.printStream.println(newGC.getEvents().size());
            gc.screen.printStream.println();

            for (String r : newGC.getEvents()) {
                //Event event = r;

                Class<?> eventClass = Class.forName(r);
                Constructor<?> constructor = eventClass.getConstructor(long.class, GreenhouseControls.class);
                Event newEvent = (Event) constructor.newInstance(3000, gc);

                Thread t = new Thread(newEvent);
                t.start();
            }

            // Add event if you wanna see the changes in the list what is fixed
            //newGC.addEvent(event);

            // Run the rest of the events from the list
            //this.gc.run();

        } // end of try
        catch(IOException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        gc.screen.printStream.println("Restore: Restoring GreenhouseControls");
        action();
    }



    @Override
    public long getDelayTime() {
        return super.delayTime;
    }
} // Restore
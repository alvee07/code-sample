/**
 * Name: Alvee Hassan Akash
 * Student ID: 3433334
 * Program: 01
 * Course: COMP 308
 * Athabasca University
 */

/**
 * title: PausableThreadPoolExecutor.java
 * description: a basic PausableThreadPoolExecutor class, JFrame window.
 * date: April 25, 2020
 * @author Alvee Hassan Akash
 * @version 1.0
 * @copyright 2020 Alvee Hassan Akash
 */

/**
 * DOCUMENTATION...
 */

/**
 * PausableThreadPoolExecutor
 *
 * Purpose and Description
 *
 * A class to controls threads with the ability of controlling the GreenhouseControls object.
 * base class was found @link https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ThreadPoolExecutor.html
 *
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
 * public class PausableThreadPoolExecutor extends ScheduledThreadPoolExecutor implements Serializable
 *
 * Methods (Method documentations are with the methods)
 *
 * Constructors
 * public PausableThreadPoolExecutor(int numberOfThreads, GreenhouseControls gc)
 *
 *
 *
 * protected void beforeExecute(Thread t, Runnable r)
 *
 * public void pause()
 *
 * public void resume()
 *
 *
 *
 *
 */

/**
 * CODE...
 */


import java.io.Serializable;
import java.util.concurrent.*;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PausableThreadPoolExecutor extends ScheduledThreadPoolExecutor implements Serializable {
    private boolean isPaused;
    private ReentrantLock pauseLock = new ReentrantLock();
    private Condition unpaused = pauseLock.newCondition();
    protected GreenhouseControls gc;

    /**
     * Parameterised constructor
     * @param numberOfThreads - number of threads will run the events
     * @param gc - GreenhouseControls object
     * by Alvee Hassan Akash
     */
    public PausableThreadPoolExecutor(int numberOfThreads, GreenhouseControls gc) {
        super(numberOfThreads);
        this.gc = gc;
    }


    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        pauseLock.lock();
        try {
            while (isPaused) unpaused.await();
        } catch(InterruptedException ie) {
            t.interrupt();
        } finally {
            pauseLock.unlock();
        }
    }


    public void pause() {
        System.out.println("System Paused");

        pauseLock.lock();
        try {
            isPaused = true;
        } finally {
            pauseLock.unlock();
        }
    }


    public void resume() {
        System.out.println("System Resume");

        pauseLock.lock();
        try {
            isPaused = false;
            unpaused.signalAll();
        } finally {
            pauseLock.unlock();
        }
    }


}

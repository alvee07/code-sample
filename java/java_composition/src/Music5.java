/**
 * Name: Alvee Hassan Akash
 * Student ID: 3433334
 * Program: 04
 * Course: COMP 308
 * Athabasca University
 */


/**
 * title: Music5.java
 * description: a basic musical idea of cord, instruments, playable.
 * date: March 05, 2020
 * Note: Almost all of the codes are taken from this page for assignment purpose.
 * @see https://github.com/BruceEckel/TIJ4-code/tree/master/examples/polymorphism
 *
 * Note: I have modified the code to get done the assignment of the class COMP 308. (exercise 10)
 * @author Alvee Hassan Akash
 */

/**
 * DOCUMENTATION...
 */

/**
 *
 * Music5
 *
 * Purpose and Description
 *
 * Modify Music5.java by adding a Playable interface. Move the play( ) declaration from Instrument to Playable.
 * Add Playable to the derived classes by including it in the implements list. Change tune( ) so that it takes a
 * Playable instead of an Instrument.
 *
 * This program does not use User input, all inputs are in Main.java file.
 *
 * Sun Java SDK version 1.3 or better.
 *
 * Compiling and running instructions
 * Assuming SDK 1.3 (or later) and the CLASSPATH are set up properly.
 * Change to the directory containing the source code.
 *
 * Compile:    javac Cycle.java
 * Run:        java Cycle
 * Document:   javadoc Cycle.java
 */

/**
 *
 * Classes
 *
 * public class Music5
 *
 * Methods (Method documentations are with the methods)
 *
 * static void tune(Playable i)
 * static void tuneAll(Playable[] e)
 *
 *
 * Interfaces
 *
 * interface Instrument
 * interface Playable
 *
 * other Classes
 *
 * class Wind implements Instrument, Playable
 * class Percussion implements Instrument, Playable
 * class Stringed implements Instrument, Playable
 * class Brass extends Wind
 * class Woodwind extends Wind
 *
 */


/**
 * CODE...
 */
/** Java core packages */

enum Note {
    MIDDLE_C, C_SHARP, B_FLAT; // Etc.
}

interface Instrument {
    // Compile-time constant:
    int VALUE = 5; // static & final
    // Cannot have method definitions:

    void adjust();

}
// this is added by Alvee Hassan Akash
// Also implemented Playable, so that system can read the instance objects from it
interface Playable {
    void play(Note n); // Automatically public
}

class Wind implements Instrument, Playable {
    public void play(Note n) {
        System.out.println(this + ".play() " + n);
    }
    public String toString() { return "Wind"; }
    public void adjust() {
        System.out.println(this + ".adjust()"); }
}

class Percussion implements Instrument, Playable {
    public void play(Note n) {
        System.out.println(this + ".play() " + n);
    }
    public String toString() { return "Percussion"; }
    public void adjust() {
        System.out.println(this + ".adjust()"); }
}

class Stringed implements Instrument, Playable {
    public void play(Note n) {
        System.out.println(this + ".play() " + n);
    }
    public String toString() { return "Stringed"; }
    public void adjust() {
        System.out.println(this + ".adjust()"); }
}

class Brass extends Wind {
    public String toString() { return "Brass"; }
}

class Woodwind extends Wind {
    public String toString() { return "Woodwind"; }
}

public class Music5 {
    // Doesn't care about type, so new types
    // added to the system still work right:
    static void tune(Playable i) {
        // ...
        i.play(Note.MIDDLE_C);
    }
    static void tuneAll(Playable[] e) {
        for(Playable i : e)
            tune(i);
    }
}//:~

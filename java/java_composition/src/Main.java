/**
 * Name: Alvee Hassan Akash
 * Student ID: 3433334
 * Program: Main Method to see the programs testing 1, 2, 3, & 4.
 * Course: COMP 308
 * Athabasca University
 *
 * NOTE: Most of the programing is self-documenting or self-describing.
 */


/**
 * Main.java
 *
 * Method: public static void ride(Cycle anyCycleTypeObject) - to show the up cast from derived class to base class
 *
 * Requirements: class files as for running instructions.
 * Program Purpose: testing for programs 1, 2, 3, 4.
 *
 *
 * Compile Instructions:    javac *.java
 *
 * Running Instructions:    java Main
 *
 */

/**
 * CODE...
 */


public class Main {

    /**
     * Main method of the TME1, to test all the programs included in assignments 1.
     * @param args - none for this program
     */
    public static void main(String[] args) {

        /**
         * Program 01 output
         */

        System.out.println("\nWelcome to TME 1 for COMP 308");
        System.out.println("------------------------------\n");
        System.out.println("This is Program 1");
        System.out.println("------------------------------\n");

        Circle c = new Circle(-1, -3 , 6);
        System.out.println("Circle c = new Circle(-1, -3 , 6);");
        c.printAttributes();
        c.move(3,3);
        System.out.println("c.move(3,3);");
        c.printAttributes();
        System.out.println("c.isInside(-6, -6)");
        System.out.println(c.isInside(-6, -6));


        /**
         * Program 02 output
         */

        System.out.println("\n\nThis is Program 2");
        System.out.println("------------------------------\n");

        FullName fullNameToMailing = new FullName("Mr.", "Kishore", "Kumar", "Singh");
        FullName fullNameFromMailing = new FullName("Mr.", "Tahsin", "kaml", "khan");

        MailingAddress mailingAddressTo = new MailingAddress(fullNameToMailing, "4719 49 Ave", "Camrose", "AB", "T4V 2R3");
        MailingAddress mailingAddressFrom = new MailingAddress(fullNameFromMailing, "4603 50 street", "Camrose", "AB", "T4V 1N9");

        ShippingLabel label = new ShippingLabel(mailingAddressTo, mailingAddressFrom);
        System.out.println(label);



        /**
         * Program 03 output
         */

        System.out.println("\n\nThis is Program 3");
        System.out.println("------------------------------\n");

        Cycle unicycle = new Unicycle();
        ride(unicycle);

        Cycle bicycle = new Bicycle();
        ride(bicycle);

        Cycle tricycle = new Tricycle();
        ride(tricycle);


        /**
         * Program 04 output
         */

        System.out.println("\n\nThis is Program 4");
        System.out.println("------------------------------\n");

        Playable[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        Music5.tuneAll(orchestra);

    }// end of main method

    /**
     * Up cast calls to Cycle class, and prints the wheels number of each derived classes on the screen
     * @param anyCycleTypeObject
     */
    public static void ride(Cycle anyCycleTypeObject){
        anyCycleTypeObject.wheels();
    }
}//:~

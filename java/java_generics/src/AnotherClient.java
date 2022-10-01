/**
 * Name: Alvee Hassan Akash
 * Student ID: 3433334
 * Program: 02 - Main Method to see the programs testing 2.
 * Course: COMP 308
 * Athabasca University
 *
 * NOTE: Most of the programing is self-documenting or self-describing.
 */

/**
 * title: AnotherClient.java
 * description: a basic AnotherClient class to test the order Processing
 * date: March 25, 2020
 * @author Alvee Hassan Akash
 * @version 1.0
 * @copyright 2020 Alvee Hassan Akash
 */

/**
 * DOCUMENTATION...
 */

/**
 * AnotherClient.java
 *
 * Requirements: class files as for running instructions.
 * Program Purpose: testing for programs 2.
 *
 *
 * Compile Instructions:    javac *.java
 *
 * Running Instructions:    java AnotherClient
 *
 */

/**
 * CODE...
 */

public class AnotherClient {

    public static void main(String[] args) {
        System.out.println("------------------------------------------------------------");
        System.out.println("This is the Another Client class testing ComputerPartyOrder");
        System.out.println("------------------------------------------------------------\n");

/**
 * All the Products in this program system Client class to test.
 */

        ComputerPart computerPart = new ComputerPart(5);
        Motherboard motherboard = new Motherboard("asus", 5);
        RAM ram = new RAM("mac", 500, 5);
        Drive drive = new Drive("drive", 2, 5);
        Peripheral peripheral = new Peripheral(5);
        Printer printer = new Printer("Dell", 5);
        Monitor monitor = new Monitor("asus", 5);
        Service service = new Service(5);
        AssemblyService assemblyService = new AssemblyService("BB", 1);
        DeliveryService deliveryService = new DeliveryService("CP", 2);
        Cheese cheese = new Cheese(2);
        Mozzarella mozzarella = new Mozzarella(9);
        Cheddar cheddar = new Cheddar(9);
        Fruit fruit = new Fruit(9);
        Apple apple = new Apple(10);
        Orange orange= new Orange(1);

//-------------------------------------------------------------------------------------


        ComputerPartyOrder<Product> computerPartyOrder = new ComputerPartyOrder<>();
        computerPartyOrder.addProduct(fruit);
        //computerPartyOrder.addProduct(printer);
        //computerPartyOrder.addProduct(drive);
        //computerPartyOrder.addProduct(apple);
        computerPartyOrder.addProduct(computerPart);
        computerPartyOrder.addProduct(peripheral);
        //computerPartyOrder.addProduct(deliveryService);
        //computerPartyOrder.addProduct(mozzarella);
        computerPartyOrder.addProduct(cheese);
        computerPartyOrder.addProduct(service);
        //computerPartyOrder.addProduct(assemblyService);


        OrderProcessor<GenericOrder<Product>> orderProcessor = new OrderProcessor<>();
        orderProcessor.accept(computerPartyOrder);

        // call it before you call Dispatch everything.
        // process method processes the order into Tuple based List
        orderProcessor.process();

        orderProcessor.dispatchComputerParts();
        orderProcessor.dispatchPeripherals();
        orderProcessor.dispatchCheese();
        orderProcessor.dispatchFruit();
        orderProcessor.dispatchServices();

    } // end of public static void main
}

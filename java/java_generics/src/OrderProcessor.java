/**
 * Name: Alvee Hassan Akash
 * Student ID: 3433334
 * Program: 01
 * Course: COMP 308
 * Athabasca University
 */

/**
 * title: OrderProcessor.java
 * description: a basic Order Processor collection sorting class
 * date: March 25, 2020
 * @author Alvee Hassan Akash
 * @version 1.0
 * @copyright 2020 Alvee Hassan Akash
 */

/**
 * DOCUMENTATION...
 */

/**
 * OrderProcessor
 *
 * Purpose and Description
 *
 * a class called OrderProcessor that represents a orders in the internal collection of GenericOrder
 * into collections of ComputerPart, Peripheral, Cheese, Fruit, and Service.
 * And associates each object with the unique identifier from Generic Class var 'id'.
 *
 * This program does not use User input, all inputs are in Main.java file.
 *
 * Sun Java SDK version 1.3 or better.
 *
 * Compiling and running instructions
 * Assuming SDK 1.3 (or later) and the CLASSPATH are set up properly.
 * Change to the directory containing the source code.
 *
 * Compile:    See AnotherClient class file
 * Run:        See AnotherClient class file
 *
 */

/**
 * Classes
 *
 * public class OrderProcessor<T extends GenericOrder>
 *
 * Methods (Method documentations are with the methods)
 *
 * Constructors
 * public OrderProcessor()
 *
 * Instance Variables
 *
 * This is store all the Orders that has "accept"ed from the method of this class.
 *  - private final List<GenericOrder<Product>> allKindOfProductsFromGenericOrder;
 *
 * These are the List of each category of object that has created to store
 * internal collection of ComputerPart, Peripheral, Cheese, Fruit, and Service.
 *  - private List<Tuple<ComputerPart, Long>> ComputerPart = new ArrayList<>();
 *  - private List<Tuple<Peripheral, Long>> Peripheral = new ArrayList<>();
 *  - private List<Tuple<Cheese, Long>> Cheese = new ArrayList<>();
 *  - private List<Tuple<Fruit, Long>> Fruit = new ArrayList<>();
 *  - private List<Tuple<Service, Long>> Service = new ArrayList<>();
 *
 */

import java.util.ArrayList;
import java.util.List;

/**
 * CODE...
 */

public class OrderProcessor<T extends GenericOrder<Product>> {

    /**
     * Instance Variables
     */

    private final List<GenericOrder<Product>> allKindOfProductsFromGenericOrder;
    private List<Tuple<ComputerPart, Long>> ComputerPart = new ArrayList<>();
    private List<Tuple<Peripheral, Long>> Peripheral = new ArrayList<>();
    private List<Tuple<Cheese, Long>> Cheese = new ArrayList<>();
    private List<Tuple<Fruit, Long>> Fruit = new ArrayList<>();
    private List<Tuple<Service, Long>> Service = new ArrayList<>();

    /**
     * Constructor
     */
    public OrderProcessor(){
        this.allKindOfProductsFromGenericOrder = new ArrayList<>();
    }

    /**
     * Accepts a GenericOrder or any of its subclass objects and stores it in any internal
     * collection of OrderProcessor var "allKindOfProductsFromGenericOrder"
     * @param product - Generic Object value
     */
    @SuppressWarnings("safe")
    public void accept(GenericOrder<Product> product){
        allKindOfProductsFromGenericOrder.add(product);
    }// end of public void accept

    /**
     * Sorts all accepted orders in "allKindOfProductsFromGenericOrder" of GenericOrder object
     * into collections of ComputerPart, Peripheral, Cheese, Fruit, and Service.
     * Associates each object with the unique identifier by Using Custom made Tuple Class.
     * Checks the each instance of object and store them in correct place.
     */
    public void process(){
        for (GenericOrder<Product> temp : allKindOfProductsFromGenericOrder){
            for (Object object : temp.getProducts()){

                if (object instanceof ComputerPart){
                    Tuple<ComputerPart, Long> tuple = new Tuple<>((ComputerPart) object, temp.getId());
                    ComputerPart.add(tuple);
                }

                if (object instanceof Peripheral){
                    Tuple<Peripheral, Long> tuple = new Tuple<>((Peripheral) object, temp.getId());
                    Peripheral.add(tuple);
                }

                if (object instanceof Cheese){
                    Tuple<Cheese, Long> tuple = new Tuple<>((Cheese) object, temp.getId());
                    Cheese.add(tuple);
                }

                if (object instanceof Fruit){
                    Tuple<Fruit, Long> tuple = new Tuple<>((Fruit) object, temp.getId());
                    Fruit.add(tuple);
                }

                if (object instanceof Service){
                    Tuple<Service, Long> tuple = new Tuple<>((Service) object, temp.getId());
                    Service.add(tuple);
                }
            } // for (Object object : temp.getProducts())
        } // for (GenericOrder temp : listOfProducts)
    } // end of public void process()

    /**
     * dispatchXXX; // this method simulates the dispatch of the sorted collections.
     * For example, the method dispatchComputerParts()
     * so I made 5 methods to print the 5 lists.
     */

    /**
     * Simulates the dispatch of the sorted collections of Computer Parts
     * Function also sorts the order according to the TME structure like
     * Motherboard --> RAM --> Drive
     *
     * Motherboard name=asus, price=5.0, order number= 1
     * Motherboard name=asus, price=5.0, order number= 3
     * RAM name=mac, size=500, price=5.0, order number= 3
     * Drive name=drive, speed=2, price=5.0, order number= 1
     */
    public void dispatchComputerParts(){
        List<Tuple<ComputerPart, Long>> regComputerPart = new ArrayList<>();
        List<Tuple<ComputerPart, Long>> motherboardList = new ArrayList<>();
        List<Tuple<ComputerPart, Long>> ramList = new ArrayList<>();
        List<Tuple<ComputerPart, Long>> driveList = new ArrayList<>();

        for (Tuple<ComputerPart, Long> item : ComputerPart){
            Product product = item.getProduct();
            if (product instanceof Motherboard){
                motherboardList.add(item);
            }
            if (product instanceof RAM){
                ramList.add(item);
            }
            if (product instanceof Drive){
                driveList.add(item);
            }
            if (product.getClass().equals(ComputerPart.class)){
                regComputerPart.add(item);
            }
        }
        List<Tuple<ComputerPart, Long>> computerParts = new ArrayList<>();
        computerParts.addAll(regComputerPart);
        computerParts.addAll(motherboardList);
        computerParts.addAll(ramList);
        computerParts.addAll(driveList);

        ComputerPart = computerParts;
        System.out.println("----- Displaying Computer Parts Order ----- \n");
        for (Tuple<ComputerPart, Long> item : ComputerPart){
            Product product = item.getProduct();
            System.out.println(product.productDetails() + ", order number= "+item.getId());
        }
        System.out.println();
    }

    /**
     * Simulates the dispatch of the sorted collections of Peripherals
     * Function also sorts the order according to the TME structure like
     * Printer --> Printer
     *
     * Printer name=Dell, price=5.0, order number= 3
     * Printer name=asus, price=5.0, order number= 1
     */
    public void dispatchPeripherals(){
        List<Tuple<Peripheral, Long>> regPeripheral = new ArrayList<>();
        List<Tuple<Peripheral, Long>> printerList = new ArrayList<>();
        List<Tuple<Peripheral, Long>> monitorList = new ArrayList<>();

        for (Tuple<Peripheral, Long> item : Peripheral){
            Product product = (Product) item.getProduct();
            if (product instanceof Printer){
                printerList.add(item);
            }
            if (product instanceof Monitor){
                monitorList.add(item);
            }
            if (product.getClass().equals(Peripheral.class)){
                regPeripheral.add(item);
            }
        }
        List<Tuple<Peripheral, Long>> peripheralList = new ArrayList<>();
        peripheralList.addAll(regPeripheral);
        peripheralList.addAll(printerList);
        peripheralList.addAll(monitorList);

        Peripheral = peripheralList;
        System.out.println("----- Displaying Peripheral Order ----- \n");
        for (Tuple<Peripheral, Long> item : Peripheral){
            Product product = item.getProduct();
            System.out.println(product.productDetails() + ", order number= "+item.getId());
        }
        System.out.println();
    }

    /**
     * Simulates the dispatch of the sorted collections of Cheese
     * Function also sorts the order according to the TME structure like
     * Cheddar --> Mozzarella
     *
     * Cheese name=Cheddar, price=9.0, order number= 5
     * Cheese name=Mozzarella, price=9.0, order number= 5
     */
    public void dispatchCheese(){
        List<Tuple<Cheese, Long>> regCheeseList = new ArrayList<>();
        List<Tuple<Cheese, Long>> cheddarList = new ArrayList<>();
        List<Tuple<Cheese, Long>> mozzarellaList = new ArrayList<>();

        for (Tuple<Cheese, Long> item : Cheese){
            Product product = (Product) item.getProduct();
            if (product instanceof Cheddar){
                cheddarList.add(item);
            }
            if (product instanceof Mozzarella){
                mozzarellaList.add(item);
            }
            if (product.getClass().equals(Cheese.class)){
                regCheeseList.add(item);
            }
        }
        List<Tuple<Cheese, Long>> cheeseList = new ArrayList<>();
        cheeseList.addAll(regCheeseList);
        cheeseList.addAll(cheddarList);
        cheeseList.addAll(mozzarellaList);

        Cheese = cheeseList;
        System.out.println("----- Displaying Cheese Order ----- \n");
        for (Tuple<Cheese, Long> item : cheeseList){
            Product product = item.getProduct();
            System.out.println(product.productDetails() + ", order number= "+item.getId());
        }
        System.out.println();
    }

    /**
     * Simulates the dispatch of the sorted collections of Fruit
     * Function also sorts the order according to the TME structure like
     * Apple --> Orange
     *
     * Fruit name=Apple, price=10.0, order number= 5
     * Fruit name=Orange, price=1.0, order number= 4
     */
    public void dispatchFruit(){
        List<Tuple<Fruit, Long>> regFruit = new ArrayList<>();
        List<Tuple<Fruit, Long>> appleList = new ArrayList<>();
        List<Tuple<Fruit, Long>> orangeList = new ArrayList<>();

        for (Tuple<Fruit, Long> item : Fruit){
            Product product = (Product) item.getProduct();
            if (product instanceof Apple){
                appleList.add(item);
            }
            if (product instanceof Orange){
                orangeList.add(item);
            }
            if (product.getClass().equals(Fruit.class)){
                regFruit.add(item);
            }
        }
        List<Tuple<Fruit, Long>> fruitList = new ArrayList<>();
        fruitList.addAll(regFruit);
        fruitList.addAll(appleList);
        fruitList.addAll(orangeList);

        Fruit = fruitList;
        System.out.println("----- Displaying Fruit Order ----- \n");
        for (Tuple<Fruit, Long> item : fruitList){
            Product product = item.getProduct();
            System.out.println(product.productDetails() + ", order number= "+item.getId());
        }
        System.out.println();
    }

    /**
     * Simulates the dispatch of the sorted collections of Fruit
     * Function also sorts the order according to the TME structure like
     * AssemblyService --> DeliveryService
     *
     * AssemblyService name=BB, price=1.0, order number= 5
     * DeliveryService name=CP, price=2.0, order number= 4
     */
    public void dispatchServices(){
        List<Tuple<Service, Long>> regService = new ArrayList<>();
        List<Tuple<Service, Long>> assemblySList = new ArrayList<>();
        List<Tuple<Service, Long>> deliverySList = new ArrayList<>();

        for (Tuple<Service, Long> item : Service){
            Product product = (Product) item.getProduct();
            if (product instanceof AssemblyService){
                assemblySList.add(item);
            }
            if (product instanceof DeliveryService){
                deliverySList.add(item);
            }
            if (product.getClass().equals(Service.class)){
                regService.add(item);
            }
        }
        List<Tuple<Service, Long>> serviceList = new ArrayList<>();
        serviceList.addAll(regService);
        serviceList.addAll(assemblySList);
        serviceList.addAll(deliverySList);

        Service = serviceList;
        System.out.println("----- Displaying Service Order ----- \n");
        for (Tuple<Service, Long> item : Service){
            Product product = item.getProduct();
            System.out.println(product.productDetails() + ", order number= "+item.getId());
        }
        System.out.println();
    }


}///:~
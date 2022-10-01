
/******************************************************************
 * COMP308 Java for Programmer, 
 * SCIS, Athabasca University
 *
 * Assignment: TME2
 * @author: Steve Leung
 * @date  : Oct 21, 2005
 *
 ******************************************************************/


abstract class Product {
    protected float price;

    // return the price of a particular product
    abstract float price();
    abstract String productDetails();
}

//------------------------------------------------------------
// I added to complete the assignment
interface ComputerInterface {}
interface PartyTrayInterface {}
//interface CompPartyOrder{}

class ComputerPart extends Product implements ComputerInterface {
    public ComputerPart(float p) {
        price = p;
    }
    public float price() { return price; }
    public String productDetails(){
        return "ComputerPart price=$"+price;
    }
}
class Motherboard extends ComputerPart {
    protected String manufacturer;
    public Motherboard(String mfg, float p) {
        super(p);
        manufacturer = mfg;
    }
    public String getManufacturer() { return manufacturer; }
    public String productDetails(){
        return "Motherboard name="+manufacturer+", price=$"+price;
    }
}
class RAM extends ComputerPart {
    protected int size;
    protected String manufacturer;
    public RAM(String mfg, int size, float p) {
        super(p);
        this.manufacturer = mfg;
        this.size = size;
    }
    public String getManufacturer() { return manufacturer; }
    public String productDetails(){
        return "RAM name="+manufacturer+", size="+size+", price=$"+price;
    }
}
class Drive extends ComputerPart {
    protected String type;
    protected int speed;
    public Drive(String type, int speed, float p) {
        super(p);
        this.type = type;
        this.speed = speed;
    }
    public String getType() { return type; }
    public int getSpeed() { return speed; }
    public String productDetails(){
        return "Drive name="+type+", speed="+speed+", price=$"+price;
    }
}


class Peripheral extends Product implements ComputerInterface {
    public Peripheral(float p) {
        price = p;
    }
    public float price() { return price; }
    public String productDetails(){
        return "Peripheral price=$"+price;
    }
}
class Printer extends Peripheral {
    protected String model;
    public Printer(String model, float p) {
        super(p);
        this.model = model;
    }
    public String getModel() { return model; }
    public String productDetails(){
        return "Printer name="+model+", price=$"+price;
    }
}
class Monitor extends Peripheral {
    protected String model;
    public Monitor(String model, float p) {
        super(p);
        this.model = model;
    }
    public String getModel() { return model; }
    public String productDetails(){
        return "Monitor name="+model+", price=$"+price;
    }
}

class Service extends Product implements ComputerInterface, PartyTrayInterface {
    public Service(float p) {
        price = p;
    }
    public float price() { return price; }
    public String productDetails(){
        return "Service price=$"+price;
    }
}
class AssemblyService extends Service {
    String provider;
    public AssemblyService(String pv, float p) {
        super(p);
        provider = pv;
    }
    public String getProvider() { return provider; }
    public String productDetails(){
        return "AssemblyService name="+provider+", price=$"+price;
    }
}
class DeliveryService extends Service {
    String courier;
    public DeliveryService(String c, float p) {
        super(p);
        courier = c;
    }
    public String getCourier() { return courier; }
    public String productDetails(){
        return "DeliveryService name="+courier+", price=$"+price;
    }
}

//-------------------------------------------------------------
class Cheese extends Product implements PartyTrayInterface {
    public Cheese(float p) {
        price = p;
    }
    public float price() { return price; }
    public String productDetails(){
        return "Cheese price=$"+price;
    }
}
class Cheddar extends Cheese {
    public Cheddar(float p) {
        super(p);
    }
    public String productDetails(){
        return "Cheese name=Cheddar, price=$"+price;
    }
}
class Mozzarella extends Cheese {
    public Mozzarella(float p) {
        super(p);
    }
    public String productDetails(){
        return "Cheese name=Mozzarella, price=$"+price;
    }
}

class Fruit extends Product implements PartyTrayInterface {
    public Fruit(float p) {
        price = p;
    }
    public float price() { return price; }
    public String productDetails(){
        return "Fruit price =$"+price;
    }
}
class Apple extends Fruit {
    public Apple(float p) {
        super(p);
    }

    public String productDetails(){
        return "Fruit name=Apple, price=$"+ price;
    }
}
class Orange extends Fruit {
    public Orange(float p) {
        super(p);
    }
    public String productDetails(){
        return "Fruit name=Orange, price=$"+ price;
    }
}
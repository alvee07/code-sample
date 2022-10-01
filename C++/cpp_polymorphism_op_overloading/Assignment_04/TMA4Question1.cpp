//: TMA4Question1.cpp

/*
 Title: TMA4Question1.cpp
 Description: Class, operator overloading with C++
 Date: January 30, 2020
 Author: Alvee H. Akash
 ID: 3433334
 Version: 1.0
 Copyright: 2020 Alvee H. Akash
 */


/*
 DOCUMENTATION
 
 Program Purpose:
 Documentation followed as GoodDocs.cpp,
 test plans are showed in the next paragraph,
 and comments are inline comments for better understanding.
 keyboard input N/A.
 
 Compile (Assuming GCC compiler istalled): g++ -o TMA4Question1 TMA4Question1.cpp
 Execution (assuming Cygwin is running): ./TMA4Question1
 
 Notes: in g++, main return type int
 
 Classes: Point, Shape, Circle, Square.
 
 Variables:
 sqrObject - Shape Square - Instance of Shape class
 square - Shape Square - Instance of Shape class
 cirObject - Shape Circle - Instance of Shape class
 circle - Shape Circle - Instance of Shape class

 
 */

/*
 TEST PLAN
 
 Normal case:
 Point x: 0    y: 0
 Point x: 10    y: 0
 Point x: 10    y: 10
 Point x: 0    y: 10

 Point + operator overloading
 Point x: 10    y: 10
 Point x: 10    y: 0
 Point x: 20    y: 10

 Area of this 4 points shape is 100
 Perimeter of this 4 points shape is 40
 Circle area is 28.2735
 Circle perimeter is 18.849


 Given attributes from Question

 Circle area is 1661.85
 Circle perimeter is 144.509

 Given attribites for Square
 Point x: 5    y: -5
 Point x: -10    y: 7
 Point x: 4    y: 23
 Point x: -6    y: 12
 This is not square
 This is not Square
 
 Bad Case:
 Memory allocation problem might occur, if there is any memory hardware problem.
 
 Discussion:
 This program creates classes Point, Shape, Circle, Square. Shape is the base class for Circle and Square class. This is an example of polymorphism. Point is the composition of all classes. All the classes consist Point class. This program has some heavy math calculation how to check if it is a square or not, if it is, then show its area and perimeter, same goes for circle class.
 Triangle class is missing from the program.
 */

// Header files
#include <stdio.h>
#include <iostream>
#include <cmath>
using namespace std;

// Point class
class Point{
public:
    int x;
    int y;
    
    // default constructor
    Point(){}
    
    // parameterized constructor
    Point(int xCordinate, int yCordinate){
        x = xCordinate;
        y = yCordinate;
    } // Point
    
    // point addition
    Point operator+(Point object){
        Point newObject;
        newObject.x = x + object.x;
        newObject.y = y + object.y;
        return newObject;
    } // operator+
    
    // point subtract
    Point operator-(Point object){
        Point newObject;
        newObject.x = x - object.x;
        newObject.y = y - object.y;
        return newObject;
    } // operator-
    
    // Friend class helps to use ostream for this class
    friend ostream& operator<< (ostream &out, const Point &newObject);
}; // Point
// printing on the ostream class, overloading << operator
ostream& operator<< (ostream &out, const Point &newObject)
{
    out << "Point x: "<< newObject.x << "\ty: "<< newObject.y << endl;
    return out;
}

// Shape class
class Shape{
public:
    // area of this shape
    virtual void getAreaOfShape(){}
    // perimeter of this shape
    virtual void getPerimeterOfShape(){}
}; // Shape


// Circle class
class Circle: public Shape{
public:
    Point dot;
    float radius;
    
    // default constructor
    Circle(){}
    
    // parameterized Constructor
    Circle(Point point, float rad){
        dot = point;
        radius = rad;
    }
    
    // Circle's area calculations
    void getAreaOfShape(){
        float pi = 3.1415;
        float area = 0;
        area = pi * pow(radius, 2);
        cout << "Circle area is " << area << endl;
    } // getAreaOfShape
    
    // Circle's perimeter calculations
    void getPerimeterOfShape(){
        cout << "Circle perimeter is " << 2 * radius * 3.1415 << endl;
    } // getPerimeterOfShape
}; // Circle class


// Square class
class Square: public Shape{
public:
    Point a, b, c, d;
    
    // default constructor
    Square(){}
    
    // parameterized Constructor
    Square(Point aInput, Point bInput, Point cInput, Point dInput){
        a = aInput;
        b = bInput;
        c = cInput;
        d = dInput;
    }
    // check if the given square is really square or not
    bool isSquare(){
        int oneSide = sqrt(pow(a.x - b.x, 2) + pow(a.y - b.y, 2));
        int secondSide = sqrt(pow(b.x - c.x, 2) + pow(b.y - c.y, 2));
        int thirdSide = sqrt(pow(c.x - d.x, 2) + pow(c.y - d.y, 2));
        int fourthSide = sqrt(pow(d.x - a.x, 2) + pow(d.y - a.y, 2));
        if (oneSide == secondSide && secondSide == thirdSide &&
            thirdSide == fourthSide && fourthSide == oneSide) {
            return true;
        }
        //cout << oneSide << secondSide << thirdSide << fourthSide;
        return false;
    } // isSquare
    
    // Square's area calculations
    void getAreaOfShape(){
        float area = 0;
        if (isSquare()) {
            area = ((a.x * b.y) - (a.y * b.x)) + ((b.x * c.y) - (b.y * c.x)) + ((c.x * d.y) - (c.y * d.x)) + ((d.x * a.y) - (d.y * a.x));
            area = abs(area / 2);
            cout << "Area of this 4 points shape is " << area << endl;
        }
        else cout << "This is not square\n";
    } // getAreaOfSquare
    
    // Square's perimeter calculations
    void getPerimeterOfShape(){
        float perimeter = 0;
        if (isSquare()) {
            perimeter = sqrt(pow(a.x - b.x, 2) + pow(a.y - b.y, 2));
            perimeter += sqrt(pow(b.x - c.x, 2) + pow(b.y - c.y, 2));
            perimeter += sqrt(pow(c.x - d.x, 2) + pow(c.y - d.y, 2));
            perimeter += sqrt(pow(d.x - a.x, 2) + pow(d.y - a.y, 2));
            cout << "Perimeter of this 4 points shape is " << perimeter << endl;
        }
        else cout << "This is not Square\n";
        
    } // getPerimeterOfShape
    
}; // Square



int main(int argc, const char * argv[]) {
    // Mostly Self-documented program structure
    
    // Points are initialized here and printing on screen.
    Point a(0, 0); cout << a;
    Point b(10,0); cout << b;
    Point c(10,10); cout << c;
    Point d(0,10); cout << d;
    
    cout << "\nPoint + operator overloading \n";
    cout << c;
    cout << b;
    Point g = c + b;
    // show on the screen how g is made
    cout << g;
    
    cout << "\n";
    
    // Area and perimeter of square shape prints if it is a square
    Shape * sqrObject = new Square(a,b,c,d);
    sqrObject->getAreaOfShape();
    sqrObject->getPerimeterOfShape();
    
    // Area and perimeter of circle shape prints
    Shape * cirObject = new Circle(c, 3);
    cirObject->getAreaOfShape();
    cirObject->getPerimeterOfShape();
    
    cout << "\n\nGiven attributes from Question \n\n";
    
    // creating point as in question given for Circle
    Point cirPoint(10, -5);
    Shape * circle = new Circle(cirPoint, 23);
    
    // calling circle area and perimeter from shape class
    circle->getAreaOfShape();
    circle->getPerimeterOfShape();
    
    cout << "\nGiven attribites for Square \n";
    // creating point as in question given for Square
    Point w(5, -5); cout << w;
    Point x(-10,7); cout << x;
    Point y(4,23); cout << y;
    Point z(-6,12); cout << z;
    
    // calling Square area and perimeter from shape class
    Shape * square = new Square(w,x,y,z);
    square->getAreaOfShape();
    square->getPerimeterOfShape();

    
    // Area and perimeter of triangle shape prints
    
    
    return 0;
} ///:~

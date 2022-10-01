//: TMA4Question2.cpp

/*
 Title: TMA4Question2.cpp
 Description: Base class, sub classes, and polymorphisms explanation with C++
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

 Compile (Assuming GCC compiler istalled): g++ -o TMA4Question2 TMA4Question2.cpp
 Execution (assuming Cygwin is running): ./TMA4Question2

 Notes: in g++, main return type int

 Classes: Rodent, Mouse, Gerbil, Hamster

 Variables:
 Rodents - Rodent * - Instances of Rodent class

 */

/*
 TEST PLAN

 Normal case:
 I am Timothy from Mouse class
 My height is 10
 I am Kenzie from Gerbil class
 My height is 12
 I am Maddy from Hamster class
 Hamster height is 15
 I am Jerry from Mouse class
 My height is 10
 I am Tom from Gerbil class
 My height is 12
 I am Dexter from Hamster class
 Hamster height is 15
 I am Kelsey from Hamster class
 Hamster height is 15
 I am Cassidy from Mouse class
 My height is 10
 I am Aurora from Gerbil class
 My height is 12
 I am Josh from Hamster class
 Hamster height is 15

 Bad Case:
 Memory allocation problem might occur, if there is any memory hardware problem.

 Discussion:
 This program creates a Rodent higher/base class, then from that class Mouse, Gerbil, Hamster classes were created. This program illustrates polymorphism. When the higher class calss the method, it goes to sub class's method, and does it task.
 */

// Header files
#include <stdio.h>
#include <iostream>
#include <fstream>
using namespace std;


// Rodent class initialization
class Rodent{
public:
    virtual void rodentName(){}
    virtual void rodentHeight(){}
}; // Rodent


// Mouse class initialization
class Mouse: public Rodent{
public:
    int height = 10;
    string name;

    // parameterised constructor
    Mouse(string nameInput){
        name = nameInput;
    }
    void rodentName(){
        cout << "I am "<< name << " from Mouse class" << endl;
    }
    void rodentHeight(){
        cout << "My height is " << height << endl;
    }
}; // Mouse

// Gerbil class initialization
class Gerbil: public Rodent{
public:
    int height = 12;
    string name;

    // parameterised constructor
    Gerbil(string nameInput){
        name = nameInput;
    }
    void rodentName(){
        cout << "I am "<< name << " from Gerbil class" << endl;
    }
    void rodentHeight(){
        cout << "My height is " << height << endl;
    }
}; // Gerbil

// Hamster class initialization
class Hamster: public Rodent{
public:
    int height = 15;
    string name;

    // parameterised constructor
    Hamster(string nameInput){
        name = nameInput;
    }
    void rodentName(){
        cout << "I am "<< name << " from Hamster class" << endl;
    }
    void rodentHeight(){
        cout << "Hamster height is " << height << endl;
    }
}; // Hamster


int main(int argc, const char * argv[]) {

    // creating 10 pointers of Rodents objects
    Rodent *Rodents[10];

    // Each index has different class's object and Rodent class calls its method
    // Self-Documented code

    Rodents[0] = new Mouse("Timothy");
    Rodents[0]->rodentName();
    Rodents[0]->rodentHeight();

    Rodents[1] = new Gerbil("Kenzie");
    Rodents[1]->rodentName();
    Rodents[1]->rodentHeight();

    Rodents[2] = new Hamster("Maddy");
    Rodents[2]->rodentName();
    Rodents[2]->rodentHeight();

    Rodents[3] = new Mouse("Jerry");
    Rodents[3]->rodentName();
    Rodents[3]->rodentHeight();

    Rodents[4] = new Gerbil("Tom");
    Rodents[4]->rodentName();
    Rodents[4]->rodentHeight();

    Rodents[5] = new Hamster("Dexter");
    Rodents[5]->rodentName();
    Rodents[5]->rodentHeight();

    Rodents[6] = new Hamster("Kelsey");
    Rodents[6]->rodentName();
    Rodents[6]->rodentHeight();

    Rodents[7] = new Mouse("Cassidy");
    Rodents[7]->rodentName();
    Rodents[7]->rodentHeight();

    Rodents[8] = new Gerbil("Aurora");
    Rodents[8]->rodentName();
    Rodents[8]->rodentHeight();

    Rodents[9] = new Hamster("Josh");
    Rodents[9]->rodentName();
    Rodents[9]->rodentHeight();

    return 0;
} ///:~

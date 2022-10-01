//: TMA2Question3.cpp

/*
 Title: TMA2Question3.cpp
 Description: Defining outer class and inner classes with C++
 Date: January 10, 2020
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
 keyboard input file name with ext.
 simple calculations are addition.

 Compile (Assuming GCC compiler istalled): g++ -o TMA2Question3 TMA2Question3.cpp
 Execution (assuming Cygwin is running): ./TMA1Question3

 Notes: in g++, main return type int

 Classes: Hen, Nest, Egg

 */

/*
 TEST PLAN

 Normal case:
 Constructing Hen Class
 Hen class is calling display function
 Constructing Nest Class
 Nest class is calling display function
 Constructing Egg Class
 Egg class is calling display function
 Destructing Hen Class
 Destructing Nest Class
 Destructing Egg Class

 Bad Data case 1
 Memory allocation problem might occur, if there is any memory hardware problem.


 Discussion:
 The program creates three classes Hen, Nest, Egg, and showing their dipsplay function. In the end, it will delete its storage from the system.
 */

// Header files
#include <stdio.h>
#include <iostream>
#include <fstream>
#include <string>
using namespace std;

// Hen class (Outter class of Nest class)
class Hen{
public:
    // default constructor
    Hen(){
        cout << "Constructing Hen Class\n";
    } // Hen
    // destructor
    ~Hen(){
        cout << "Destructing Hen Class\n";
    } //~Hen
    // member function tto show where the function is being called from
    void display(){
        cout << "Hen class is calling display function\n";
    } // display

    // Nested Nest class inside Hen class
    class Nest{
    public:
        // default constructor
        Nest(){
            cout << "Constructing Nest Class\n";
        } // Nest
        // destructor
        ~Nest(){
            cout << "Destructing Nest Class\n";
        } //~Nest
        // member function tto show where the function is being called from
        void display(){
            cout << "Nest class is calling display function\n";
        } // display

        // Nested Egg class inside Nest class
        class Egg{
        public:
            // default constructor
            Egg(){
                cout << "Constructing Egg Class\n";
            } // Egg
            // destructor
            ~Egg(){
                cout << "Destructing Egg Class\n";
            } // ~Egg
            // member function tto show where the function is being called from
            void display(){
                cout << "Egg class is calling display function\n";
            } // display

        }; // Egg class

    }; // Nest class

}; // Hen class

int main(int argc, const char * argv[]) {

    // Creating the Hen class and calling display function
    Hen *hen = new Hen();
    hen->display();

    // Creating the Nest class and calling display function
    Hen::Nest *nest = new Hen::Nest();
    nest->display();

    // Creating the Egg class and calling display function
    Hen::Nest::Egg *egg = new Hen::Nest::Egg();
    egg->display();

    // Freeing the storage of objects
    delete hen;
    delete nest;
    delete egg;

}///:~

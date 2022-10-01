//: TMA2Question1.cpp

/*
 Title: TMA2Question1.cpp
 Description: DVD rental store management using abstract data type with C++
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

 Compile (Assuming GCC compiler istalled): g++ -o TMA2Question1 TMA2Question1.cpp
 Execution (assuming Cygwin is running): ./TMA2Question1

 Notes: in g++, main return type int

 Classes: struct DVD

 Variables:
     inputFile - ifstream - used to open the file stream from 'fileName'.
     name - string - stores users name
     price - float - stores DVD price
     rent - bool - stores if the DVD is rented or not
*/

/*
 TEST PLAN

 Normal case:
 In my DVD store, I am only showing name, price & rent (0/1 boolean rent)
 alvee    5.93    1
 fariah    2.03    0
 maddy    3.03    1
 Alex    2.03    1
 Matt    1.03    0
 Gavin    3.93    1
 Amber    2.03    0
 rama    3.03    1
 Daniel    2.03    1
 zhane    1.03    0

 Bad Data case 1 (not existing file in the directory)
      In my DVD store, I am only showing name, price & rent (0/1 boolean rent)
      Can not open file name Q1_file.txt


 Bad Data case 2:
 If the file is not set up properly, this program can not read the file and will print 0 0 on the screen

 In my DVD store, I am only showing name, price & rent (0/1 boolean rent)
 0    0
 0    0
 0    0
 0    0
 0    0
 0    0
 0    0
 0    0
 0    0
 0    0

 Discussion:
     The program opens a file and takes its data in DVD struct data structure and stores into an array and then prints it off on the screen.
*/

// Header files
#include <stdio.h>
#include <cstdlib>
#include <iostream>
#include <fstream>
#include <string>
using namespace std;


int main(int argc, const char * argv[]) {

    // abstract data type of DVD
    struct DVD {
        string name;
        float price;
        bool rent;

        // default constructor
        DVD(){
            name = "";
            price = 0;
            rent = false;} // DVD

        // parameterized constructor
        DVD(string input, float p, bool r)
        {   name = input;
            price = p;
            rent = r;} // DVD

        // prints DVD current name, price, and rent status
        void print(){
            //cout << "DVD current status" << endl;
            cout << name << "\t" << price << "\t" << rent << endl;
        } // print
    }; // DVD

    /*
     All the variables are initialised here
     */
    string name; float price; bool rent;

    // opening the file to read into DVD arrays
    ifstream input_File ("Q1_file.txt");

    // file can not open and program exits
    if (!input_File.is_open()) {
        cout << "Can not open file name Q1_file.txt\n";
        exit(EXIT_FAILURE);
    } // if

    // Making 10 DVD objects
    struct DVD dvd_records[10];

    // importing all the info from the file and storing into DVD objects
    int i = 0;
        while (input_File >> name >> price >> rent) {
            dvd_records[i] = DVD(name, price, rent);
            i++;
        } // while


    // printing all the 10 DVD on the screen
    cout << "In my DVD store, I am only showing name, price & rent (0/1 boolean rent)\n";
    for (int i = 0; i < 10; i++) {
        dvd_records[i].print();
    } // for

    // closing file
    input_File.close();
    return 0;
} ///:~

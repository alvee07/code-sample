//: TMA2Question2.cpp

/*
 Title: TMA2Question2.cpp
 Description: Dynamic storage allocation with C++
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

 Compile (Assuming GCC compiler istalled): g++ -o TMA2Question2 TMA2Question2.cpp
 Execution (assuming Cygwin is running): ./TMA2Question2

 Notes: in g++, main return type int

 Classes: none

 Variables:
 endLowerCaseLetter - int - Stored data to iterate through letters a-z
 endUpperCaseLetter - int - Stored data to iterate through letters A-Z
 integerVar - int - allocating int storage in memory
 longInteger - long - allocating long storage in memory
 arrayOfChar - char - allocating char storage in memory (100 * char size)
 arrayOfFloat - float - allocating float storage in memory

 */

/*

 TEST PLAN

 Normal case:
 Dynamic storage programming !

 Type Address and value
 int @ <0x7ffeefbff510> = 0
 long @ <0x7ffeefbff508> = 0
 char @ <0x7ffeefbff500> =
 float @ <0x7ffeefbff4f8> = 0

 Bad Case:
 Memory allocation problem might occur, if there is any memory hardware problem.

 After testing two different system (MacBookPro and Windows), there was no memory allocation problem found

 Discussion: The program allocates integer, long, array of chars, array of floats in memory, and initiliazes values, after that it deletes its data storage from the memory.

 */

// Header files
#include <iostream>
#include <fstream>
#include <stdio.h>
#include <cstdlib>
#include <string>
using namespace std;


int main(int argc, const char * argv[]) {

    /*
     variable initialization to put chars into arrayOfChars.
     manually calculated by char's code to run the loop easily.
     */
    int endLowerCaseLetter = 'a' + 26;
    int endUpperCaseLetter = 'A' + 26;

    cout << "Dynamic storage programming !\n";

    // Initializaing the space in the memory
    int *integerVar = new (nothrow) int;
    long *longInteger = new (nothrow) long;
    char *arrayOfChar = new (nothrow) char[100];
    float *arrayOfFloat = new (nothrow) float[100];

    // initializing memory problem will exit the program
    if ((!integerVar) || (!longInteger) || (!arrayOfChar) || (!arrayOfChar)) {
        cout << "Can not allocate memory\n";
        exit(EXIT_FAILURE);
    }

    // printing all address and value of the dynamic variables
    cout << "\nType Address and value\n";
    cout << "int @ <" << &integerVar << "> = " << *integerVar << endl;
    cout << "long @ <" << &longInteger << "> = " << *longInteger << endl;
    cout << "char @ <" << &arrayOfChar << "> = " << *arrayOfChar << endl;
    cout << "float @ <" << &arrayOfFloat << "> = " << *arrayOfFloat << endl;

    // Deleting info in the variables
    delete integerVar;
    delete longInteger;
    delete []arrayOfChar;
    delete []arrayOfFloat;

    // storing small a-z into the arrayOfChar pointer
    for (int i = 'a'; i < endLowerCaseLetter; i++) {
        char letter = i;
        arrayOfChar[i - 97] = letter;
    } // for

    // storing big A-Z into the arrayOfChar pointer
    for (int i = 'A'; i < endUpperCaseLetter; i++) {
        char letter = i;
        arrayOfChar[i - 39] = letter;
    } // for

    // storing 101.00 into the arrayOfChar pointer
    for (float i = 101.00; i < 201.00; i++) {
        arrayOfFloat[(int)i-101] = i;
    } // for


    /*

     //this is to check the variables are actually storing values or not

     // array of floats with defaultfloat precission
     for (int i = 0; i < 100; i++) {
     cout << defaultfloat << arrayOfFloat[i] << endl;
     }

     // array of chars prints on the screen
     for (int i = 0; i < 52; i++) {
     cout << arrayOfChar[i];
     }

     */

    return 0;
} ///:~

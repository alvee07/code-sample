//: TMA1Question3.cpp

/*
 Title: TMA1Question3.cpp
 Description: Displays three vectors and their formatted calculation with C++
 Date: September 25, 2019
 Author: Alvee H. Akash
 ID: 3433334
 Version: 1.0
 Copyright: 2019 Alvee H. Akash
 */

/*
 DOCUMENTATION

 Program Purpose:
 Documentation followed as GoodDocs.cpp,
 test plans are showed in the next paragraph,
 and comments are inline comments for better understanding.
 keyboard input file N/A,
 simple calculations are addition, square, loop counter handling.

 Compile (Assuming GCC compiler istalled): g++ -o TMA1Question3 TMA1Question3.cpp
 Execution (assuming Cygwin is running): ./TMA1Question3

 Notes: in g++, main return type int

 Classes: none

 Variables:
 firstVector - vector - used to store 1-25 numbers
 secondVector - vector - used to store loop counter value squred
 thirdVector - vector - used to store the addition of first and second vectors results
 */


/*
 TEST PLAN

 Normal case:
 counter       First       +    Second      =    Third
 0            0                0                0
 1            1                1                2
 2            2                4                6
 3            3                9                12
 4            4                16               20

 Bad Data case:
 There is no such bad case in this program because there is no user input.

 Discussion:
 Write a program that creates three vector<float> objects. Fill the first two objects with 25 floating-point numbers using a forloop as follows:
 a. fill the first vector object with the loop counter value;
 b. fill the second vector object with the loop counter value squared;
 c. finally, write a for loop that adds the corresponding elements in the first
 two vectors, and puts the result in the corresponding element of the third vector.

 */

#include <stdio.h>
#include <iostream>
#include <vector>
#include <math.h>
using namespace std;

int main(int argc, const char * argv[]) {

    /*
     All the variables are initialised here
     */
    vector<float> firstVector;
    vector<float> secondVector;
    vector<float> thirdVector;

    // storing loop counter value to first vector
    for (int i = 0; i < 25; i++) {
        firstVector.push_back(i);
    } // for

    // storing loop counter value squared to second vector
    for (int i = 0; i < 25; i++) {
        int loopCounterValueSquared = pow(i, 2);
        secondVector.push_back(loopCounterValueSquared);
    } // for

    for (int i = 0; i < 25; i++) {
        //  adding first vector and second vector value and store it to third vector
        thirdVector.push_back(firstVector[i] + secondVector[i]);
    } // for

    cout << "counter\t\tFirst\t\t+\tSecond\t\t=\tThird"<<endl;

    for (int i = 0; i < 25; i++) {
        cout << i;
        cout << "\t\t\t" << firstVector[i];
        cout << "\t\t\t\t" << secondVector[i];
        cout << "\t\t\t\t" << thirdVector[i];
        cout << endl;
    } // for

} ///:~

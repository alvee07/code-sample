//: TMA1Question4.cpp

/*
 Title: TMA1Question4.cpp
 Description: Using two nested loop find prime numbers 1-10000 with C++
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
 keyboard input N/A.
 simple calculations are mod, loop counter handling.

 Compile (Assuming GCC compiler istalled): g++ -o TMA1Question4 TMA1Question4.cpp
 Execution (assuming Cygwin is running): ./TMA1Question4

 Notes: in g++, main return type int

 Classes: none

 Variables:
 primeNumber - bool - checks the number is prime or not prime
 square_root_of_potential_prime_number - int - potential prime number's sqare root value
 */


/*
 TEST PLAN

 Normal case:
 Prime numbers 1 - 10,000
 2
 3
 5
 .
 .
 .
 9949
 9967
 9973

 Bad Data case:
 There is no such bad case in this program because there is no user input.

 Discussion:
 Write a program that uses two nested for loops and the modulus operator (%) to detect and print the prime numbers from 1 to 10,000.

 */

#include <iostream>
#include <vector>
#include <math.h>
using namespace std;

int main(int argc, const char * argv[]) {

    cout << "Prime numbers 1 - 10,000" << endl;

    for (int i = 2; i < 10000; i++) {
        // boolean to check if the number is prime or not prime
        bool primeNumber = true;

        // more efficient algortihm to find prime numbers is to check squre root of the given number
        int square_root_of_potential_prime_number = 1 + sqrt(i);

        for (int j = 2; j < square_root_of_potential_prime_number; j++) {
            if (i % j == 0) {
                primeNumber = false;
            } // if
        } // for

        if (primeNumber == true) {
            cout << i << "\n";
        } // if

    } // for

}/// : ~

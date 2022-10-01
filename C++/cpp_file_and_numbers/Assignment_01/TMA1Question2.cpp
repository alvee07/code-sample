//: TMA1Question2.cpp

/*
 Title: TMA1Question2.cpp
 Description: Opens a text file, reads one line by user's <enter> key press with C++
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

 Compile (Assuming GCC compiler istalled): g++ -o TMA1Question2 TMA1Question2.cpp
 Execution (assuming Cygwin is running): ./TMA1Question2

 Notes: in g++, main return type int

 Classes: none

 Variables:
 input_File - ifstream - used to open the file stream from 'fileName'.
 */

/*
 TEST PLAN

 Normal case:
 This program reads one line at a time just hit Enter key

 This is Alvee. I am writing C++ program.
 This program is first assignment.
 I never write C++ code in my life.

 Bad Data case 1 (invalid entry before 'enter' key)
 This program reads one line at a time just hit Enter key

 This is Alvee. I am writing C++ program.falksjfhalskjfhaslkfhj
 This program is first assignment.sdsdfsfsfsfawrfwe
 I never write C++ code in my life.


 Discussion:
 Opens a valid file, and reads one line at a time, each line will print on
 the screen wheneven user hits <enter> key.
*/



#include <iostream>
#include <fstream>
using namespace std;

int main(void) {

    //  opening a file from host computer.
    ifstream input_File ("Q2_text.txt");

    cout << "This program reads one line at a time just hit Enter key\n";
    //  check file reaches the end
    while (!input_File.eof()) {

        //  if user presses <enter> key, print one line at a time
        if (cin.get() == '\n') {
            //  string variable to read one line from the file and prints on the screen
            string oneLine;
            getline(input_File, oneLine);
            cout << oneLine;
        } // if
    } // while
    cout << endl;

    //  closing file
    input_File.close();
    return 0;
} ///:~

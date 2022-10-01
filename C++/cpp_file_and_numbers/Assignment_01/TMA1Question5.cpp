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
 simple calculations are loop handling, array index handling.
 
 Compile (Assuming GCC compiler istalled): g++ -o TMA1Question4 TMA1Question4.cpp
 Execution (assuming Cygwin is running): ./TMA1Question4
 
 Notes: in g++, main return type int
 
 Classes: none
 
 Variables:
 arrayOfString - array - stores 100 strings in the array
 input_File - ifstream - used to open the file stream from 'fileName'.
 oneLine - string - reads from file and stores into the string.
 */


/*
 TEST PLAN
 
 Normal case:
 line 0 : This is Alvee. I am writing C++ program.
 line 1 : This program is first assignment.
 line 2 : I never write C++ code in my life.
 line 3 : I hope everything goes well and I get good marks.
 line 4 : I wanna learn a lot of coding too.
 .
 .
 .
 line 97 : 87)     First line of auto generated lines starts here.
 line 98 : 88)     First line of auto generated lines starts here.
 line 99 : 89)     First line of auto generated lines starts here.
 
 Bad Data case:
 There is no such bad case in this program because there is no user input.
 
 Discussion:
 Write a program that creates an array of 100 string objects. Fill the array by having your program open a (text) file, and read one line of the file into each string until you have filled the array.
 
 */

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main(int argc, const char * argv[]) {
    
    /*
     string of an array, can store 100 strings in the array
     */
    string arrayOfString[100];
    
    //  Opening file
    ifstream input_File ("Q5_text.txt");
    
    // error checks if file can not open
    if (!input_File.is_open()) {
        exit(EXIT_FAILURE);
    } // if
    
    for (int i = 0; i < 100; i++) {
        // reads one line from the file
        string oneLine;
        
        getline(input_File, oneLine);
        
        // storing one line into the array
        arrayOfString[i] = oneLine;
    } // for
    
    for (int j = 0; j < 100; j++) {
        cout << "line " << j << " : " << arrayOfString[j] << endl;
    } // for
    
    //  Closing file
    input_File.close();
    
}/// : ~

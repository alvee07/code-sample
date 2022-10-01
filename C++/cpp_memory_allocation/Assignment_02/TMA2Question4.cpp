//: TMA2Question4.cpp

/*
 Title: TMA2Question4.cpp
 Description: Reading file data into class file with C++
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

 Compile (Assuming GCC compiler istalled): g++ -o TMA2Question4 TMA2Question4.cpp
 Execution (assuming Cygwin is running): ./TMA2Question4

 Notes: in g++, main return type int

 Classes: Text

 Variables:
 textOpener - Text - instance of Text class
 */

/*
 TEST PLAN

 Normal case:
 This is a file which contains a lot of lines of text.This file will be opened in Text class second constructor.Then I will display the file content.This is the fourth line of this text file.This is the last line of this text file.

 Bad Data case 1 (not existing file in the directory)
 Can not open file name Q2_file.txt
 
 Bad Data Case 2:
 Memory allocation problem might occur, if there is any memory hardware problem.


 Discussion:
 The program creates a Text class which opens a file and reads its data and prints it off on the screen. Text class also has a default empty constructor.
 */

// Header files
#include <stdio.h>
#include <iostream>
#include <fstream>
#include <string>
using namespace std;

// Text class
class Text {
    string fileContent;
public:
    Text(){
        cout << "Empty constructor\n";
    } // Text
    
    Text(string File_Name){
        // Opening file
        ifstream input_File(File_Name.c_str());
        
        // file can not open and program exits
        if (!input_File.is_open()) {
            cout << "Can not open file name Q2_file.txt\n";
            exit(EXIT_FAILURE);
        } // if
        
        // Reading file into a string word by word
        string tempWord;
        while (!input_File.eof()) {
            getline(input_File, tempWord);
            fileContent += tempWord;
        } // while
    } // Text
    
    void contents(){
        cout << fileContent;
    } // contents

}; // Text class

int main(int argc, const char * argv[]) {

    // creating a Text object
    Text *textOpener = new (nothrow) Text("Q2_file.txt");

    // Showing the file content on the screen
    textOpener->contents();

} ///:~

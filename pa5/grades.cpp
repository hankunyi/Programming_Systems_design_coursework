// Name:
// USC NetID:
// CSCI 455 PA5
// Fall 2017

/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize]
 * 
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h"

// cstdlib needed for call to atoi
#include <cstdlib>

int main(int argc, char * argv[]) {

  // gets the hash table size from the command line

  int hashSize = Table::HASH_SIZE;

  Table * grades;  // Table is dynamically allocated below, so we can call
                   // different constructors depending on input from the user.

  if (argc > 1) {
    hashSize = atoi(argv[1]);  // atoi converts c-string to int

    if (hashSize < 1) {
      cout << "Command line argument (hashSize) must be a positive number" 
	   << endl;
      return 1;
    }

    grades = new Table(hashSize);

  }
  else {   // no command line args given -- use default table size
    grades = new Table();
  }


  grades->hashStats(cout);

  // add more code here
  // Reminder: use -> when calling Table methods, since grades is type Table*

	string command;
	while(1){
		cout<<"cmd>";
		cin>>command;
		if(command == "insert"){
			string name;
			int score;
			cin >> name;
			cin >> score;
			if(!grades->insert(name, score)){
				cout << "the name was already present." << endl;
			}
		}
		else if(command == "change"){
			string name;
			int newScore;
			cin >> name;
			cin >> newScore;
			if(grades->lookup(name) == NULL){
				cout << "the student is not in the table." << endl;
			}
			else{
				*grades->lookup(name) = newScore;
			}
		}
		else if(command == "lookup"){
			string name;
			cin >> name;
			if(grades->lookup(name)==NULL){
				cout << "the student is not in the table." << endl;
			}
			else{
				cout << "score is " << *(grades->lookup(name)) << endl;
			}
		}
		else if(command == "remove"){
			string name;
			cin >> name;
			if(grades->lookup(name) == NULL){
				cout << "the student is not in the table." << endl;
			}
			else{
				grades->remove(name);
			}
		}
		else if(command == "print"){
			grades->printAll();
		}
		else if(command == "size"){
			cout << grades->numEntries() << endl; 
		}
		else if(command == "stats"){
			grades->hashStats(cout);
		}
		else if(command == "help"){
			cout << "insert name score" << endl;
			cout << "change name newscore" << endl;
			cout << "lookup name" << endl;
			cout << "remove name" << endl;
			cout << "print" << endl;
			cout << "size" << endl;
			cout << "states" << endl;
			cout << "help" << endl;
		}
		else if(command == "quit"){
			return 0;
		}
		else{
			cout << "ERROR: invalid command" << endl;
		}

	}



  return 0;
}

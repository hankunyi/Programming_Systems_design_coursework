// Name:
// USC NetID:
// CSCI 455 PA5
// Fall 2017

// Table.cpp  Table class implementation


/*
 * Modified 11/22/11 by CMB
 *   changed name of constructor formal parameter to match .h file
 */

#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>


// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"


//*************************************************************************


Table::Table() {
	hashSize = HASH_SIZE;
	data = new ListType[hashSize];
}


Table::Table(unsigned int hSize) {
	hashSize = hSize;
	data = new ListType[hashSize];	
}


int * Table::lookup(const string &key) {

	return lookupKey(data[hashCode(key)], key);

}

bool Table::remove(const string &key) {

	return listRemove(data[hashCode(key)], key);
		
}

bool Table::insert(const string &key, int value) {
	
	return insertFront(data[hashCode(key)], key, value);
}

int Table::numEntries() const {
	int number=0;
	for(int i=0; i<hashSize; i++){
		if(!isEmpty(data[i])){
			number += listLength(data[i]);
		}
	}
	return number;
}


void Table::printAll() const {
	for(int i=0; i<hashSize; i++){
		if(!isEmpty(data[i])){
			printList(data[i]);
		}
	}
}

void Table::hashStats(ostream &out) const {
	int validBucket=0;
	int maxLength=0;
	for(int i=0; i<hashSize; i++){
		if(!isEmpty(data[i])){
			validBucket ++;
			if(listLength(data[i])>maxLength){
				maxLength = listLength(data[i]);
			}
		}
	}

	out << "number of buckets: " << hashSize << endl;
	out << "number of entries: " << numEntries() << endl;
	out << "number of non-empty buckets: " << validBucket << endl;
	out << "longest chain: " << maxLength << endl;

  
}


// add definitions for your private methods here

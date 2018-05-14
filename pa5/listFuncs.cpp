// Name:
// USC NetID:
// CSCI 455 PA5
// Fall 2017


#include <iostream>

#include <cassert>

#include "listFuncs.h"

using namespace std;

Node::Node(const string &theKey, int theValue) {
  key = theKey;
  value = theValue;
  next = NULL;
}

Node::Node(const string &theKey, int theValue, Node *n) {
  key = theKey;
  value = theValue;
  next = n;
}




//*************************************************************************
// put the function definitions for your list functions below

void initList(ListType &list) {
  list = NULL;
}


int* lookupKey(ListType &list, string target){
	Node *p = list;
	while(p!=NULL){
		if(p->key == target){
			return &(p->value);
		}
		p=p->next;
	}
	return NULL;
}
	
bool insertFront(ListType &list, string target, int value){
	if(lookupKey(list, target)!=NULL){
		return false;
	}
	else{
		Node *insert = new Node(target, value, list);
		list = insert;	
		return true;
	}
}
bool listRemove(ListType &list, string target){
	if(lookupKey(list, target)==NULL){
		return false;
	}
	else{
		Node *p = list;
		if(p->key == target){
			Node *save = p->next;
			delete p;
			list = save;
		}
		else{
			while(p->next->key !=target){
				p=p->next;
			}
			Node *deadGuy = p->next;
			p->next = p->next->next;
			delete deadGuy;
		}
		return true;
	}

}
void printList(ListType &list){
	if(list==NULL){
		cout<<"empty"<<endl;
	}
	Node *p = list;
	while(p!=NULL){	
		cout<<p->key<<" " << p->value<<endl;
		p = p->next;
	}
}

bool isEmpty(ListType &list){
	return (list==NULL);
}

int  listLength(ListType &list){
	int length=0;
	Node *p = list;
	while(p!=NULL){
		length++;
		p=p->next;
	}
	return length;
}




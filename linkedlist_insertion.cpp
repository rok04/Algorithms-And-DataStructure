#include<cstdio>
#include<stdio.h>
#include<stdlib.h>
#include <iostream>
using namespace std;
struct node {
int data;
struct node* link;
	
};

// When we have to make change in list then pass by reference other then passs by value
// alway when pass by reference then save head into other variable 
// make new node first suing malloc 
//replace head by *head while using pass by refernece 
// At first time append in head then make head as new node or copy all data of new node into head
// Then  go to required position by temp=temp->link and put address of new_node into temp->link.


void append(node**head,int data)
{
struct node * temp=*head;
struct node *new_node=(struct node*)malloc(sizeof(struct node));
         new_node->data=data;
	     new_node->link=NULL;
	if(*head==NULL) // 
	   {
	   *head=new_node;
	   	return ;
	   	
	   	
	   }
	while(temp->link!=NULL)
	     temp=temp->link;
	     
	 temp->link=new_node;
	 return;
	     
}
void printlist(struct node* node)
{
	while(node!=NULL)
	{
		cout<<node->data;
		node=node->link;
	}
	
	
}
int main() {
	 struct node *head=NULL;
	 append(&head,12);
	 append(&head,13);
	printlist(head);
}
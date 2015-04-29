#include<cstdio>
#include<stdio.h>
#include<stdlib.h>
#include <iostream>
using namespace std;
struct node {
int data;
struct node* link;
	
};
//Reverse the linked list 
// hERE WE ARE USING 3 NODES AS CURRENT NODE AND NEXT NOODE AND PREVIOUS NODE 
// pREV NODE STORE PREV NODE DATA AND THEN REPLACE IT WITH CURRENT NODE 
// fIRSTLY STORE CURRENT NODE LINK IN NEXT AND THEN REPLACE NEXT BY CURRENNT


void append(node**head,int data)
{
struct node * temp=*head;
struct node *new_node=(struct node*)malloc(sizeof(struct node));
         new_node->data=data;
	     new_node->link=NULL;
	if(*head==NULL)
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
		cout<<node->data<<" ";
		node=node->link;
	}
	
	
}
void rev(struct node **head)
{
	struct node* curr=*head;
	struct node *prev=NULL;
	struct node * nxt;
	if(*head==NULL)
	{
		cout<<"EMPTY ";
		return ;
		
	}
	
	
	while(curr!=NULL)
	{
		
		nxt=curr->link;// firstly  store next node 
		curr->link=prev;// link with prev node
		  prev=curr;// now go forward 
		   curr=nxt;
		   
	}
	*head=prev;// make last one as head
		  
		
		
		
	}
int main() {
	 struct node *head=NULL;
	 append(&head,12);
	 append(&head,13);
	 append(&head,14);
	 append(&head,15);
	 append(&head,16);
	 
	printlist(head);
	rev(&head);
	cout<<endl;
	printlist(head);
}

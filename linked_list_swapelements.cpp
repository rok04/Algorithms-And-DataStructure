#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<math.h>
#include<string.h>
#include<vector>
#include<map>
#include <set>
#include <queue>
#include<algorithm>
#include<cstdio>
#include<stdio.h>
#include<complex>
#include<string>
#include <limits>
#define ui unsigned int
#define ulld unsigned long long int
#define lld long long int
#define gc getchar_unlocked
#define pb(x) push_back(x)
#define mp(x,y) make_pair((x),(y))
#define MAX 1000000
#define MOD 1000000007
#define rep(i,n) for(int (i)=0;(i)<(int)(n);++(i))
#define rer(i,l,u) for(int (i)=(int)(l);(i)<=(int)(u);++(i))
#define reu(i,l,u) for(int (i)=(int)(l);(i)<(int)(u);++(i))
using namespace std;
typedef vector<int> vi;
 typedef pair<int,int> pii;
  typedef vector<pair<int,int> > vpii;
typedef long long ll;
 typedef vector<long long> vl;
  typedef pair<long long,long long> pll;
  typedef vector<pair<long long,long long> > vpll;
typedef vector<string> vs;
typedef long double ld;
template<typename T, typename U> inline void amin(T &x, U y) { if(y < x) x = y; }
template<typename T, typename U> inline void amax(T &x, U y) { if(x < y) x = y; }
struct node {
int data;
struct node* link;
	
};
// Pairwise swap of elements  in linked list
// swap elements of 1 with 2 and 3 with 4 
// only swap elements not nodes
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
	
	void swapp(struct node **head)
	{
		
		struct node * temp=*head;
		
		if(*head==NULL)
		    {
		    	
		    	cout<<"EMPTY list";
  return ;

		    }
		    int count=0;
		    while(temp->link!=NULL)
		       {
		       	count++;
		       	if(count%2==1)
		       	   {
		       	   	swap(temp->data,temp->link->data);
		       	   	  
		       	    }
		       	   temp=temp->link;
		       	   
		       	
		       }
	}
	
	
		void swapp3(struct node **head)//with 3 nodes exchange
	{
		
		struct node * temp=*head;
		
		if(*head==NULL)
		    {
		    	
		    	cout<<"EMPTY list";
  return ;

		    }
		    int count=0;
		    while(temp->link->link!=NULL)
		       {
		       	count++;
		       	if(count%3==1)
		       	   {
		       	   	swap(temp->data,temp->link->data);
		       	   	swap(temp->link->data,temp->link->link->data);  
		       	    }
		       	   temp=temp->link;
		       	   
		       	
		       }
	}

	

	
int main() {
	 struct node *head=NULL;
	 append(&head,12);
	 append(&head,13);
	 append(&head,14);
	 append(&head,15);
	 append(&head,16);
	 
	printlist(head);
	swapp(&head);
//	rev(&head);
	cout<<endl;
	printlist(head);
	swapp3(&head);
	cout<<endl;
	printlist(head);
}

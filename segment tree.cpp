//implementation of segment tree!!!!
#include<iostream>
#include<algorithm>
#include<cstdio>
#define MAXI 100000000;

using namespace std;
struct node{

lld value ;
lld counter;


}tree[1000005];
int h[1000005];


void init()
{
    for(int i=0;i<=1000000;i++)
          {tree[i].counter=0;
             h[i]=0;}

}

void buildtree(lld arr[],lld start,lld last,lld node)
{
    if(start>last)
        return;
       if(start==last)
        {tree[node].value=arr[start];
             if(h[arr[start]]==0)
                  tree[node].counter=1;
             else
                tree[node].counter=0;
             h[arr[start]]=1;
        return ;
        }

    buildtree(arr,start,(start+last)>>1,node*2);
    buildtree(arr,1+(start+last)>>1,last,node*2 +1);
    tree[node].counter=(tree[node*2].counter+tree[node*2+1].counter);


}

lld qry(lld arr[],lld start,lld last,lld node,lld start_limit,lld last_limit)
{
    int p1,p2;
     if(start_limit>last||start>last_limit) // interval out of the limit
            return 0;
            if(start>=start_limit && last<=last_limit){
                return tree[node].value;

            }
            int q=qry(arr,start,(start+last)/2,2*node,start_limit,last_limit);
            int p=qry(arr,1+(start+last)>>1,last,2*node+1,start_limit,last_limit);

        return(p+q);

}
int main()
{




       lld n,k;
       scanf("%lld",&n);
       lld arr[n+1];
       init();

       for(int i=0;i<n;i++)
        scanf("%lld",&arr[i]);
        buildtree(arr,0,n-1,1);
        lld p,q;
         scanf("%lld",&k);

       for(int i=0;i<k;i++)
       { scanf("%lld %lld",&p,&q);
       p--;
       q--;

           printf("%lld\n",qry(arr,0,n-1,1,p,q));
       }
}


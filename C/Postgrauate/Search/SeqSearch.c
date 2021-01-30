#include<stdio.h>
typedef int elemType; 

/**
 * 传入一个数组，key值，数组长度
 */
int Search_Seq(elemType a[],elemType,int );

int main(int argc, char const *argv[]){
    int a[10];
    for (int i = 0; i < 10; i++){
        a[i] = i;
    }
    int length = sizeof(a)/sizeof(a[0]);
    printf("location 3 is %d\n",Search_Seq(a,3,length));
    return 0;
}

int Search_Seq(elemType a[],elemType key,int n){
    a[0] = key;
    int i = n;
    for(; a[i]!=key; i--);
    return i;
}


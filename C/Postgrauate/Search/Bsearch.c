#include<stdio.h>
int Bsearch(int a[],int n,int key);
int main(int argc, char const *argv[]){
    int a[10];
    for(int i = 9;i >= 0;i--){
        a[i] = i;
    }
    printf("The locaion 3 is %d\n",Bsearch(a,sizeof(a)/sizeof(a[0]),3));
    return 0;
}
int Bsearch(int a[],int n, int key){
    int low = 0;
    int high = n - 1;
    int mid = 0;

    while(low <= high){
        mid = (low + high)/2; //开始循环，寻找中间值
        if(a[mid] == key){

            return mid;

        } else if(a[mid] > key){

            high = mid - 1;

        } else {

            low = mid + 1;

        }
    }

    //满足只要退出循环就表示查找失败
    return -1;
}
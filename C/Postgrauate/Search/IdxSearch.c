#include<stdio.h>
typedef struct{
    int key;
    int index;
} IdxType;

int IdxSearch(IdxType a[],int b,int SeqList[],int n,int key);
int main(int argc, char const *argv[]){
    int c[10];
    for (int i=0;i < 10;i++){
        c[i] = i;
    }
    IdxType a[2];
    a[0].key = 0;
    a[0].index = 0;
    a[1].key = 5;
    a[1].index = 5;
    printf("The location 3 is %d\n",IdxSearch(a,2,c,2,7));

    return 0;
}

int IdxSearch(IdxType a[],int b,int SeqList[],int n,int key){
    int low = 0,high = n - 1;
    int mid, i;
    int s = 10/b; //这个是分块

    //二分查找---选择哪个块
    while(low <= high){
        mid = (low + high)/2;
        if(a[mid].key >= key){
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }

    //顺序查找---块中所匹配的元素
    i = a[high+1].index;
    for(int j = i; j < i + s; j++){
        if(SeqList[j] == key){
            return j;
        }
    }
    
    return -1;
}

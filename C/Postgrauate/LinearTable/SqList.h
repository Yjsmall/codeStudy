#include <stdio.h>
#include <stdlib.h>
#define MAXSIZE 50
#define elementType int
typedef struct{
    elementType data[MAXSIZE];
    int length;
}sList;

void initList(sList** list);
int insertList(sList**,int index,int value);
void printList(sList* list);
int deleteList(sList** list,int index,int *element);
int length(sList* list);
int isEmpty(sList* list);
int locateElem(sList* list,int elme);

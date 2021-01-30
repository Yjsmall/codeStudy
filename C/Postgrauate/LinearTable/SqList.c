#include "SqList.h"
int main(){
    sList *list = (sList*)malloc(sizeof(sList));
    //不能直接使用这个函数,这是个野指针
    InitList(&list);
    insert(&list,1,0);
    printList(list);
    int a = 9999;
    // deleteList(&list,1,&a);
    // printf("%d\n",a);
    locateElem(list,0);
    return 0;
}

void initList(sList **L)
{
    (*L)->length = 0;
    printf("初始化成功\n");
}

int insertList(sList **L,int index,int value)
{
    //判断插入位置是否正确
    if(index < 1 || index > (*L)->length+1)
    {
        printf("插入位置不正确\n");
        return -1;
    }

    //判断表是否满
    if(length(*L) >= MAXSIZE)
    {
        printf("顺序表满!\n");
        return -1;
    }

    //移动元素
    for (int i = (*L)->length; i >= index; i--)
    {
        (*L)->data[i] = (*L)->data[i-1];
    }
    (*L)->data[index] = value;
    (*L)->length++;
    printf("插入成功!\n");

    return 1;
    
}

void printList(sList *L)
{
    if(isEmpty(L))
    {
        printf("表空\n");
    } 
    else
    {
        for (int i = 0; i < L->length; i++)
        {
            printf("%d\t",L->data[i]);
        }
        printf("\n");
    }
}

int deleteList(sList **L,int index,int *a)
{
    //判断删除位置是否正确
    if(index < 1 || index > (*L)->length)
    {
        printf("删除位置不正确!");
        return -1;
    }
    else
    {
        //先取出元素
        *a = (*L)->data[index-1];
        //再进行移动
        for (int i = index; i < (*L)->length; i++)
        {
            (*L)->data[i] = (*L)->data[i-1];
        }
        //表长减一
        (*L)->length--;
        printf("删除成功!");
        printf("\n");
        return 1;
    }
}

int length(sList *L)
{
    return L->length;
}

int isEmpty(sList *L)
{
    if(length(L) == 0)
    {
        return 1;
    }
    else
    {
        return 0;
    }
    

}

int locateElem(sList *L,int e)
{
    for(int i = 0; i < L->length; i++)
    {
        if(e == L->data[i])
        {
            printf("查找成功\n");
            return i+1;
        }
    }
    printf("没有改元素!\n");
    return 0;
}
#include <stdio.h>
#include "addrlist.h"
/**
 * 每个地址的三个部分,分别保存三个数组的对应元素
 */
static char name[MAX_ADDRESSES][NAME_LENGTH];
static char address[MAX_ADDRESSES][ADDRESS_LENGTH];
static char phone[MAX_ADDRESSES][PHONE_LENGTH];

static int 
find_entry(char const *name_to_find)
{
    int entry;
    for(entry = 0; entry < MAX_ADDRESSES; entry++)
    {
        if(strcmp(name_to_find, address[entry]) == 0){
            return entry;
        }
    }
    return -1;
}

int main(int argc, char const *argv[])
{
    return 0;
}

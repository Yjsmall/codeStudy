#include "stack.h"
#include <assert.h>
#include <stdio.h>

#define STACK_SIZE 100 

static STACK_TYPE stack[STACK_SIZE];
static int top_element = -1;

void push(STACK_TYPE value){
    assert( !isFull() );
    top_element += 1;
    stack[top_element] = value;
}

void pop(){
    assert( !isEmpty() );
    top_element -= 1;
}

STACK_TYPE top() {
    assert( !isEmpty() );
    return stack[top_element];
}

int isEmpty() {
    return top_element == -1;
}

int isFull() {
    return top_element == STACK_SIZE - 1;
}

int main(int argc, char const *argv[]){
    for (int i = 0; i < 100; i++){
        push(i);
    }

    if( isFull() ){
        printf("stack已经满了\n");
    }

    for (int i = 0; i < 100; i++){
        printf("%d\t",top());
        pop();
    }
    printf("\n");
    if( isEmpty() ){
        printf("Stack EMPTY\n");
    }
    
    return 0;
}


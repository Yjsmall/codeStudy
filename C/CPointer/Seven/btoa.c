/**
 * 输入一个数字,并且依次打印这个字符(字符方式)
 * 之前递归例子:阶乘--没有体现递归优越;斐波那契--效率之分低下
 */
#include <stdio.h>
void binary_to_ascii(unsigned int number);
int factorial_recursive(int n);
int factorial_iteration(int n);
long fibonacci_iteration(int n);

int main(int argc, char const *argv[]){
    binary_to_ascii(4276);
    printf("\n");
    printf("使用--递归--查询计算3的阶乘%d\n",factorial_recursive(3));
    printf("使用--迭代--查询计算3的阶乘%d\n",factorial_iteration(3));

    printf("斐波那契数列--迭代--查询3的结果为%ld\n",fibonacci_iteration(3));
    return 0;
}

void
binary_to_ascii (unsigned int value)
{
    unsigned int quotient;
    quotient = value / 10;
    if(quotient != 0) {
        binary_to_ascii(quotient);
    }
    putchar(value % 10 + '0');
}

int factorial_recursive(int value){
    if(value <= 0) {
        return 1;
    } else {
        return value * factorial_recursive(value - 1);
    }
    
}

int factorial_iteration(int n){
    int result = 1;
    while(n > 1){
        result *= n;
        n--;
    }
    return result;
}

long fibonacci_iteration(int n){
    long result;
    long previous_result;
    long next_older_result;

    result = previous_result = 1;
    while(n > 1){
        n--;
        next_older_result = previous_result;
        previous_result = result;
        result = previous_result + next_older_result;
    }
    return result;
}


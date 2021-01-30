/**
 * 可变参数
 * 
 * 一个类型:va_list
 * 三个宏 :va_start,va_arg,va_end
 */
#include <stdio.h>
#include <stdarg.h>

float average(int n_values, ...);

int main() {
    float Average = average(3,1,13,14);
    printf("Average is %f\n", Average);
    return 0;
}

float average(int n_values, ...) {
    va_list list;
    int count;
    float sum = 0;

    va_start(list,n_values);

    for (int i = 0; i < n_values; i++){
        sum += va_arg(list, int );
    }

    va_end(list);

    return sum / n_values;

}

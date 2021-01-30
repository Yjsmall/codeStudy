#include <iostream>
#include <string>
#include <cstring>
int main(){
    using namespace std;
    char charr[20];
    string str;
    cout << "Length of string in charr before input: " << strlen(charr) << endl;
    cout << "Length of string in str before input: " << str.size() << endl;

    //输入第一行
    cout << "Enter a line of text:" << endl;
    cin.getline(charr,20);
    cout << "You entered: " << charr << endl;

    //输入第二行
    cout << "Enter another line of text:" << endl;
    //cin now an arugment;no length specifier,这个getline（）不是iostream类中方法
    getline(cin,str);
    cout << "You entered: " << str << endl;

    cout << "Length of string in charr after input: " << strlen(charr) << endl;
    cout << "Length of string in str after input: " << str.size() << endl;

    return 0;
}
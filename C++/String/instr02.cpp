#include <iostream>
int main(){
    //cin.getline(数组名，读入的大小);
    /** 
     * cin.get(数组名，读入的大小);但是这个会读如换行符,不能连续两次调用
     * cin.get(name,ArSize);
     * cin.get(dessert,ArSize); a problem
     * 
     * 正确如下:
     * cin.get(name,ArSize);
     * cin.get(); 换行
     * cin.get(dessert,ArSize); 
     */ 
    using namespace std;
    const int ArSize = 20;
    char name[ArSize];
    char dessert[ArSize];

    cout << "Enter your name: \n";
    cin.getline(name, ArSize);
    cout << "Enter your dessert: \n";
    cin.getline(dessert,ArSize);
    cout << "I have some delicious " << dessert;
    cout << " for you." << name << ".\n";
    return 0;
}
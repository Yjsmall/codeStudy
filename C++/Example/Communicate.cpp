#include <iostream>
using namespace std;
#include <string>
#include <unistd.h>
#define MAX 1000


//设计联系人
struct Person
{
    string name;
    int sex;
    int age;
    string Phone;
    string address;
};

//通讯录结构体
struct Addressbooks
{
    //通讯录保存的数组
    struct Person personArrary[MAX];
    //当前人数
    int Size;
};

//1.添加联系人
void addPerson(Addressbooks * abs)
{
    if (abs->Size == MAX)
    {
        cout << "Is full,can't add" << endl;
        return;
    }
    else
    {
        //姓名
        string name;
        cout << "请输入姓名:" << endl;
        cin >> name;
        abs->personArrary[abs->Size].name = name;

        //性别
        cout << "1-man,0-woman" << endl;
        int sex = 0;
        while(true)
        {
            cin >> sex;
            if (sex == 1 || sex == 0)
            {
                abs->personArrary[abs->Size].sex = sex;
                break; 
            }
            cout << "输入错入,重写输入" << endl;
            
        }

        //年龄
        cout << "输入年龄" << endl;
        int age = 0;
        cin >> age;
        abs->personArrary[abs->Size].age = age;

        //电话
        cout << "请输入电话" << endl;
        string Phone;
        cin >> Phone;
        abs->personArrary[abs->Size].Phone = Phone;

        //住址
        cout << "请输入家庭地址" << endl;
        string address;
        cin >> address;
        abs->personArrary[abs->Size].address = address;

        //更新人数
        abs->Size++;

        cout << "添加成功" << endl;

        pause();
        system("clear");
    }
    
    
}



void showMenu()
{
    cout << "1.添加联系人" << endl;
    cout << "2.显示联系人" << endl;
    cout << "3.删除联系人" << endl;
    cout << "4.查找联系人" << endl;
    cout << "5.修改联系人" << endl;
    cout << "6.清空联系人" << endl;
    cout << "0.退出通讯录" << endl;
}

int main(int argc, char const *argv[])
{
    //创建通讯录结构体变量
    Addressbooks abs;
    //初始化通讯录的当前人数,有Java那种感觉了
    abs.Size = 0;

    //创建用户选择的变量
    int select = 0;

    //菜单调用
    showMenu();
    bool flag = true;

    while(flag) 
    {
        cin >> select;

        switch (select)
        {
            case 1:
                addPerson(&abs);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 0:
                cout << "欢迎下次使用" << endl;
                pause();
                break;
            default:
                break;
        }
    }
    return 0;
}

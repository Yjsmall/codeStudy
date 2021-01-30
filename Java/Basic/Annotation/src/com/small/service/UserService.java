package com.small.service;

/**
 * @author small
 */
public class UserService {
    int id;
    int age;

    /**
     * 登陆方法
     * @param name 姓名
     * @param pwd 密码
     * @return true登陆成功
     */
    public boolean login(String name,String pwd){
        if ("admin".equals(name) && "123".equals(pwd)){
            return true;
        } else {
            return false;
        }
    }

    public void logout(){
        System.out.println("退出成功");
    }
}

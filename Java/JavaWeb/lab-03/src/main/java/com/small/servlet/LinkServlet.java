package com.small.servlet;

import com.small.bean.Word;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author small
 */
@WebServlet(name = "linkServlet",urlPatterns = "/LinkServlet")
public class LinkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        HttpSession session=req.getSession();

        //获取表单提交的成语str
        String str = req.getParameter("str");

        //排除不为4位汉字的情况：不为汉字或不为4位都将重定向到error界面
        if(!check(str)){
            resp.sendRedirect("error.jsp?action=1");

        } else if((str.length() != 4)){

            resp.sendRedirect("error.jsp?action=2");

        } else {

            //截取第一个字符,最后一个字符,左闭右开区间
            String first = str.substring(0,1);
            String last = str.substring(3,4);

            Word word=new Word();
            word.setStr(str);
            word.setLast(last);

            //创建Word类型的集合，从session中获取
            List<Word> list= (List<Word>)  session.getAttribute("wordlist");

            //说明还没有成语
            if(list==null) {
                list= new ArrayList<>();
                list.add(word);

                //将list存入session
                session.setAttribute("wordlist", list);
                resp.sendRedirect("show.jsp");

            } else {
                //取出list中最后一位的Word对象
                Word lastword = list.get(list.size()-1);

                //判断尾首是否相等，只能用equals()
                if(lastword.getLast().equals(first)) {
                    list.add(word);
                    session.setAttribute("wordlist", list);
                    resp.sendRedirect("show.jsp");
                } else {
                    resp.sendRedirect("error.jsp？action=3");
                }
            }
        }
    }

    /**
     * 判断是否都为汉字
     * @param str 字符串
     * @return 真假
     */
    public boolean check(String str){
        int n;
        for(int i = 0; i < str.length(); i++) {
            n = str.charAt(i);
            if(!(19968 <= n && n <40869)) {
                return false;
            }
        }
        return true;
    }
}

package com.small.filter;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;

/**
 * @author small
 */
public class SessionListener implements HttpSessionListener {


    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        HashMap<String, String> books = new HashMap<>(20);
        session.setAttribute("books",books);
        session.setAttribute("money",0.0);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}

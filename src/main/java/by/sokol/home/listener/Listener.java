package by.sokol.home.listener;

import by.sokol.home.entity.CalcHistory;

import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class Listener implements ServletContextListener, HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setAttribute("isGuest", true);
        se.getSession().setAttribute("isUser", false);
        se.getSession().setAttribute("calcHistory", new CalcHistory());
    }

}

package by.sokol.home.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/user/calc","/user/history"})
public class CalcAndHistoryFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        boolean isUser = (boolean) req.getSession().getAttribute("isUser");
        if (isUser) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect("/");
        }
    }
}

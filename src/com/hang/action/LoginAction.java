package com.hang.action;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/index.html")
public class LoginAction extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println(name+" "+password);
        if(name.equals("123456") && password.equals("123456")){
            chain.doFilter(request,response);
        }

    }
}

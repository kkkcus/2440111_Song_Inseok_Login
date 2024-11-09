package com.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); // 요청 인코딩 설정
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User newUser = new User(name, email, password);

        ServletContext context = getServletContext();
        HashMap<String, User> users = (HashMap<String, User>) context.getAttribute("users");

        if (users == null) {
            users = new HashMap<>();
            context.setAttribute("users", users);
        }

        users.put(email, newUser);

        response.setContentType("text/html; charset=UTF-8"); // 응답 인코딩 설정
        response.sendRedirect("loginpage.html"); // 회원가입 후 로그인 페이지로 리다이렉트
    }
}

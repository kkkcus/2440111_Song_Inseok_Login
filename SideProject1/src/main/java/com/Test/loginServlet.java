package com.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        ServletContext context = getServletContext();
        HashMap<String, User> users = (HashMap<String, User>) context.getAttribute("users");

        // Null 체크: users가 없으면 새로 생성
        if (users == null) {
            users = new HashMap<>();
            context.setAttribute("users", users);
        }

        if (users.containsKey(email)) {
            User user = users.get(email);
            if (user.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("main.jsp"); // 로그인 성공 후 환영 페이지로 리다이렉트
                return;
            }
        }

        request.setAttribute("loginError", "로그인 실패. 이메일 또는 비밀번호를 확인하세요.");
        request.getRequestDispatcher("main.jsp").forward(request, response); // 로그인 실패 시 login.jsp로 이동
    }
}

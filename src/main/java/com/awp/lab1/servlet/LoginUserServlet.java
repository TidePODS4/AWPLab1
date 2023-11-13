package com.awp.lab1.servlet;


import com.awp.lab1.database.UserTable;
import com.awp.lab1.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginUserServlet", value = "/login")
public class LoginUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("views/login.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        var user = new User(login, password);

        var optionalUser = UserTable.login(user);
        if (optionalUser.isPresent()){
            routing(req, resp, optionalUser.get());
            return;
        }

        req.setAttribute("isUserValid", false);
        req.getRequestDispatcher("views/login.jsp").forward(req, resp);
    }

    private static void routing(HttpServletRequest req, HttpServletResponse resp, User user)
            throws IOException {

        System.out.println(user);
        if (user.getAdmin()){
            resp.sendRedirect(req.getContextPath() + "/admin-panel");
        }
        else {
            resp.sendRedirect(req.getContextPath() + "/date");
        }
    }
}

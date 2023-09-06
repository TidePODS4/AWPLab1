package com.awp.lab1.servlet;


import com.awp.lab1.database.UserTable;
import com.awp.lab1.entity.User;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "LoginUserServlet", value = "/login")
public class LoginUserServlet extends HttpServlet {

    @SneakyThrows
    @Override
    public void init(){
        var admin = new User("admin", "admin", true);
        UserTable.addUser(admin);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("views/login.jsp").
            forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        var user = new User(login, password);

        var optionalUser = UserTable.login(user);

        if (optionalUser.isPresent()){
            routing(req, resp, user);
            return;
        }

        req.setAttribute("isUserValid", false);
        req.getRequestDispatcher("views/login-user.jsp").forward(req, resp);
    }

    private static void routing(HttpServletRequest req, HttpServletResponse resp, User user)
            throws IOException, ServletException {
        if (user.isAdmin()){
            resp.sendRedirect(req.getContextPath() + "/admin-panel");
            return;
        }

        var date = new Date();
        req.setAttribute("date", date.toString());
        req.getRequestDispatcher("views/date.jsp").forward(req, resp);
    }
}
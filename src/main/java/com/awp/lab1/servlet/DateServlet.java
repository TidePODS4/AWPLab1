package com.awp.lab1.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "DateServlet", value = "/date")
public class DateServlet extends HttpServlet {
    private Date date;

    /*@Override
    public void init() throws ServletException {
        super.init();
        date = new Date();
    }*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("date", date.toString());
        req.getRequestDispatcher("views/date.jsp").forward(req, resp);
    }
}

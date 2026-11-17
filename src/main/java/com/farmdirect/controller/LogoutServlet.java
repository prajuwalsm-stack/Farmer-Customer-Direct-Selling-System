package com.farmdirect.controller;
import javax.servlet.annotation.WebServlet;import javax.servlet.http.*;import java.io.IOException;
@WebServlet("/logout") public class LogoutServlet extends HttpServlet{protected void doGet(HttpServletRequest q,HttpServletResponse p)throws IOException{q.getSession().invalidate();p.sendRedirect("index.jsp");}}
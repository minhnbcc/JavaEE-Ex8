/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.nbcc.servlet;

import edu.nbcc.user.IUser;
import edu.nbcc.user.UserFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Minh
 */
public class EmailServlet extends HttpServlet {

    int globalCount;

    public EmailServlet() {
        super();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmailServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EmailServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        throw new ServletException("Get calls are not allowed");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = "";
        String url = "index.jsp";

        if (request.getParameter("btnSubmit") != null) {
            try {
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String emailAddress = request.getParameter("emailAddress");

                IUser user = UserFactory.createInstance(firstName, lastName, emailAddress);
                if (!user.hasRequiredFields()) {
                    message = "Please provide all information";
                } else if (!user.isEmailValid()) {
                    message = "Please enter valid email";
                } else {
                    url = "/thanks.jsp";
                    globalCount++;
                    response.setContentType("text/html");
                    request.setAttribute("user", user);
                    request.setAttribute("globalCount", globalCount);
                }
            } catch (Exception e) {
                message = e.getMessage();
            }
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } else {
            request.setAttribute("message","Improper calls are not allowed");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

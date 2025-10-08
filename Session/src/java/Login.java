
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author hieuchu
 */
@WebServlet(urlPatterns={"/Login"})
public class Login extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            
            String account = request.getParameter("account");
            String password = request.getParameter("password");
            if(account.equalsIgnoreCase("student") && password.equalsIgnoreCase("student")){
                HttpSession session = request.getSession();
                session.setAttribute("username", account);
                session.setAttribute("role", "student");
                response.sendRedirect("student.jsp");
                
            } else if(account.equalsIgnoreCase("teacher") && password.equalsIgnoreCase("teacher")){
                HttpSession session = request.getSession();
                session.setAttribute("username", account);
                session.setAttribute("role", "teacher");
                response.sendRedirect("teacher.jsp");
            }
            
            else{
                request.setAttribute("error", "sai tai khoan");
                request.getRequestDispatcher("/Login.jsp").forward(request, response);
            }             
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    }

}

package servlet;

import service.Userservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ResignServlet",urlPatterns = "/ResignServlet")
public class ResignServlet extends HttpServlet {
    private Userservice userservice = new Userservice();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码形式
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("username");
        String pass=request.getParameter("password");
        String res=userservice.Resign(name,pass);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter outs=response.getWriter();
        outs.print(res);
        outs.flush();
        outs.close();
    }
}

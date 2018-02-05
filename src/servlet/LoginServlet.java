package servlet;

import service.Userservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private Userservice userservice = new Userservice();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码形式
        request.setCharacterEncoding("UTF-8");
        String account=request.getParameter("account");
        String pass=request.getParameter("password");
        System.out.println(account);
        System.out.println(pass);
        String res=userservice.Login(account,pass);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter outs=response.getWriter();
        outs.print(res);    //登录成功  密码错误   500为用户名不存在查找数据库异常
        outs.flush();
        outs.close();
    }
}

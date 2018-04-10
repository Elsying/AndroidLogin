package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Sendsearch",urlPatterns = "/Sendsearch")
public class Sendsearch extends HttpServlet {

    private static final String SAVE_PATH="D:\\lsy";//上传路径
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String scrip_name=request.getParameter("scrip_name");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter outs = response.getWriter();
        String newname;
            if ((newname = selectFiles(new File(SAVE_PATH), scrip_name)) != null) {
                //输出文件名字
                outs.print(newname);
            }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    //查询文件是否存在
    private String selectFiles(File file,String filename) {
        if(filename.indexOf("_")>0){
            String filena = filename.substring(0, filename.indexOf("_"));
            String number=filename.substring(filename.indexOf("_"));
            String[] fill = file.list();
            for (String f:fill) {
                if(f.indexOf("_")>0){
                    String names=f.substring(0,f.indexOf("_"));
                    String numbers=f.substring(f.indexOf("_"));
                    if(filena.equals(names)&&!numbers.equals(number)){
                        return f;
                    }
                }
            }
            return null;
        }
        else
            return null;
    }
}

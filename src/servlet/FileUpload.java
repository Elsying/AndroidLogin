package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
@MultipartConfig      /////////////重要！！！！！(location = "D:\\")
@WebServlet(name = "FileUpload",urlPatterns = "/FileUpload")
public class FileUpload extends HttpServlet {

    private static final String SAVE_PATH="D:\\lsy";//上传路径
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Part part=request.getPart("file");
        String header = part.getHeader("Content-Disposition");
        System.out.println(header);
        String fileNames = header.substring(header.indexOf("filename=\"") + 10,//获取文件名字
                header.lastIndexOf("\""));


        File f=new File(SAVE_PATH+File.separator);
        if(!f.exists()){
            f.mkdir();
        }
        part.write(SAVE_PATH+File.separator+fileNames);         //上传

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter outs=response.getWriter();
        outs.print(fileNames+"  上传成功");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}

package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FileUpload",urlPatterns = "/FileUpload")
public class FileUpload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter outs=response.getWriter();
        outs.print("成功");
        response.setCharacterEncoding("GBK");
        Part part=request.getPart("file");

        String header = part.getHeader("Content-Disposition");
        System.out.println(header);

        String fileNames = header.substring(header.indexOf("filename=\"") + 10,
                header.lastIndexOf("\""));
        part.write(fileNames);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}

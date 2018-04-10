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
import java.util.HashMap;
import java.util.Map;

@MultipartConfig      /////////////重要！！！！！(location = "D:\\")
@WebServlet(name = "FileUpload",urlPatterns = "/FileUpload")
public class FileUpload extends HttpServlet {

    private static final String SAVE_PATH = "D:\\lsy";//上传路径

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Part part = request.getPart("file");
        String header = part.getHeader("Content-Disposition");
        System.out.println(header);
        String fileNames = header.substring(header.indexOf("filename=\"") + 10,//获取文件名字
                header.lastIndexOf("\""));
        File f = new File(SAVE_PATH + File.separator);
        if (!f.exists()) {
            f.mkdir();
        }
        //删除版本号低的
        selectFile(f, fileNames);
        part.write(SAVE_PATH + File.separator + fileNames);         //上传

        request.setAttribute("message", "上传成功！！");
        request.getRequestDispatcher("/message.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    private void selectFile(File file, String filename) {
        if (filename.indexOf("_") > 0) {
            String filena = filename.substring(0, filename.indexOf("_"));
            String[] fil = file.list();
            for (String f : fil) {
                if(f.indexOf("_")>0) {
                    String names = f.substring(0, f.indexOf("_"));
                    if (filena.equals(names)) {
                        //判断文件名一样，且版本号不一样的则删除原来的
                        System.out.println(f);
                        File fii = new File(SAVE_PATH + File.separator + f);
                        if (fii.exists()) {
                            fii.delete();

                        }
                    }
                }
            }
        }
    }



}

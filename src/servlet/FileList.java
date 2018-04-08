package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


//显示所有文件
@WebServlet(name = "FileList",urlPatterns = "/FileList")
public class FileList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取上传文件的目录
        String uploadFilePath = "D:\\lsy";
        // 存储要下载的文件名
        Map<String, String> fileNameMap = new HashMap<String, String>();
        // 递归遍历filepath目录下的所有文件和目录，将文件的文件名存储到map集合中
        listFile(new File(uploadFilePath), fileNameMap);// File既可以代表一个文件也可以代表一个目录
        request.setAttribute("fileNameMap", fileNameMap);
        request.getRequestDispatcher("/listFile.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    //递归遍历指定目录下的所有文件
    private void listFile(File file,Map<String,String>map){
        if(file == null)
            return;
        // 如果file代表的不是一个文件，而是一个目录
        if(!file.isFile()){
            File files[] = file.listFiles();
            if(files == null) return;
            // 遍历files[]数组
            for (File f : files) {
                // 递归
                listFile(f, map);
            }
        }
        else{
            String filename=file.getName().substring(file.getName().indexOf("_")+1);
            map.put(file.getName(),filename);
        }
    }
}

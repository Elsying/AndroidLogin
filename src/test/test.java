package test;

import bean.User;
import cn.itcast.commons.CommonUtils;
import dao.Userdao;
import dao.UserdaoFactory;

import java.io.FileWriter;
import java.io.IOException;

public class test {
    public static void main(String []args){

//        Userdao userdao= UserdaoFactory.getUserdaoInstance();
//        User u=userdao.find("s","sdsd");
//        if (u==null){
//            System.out.println("kong ");
//        }
//        System.out.println("不为空出来");
        //System.out.print(name);

//        User u=new User();
//        u.setUsername("lsying");
//        u.setPassword("777");
//        userdao.add(u);
        write("cc");
    }
    public static void write(String aa) {
        try {
            FileWriter fw = new FileWriter("D:/test.txt");
            fw.write("cnm");
            fw.write(aa);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

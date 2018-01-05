package test;

import bean.User;
import cn.itcast.commons.CommonUtils;
import dao.Userdao;
import dao.UserdaoFactory;

public class test {
    public static void main(String []args){

        Userdao userdao= UserdaoFactory.getUserdaoInstance();
        User u=userdao.find("s","sdsd");
        if (u==null){
            System.out.println("kong ");
        }
        System.out.println("不为空出来");
        //System.out.print(name);

//        User u=new User();
//        u.setUsername("lsying");
//        u.setPassword("777");
//        userdao.add(u);
    }
}

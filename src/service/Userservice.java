package service;

import bean.User;
import cn.itcast.commons.CommonUtils;
import dao.Userdao;
import dao.UserdaoFactory;
import dao.UserdaoImpl;

import java.sql.SQLException;

public class Userservice {
    private Userdao userdao=  UserdaoFactory.getUserdaoInstance();    //用工厂模式创建对象， 可以用spring解耦（以后优化）
    private final static String ERROR = "密码错误！";
    private final static String SUCCESS = "登陆成功！";
    private final static String ERROR_A = "用户名不存在！";

    private final static String ERROR_R = "注册失败，用户名已存在！";
    private final static String SUCCESS_R = "注册成功！";
    private final static String ERROR_Rb = "注册失败,密码已存在";

    private final static String ERROR_S = "未知错误";


    //注册
//    public void add(User u){
//        userdao.add(u);
//
//    }

    //注册查找是否存在
    public User finduser(String account)
    {
        return userdao.finduser(account);
    }


    //
//    public User find(String username,String password)
//    {
//
//        return userdao.find(username,password);
//    }

    //
    public void edit(User u) {
        userdao.edit(u);
    }


    //登录验证
    //登录成功  密码错误   500为用户名不存在查找数据库异常
    public String Login(String account,String password) {
        User r=userdao.find(account,password);
        User u = userdao.finduser(account);   //查找账号
        User p = userdao.findpass(password);   //查找密码

        if(r!=null){
            return SUCCESS;
        }
        if (u!=null){
            if(!u.getPassword().equals(password))
                return ERROR;
        }

            return ERROR_A;


    }

    //注册
    public String Resign(String account, String password){
        //User up=userdao.find(username,password);
        User u = userdao.finduser(account);   //查找账号
        User p = userdao.findpass(password);   //查找密码
        if (u==null&&p==null){
            User ne=new User();     //这里不好0.0
            ne.setAccount(account);
            ne.setPassword(password);
            userdao.add(ne);
            return SUCCESS_R;
        }
        else if(u!=null){
            return ERROR_R;
        }
        else if(p!=null){
            return ERROR_Rb;
        }
        else
            return ERROR_S;


    }

    //搜索




    //service层可以使用很多dao，写不一样的操作，这里只有一个dao所以....

}

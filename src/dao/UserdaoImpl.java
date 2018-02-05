package dao;

import bean.User;
import cn.itcast.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;


/////一个dao对应一张表（最好）
public class UserdaoImpl implements Userdao {
//    public static final String DRIVER="com.jdbc.Driver";
//    public static final String USER="root";
//    public static final String PASS="3567zxcv";
//    public static final String URL = "jdbc:mysql://localhost:3306/db_android";

    private QueryRunner qr = new TxQueryRunner();//TxQueryRunner封装了jdbcUtils开启事物，连接c3p0连接池（在itcast-tools-1.4.jar）
    private QueryRunner nr=new NewTxQueryRunner();

    //插入
    public void add(User u) {
        String sql = "insert into user_list(account,password) values(?,?)";
        Object[] params = {u.getAccount(), u.getPassword()
        };
        try {
            qr.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //查找账号
    public User finduser(String account) {
        String sql = "select * from user_list where account=? ";
        System.out.println("find");
        try {
//            if((nr.query(sql, new BeanHandler<User>(User.class),username))==null) {
//                return null;
//            }else {
                return  qr.query(sql, new BeanHandler<User>(User.class), account);

        } catch (SQLException e) {
            //System.out.print("MY");
            throw new RuntimeException(e);
        }
    }

    //查找密码
    public User findpass(String password) {
        String sql = "select * from user_list where password=? ";
        try {
//            if(qr.query(sql, new BeanHandler<User>(User.class),password)==null){
//                return null;
//            }
//            else
                return qr.query(sql, new BeanHandler<User>(User.class), password);
        } catch (SQLException e) {
            //System.out.print("MY");
            throw new RuntimeException(e);
        }
    }

    //查找
    public User find(String account,String password) {
        String sql = "select * from user_list where account=? and password=? ";
        try {
//            if (nr.query(sql, new BeanHandler<User>(User.class),username,password)==null){
//                return null;
//            }
//            else
                return qr.query(sql, new BeanHandler<User>(User.class), account,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public void edit(User u) {

    }


}


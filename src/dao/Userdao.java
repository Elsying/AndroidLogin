package dao;

import bean.User;

public interface Userdao {
     void add(User u);
     User finduser(String account);
     User findpass(String password);
     User find(String account,String password);
     void edit(User u);

}

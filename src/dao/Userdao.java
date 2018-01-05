package dao;

import bean.User;

public interface Userdao {
     void add(User u);
     User finduser(String username);
     User findpass(String password);
     User find(String username,String password);
     void edit(User u);

}

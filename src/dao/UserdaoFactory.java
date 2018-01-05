package dao;

public class UserdaoFactory {
    public static Userdao getUserdaoInstance(){
        return new UserdaoImpl();
    }
}

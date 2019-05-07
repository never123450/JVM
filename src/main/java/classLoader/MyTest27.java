package classLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyTest27 {

    //分析一下这2行代码完成了什么事
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println(System.getProperty("jdbc.drivers"));//null
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myTest","userName","password");
    }

}
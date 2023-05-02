package util;

import java.sql.SQLDataException;
import java.sql.SQLException;

public class DBConnection {

    private  static final  String URL ="jdbc:mysql://localhost:3306/MyApp?serverTimezone=America/Bogota";
    private static  final  String USER = "My_App_user";
    private static  final String PASS = "My_App_password";

    private static BasicDataSource pool;

    public static BasicDataSource getInstance() throws SQLException{
        if (pool == null){
            pool =new  BasicDataSource();
            pool.SetUrl(URL);
            pool.setUsername(USER);
            pool.setPassword(PASS);

            pool.setIntialSize(3);
            pool.setMinIdle(3);
            pool.setMaxIdle(8);
            pool.setMaxTotal(8);
        }
        return pool;

    }//getConnectionToDatabase
    public  static  Connection getConnection() throws SQLException{
        return getInstance().getConnetion();
    }

}

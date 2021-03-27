package cn.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class C3p0Utils {
    private static DataSource ds;
    static {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass("com.mysql.jdbc.Driver");
            cpds.setJdbcUrl("jdbc:mysql://localhost:3306/note");
            cpds.setUser("root");
            cpds.setPassword("");
            cpds.setInitialPoolSize(5);
            cpds.setMaxPoolSize(15);
        }catch (Exception e){
            throw new ExceptionInInitializerError(e);
        }
        ds = cpds;
    }
    public static  DataSource getDataSource(){
        return ds;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(ds.getConnection());
    }
}

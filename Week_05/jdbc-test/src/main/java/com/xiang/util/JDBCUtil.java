package com.xiang.util;

import java.sql.*;

/**
 * @author
 * @date
 * @revisionHistory
 **/
public class JDBCUtil {

    private static String driver="com.mysql.jdbc.Driver";
//    private static String url = "jdbc:MySQL://localhost:3306/demo";
//    private static String user = "root";
//    private static String password = "root";

    private static String url = "jdbc:MySQL://sh-cdb-dgkoda68.sql.tencentcdb.com:58906/joinf_trade";
    private static String user = "root";
    private static String password = "Peat-blood-Sofia-driven-Baton6";



    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}

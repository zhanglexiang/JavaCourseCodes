package com.xiang.example;

import com.xiang.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransaction {
    public static void main(String[] args) {
        insert();
    }

    private static void insert() {
        Connection connection = null;

        Statement statement = null;
        try {
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            int row = statement.executeUpdate("insert into t_user (id,username,password,number) " +
                    "values ('1','李明1','1234567','123')");
            if (row > 0) {
                int i = 1 / 0;
                System.out.println("插入成功");
                connection.commit();
            } else {
                connection.rollback();
            }
        } catch (SQLException throwables) {
            System.out.println("插入失败");
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, null);
        }
    }
}
package com.xiang.data;

import com.xiang.util.JDBCUtil;

import java.math.BigDecimal;
import java.sql.*;

/**
 *  批量插入100W条数据
 **/
public class BachInsertData {

    public static void main(String[] args) throws SQLException {
        bulkSubmissionOrder();
    }


    private static void bulkSubmissionOrder() {
        long start = System.currentTimeMillis();
        //获取数据库连接
        Connection conn = JDBCUtil.getConnection();
        String sql = "insert into s_order (code,user_id,order_status,commodity_num,pay_way,pay_time,original_sum,discount,final_sum) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            conn.setAutoCommit(false); //取消自动提交
            for (int i = 1; i <= 1000000; i++) {
                ps.setString(1, "c"+i);
                ps.setLong(2, 1);
                ps.setInt(3, 0);
                ps.setInt(4, 2);
                ps.setString(5, "支付宝");
                ps.setDate(6, new Date(System.currentTimeMillis()));
                ps.setBigDecimal(7, new BigDecimal(200));
                ps.setBigDecimal(8, new BigDecimal(0));
                ps.setBigDecimal(9, new BigDecimal(200));
                ps.addBatch();
                if (i % 500 == 0) {
                    ps.executeBatch();
                    ps.clearBatch();
                }
            }
            ps.executeBatch();
            ps.clearBatch();
            conn.commit(); //所有语句都执行完毕后才手动提交sql语句
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps, null);
        }
        System.out.println("百万条数据插入用时：" + (System.currentTimeMillis() - start)+"【单位：毫秒】");
    }

}

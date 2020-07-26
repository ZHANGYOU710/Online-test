package cn.uu710.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接工具类
 */
public class ConnUtil {
    private static String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://127.0.0.1:3306/online-test"
            + "?useUnicode=true&characterEncoding=utf8";
    private static String USER_NAME = "root";
    private static String PASSWORD = "5001170080";
    private static Connection conn;


    static {
        //装载mysql的驱动类
        try {
            Class.forName(DRIVER_CLASS_NAME);
        } catch (ClassNotFoundException e) {
            System.out.println("驱动类装载错误！！！！");
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConn() throws SQLException {
        if (ConnUtil.conn == null || ConnUtil.conn.isClosed()) {
            ConnUtil.conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        }
        return conn;
    }

    /**
     * 关闭数据库连接
     */
    public static void closeConn() {
        try {
            if (ConnUtil.conn != null && !ConnUtil.conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.conn = null;
        }
    }
}

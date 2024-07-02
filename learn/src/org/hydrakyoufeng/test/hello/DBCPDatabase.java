package org.hydrakyoufeng.test.hello;

//package org.hydrakyoufeng.test.hello;
//
//import org.apache.commons.dbcp2.BasicDataSource;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.time.Duration;
//
//public class DBCPDatabase {
//
//    /**
//     * DBCP的连接池主类实现了DataSource接口
//     * DataSource接口：JAVA的连接池接口，实现了该接口，表示可以帮我们分配一个连接
//     */
//    private static BasicDataSource dataSource = new BasicDataSource();;
//
//    static {
//        // 以下都是设置连接池参数（这些参数可以通过配置文件设置，这里就不演示了）
//        dataSource.setUsername("entrance");
//        dataSource.setPassword("123456");
//        dataSource.setUrl("jdbc:mysql://127.0.0.1:3307/entrance?serverTimezone=PRC&characterEncoding=utf-8&useSSL=true&zeroDateTimeBehavior=convertToNull");
//
//        // 创建连接池时的初始连接数
//        dataSource.setInitialSize(5);
//
//        // 驱逐空闲连接时，保留的最少连接数
//        dataSource.setMinIdle(5);
//
//        // 最大空闲连接数
//        dataSource.setMaxIdle(20);
//
//        // 等待空闲连接的最大时长
//        dataSource.setMaxWait(Duration.ofMillis(30000));
//
//        // 空闲线程等待多久后，会自动被清除
//        dataSource.setMinEvictableIdle(Duration.ofMinutes(1));
//
//        // 设置最大连接数
//        dataSource.setMaxTotal(50);
//
//        // 是否测试连接有效性
//        dataSource.setTestOnBorrow(true);
//
//        // 测试连接有效性的SQL语句
//        dataSource.setValidationQuery("select 1");
//    }
//
//    public static Connection getConnection() throws SQLException {
//        return dataSource.getConnection();
//    }
//
//}
class DBCPDatabase {

}


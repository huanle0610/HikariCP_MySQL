package org.amtf.my;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Database connection pool
 */
public class DBConnPool {
    private static DBConnPool _instance = null;
    private static HikariDataSource _dataSource = null;

    public static synchronized DBConnPool getInstance() {
        if (_instance == null) {
            _instance = new DBConnPool();

            String hikari_properties = DBConnPool.class.getClassLoader().getResource("hikari.properties").getFile();
            HikariConfig config = new HikariConfig(hikari_properties);

            _dataSource = new HikariDataSource(config);
        }

        return _instance;
    }

    public static Connection getConnection() {
        DBConnPool.getInstance();
        Connection connection = null;

        try {
            connection = _dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}

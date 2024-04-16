package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {
	private static Connection conn = null;

	public static Connection getConnection() {
		if (conn == null) {
			try {
				Properties dbProperties = loadProperties();
				String dbUrl = dbProperties.getProperty("dbUrl");
				conn = DriverManager.getConnection(dbUrl, dbProperties);
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}

	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	private static Properties loadProperties() {
		try (FileInputStream fileInputStream = new FileInputStream("db.properties")) {
			Properties dbProperties = new Properties();
			dbProperties.load(fileInputStream);
			return dbProperties;
		}
		catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}

	public static void closeStatment(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	public static void closeResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}

package nl.hu.v1ipass.DAO;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

//public class BaseDAO {
//	private DataSource connectionpool;
//	private static Connection connection;
//
//	public BaseDAO() {
//		try {
//			final String DATABASE_URL_PROP = System.getenv("DATABASE_URL");
//			if (DATABASE_URL_PROP != null) {
//				URI dbUri = new URI(DATABASE_URL_PROP);
//				String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();
//				BasicDataSource pool = new BasicDataSource();
//				if (dbUri.getUserInfo() != null) {
//					pool.setUsername(dbUri.getUserInfo().split(":")[0]);
//					pool.setPassword(dbUri.getUserInfo().split(":")[1]);
//				}
//				pool.setDriverClassName("org.postgresql.Driver");
//				pool.setUrl(dbUrl);
//				pool.setInitialSize(1);
//
//				connectionpool = pool;
//
//				connection = connectionpool.getConnection();
//			} else {
//				InitialContext ic = new InitialContext();
//				connectionpool = (DataSource) ic.lookup("java:comp/env/jdbc/PostgresDS");
//			}
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	protected final static Connection getConnection() {
//		try {
//			return connection;
//		} catch (Exception ex) {
//			throw new RuntimeException(ex);
//		}
//	}
//}
public class BaseDAO {
	protected final static Connection getConnection() {
		Connection result = null;

		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/PostgresDS");

			result = ds.getConnection();
		}

		catch (Exception ex) {
			throw new RuntimeException(ex);
		}

		return result;
	}
}

//public class BaseDAO {
//
//	public static Connection getConnection() {
//
//		Connection myConn = null;
//		try {
//			myConn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/IPASS", "postgres", "thomasajax");
//		}
//
//		catch (Exception exc) {
//			exc.printStackTrace();
//		}
//		return myConn;
//	}
//}

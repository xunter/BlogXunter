package blogxunter.main.data;

import java.sql.*;


public class DataBaseConnection {
	private Connection connection;
	private String driverClassName;
	private String url;
	private String username;
	private String password;
		
	public DataBaseConnection(String driverClassName, String url, String username, String password) {
		super();
		this.driverClassName = driverClassName;
		this.url = url;
		this.username = username;
		this.password = password;
		try
        {
			Class.forName(driverClassName);
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
        	ex.printStackTrace();
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
        }
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	
	public String getDriverClassName() {
		return driverClassName;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	/**
	 * Метод для чтения из БД данных(select)
	 * @param sql - sql запрос
	 * @return Коллекцию типа ResultSet
	 */
	public ResultSet getResultSet(String sql) {
		try {
			Statement state = connection.createStatement();
			ResultSet set = state.executeQuery(sql);
			return set;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	/**
	 * Метод выполнения sql запроса(insert, update, delete), 
	 * который не возвращает результата
	 * @param sql - sql запрос
	 */
	public void execute(String sql) {
		try {
			Statement state = connection.createStatement();
			state.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

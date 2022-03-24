package by.it.academy.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnectionDB implements MyConnection{
    private final String url;
    private final String username;
    private final String password;
    private Connection connection;
    String DB_DRIVER = "com.mysql.jdbc.Driver";

    public MyConnectionDB() {
        this.url = "jdbc:mysql://127.0.0.1:3307/cinema";
        this.username = "root";
        this.password = "";
    }

    public MyConnectionDB(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName(DB_DRIVER);
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    public boolean close() throws SQLException {
            connection.close();
            return true;
    }
}

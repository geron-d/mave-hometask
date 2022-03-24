package by.it.academy;

import by.it.academy.connection.MyConnection;
import by.it.academy.connection.MyConnectionDB;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Properties properties = new Properties();

        try(InputStream resourceAsStream = new App().getResourceAsStream()) {
            properties.load(resourceAsStream);
            String login = properties.getProperty("username");
            String password = properties.getProperty("password");
            String uri = properties.getProperty("db.uri");
            MyConnection connection = new MyConnectionDB(uri,login,password);
            System.out.println("Connect to " + uri + " with login = " + login + ", password = " + password);
            try(Connection connect = connection.connect()) {
                System.out.println("Connection to DB successful!");
            } catch (SQLException |ClassNotFoundException e) {
                System.err.println("Connection to DB unsuccessful!");
            }
        } catch (IOException e) {
            System.err.println("Unable to load properties file");
        }

    }

    private InputStream getResourceAsStream() {
        return this.getClass().getClassLoader().getResourceAsStream("config.properties");
    }
}

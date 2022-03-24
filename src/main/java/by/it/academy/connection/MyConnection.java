package by.it.academy.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface MyConnection {
    Connection connect() throws ClassNotFoundException, SQLException;

    boolean close() throws ClassNotFoundException, SQLException;
}

package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorker {

    private final String URL = "jdbc:mysql://localhost:3306/my_db?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASS = "root";

    private Connection connection;

    public void connectToDB(){
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            if (!connection.isClosed()) {System.out.println("Соединение с БД установлено");}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnectFromDB(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection.isClosed()) {System.out.println("Соединение с БД прервано");}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void isConnected () throws SQLException {
        if (!connection.isClosed()) {System.out.println("Соединение с БД поддерживается");}
        else {System.out.println("Соединение с БД прервано");}
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


}

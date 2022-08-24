package Sql.JDBC.withoutJDBCtemplate;

import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class BookDAO {
    public static  ResultSet findBooks() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/dcfk", "postgres", "19012001");
            if(connection != null)
                System.out.println("Connection Successful !\n");
            else
                System.exit(0);
            // Создание Statement для отправки запроса базе данных
            statement = connection.prepareStatement("select id, title from Book ");
            resultSet = statement.executeQuery();
            int columns = resultSet.getMetaData().getColumnCount();
            // Перебор строк с данными
            while(resultSet.next()){
                for (int i = 1; i <= columns; i++){
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
    }
}
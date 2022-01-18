package br.com.crudcontatos.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root#123";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/crud";

    public static Connection createConnectionToMySQL() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Faz a classe  ser carregada pela JVM
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Erro ao tentar conectar com o banco de dados.");
        }

        return conn;
    }
}

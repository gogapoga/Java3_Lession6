package HW;

import java.sql.*;
import java.util.ArrayList;

public class SQLService {
    private static Connection connection;
    private static Statement stmt;

    public static  void connect() throws  SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:StudentsDB.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static boolean addStudent(Student student) {
        if(SQLService.getStudent(student.getName()) == null) {
            String SQL = String.format("INSERT INTO STUDENTS (ID , NAME , BALL) VALUES ('%s' , '%s', '%s')", student.getId(), student.getName(), student.getBall());
            try {
                stmt.executeUpdate(SQL);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        }
        else return false;
    }
    public static Student getStudent(String name) {
        String sql = String.format("SELECT * FROM STUDENTS WHERE NAME= '%s'", name);
        try{
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) return new Student(rs.getInt(1),rs.getString(2), rs.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static boolean changeStudent(Student student) {
        if(SQLService.getStudent(student.getName()) != null) {
            String SQL = String.format("UPDATE STUDENTS SET BALL = '%s' WHERE NAME = '%s'", student.getBall(), student.getName());
            try {
                stmt.executeUpdate(SQL);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        } else return false;
    }
    public static void deleteStudent(Student student) {
        String SQL = String.format("DELETE FROM STUDENTS WHERE NAME = '%s'", student.getName());
        try{
            stmt.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}


package HW;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class DZ3Test {
    private Student student;
    @Before
    public void startTest() {
        student = new Student(6, "Fedorov", 80);
        try {
            SQLService.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @After
    public void stopTest() {
        SQLService.deleteStudent(student);
        SQLService.disconnect();
    }
    @Test
    public void getStudentTest1() {
        Student studIvanov = new Student(1, "Ivanov", 40);
        Assert.assertEquals(studIvanov, SQLService.getStudent("Ivanov"));
    }
    @Test
    public void getStudentTest2() {
        Student studPetrov = new Student(2, "Petrov", 60);
        Assert.assertEquals(studPetrov, SQLService.getStudent("Petrov"));
    }
    @Test
    public void getStudentTest3() {
        Assert.assertEquals(null, SQLService.getStudent("Petrov2"));
    }
    @Test
    public void addStudentTest1() {
        Assert.assertEquals(true, SQLService.addStudent(student));
        SQLService.deleteStudent(student);
    }
    @Test
    public void addStudentTest2() {
        SQLService.addStudent(student);
        Assert.assertEquals(student, SQLService.getStudent("Fedorov"));
        SQLService.deleteStudent(student);
    }
    @Test
    public void addStudentTest3() {
        SQLService.addStudent(student);
        Assert.assertEquals(false, SQLService.addStudent(student));
        SQLService.deleteStudent(student);
    }
    @Test
    public void changeStudentTest1() {
        SQLService.addStudent(student);
        Student changedStudent = new Student(student);
        changedStudent.setBall(70);
        Assert.assertEquals(true, SQLService.changeStudent(changedStudent));
        SQLService.deleteStudent(student);
    }
    @Test
    public void changeStudentTest2() {
        SQLService.addStudent(student);
        Student changedStudent = new Student(student);
        changedStudent.setBall(70);
        SQLService.changeStudent(changedStudent);
        Assert.assertEquals(changedStudent, SQLService.getStudent("Fedorov"));
        SQLService.deleteStudent(student);
    }
    @Test
    public void changeStudentTest3() {
        Student studPetrov = new Student(2, "Petrov2", 60);
        Assert.assertEquals(false, SQLService.changeStudent(studPetrov));
    }
}

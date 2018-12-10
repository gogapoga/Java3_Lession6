package HW;

public class Student {
    private int id;
    private String name;
    private int ball;
    public Student(int id, String name, int ball) {
        this.id = id;
        this.name = name;
        this.ball = ball;
    }
    public Student(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.ball = student.getBall();
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public  int getBall() {
        return ball;
    }
    public void setBall(int newball) {
        ball = newball;
    }
    public void print() {
        StringBuilder str = new StringBuilder("Студент: ");
        str.append(id);
        str.append(" ");
        str.append(name);
        str.append(" ");
        str.append(ball);
        System.out.println(str);
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        return (this.id == ((Student) obj).getId()) && (this.name.equals(((Student) obj).getName())) && (this.ball == ((Student) obj).getBall());
    }
}
